package com.tencent.TMG.mediacodec;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaCodecInfo.CodecProfileLevel;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.util.LongSparseArray;
import com.tencent.TMG.utils.ArrayUtils;
import com.tencent.TMG.utils.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
public class NativeCodec
  implements IMediaCodecCallback
{
  public static String BOTTOM = "crop-bottom";
  public static String LEFT = "crop-left";
  public static String PPS = "csd-1";
  public static String RIGHT = "crop-right";
  public static String SLICEHEIGHT = "slice-height";
  public static String SPS = "csd-0";
  public static String STRIDE = "stride";
  private static final String TAG = "NativeCodec";
  public static String TOP = "crop-top";
  static NativeCodec.AVCCaps gAVCDecoderCaps;
  static NativeCodec.AVCCaps gAVCEncoderCaps;
  public static boolean mUseAsyncAPI = false;
  int mBitRate;
  AndroidCodec mCodec;
  AtomicBoolean mCodersExit = new AtomicBoolean(false);
  int mColorFormat;
  boolean mDebugDelay = false;
  LongSparseArray<Long> mDebugDelayMap = null;
  LongSparseArray<Long> mDebugDelayMap2 = null;
  LongSparseArray<Long> mDebugIndexMap = null;
  String mDebugTag = null;
  MediaFormat mFormat = null;
  int mFrameInverval = 30000;
  int mFrameRate = 20;
  int mHeight = 240;
  long mLastEncFrameTime = 0L;
  String mMime;
  private int mNativeContext = 0;
  List<AndroidCodec.InputBufferData> mPendingInputBuffers = new ArrayList();
  long mTimeStamp = 0L;
  int mTotalFrameNum = 0;
  int mTryAgainLaterCount = 0;
  int mTryAgainLaterCount2 = 0;
  int mWidth = 320;
  boolean misdecoder;
  int setBitRatePending = 0;
  boolean setIFramePending = false;
  
  public NativeCodec() {}
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.mMime = paramString;
    this.misdecoder = paramBoolean;
    this.mWidth = ((Integer)paramMap.get("width")).intValue();
    this.mHeight = ((Integer)paramMap.get("height")).intValue();
    if (this.misdecoder) {
      try
      {
        int i = this.mWidth;
        int j = this.mHeight;
        this.mFormat = MediaFormat.createVideoFormat(paramString, i, j);
        this.mFormat.setInteger("max-input-size", i * j);
        this.mFormat.setInteger("color-format", 21);
        this.mFormat.setInteger("frame-rate", 25);
        if (paramString.contains(AndroidCodec.AVC_CODEC_MIME))
        {
          paramString = (ByteBuffer)paramMap.get(SPS);
          paramMap = (ByteBuffer)paramMap.get(PPS);
          this.mFormat.setByteBuffer(SPS, paramString);
          this.mFormat.setByteBuffer(PPS, paramMap);
        }
        if (QLog.isColorLevel())
        {
          paramString = new StringBuilder();
          paramString.append("width =");
          paramString.append(i);
          paramString.append(", height =");
          paramString.append(j);
          QLog.d("NativeCodec", 0, paramString.toString());
        }
        createDecCodec();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "NativeCodec", paramString);
        }
        this.mCodec = null;
      }
    } else {
      try
      {
        this.mBitRate = ((Integer)paramMap.get("bitrate")).intValue();
        this.mFrameRate = ((Integer)paramMap.get("frame-rate")).intValue();
        createEncCodec();
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "NativeCodec", paramString);
        }
        this.mCodec = null;
      }
    }
    this.mDebugIndexMap = new LongSparseArray();
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap = new LongSparseArray();
      this.mDebugDelayMap2 = new LongSparseArray();
      if (mUseAsyncAPI) {
        paramString = "Async";
      } else {
        paramString = " Sync";
      }
      this.mDebugTag = paramString;
      paramMap = new StringBuilder();
      paramMap.append(this.mDebugTag);
      if (this.misdecoder) {
        paramString = "DEC";
      } else {
        paramString = "ENC";
      }
      paramMap.append(paramString);
      this.mDebugTag = paramMap.toString();
    }
  }
  
  private void createDecCodec()
  {
    this.mCodec = new AndroidCodec();
    if (this.misdecoder)
    {
      List localList = AndroidCodec.getDecoderInfos(this.mMime);
      int i = 0;
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      Object localObject;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (i >= localList.size()) {
          break;
        }
        localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject == null)
        {
          localObject = localMediaCodecInfo;
          break;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
        {
          localObject = (MediaCodecInfo)localList.get(i);
          this.mFormat.setInteger("color-format", 19);
          break;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21))
        {
          localObject = (MediaCodecInfo)localList.get(i);
          this.mFormat.setInteger("color-format", 21);
          break;
        }
        i += 1;
      }
      if (!this.mCodec.init(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
        this.mCodec = null;
      }
    }
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.provideAs(TypeTransformer.java:780)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.e0expr(TypeTransformer.java:441)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:710)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public static native int getVersion();
  
  private static void initAVCDecoderCaps()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME).get(0), AndroidCodec.AVC_CODEC_MIME);
    gAVCDecoderCaps = new NativeCodec.AVCCaps();
    if (localCodecCapabilities == null) {
      return;
    }
    int i = 0;
    while (i < localCodecCapabilities.profileLevels.length)
    {
      if (localCodecCapabilities.profileLevels[i].profile <= 1)
      {
        if (gAVCDecoderCaps.profile <= 3) {
          gAVCDecoderCaps.profile = 3;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].profile == 4)
      {
        if (gAVCDecoderCaps.profile <= 5) {
          gAVCDecoderCaps.profile = 5;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].profile == 8)
      {
        if (gAVCDecoderCaps.profile <= 5) {
          gAVCDecoderCaps.profile = 5;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].profile == 16)
      {
        if (gAVCDecoderCaps.profile <= 5) {
          gAVCDecoderCaps.profile = 5;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].profile == 32)
      {
        if (gAVCDecoderCaps.profile <= 5) {
          gAVCDecoderCaps.profile = 5;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].profile == 2)
      {
        if (gAVCDecoderCaps.profile <= 4) {
          gAVCDecoderCaps.profile = 4;
        }
      }
      else if ((localCodecCapabilities.profileLevels[i].profile >= 64) && (gAVCDecoderCaps.profile <= 5)) {
        gAVCDecoderCaps.profile = 5;
      }
      Object localObject;
      if (localCodecCapabilities.profileLevels[i].level <= 1)
      {
        if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 176;
          ((NativeCodec.AVCCaps)localObject).height = 144;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 2)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 4)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 8)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 16)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 32)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 64)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 576))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 352;
          ((NativeCodec.AVCCaps)localObject).height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 128)
      {
        if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 720;
          ((NativeCodec.AVCCaps)localObject).height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 256)
      {
        if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 720;
          ((NativeCodec.AVCCaps)localObject).height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 512)
      {
        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 720))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 1280;
          ((NativeCodec.AVCCaps)localObject).height = 720;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 1024)
      {
        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 1024))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 1280;
          ((NativeCodec.AVCCaps)localObject).height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 2048)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 2048;
          ((NativeCodec.AVCCaps)localObject).height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 4096)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 2048;
          ((NativeCodec.AVCCaps)localObject).height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 8192)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1088))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 2048;
          ((NativeCodec.AVCCaps)localObject).height = 1088;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 16384)
      {
        if ((gAVCDecoderCaps.width < 3680) || (gAVCDecoderCaps.height < 1536))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 3680;
          ((NativeCodec.AVCCaps)localObject).height = 1536;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 32768)
      {
        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2304))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 4096;
          ((NativeCodec.AVCCaps)localObject).height = 2304;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level > 32768)
      {
        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 4096))
        {
          localObject = gAVCDecoderCaps;
          ((NativeCodec.AVCCaps)localObject).width = 4096;
          ((NativeCodec.AVCCaps)localObject).height = 4096;
        }
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("initAVCDecoderCaps caps.profileLevels[");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append("].level = ");
        ((StringBuilder)localObject).append(localCodecCapabilities.profileLevels[i].level);
        QLog.e("NativeCodec", 0, ((StringBuilder)localObject).toString());
      }
      i += 1;
    }
  }
  
  private static void initAVCEncoderCaps()
  {
    Object localObject = AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME);
    int i = 0;
    localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)((List)localObject).get(0), AndroidCodec.AVC_CODEC_MIME);
    gAVCEncoderCaps = new NativeCodec.AVCCaps();
    if (localObject == null) {
      return;
    }
    while (i < ((MediaCodecInfo.CodecCapabilities)localObject).profileLevels.length)
    {
      if (localObject.profileLevels[i].profile == 1)
      {
        gAVCEncoderCaps.profile = 3;
        setLevel(localObject.profileLevels[i], gAVCEncoderCaps);
      }
      i += 1;
    }
  }
  
  private static boolean onAttach(String paramString, int paramInt, boolean paramBoolean, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "onAttach");
    }
    if (Build.VERSION.SDK_INT < 16) {
      return false;
    }
    paramString = new NativeCodec(paramString, paramMap, paramBoolean);
    if (paramString.mCodec == null) {
      return false;
    }
    paramString.mNativeContext = paramInt;
    paramString.attachCodec(paramString);
    paramString.mTimeStamp = 0L;
    paramString.mTryAgainLaterCount = 0;
    paramString.mLastEncFrameTime = 0L;
    paramString.mTotalFrameNum = 0;
    return paramString.mCodec.start();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.mDebugDelay)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.mDebugTag);
        localStringBuilder.append(" frameIndex:");
        localStringBuilder.append(paramInt);
        QLog.d("NativeCodec", 0, localStringBuilder.toString());
      }
      this.mDebugDelayMap2.put(paramInt, Long.valueOf(System.currentTimeMillis()));
    }
    return true;
  }
  
  private static void onDetach(Object arg0)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "onDetach");
    }
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    NativeCodec localNativeCodec = (NativeCodec)???;
    if (localNativeCodec != null)
    {
      localNativeCodec.detachCodec();
      localNativeCodec.mTryAgainLaterCount = 0;
      localNativeCodec.mTimeStamp = 0L;
      localNativeCodec.mFormat = null;
      localNativeCodec.mLastEncFrameTime = 0L;
      localNativeCodec.mTotalFrameNum = 0;
      synchronized (localNativeCodec.mPendingInputBuffers)
      {
        localNativeCodec.mCodersExit.set(true);
        localNativeCodec.mPendingInputBuffers.clear();
        localNativeCodec.mDebugIndexMap.clear();
        if (localNativeCodec.mDebugDelay)
        {
          localNativeCodec.mDebugDelayMap.clear();
          localNativeCodec.mDebugDelayMap2.clear();
        }
        AndroidCodec localAndroidCodec = localNativeCodec.mCodec;
        if (localAndroidCodec == null) {}
      }
    }
    try
    {
      localNativeCodec.mCodec.stop();
      localNativeCodec.mCodec.release();
      label137:
      localNativeCodec.mCodec = null;
      return;
      localObject = finally;
      throw localObject;
      return;
    }
    catch (Exception localException)
    {
      break label137;
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    Object localObject1 = this.mCodec;
    if (localObject1 == null) {
      return false;
    }
    if (this.mTryAgainLaterCount >= 16)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NativeCodec", 0, "try too many times!");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        Object localObject3 = ((AndroidCodec)localObject1).getInputBuffer();
        paramInt1 = 0;
        localObject1 = localObject3;
        Object localObject4;
        if (localObject3 == null)
        {
          boolean bool = QLog.isColorLevel();
          if (bool) {
            QLog.e("NativeCodec", 0, "inputbuffer not available");
          }
          int i = paramInt1;
          localObject4 = localObject3;
          try
          {
            if (this.misdecoder)
            {
              i = paramInt1;
              localObject4 = localObject3;
              if (this.mTotalFrameNum == 0)
              {
                i = paramInt1;
                localObject4 = localObject3;
                Thread.sleep(10L);
                i = paramInt1;
                localObject4 = localObject3;
                localObject1 = this.mCodec.getInputBuffer();
              }
              else
              {
                i = paramInt1;
                localObject4 = localObject3;
                Thread.sleep(50L);
                i = paramInt1;
                localObject4 = localObject3;
                localObject1 = this.mCodec.getInputBuffer();
              }
            }
            else
            {
              i = paramInt1;
              localObject4 = localObject3;
              Thread.sleep(50L);
              i = paramInt1;
              localObject4 = localObject3;
              localObject1 = this.mCodec.getInputBuffer();
            }
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
            paramInt1 = i;
            localObject3 = localObject4;
          }
          i = j;
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            i = j;
            localObject4 = localObject1;
            QLog.e("NativeCodec", 0, "inputbuffer not available");
          }
          paramInt1 = j;
          localObject3 = localObject1;
          if (j <= 12) {
            continue;
          }
          i = j;
          localObject4 = localObject1;
          if (QLog.isColorLevel())
          {
            i = j;
            localObject4 = localObject1;
            localObject3 = new StringBuilder();
            i = j;
            localObject4 = localObject1;
            ((StringBuilder)localObject3).append("inputbuffer not available, try count = ");
            i = j;
            localObject4 = localObject1;
            ((StringBuilder)localObject3).append(j);
            i = j;
            localObject4 = localObject1;
            QLog.e("NativeCodec", 0, ((StringBuilder)localObject3).toString());
          }
          return false;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("NativeCodec", 0, "onDoCodec InterruptedException", localInterruptedException);
          paramInt1 = i;
          localObject3 = localObject4;
        }
        else
        {
          if (this.misdecoder) {
            paramInt1 = writeInputData(localInterruptedException.buffer, false);
          } else {
            paramInt1 = writeInputData2(localInterruptedException.buffer, this.mColorFormat, false);
          }
          if (paramInt1 < 0)
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.e("NativeCodec", 0, "writeInputData, sampleSize < 0");
            return false;
          }
          this.mLastEncFrameTime += this.mFrameInverval;
          if (this.mDebugDelay) {
            this.mDebugDelayMap.put(this.mLastEncFrameTime, Long.valueOf(System.currentTimeMillis()));
          }
          this.mDebugIndexMap.put(this.mLastEncFrameTime, Long.valueOf(paramInt2));
          if (this.misdecoder) {
            this.mCodec.queueInputBuffer(localInterruptedException.index, paramInt1, 0L, 0);
          } else {
            this.mCodec.queueInputBuffer(localInterruptedException.index, paramInt1, this.mLastEncFrameTime, 0);
          }
          Object localObject2;
          if (this.misdecoder)
          {
            if (this.mTotalFrameNum == 0)
            {
              localObject3 = this.mCodec.dequeueOutputBuffer_First();
              localObject4 = new StringBuilder();
              ((StringBuilder)localObject4).append("dequeueOutputBuffer_Dec() begin sampleSize = ");
              ((StringBuilder)localObject4).append(paramInt1);
              ((StringBuilder)localObject4).append("buff.index = ");
              ((StringBuilder)localObject4).append(localInterruptedException.index);
              ((StringBuilder)localObject4).append("mTotalFrameNum = ");
              ((StringBuilder)localObject4).append(this.mTotalFrameNum);
              QLog.e("NativeCodec", 0, ((StringBuilder)localObject4).toString());
              localObject2 = localObject3;
            }
            else
            {
              localObject2 = this.mCodec.dequeueOutputBuffer();
            }
          }
          else {
            localObject2 = this.mCodec.dequeueOutputBuffer();
          }
          if (localObject2 != null)
          {
            if (((AndroidCodec.BufferData)localObject2).index < 0)
            {
              this.mTryAgainLaterCount += 1;
              if (QLog.isColorLevel())
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("dequeueOutputBuffer, try again later, count = ");
                ((StringBuilder)localObject2).append(this.mTryAgainLaterCount);
                QLog.e("NativeCodec", 0, ((StringBuilder)localObject2).toString());
              }
              if (this.mTryAgainLaterCount < 16) {
                break label1273;
              }
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dequeueOutputBuffer, error count = ");
              ((StringBuilder)localObject2).append(this.mTryAgainLaterCount);
              QLog.e("NativeCodec", 0, ((StringBuilder)localObject2).toString());
              return false;
            }
            this.mTryAgainLaterCount = 0;
            if (!((AndroidCodec.BufferData)localObject2).success)
            {
              if (!QLog.isColorLevel()) {
                break label1275;
              }
              QLog.e("NativeCodec", 0, "onDoCodec err!");
              return false;
            }
            if ((((AndroidCodec.BufferData)localObject2).format != null) && (((AndroidCodec.BufferData)localObject2).buffer != null))
            {
              if (this.misdecoder)
              {
                if (!HWColorFormat.isSupportedDecodeFormats(((AndroidCodec.BufferData)localObject2).format.getInteger("color-format")))
                {
                  if (!QLog.isColorLevel()) {
                    break label1277;
                  }
                  QLog.e("NativeCodec", 0, "onDoCodec don't support format!");
                  return false;
                }
                calcDelay(true, ((AndroidCodec.BufferData)localObject2).info);
                setFrame(((AndroidCodec.BufferData)localObject2).buffer, ((AndroidCodec.BufferData)localObject2).info.size, ((AndroidCodec.BufferData)localObject2).format);
              }
              else
              {
                paramInt1 = ((AndroidCodec.BufferData)localObject2).info.flags;
                localObject3 = localObject2;
                if (((AndroidCodec.BufferData)localObject2).info.flags == 2)
                {
                  this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject2).index);
                  readOutputStream(((AndroidCodec.BufferData)localObject2).buffer, ((AndroidCodec.BufferData)localObject2).info.presentationTimeUs, ((AndroidCodec.BufferData)localObject2).info.offset, ((AndroidCodec.BufferData)localObject2).info.size, ((AndroidCodec.BufferData)localObject2).info.flags);
                  localObject2 = this.mCodec.dequeueOutputBuffer();
                  if (localObject2 != null)
                  {
                    if (((AndroidCodec.BufferData)localObject2).index < 0)
                    {
                      this.mTryAgainLaterCount2 += 1;
                      if (QLog.isColorLevel())
                      {
                        localObject2 = new StringBuilder();
                        ((StringBuilder)localObject2).append("re-dequeue dequeueOutputBuffer, try again later, count = ");
                        ((StringBuilder)localObject2).append(this.mTryAgainLaterCount2);
                        QLog.e("NativeCodec", 0, ((StringBuilder)localObject2).toString());
                      }
                      if (this.mTryAgainLaterCount2 < 10) {
                        break label1279;
                      }
                      return false;
                    }
                    this.mTryAgainLaterCount2 = 0;
                    if (!((AndroidCodec.BufferData)localObject2).success)
                    {
                      if (!QLog.isColorLevel()) {
                        break label1281;
                      }
                      QLog.e("NativeCodec", 0, "re-dequeue onDoCodec err!");
                      return false;
                    }
                    if ((((AndroidCodec.BufferData)localObject2).format == null) || (((AndroidCodec.BufferData)localObject2).buffer == null))
                    {
                      this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject2).index);
                      return false;
                    }
                  }
                  localObject3 = localObject2;
                  if (QLog.isColorLevel())
                  {
                    QLog.d("NativeCodec", 0, "re-dequeue success");
                    localObject3 = localObject2;
                  }
                }
                localObject2 = localObject3;
                if (localObject3 != null)
                {
                  localObject2 = calcDelay(true, ((AndroidCodec.BufferData)localObject3).info);
                  readOutputStream(((AndroidCodec.BufferData)localObject3).buffer, ((Long)localObject2).longValue(), ((AndroidCodec.BufferData)localObject3).info.offset, ((AndroidCodec.BufferData)localObject3).info.size, ((AndroidCodec.BufferData)localObject3).info.flags);
                  localObject2 = localObject3;
                }
              }
              this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject2).index);
              this.mTotalFrameNum += 1;
              return true;
            }
            this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject2).index);
            return false;
          }
          return true;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "onDoCodec Exception!", localException);
        }
        return false;
      }
      int j = paramInt1 + 1;
      if (localException == null) {}
    }
    return false;
    label1273:
    return true;
    label1275:
    return false;
    label1277:
    return false;
    label1279:
    return true;
    label1281:
    return false;
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!mUseAsyncAPI)
    {
      if (QLog.isColorLevel()) {
        QLog.e("NativeCodec", 0, "NOT in async mode.");
      }
      return -1;
    }
    label369:
    label372:
    synchronized (this.mPendingInputBuffers)
    {
      if (this.mCodersExit.get())
      {
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "hardware coders exit, return.");
        }
        return 2;
      }
      if (this.mPendingInputBuffers.size() > 0)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("InputData pendingInputBuffers exist, size: ");
          ((StringBuilder)localObject1).append(this.mPendingInputBuffers.size());
          QLog.d("NativeCodec", 0, ((StringBuilder)localObject1).toString());
        }
        Object localObject1 = (AndroidCodec.InputBufferData)this.mPendingInputBuffers.get(0);
        if (localObject1 == null) {
          return 2;
        }
        if (((AndroidCodec.InputBufferData)localObject1).buffer == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "inputbuffer null, return");
          }
          return -1;
        }
        if (((AndroidCodec.InputBufferData)localObject1).processing)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.misdecoder)
        {
          paramInt1 = writeInputData(((AndroidCodec.InputBufferData)localObject1).buffer, false);
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeCodec", 0, "call writeInputData2 in onDoCodec");
          }
          paramInt1 = writeInputData2(((AndroidCodec.InputBufferData)localObject1).buffer, this.mColorFormat, false);
          break label369;
          if (paramInt1 <= 0) {
            break label372;
          }
          this.mLastEncFrameTime += this.mFrameInverval;
          this.mPendingInputBuffers.remove(0);
          if (this.mDebugDelay) {
            this.mDebugDelayMap.put(this.mLastEncFrameTime, Long.valueOf(System.currentTimeMillis()));
          }
          this.mDebugIndexMap.put(this.mLastEncFrameTime, Long.valueOf(paramInt2));
          this.mCodec.queueInputBuffer(((AndroidCodec.InputBufferData)localObject1).index, paramInt1, this.mLastEncFrameTime, 0);
          return 1;
          return -1;
          return 0;
        }
      }
      else
      {
        return 2;
      }
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  private void resetCodec()
  {
    if (this.mCodec != null) {
      try
      {
        synchronized (this.mPendingInputBuffers)
        {
          this.mCodersExit.set(true);
          this.mPendingInputBuffers.clear();
          this.mDebugIndexMap.clear();
          if (this.mDebugDelay)
          {
            this.mDebugDelayMap.clear();
            this.mDebugDelayMap2.clear();
          }
          this.mCodec.stop();
          this.mCodec.release();
          this.mCodec = null;
        }
        try
        {
          if (this.misdecoder) {
            createDecCodec();
          } else {
            createEncCodec();
          }
          this.mTimeStamp = 0L;
          this.mLastEncFrameTime = 0L;
          if (this.mCodec != null) {
            this.mCodec.start();
          }
          this.mCodersExit.set(false);
          return;
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "resetCodec", localException2);
          }
        }
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "resetCodec", localException1);
        }
        this.mCodec = null;
      }
    }
  }
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i2 = paramMediaFormat.getInteger("width");
    int i1 = paramMediaFormat.getInteger("height");
    int k = paramMediaFormat.getInteger(LEFT);
    int i3 = paramMediaFormat.getInteger(RIGHT);
    int i5 = paramMediaFormat.getInteger(TOP);
    int i4 = paramMediaFormat.getInteger(BOTTOM);
    int m = paramMediaFormat.getInteger(STRIDE);
    int j = paramMediaFormat.getInteger(SLICEHEIGHT);
    int i6 = paramMediaFormat.getInteger("color-format");
    int i = j;
    if (j < i1) {
      i = i1;
    }
    j = m;
    if (m < i2) {
      j = i2;
    }
    m = i5;
    int n = i;
    if (i6 == 2130706688)
    {
      n = i - i5 / 2;
      k = 0;
      m = 0;
    }
    i = j;
    if (j < i2) {
      i = i2;
    }
    if (((2141391876 == i6) || (2130706433 == i6) || (2130706944 == i6)) && (i1 < n)) {
      j = n;
    } else {
      j = i1;
    }
    if (k + i3 + m + i4 == 0)
    {
      i2 -= 1;
      i3 = i1 - 1;
      m = i;
      n = j;
      k = 0;
      i1 = 0;
      i = i2;
      j = i3;
    }
    else
    {
      i1 = i3 - k + 1;
      n = i4 - m + 1;
      if (i < i1) {
        i = i1;
      }
      if (j < n) {
        j = n;
      }
      i1 = m;
      n = j;
      m = i;
      j = i4;
      i = i3;
    }
    if ((m > 0) && (n > 0) && (i > 0) && (j > 0))
    {
      SystemClock.elapsedRealtime();
      boolean bool = false;
      paramInt = readOutputDataEx(paramByteBuffer, paramInt, m, n, k, i1, i - k + 1, j - i1 + 1, i6);
      SystemClock.elapsedRealtime();
      if (paramInt > 0) {
        bool = true;
      }
      return bool;
    }
    if (QLog.isColorLevel()) {
      QLog.e("NativeCodec", 0, "error decoderInfomations.");
    }
    return false;
  }
  
  private static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodec.AVCCaps paramAVCCaps)
  {
    if (paramCodecProfileLevel.level == 1)
    {
      if ((paramAVCCaps.width < 176) || (paramAVCCaps.height < 144))
      {
        paramAVCCaps.width = 176;
        paramAVCCaps.height = 144;
      }
    }
    else if (paramCodecProfileLevel.level == 4)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 8)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 16)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 2)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 32)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 288))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 288;
      }
    }
    else if (paramCodecProfileLevel.level == 64)
    {
      if ((paramAVCCaps.width < 352) || (paramAVCCaps.height < 576))
      {
        paramAVCCaps.width = 352;
        paramAVCCaps.height = 576;
      }
    }
    else if (paramCodecProfileLevel.level == 128)
    {
      if ((paramAVCCaps.width < 720) || (paramAVCCaps.height < 576))
      {
        paramAVCCaps.width = 720;
        paramAVCCaps.height = 576;
      }
    }
    else if (paramCodecProfileLevel.level == 256)
    {
      if ((paramAVCCaps.width < 720) || (paramAVCCaps.height < 576))
      {
        paramAVCCaps.width = 720;
        paramAVCCaps.height = 576;
      }
    }
    else if (paramCodecProfileLevel.level == 512)
    {
      if ((paramAVCCaps.width < 1280) || (paramAVCCaps.height < 720))
      {
        paramAVCCaps.width = 1280;
        paramAVCCaps.height = 720;
      }
    }
    else if (paramCodecProfileLevel.level == 1024)
    {
      if ((paramAVCCaps.width < 1280) || (paramAVCCaps.height < 1024))
      {
        paramAVCCaps.width = 1280;
        paramAVCCaps.height = 1024;
      }
    }
    else if (paramCodecProfileLevel.level == 2048)
    {
      if ((paramAVCCaps.width < 2048) || (paramAVCCaps.height < 1024))
      {
        paramAVCCaps.width = 2048;
        paramAVCCaps.height = 1024;
      }
    }
    else if (paramCodecProfileLevel.level == 4096)
    {
      if ((paramAVCCaps.width < 2048) || (paramAVCCaps.height < 1024))
      {
        paramAVCCaps.width = 2048;
        paramAVCCaps.height = 1024;
      }
    }
    else if (paramCodecProfileLevel.level == 8192)
    {
      if ((paramAVCCaps.width < 2048) || (paramAVCCaps.height < 1088))
      {
        paramAVCCaps.width = 2048;
        paramAVCCaps.height = 1088;
      }
    }
    else if (paramCodecProfileLevel.level == 16384)
    {
      if ((paramAVCCaps.width < 3680) || (paramAVCCaps.height < 1536))
      {
        paramAVCCaps.width = 3680;
        paramAVCCaps.height = 1536;
      }
    }
    else if (paramCodecProfileLevel.level == 32768)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 2304))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 2304;
      }
    }
    else if (paramCodecProfileLevel.level == 65536)
    {
      if ((paramAVCCaps.width < 4096) || (paramAVCCaps.height < 2304))
      {
        paramAVCCaps.width = 4096;
        paramAVCCaps.height = 2304;
      }
    }
    else
    {
      paramAVCCaps = new StringBuilder();
      paramAVCCaps.append("initAVCEncoderCaps level.level = ");
      paramAVCCaps.append(paramCodecProfileLevel.level);
      QLog.e("NativeCodec", 0, paramAVCCaps.toString());
    }
  }
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.mCodec == null) {
      return;
    }
    if (paramString == null) {
      return;
    }
    if (paramString.equalsIgnoreCase("frame-rate")) {
      if (paramInt > 0)
      {
        this.mFrameRate = paramInt;
        this.mFrameInverval = (1000000 / this.mFrameRate);
        resetCodec();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("HWENC setParameters mFrameRate = ");
          ((StringBuilder)localObject).append(this.mFrameRate);
          QLog.d("NativeCodec", 0, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt(paramString, paramInt);
    this.mCodec.setParameters((Bundle)localObject);
  }
  
  public static native void set_device_infos(String paramString);
  
  public native boolean attachCodec(Object paramObject);
  
  Long calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    Long localLong1 = (Long)this.mDebugIndexMap.get(paramBufferInfo.presentationTimeUs);
    if (this.mDebugDelay)
    {
      Long localLong2 = (Long)this.mDebugDelayMap.get(paramBufferInfo.presentationTimeUs);
      StringBuilder localStringBuilder;
      if (localLong2 != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.mDebugTag);
          localStringBuilder.append("small, ");
          localStringBuilder.append(paramBufferInfo.presentationTimeUs);
          localStringBuilder.append(", takes:");
          localStringBuilder.append(System.currentTimeMillis() - localLong2.longValue());
          QLog.d("NativeCodec", 0, localStringBuilder.toString());
        }
        this.mDebugDelayMap.remove(paramBufferInfo.presentationTimeUs);
      }
      if (localLong1 != null)
      {
        localLong2 = (Long)this.mDebugDelayMap2.get(localLong1.longValue());
        if (localLong2 != null)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append(this.mDebugTag);
            localStringBuilder.append("big, ");
            localStringBuilder.append(paramBufferInfo.presentationTimeUs);
            localStringBuilder.append(", takes:");
            localStringBuilder.append(System.currentTimeMillis() - localLong2.longValue());
            QLog.d("NativeCodec", 0, localStringBuilder.toString());
          }
          this.mDebugDelayMap2.remove(localLong1.longValue());
        }
      }
    }
    this.mDebugIndexMap.remove(paramBufferInfo.presentationTimeUs);
    return localLong1;
  }
  
  void createEncCodec()
  {
    if (this.mCodec == null) {}
    for (;;)
    {
      int i;
      int k;
      int m;
      try
      {
        localList = AndroidCodec.getEndoderInfos(this.mMime);
        this.mColorFormat = 21;
        i = 0;
        if (i >= localList.size()) {
          break label500;
        }
        localObject1 = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
        if (localObject1 == null) {
          break label500;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats, 21))
        {
          this.mColorFormat = 21;
          k = i;
        }
        else
        {
          if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats, 19)) {
            break label493;
          }
          this.mColorFormat = 19;
          k = i;
        }
        this.mCodec = new AndroidCodec();
        localObject1 = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
        ((MediaFormat)localObject1).setInteger("color-format", this.mColorFormat);
        ((MediaFormat)localObject1).setInteger("frame-rate", this.mFrameRate);
        ((MediaFormat)localObject1).setInteger("bitrate", this.mBitRate);
        i = 30;
        if (this.mFrameRate * 30 > 255) {
          i = 255 / this.mFrameRate;
        }
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("KEY_I_FRAME_INTERVAL = ");
          ((StringBuilder)localObject2).append(i);
          ((StringBuilder)localObject2).append(", mFrameRate = ");
          ((StringBuilder)localObject2).append(this.mFrameRate);
          QLog.d("NativeCodec", 0, ((StringBuilder)localObject2).toString());
        }
        j = Build.VERSION.SDK_INT;
        if (j < 19) {
          ((MediaFormat)localObject1).setInteger("i-frame-interval", i);
        } else {
          ((MediaFormat)localObject1).setInteger("i-frame-interval", i);
        }
        localObject2 = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(k), this.mMime);
        if (localObject2 != null) {
          break label505;
        }
        this.mCodec = null;
        return;
      }
      catch (Exception localException)
      {
        List localList;
        Object localObject1;
        Object localObject2;
        int j;
        localException.printStackTrace();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NativeCodec", 0, "createEncCodec", localException);
        this.mCodec = null;
      }
      if (m < ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length)
      {
        if (localObject2.profileLevels[m].profile == 1)
        {
          ((MediaFormat)localObject1).setInteger("profile", 1);
          j = i;
          if (i < localObject2.profileLevels[m].level) {
            j = localObject2.profileLevels[m].level;
          }
          ((MediaFormat)localObject1).setInteger("level", j);
          i = j;
        }
      }
      else
      {
        this.mFormat = ((MediaFormat)localObject1);
        if (this.mFrameRate > 0) {
          this.mFrameInverval = (1000000 / this.mFrameRate);
        } else {
          this.mFrameInverval = 40000;
        }
        this.mCodec.init(this.mFormat, ((MediaCodecInfo)localList.get(k)).getName(), this);
        return;
        return;
        label493:
        i += 1;
        continue;
        label500:
        k = 0;
        continue;
        label505:
        m = 0;
        i = 16;
        continue;
      }
      m += 1;
    }
  }
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "onError", paramException);
    }
    if ((this.mCodersExit.get()) && (QLog.isColorLevel())) {
      QLog.e("NativeCodec", 0, "codec exit, return onError");
    }
  }
  
  /* Error */
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 233	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   4: iload_2
    //   5: invokevirtual 649	com/tencent/TMG/mediacodec/AndroidCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   8: astore_3
    //   9: aload_3
    //   10: ifnonnull +42 -> 52
    //   13: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   16: ifeq +35 -> 51
    //   19: new 201	java/lang/StringBuilder
    //   22: dup
    //   23: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   26: astore_1
    //   27: aload_1
    //   28: ldc_w 651
    //   31: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: pop
    //   35: aload_1
    //   36: iload_2
    //   37: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: ldc 34
    //   43: iconst_0
    //   44: aload_1
    //   45: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 335	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: return
    //   52: aload_0
    //   53: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   56: astore_1
    //   57: aload_1
    //   58: monitorenter
    //   59: aload_0
    //   60: getfield 117	com/tencent/TMG/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   63: invokevirtual 536	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   66: ifeq +79 -> 145
    //   69: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   72: ifeq +12 -> 84
    //   75: ldc 34
    //   77: iconst_0
    //   78: ldc_w 653
    //   81: invokestatic 335	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   90: astore_1
    //   91: aload_1
    //   92: monitorenter
    //   93: aload_0
    //   94: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   97: iconst_0
    //   98: invokeinterface 266 2 0
    //   103: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   106: iconst_0
    //   107: putfield 548	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   110: goto +28 -> 138
    //   113: astore_3
    //   114: goto +27 -> 141
    //   117: astore_3
    //   118: aload_3
    //   119: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   122: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   125: ifeq +13 -> 138
    //   128: ldc 34
    //   130: iconst_0
    //   131: ldc_w 655
    //   134: aload_3
    //   135: invokestatic 231	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   138: aload_1
    //   139: monitorexit
    //   140: return
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_3
    //   144: athrow
    //   145: aload_0
    //   146: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   149: new 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   152: dup
    //   153: aload_3
    //   154: iload_2
    //   155: invokespecial 658	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   158: invokeinterface 661 2 0
    //   163: pop
    //   164: aload_0
    //   165: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   168: iconst_0
    //   169: invokeinterface 266 2 0
    //   174: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   177: iconst_1
    //   178: putfield 548	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   181: aload_1
    //   182: monitorexit
    //   183: aload_0
    //   184: getfield 140	com/tencent/TMG/mediacodec/NativeCodec:misdecoder	Z
    //   187: ifeq +28 -> 215
    //   190: aload_0
    //   191: aload_0
    //   192: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   195: iconst_0
    //   196: invokeinterface 266 2 0
    //   201: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   204: getfield 543	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   207: iconst_1
    //   208: invokevirtual 436	com/tencent/TMG/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   211: istore_2
    //   212: goto +70 -> 282
    //   215: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   218: ifeq +12 -> 230
    //   221: ldc 34
    //   223: iconst_0
    //   224: ldc_w 663
    //   227: invokestatic 221	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: aload_0
    //   231: aload_0
    //   232: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   235: iconst_0
    //   236: invokeinterface 266 2 0
    //   241: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   244: getfield 543	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   247: aload_0
    //   248: getfield 438	com/tencent/TMG/mediacodec/NativeCodec:mColorFormat	I
    //   251: iconst_1
    //   252: invokevirtual 442	com/tencent/TMG/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   255: istore_2
    //   256: goto +26 -> 282
    //   259: astore_1
    //   260: aload_1
    //   261: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   264: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   267: ifeq +13 -> 280
    //   270: ldc 34
    //   272: iconst_0
    //   273: ldc_w 665
    //   276: aload_1
    //   277: invokestatic 231	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   280: iconst_0
    //   281: istore_2
    //   282: iload_2
    //   283: ifle +139 -> 422
    //   286: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   289: ifeq +35 -> 324
    //   292: new 201	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 202	java/lang/StringBuilder:<init>	()V
    //   299: astore_1
    //   300: aload_1
    //   301: ldc_w 667
    //   304: invokevirtual 208	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: pop
    //   308: aload_1
    //   309: iload_2
    //   310: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: ldc 34
    //   316: iconst_0
    //   317: aload_1
    //   318: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 221	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: aload_0
    //   325: aload_0
    //   326: getfield 89	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   329: aload_0
    //   330: getfield 105	com/tencent/TMG/mediacodec/NativeCodec:mFrameInverval	I
    //   333: i2l
    //   334: ladd
    //   335: putfield 89	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   338: aload_0
    //   339: getfield 119	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelay	Z
    //   342: ifeq +20 -> 362
    //   345: aload_0
    //   346: getfield 121	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelayMap	Landroid/support/v4/util/LongSparseArray;
    //   349: aload_0
    //   350: getfield 89	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   353: invokestatic 370	java/lang/System:currentTimeMillis	()J
    //   356: invokestatic 376	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   359: invokevirtual 380	android/support/v4/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   362: aload_0
    //   363: getfield 233	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   366: aload_0
    //   367: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   370: iconst_0
    //   371: invokeinterface 266 2 0
    //   376: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   379: getfield 556	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:index	I
    //   382: iload_2
    //   383: aload_0
    //   384: getfield 89	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   387: iconst_0
    //   388: invokevirtual 451	com/tencent/TMG/mediacodec/AndroidCodec:queueInputBuffer	(IIJI)V
    //   391: goto +31 -> 422
    //   394: astore_1
    //   395: aload_1
    //   396: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   399: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   402: ifeq +20 -> 422
    //   405: ldc 34
    //   407: iconst_0
    //   408: ldc_w 669
    //   411: aload_1
    //   412: invokestatic 231	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   415: goto +7 -> 422
    //   418: astore_1
    //   419: goto +85 -> 504
    //   422: aload_0
    //   423: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   426: astore_1
    //   427: aload_1
    //   428: monitorenter
    //   429: aload_0
    //   430: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   433: iconst_0
    //   434: invokeinterface 266 2 0
    //   439: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   442: iconst_0
    //   443: putfield 548	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   446: iload_2
    //   447: ifle +42 -> 489
    //   450: aload_0
    //   451: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   454: iconst_0
    //   455: invokeinterface 555 2 0
    //   460: pop
    //   461: goto +28 -> 489
    //   464: astore_3
    //   465: goto +27 -> 492
    //   468: astore_3
    //   469: aload_3
    //   470: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   473: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   476: ifeq +13 -> 489
    //   479: ldc 34
    //   481: iconst_0
    //   482: ldc_w 655
    //   485: aload_3
    //   486: invokestatic 231	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   489: aload_1
    //   490: monitorexit
    //   491: return
    //   492: aload_1
    //   493: monitorexit
    //   494: aload_3
    //   495: athrow
    //   496: astore_3
    //   497: aload_1
    //   498: monitorexit
    //   499: aload_3
    //   500: athrow
    //   501: astore_1
    //   502: iconst_0
    //   503: istore_2
    //   504: aload_0
    //   505: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   508: astore_3
    //   509: aload_3
    //   510: monitorenter
    //   511: aload_0
    //   512: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   515: iconst_0
    //   516: invokeinterface 266 2 0
    //   521: checkcast 542	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   524: iconst_0
    //   525: putfield 548	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   528: iload_2
    //   529: ifle +45 -> 574
    //   532: aload_0
    //   533: getfield 110	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   536: iconst_0
    //   537: invokeinterface 555 2 0
    //   542: pop
    //   543: goto +31 -> 574
    //   546: astore_1
    //   547: goto +31 -> 578
    //   550: astore 4
    //   552: aload 4
    //   554: invokevirtual 227	java/lang/Exception:printStackTrace	()V
    //   557: invokestatic 199	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   560: ifeq +14 -> 574
    //   563: ldc 34
    //   565: iconst_0
    //   566: ldc_w 655
    //   569: aload 4
    //   571: invokestatic 231	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   574: aload_3
    //   575: monitorexit
    //   576: aload_1
    //   577: athrow
    //   578: aload_3
    //   579: monitorexit
    //   580: aload_1
    //   581: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	582	0	this	NativeCodec
    //   0	582	2	paramInt	int
    //   8	2	3	localByteBuffer	ByteBuffer
    //   113	1	3	localObject1	Object
    //   117	37	3	localException1	Exception
    //   464	1	3	localObject2	Object
    //   468	27	3	localException2	Exception
    //   496	4	3	localObject3	Object
    //   550	20	4	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   93	110	113	finally
    //   118	138	113	finally
    //   138	140	113	finally
    //   141	143	113	finally
    //   93	110	117	java/lang/Exception
    //   183	212	259	java/lang/Exception
    //   215	230	259	java/lang/Exception
    //   230	256	259	java/lang/Exception
    //   362	391	394	java/lang/Exception
    //   286	324	418	finally
    //   324	362	418	finally
    //   362	391	418	finally
    //   395	415	418	finally
    //   429	446	464	finally
    //   450	461	464	finally
    //   469	489	464	finally
    //   489	491	464	finally
    //   492	494	464	finally
    //   429	446	468	java/lang/Exception
    //   450	461	468	java/lang/Exception
    //   59	84	496	finally
    //   84	86	496	finally
    //   145	183	496	finally
    //   497	499	496	finally
    //   52	59	501	finally
    //   183	212	501	finally
    //   215	230	501	finally
    //   230	256	501	finally
    //   260	280	501	finally
    //   499	501	501	finally
    //   511	528	546	finally
    //   532	543	546	finally
    //   552	574	546	finally
    //   574	576	546	finally
    //   578	580	546	finally
    //   511	528	550	java/lang/Exception
    //   532	543	550	java/lang/Exception
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get())
    {
      if (QLog.isColorLevel()) {
        QLog.e("NativeCodec", 0, "codec exit, return onOutputBufferAvailable");
      }
      return;
    }
    paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    if ((paramMediaCodec != null) && (paramBufferInfo != null))
    {
      if (this.misdecoder)
      {
        MediaFormat localMediaFormat = this.mCodec.getOutputFormat(paramInt);
        if (localMediaFormat != null)
        {
          calcDelay(false, paramBufferInfo);
          setFrame(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("NativeCodec", 0, "getOutputFormat null");
        }
      }
      else
      {
        int i = paramBufferInfo.flags;
        calcDelay(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
      this.mCodec.releaseOutputBuffer(paramInt);
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "onOutputFormatChanged");
    }
    if ((this.mCodersExit.get()) && (QLog.isColorLevel())) {
      QLog.e("NativeCodec", 0, "codec exit, return onOutputFormatChanged");
    }
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "setParams_impl");
    }
    Bundle localBundle;
    if (this.setIFramePending)
    {
      localBundle = new Bundle();
      localBundle.putInt(AndroidCodec.ForceIFrame, 1);
      this.setIFramePending = false;
      int i = this.setBitRatePending;
      if (i > 0) {
        localBundle.putInt("bitrate", i);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
    }
    if (this.setBitRatePending > 0)
    {
      localBundle = new Bundle();
      localBundle.putInt("bitrate", this.setBitRatePending);
      if (this.setIFramePending) {
        localBundle.putInt(AndroidCodec.ForceIFrame, 1);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
      this.setIFramePending = false;
    }
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.TMG.mediacodec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */