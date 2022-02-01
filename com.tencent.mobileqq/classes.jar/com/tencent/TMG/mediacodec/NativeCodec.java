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
  public static String BOTTOM;
  public static String LEFT;
  public static String PPS = "csd-1";
  public static String RIGHT;
  public static String SLICEHEIGHT = "slice-height";
  public static String SPS;
  public static String STRIDE;
  private static final String TAG = "NativeCodec";
  public static String TOP;
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
  
  static
  {
    LEFT = "crop-left";
    TOP = "crop-top";
    RIGHT = "crop-right";
    BOTTOM = "crop-bottom";
    STRIDE = "stride";
    SPS = "csd-0";
  }
  
  public NativeCodec() {}
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.mMime = paramString;
    this.misdecoder = paramBoolean;
    this.mWidth = ((Integer)paramMap.get("width")).intValue();
    this.mHeight = ((Integer)paramMap.get("height")).intValue();
    if (this.misdecoder)
    {
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
        if (QLog.isColorLevel()) {
          QLog.d("NativeCodec", 0, "width =" + i + ", height =" + j);
        }
        createDecCodec();
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          label390:
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
        if (!mUseAsyncAPI) {
          break label532;
        }
        paramString = "Async";
        this.mDebugTag = paramString;
        paramMap = new StringBuilder().append(this.mDebugTag);
        if (!this.misdecoder) {
          break label539;
        }
      }
    }
    label532:
    label539:
    for (paramString = "DEC";; paramString = "ENC")
    {
      for (;;)
      {
        this.mDebugTag = paramString;
        return;
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
      break;
      paramString = " Sync";
      break label390;
    }
  }
  
  private void createDecCodec()
  {
    this.mCodec = new AndroidCodec();
    List localList;
    MediaCodecInfo localMediaCodecInfo;
    int i;
    if (this.misdecoder)
    {
      localList = AndroidCodec.getDecoderInfos(this.mMime);
      localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      i = 0;
    }
    for (;;)
    {
      Object localObject = localMediaCodecInfo;
      if (i < localList.size())
      {
        localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject != null) {
          break label104;
        }
        localObject = localMediaCodecInfo;
      }
      for (;;)
      {
        if (!this.mCodec.init(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
          this.mCodec = null;
        }
        return;
        label104:
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
        {
          localObject = (MediaCodecInfo)localList.get(i);
          this.mFormat.setInteger("color-format", 19);
        }
        else
        {
          if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
            break;
          }
          localObject = (MediaCodecInfo)localList.get(i);
          this.mFormat.setInteger("color-format", 21);
        }
      }
      i += 1;
    }
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "getIntValues mime: " + paramString1 + ", key: " + paramString2);
    }
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      do
      {
        do
        {
          return 0;
          if (!"supportAsync".equalsIgnoreCase(paramString2)) {
            break;
          }
          mUseAsyncAPI = DeviceCheck.isSupportAsyncAPI();
        } while (!mUseAsyncAPI);
        return 1;
        if ((!paramString1.equalsIgnoreCase(AndroidCodec.AVC_CODEC_MIME)) || (!paramBoolean)) {
          break;
        }
        if (gAVCDecoderCaps == null) {
          initAVCDecoderCaps();
        }
        if (paramString2.equalsIgnoreCase("width")) {
          return gAVCDecoderCaps.width;
        }
        if (paramString2.equalsIgnoreCase("height")) {
          return gAVCDecoderCaps.height;
        }
      } while (!paramString2.equalsIgnoreCase("profile"));
      return gAVCDecoderCaps.profile;
      if (gAVCEncoderCaps == null) {
        initAVCEncoderCaps();
      }
      if (paramString2.equalsIgnoreCase("width")) {
        return gAVCEncoderCaps.width;
      }
      if (paramString2.equalsIgnoreCase("height")) {
        return gAVCEncoderCaps.height;
      }
    } while (!paramString2.equalsIgnoreCase("profile"));
    return gAVCEncoderCaps.profile;
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
    label39:
    if (i < localCodecCapabilities.profileLevels.length)
    {
      if (localCodecCapabilities.profileLevels[i].profile > 1) {
        break label140;
      }
      if (gAVCDecoderCaps.profile <= 3) {
        gAVCDecoderCaps.profile = 3;
      }
      label78:
      if (localCodecCapabilities.profileLevels[i].level > 1) {
        break label342;
      }
      if ((gAVCDecoderCaps.width < 176) || (gAVCDecoderCaps.height < 144))
      {
        gAVCDecoderCaps.width = 176;
        gAVCDecoderCaps.height = 144;
      }
    }
    for (;;)
    {
      i += 1;
      break label39;
      break;
      label140:
      if (localCodecCapabilities.profileLevels[i].profile == 4)
      {
        if (gAVCDecoderCaps.profile > 5) {
          break label78;
        }
        gAVCDecoderCaps.profile = 5;
        break label78;
      }
      if (localCodecCapabilities.profileLevels[i].profile == 8)
      {
        if (gAVCDecoderCaps.profile > 5) {
          break label78;
        }
        gAVCDecoderCaps.profile = 5;
        break label78;
      }
      if (localCodecCapabilities.profileLevels[i].profile == 16)
      {
        if (gAVCDecoderCaps.profile > 5) {
          break label78;
        }
        gAVCDecoderCaps.profile = 5;
        break label78;
      }
      if (localCodecCapabilities.profileLevels[i].profile == 32)
      {
        if (gAVCDecoderCaps.profile > 5) {
          break label78;
        }
        gAVCDecoderCaps.profile = 5;
        break label78;
      }
      if (localCodecCapabilities.profileLevels[i].profile == 2)
      {
        if (gAVCDecoderCaps.profile > 4) {
          break label78;
        }
        gAVCDecoderCaps.profile = 4;
        break label78;
      }
      if ((localCodecCapabilities.profileLevels[i].profile < 64) || (gAVCDecoderCaps.profile > 5)) {
        break label78;
      }
      gAVCDecoderCaps.profile = 5;
      break label78;
      label342:
      if (localCodecCapabilities.profileLevels[i].level == 2)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 4)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 8)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 16)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 32)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 288))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 288;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 64)
      {
        if ((gAVCDecoderCaps.width < 352) || (gAVCDecoderCaps.height < 576))
        {
          gAVCDecoderCaps.width = 352;
          gAVCDecoderCaps.height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 128)
      {
        if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
        {
          gAVCDecoderCaps.width = 720;
          gAVCDecoderCaps.height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 256)
      {
        if ((gAVCDecoderCaps.width < 720) || (gAVCDecoderCaps.height < 576))
        {
          gAVCDecoderCaps.width = 720;
          gAVCDecoderCaps.height = 576;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 512)
      {
        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 720))
        {
          gAVCDecoderCaps.width = 1280;
          gAVCDecoderCaps.height = 720;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 1024)
      {
        if ((gAVCDecoderCaps.width < 1280) || (gAVCDecoderCaps.height < 1024))
        {
          gAVCDecoderCaps.width = 1280;
          gAVCDecoderCaps.height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 2048)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
        {
          gAVCDecoderCaps.width = 2048;
          gAVCDecoderCaps.height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 4096)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1024))
        {
          gAVCDecoderCaps.width = 2048;
          gAVCDecoderCaps.height = 1024;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 8192)
      {
        if ((gAVCDecoderCaps.width < 2048) || (gAVCDecoderCaps.height < 1088))
        {
          gAVCDecoderCaps.width = 2048;
          gAVCDecoderCaps.height = 1088;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 16384)
      {
        if ((gAVCDecoderCaps.width < 3680) || (gAVCDecoderCaps.height < 1536))
        {
          gAVCDecoderCaps.width = 3680;
          gAVCDecoderCaps.height = 1536;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level == 32768)
      {
        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 2304))
        {
          gAVCDecoderCaps.width = 4096;
          gAVCDecoderCaps.height = 2304;
        }
      }
      else if (localCodecCapabilities.profileLevels[i].level > 32768)
      {
        if ((gAVCDecoderCaps.width < 4096) || (gAVCDecoderCaps.height < 4096))
        {
          gAVCDecoderCaps.width = 4096;
          gAVCDecoderCaps.height = 4096;
        }
      }
      else {
        QLog.e("NativeCodec", 0, "initAVCDecoderCaps caps.profileLevels[" + i + "].level = " + localCodecCapabilities.profileLevels[i].level);
      }
    }
  }
  
  private static void initAVCEncoderCaps()
  {
    MediaCodecInfo.CodecCapabilities localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)AndroidCodec.getDecoderInfos(AndroidCodec.AVC_CODEC_MIME).get(0), AndroidCodec.AVC_CODEC_MIME);
    gAVCEncoderCaps = new NativeCodec.AVCCaps();
    if (localCodecCapabilities == null) {}
    int i;
    do
    {
      return;
      i = 0;
    } while (i >= localCodecCapabilities.profileLevels.length);
    switch (localCodecCapabilities.profileLevels[i].profile)
    {
    }
    for (;;)
    {
      i += 1;
      break;
      gAVCEncoderCaps.profile = 3;
      setLevel(localCodecCapabilities.profileLevels[i], gAVCEncoderCaps);
    }
  }
  
  private static boolean onAttach(String paramString, int paramInt, boolean paramBoolean, Map<String, Object> paramMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NativeCodec", 0, "onAttach");
    }
    if (Build.VERSION.SDK_INT < 16) {}
    do
    {
      return false;
      paramString = new NativeCodec(paramString, paramMap, paramBoolean);
    } while (paramString.mCodec == null);
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
      if (QLog.isColorLevel()) {
        QLog.d("NativeCodec", 0, this.mDebugTag + " frameIndex:" + paramInt);
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
    if (Build.VERSION.SDK_INT < 16) {}
    NativeCodec localNativeCodec;
    do
    {
      return;
      localNativeCodec = (NativeCodec)???;
    } while (localNativeCodec == null);
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
    try
    {
      localNativeCodec.mCodec.stop();
      localNativeCodec.mCodec.release();
      label137:
      localNativeCodec.mCodec = null;
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      break label137;
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.mCodec == null) {
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
      Object localObject2;
      try
      {
        localObject2 = this.mCodec.getInputBuffer();
        paramInt1 = 0;
        if (localObject2 != null) {
          break label1171;
        }
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "inputbuffer not available");
        }
        int j = paramInt1;
        Object localObject3 = localObject2;
        try
        {
          AndroidCodec.BufferData localBufferData;
          int i;
          if (this.misdecoder)
          {
            j = paramInt1;
            localObject3 = localObject2;
            if (this.mTotalFrameNum == 0)
            {
              j = paramInt1;
              localObject3 = localObject2;
              Thread.sleep(10L);
              j = paramInt1;
              localObject3 = localObject2;
              localBufferData = this.mCodec.getInputBuffer();
              i = paramInt1 + 1;
              if (localBufferData != null)
              {
                if (!this.misdecoder) {
                  break label391;
                }
                paramInt1 = writeInputData(localBufferData.buffer, false);
                if (paramInt1 >= 0) {
                  break label409;
                }
                if (QLog.isColorLevel()) {
                  QLog.e("NativeCodec", 0, "writeInputData, sampleSize < 0");
                }
                return false;
              }
            }
            else
            {
              j = paramInt1;
              localObject3 = localObject2;
              Thread.sleep(50L);
              j = paramInt1;
              localObject3 = localObject2;
              localBufferData = this.mCodec.getInputBuffer();
              continue;
            }
          }
          else
          {
            j = paramInt1;
            localObject3 = localObject2;
            Thread.sleep(50L);
            j = paramInt1;
            localObject3 = localObject2;
            localBufferData = this.mCodec.getInputBuffer();
            continue;
          }
          j = i;
          localObject3 = localBufferData;
          if (QLog.isColorLevel())
          {
            j = i;
            localObject3 = localBufferData;
            QLog.e("NativeCodec", 0, "inputbuffer not available");
          }
          paramInt1 = i;
          localObject2 = localBufferData;
          if (i <= 12) {
            continue;
          }
          j = i;
          localObject3 = localBufferData;
          if (QLog.isColorLevel())
          {
            j = i;
            localObject3 = localBufferData;
            QLog.e("NativeCodec", 0, "inputbuffer not available, try count = " + i);
          }
          return false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          paramInt1 = j;
          localObject2 = localObject3;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("NativeCodec", 0, "onDoCodec InterruptedException", localInterruptedException);
        paramInt1 = j;
        localObject2 = localObject3;
        continue;
        paramInt1 = writeInputData2(localException.buffer, this.mColorFormat, false);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "onDoCodec Exception!", localException);
        }
        return false;
      }
      label391:
      continue;
      label409:
      this.mLastEncFrameTime += this.mFrameInverval;
      if (this.mDebugDelay) {
        this.mDebugDelayMap.put(this.mLastEncFrameTime, Long.valueOf(System.currentTimeMillis()));
      }
      this.mDebugIndexMap.put(this.mLastEncFrameTime, Long.valueOf(paramInt2));
      if (this.misdecoder)
      {
        this.mCodec.queueInputBuffer(localException.index, paramInt1, 0L, 0);
        if (!this.misdecoder) {
          break label696;
        }
        if (this.mTotalFrameNum != 0) {
          break label684;
        }
        localObject2 = this.mCodec.dequeueOutputBuffer_First();
        QLog.e("NativeCodec", 0, "dequeueOutputBuffer_Dec() begin sampleSize = " + paramInt1 + "buff.index = " + localException.index + "mTotalFrameNum = " + this.mTotalFrameNum);
        localObject1 = localObject2;
      }
      for (;;)
      {
        if (localObject1 == null) {
          break label1184;
        }
        if (((AndroidCodec.BufferData)localObject1).index >= 0) {
          break label708;
        }
        this.mTryAgainLaterCount += 1;
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "dequeueOutputBuffer, try again later, count = " + this.mTryAgainLaterCount);
        }
        if (this.mTryAgainLaterCount < 16) {
          break label1178;
        }
        QLog.e("NativeCodec", 0, "dequeueOutputBuffer, error count = " + this.mTryAgainLaterCount);
        return false;
        this.mCodec.queueInputBuffer(((AndroidCodec.BufferData)localObject1).index, paramInt1, this.mLastEncFrameTime, 0);
        break;
        label684:
        localObject1 = this.mCodec.dequeueOutputBuffer();
        continue;
        label696:
        localObject1 = this.mCodec.dequeueOutputBuffer();
      }
      label708:
      this.mTryAgainLaterCount = 0;
      if (!((AndroidCodec.BufferData)localObject1).success)
      {
        if (!QLog.isColorLevel()) {
          break label1180;
        }
        QLog.e("NativeCodec", 0, "onDoCodec err!");
        break label1180;
      }
      if ((((AndroidCodec.BufferData)localObject1).format == null) || (((AndroidCodec.BufferData)localObject1).buffer == null))
      {
        this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject1).index);
        return false;
      }
      if (this.misdecoder)
      {
        if (!HWColorFormat.isSupportedDecodeFormats(((AndroidCodec.BufferData)localObject1).format.getInteger("color-format")))
        {
          if (!QLog.isColorLevel()) {
            break label1182;
          }
          QLog.e("NativeCodec", 0, "onDoCodec don't support format!");
          break label1182;
        }
        calcDelay(true, ((AndroidCodec.BufferData)localObject1).info);
        setFrame(((AndroidCodec.BufferData)localObject1).buffer, ((AndroidCodec.BufferData)localObject1).info.size, ((AndroidCodec.BufferData)localObject1).format);
        this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject1).index);
        this.mTotalFrameNum += 1;
        break label1184;
      }
      if ((((AndroidCodec.BufferData)localObject1).info.flags != 1) || (((AndroidCodec.BufferData)localObject1).info.flags == 2))
      {
        this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject1).index);
        readOutputStream(((AndroidCodec.BufferData)localObject1).buffer, ((AndroidCodec.BufferData)localObject1).info.presentationTimeUs, ((AndroidCodec.BufferData)localObject1).info.offset, ((AndroidCodec.BufferData)localObject1).info.size, ((AndroidCodec.BufferData)localObject1).info.flags);
        localObject2 = this.mCodec.dequeueOutputBuffer();
        if (localObject2 != null)
        {
          if (((AndroidCodec.BufferData)localObject2).index < 0)
          {
            this.mTryAgainLaterCount2 += 1;
            if (QLog.isColorLevel()) {
              QLog.e("NativeCodec", 0, "re-dequeue dequeueOutputBuffer, try again later, count = " + this.mTryAgainLaterCount2);
            }
            if (this.mTryAgainLaterCount2 < 10) {
              break label1186;
            }
            return false;
          }
          this.mTryAgainLaterCount2 = 0;
          if (!((AndroidCodec.BufferData)localObject2).success)
          {
            if (!QLog.isColorLevel()) {
              break label1188;
            }
            QLog.e("NativeCodec", 0, "re-dequeue onDoCodec err!");
            break label1188;
          }
          if ((((AndroidCodec.BufferData)localObject2).format == null) || (((AndroidCodec.BufferData)localObject2).buffer == null))
          {
            this.mCodec.releaseOutputBuffer(((AndroidCodec.BufferData)localObject2).index);
            return false;
          }
        }
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.d("NativeCodec", 0, "re-dequeue success");
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          localObject2 = calcDelay(true, ((AndroidCodec.BufferData)localObject1).info);
          readOutputStream(((AndroidCodec.BufferData)localObject1).buffer, ((Long)localObject2).longValue(), ((AndroidCodec.BufferData)localObject1).info.offset, ((AndroidCodec.BufferData)localObject1).info.size, ((AndroidCodec.BufferData)localObject1).info.flags);
        }
        break;
      }
      label1171:
      Object localObject1 = localObject2;
    }
    label1178:
    return true;
    label1180:
    return false;
    label1182:
    return false;
    label1184:
    return true;
    label1186:
    return true;
    label1188:
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
    for (;;)
    {
      synchronized (this.mPendingInputBuffers)
      {
        if (this.mCodersExit.get())
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "hardware coders exit, return.");
          }
          return 2;
        }
        if (this.mPendingInputBuffers.size() <= 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("NativeCodec", 0, "InputData pendingInputBuffers exist, size: " + this.mPendingInputBuffers.size());
        }
        AndroidCodec.InputBufferData localInputBufferData = (AndroidCodec.InputBufferData)this.mPendingInputBuffers.get(0);
        if (localInputBufferData == null) {
          return 2;
        }
        if (localInputBufferData.buffer == null)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "inputbuffer null, return");
          }
          return -1;
        }
        if (localInputBufferData.processing)
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.misdecoder)
        {
          paramInt1 = writeInputData(localInputBufferData.buffer, false);
          if (paramInt1 <= 0) {
            break label350;
          }
          this.mLastEncFrameTime += this.mFrameInverval;
          this.mPendingInputBuffers.remove(0);
          if (this.mDebugDelay) {
            this.mDebugDelayMap.put(this.mLastEncFrameTime, Long.valueOf(System.currentTimeMillis()));
          }
          this.mDebugIndexMap.put(this.mLastEncFrameTime, Long.valueOf(paramInt2));
          this.mCodec.queueInputBuffer(localInputBufferData.index, paramInt1, this.mLastEncFrameTime, 0);
          return 1;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("NativeCodec", 0, "call writeInputData2 in onDoCodec");
      }
      paramInt1 = writeInputData2(localObject.buffer, this.mColorFormat, false);
    }
    for (;;)
    {
      return 0;
      label350:
      do
      {
        return -1;
        return 2;
        if (paramInt1 == 0) {
          break;
        }
      } while (paramInt1 != -1);
    }
  }
  
  public static native boolean putByteArray2ByteBuffer(ByteBuffer paramByteBuffer, int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4, int paramInt5);
  
  /* Error */
  private void resetCodec()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   4: ifnull +76 -> 80
    //   7: aload_0
    //   8: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 134	com/tencent/TMG/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 411	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   26: invokeinterface 414 1 0
    //   31: aload_0
    //   32: getfield 142	com/tencent/TMG/mediacodec/NativeCodec:mDebugIndexMap	Landroid/support/v4/util/LongSparseArray;
    //   35: invokevirtual 415	android/support/v4/util/LongSparseArray:clear	()V
    //   38: aload_0
    //   39: getfield 136	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelay	Z
    //   42: ifeq +17 -> 59
    //   45: aload_0
    //   46: getfield 138	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelayMap	Landroid/support/v4/util/LongSparseArray;
    //   49: invokevirtual 415	android/support/v4/util/LongSparseArray:clear	()V
    //   52: aload_0
    //   53: getfield 140	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelayMap2	Landroid/support/v4/util/LongSparseArray;
    //   56: invokevirtual 415	android/support/v4/util/LongSparseArray:clear	()V
    //   59: aload_0
    //   60: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   63: invokevirtual 418	com/tencent/TMG/mediacodec/AndroidCodec:stop	()V
    //   66: aload_0
    //   67: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   70: invokevirtual 421	com/tencent/TMG/mediacodec/AndroidCodec:release	()V
    //   73: aload_0
    //   74: aconst_null
    //   75: putfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   78: aload_1
    //   79: monitorexit
    //   80: aload_0
    //   81: getfield 157	com/tencent/TMG/mediacodec/NativeCodec:misdecoder	Z
    //   84: ifeq +75 -> 159
    //   87: aload_0
    //   88: invokespecial 237	com/tencent/TMG/mediacodec/NativeCodec:createDecCodec	()V
    //   91: aload_0
    //   92: lconst_0
    //   93: putfield 104	com/tencent/TMG/mediacodec/NativeCodec:mTimeStamp	J
    //   96: aload_0
    //   97: lconst_0
    //   98: putfield 106	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   101: aload_0
    //   102: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   105: ifnull +11 -> 116
    //   108: aload_0
    //   109: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   112: invokevirtual 381	com/tencent/TMG/mediacodec/AndroidCodec:start	()Z
    //   115: pop
    //   116: aload_0
    //   117: getfield 134	com/tencent/TMG/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   120: iconst_0
    //   121: invokevirtual 411	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   124: return
    //   125: astore_2
    //   126: aload_1
    //   127: monitorexit
    //   128: aload_2
    //   129: athrow
    //   130: astore_1
    //   131: aload_1
    //   132: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   135: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   138: ifeq +13 -> 151
    //   141: ldc 20
    //   143: iconst_0
    //   144: ldc_w 582
    //   147: aload_1
    //   148: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   151: aload_0
    //   152: aconst_null
    //   153: putfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   156: goto -76 -> 80
    //   159: aload_0
    //   160: invokevirtual 260	com/tencent/TMG/mediacodec/NativeCodec:createEncCodec	()V
    //   163: goto -72 -> 91
    //   166: astore_1
    //   167: aload_1
    //   168: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   171: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   174: ifeq -50 -> 124
    //   177: ldc 20
    //   179: iconst_0
    //   180: ldc_w 582
    //   183: aload_1
    //   184: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   187: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	188	0	this	NativeCodec
    //   130	18	1	localException1	Exception
    //   166	18	1	localException2	Exception
    //   125	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	59	125	finally
    //   59	80	125	finally
    //   126	128	125	finally
    //   7	14	130	java/lang/Exception
    //   128	130	130	java/lang/Exception
    //   80	91	166	java/lang/Exception
    //   91	116	166	java/lang/Exception
    //   116	124	166	java/lang/Exception
    //   159	163	166	java/lang/Exception
  }
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i1 = paramMediaFormat.getInteger("width");
    int i2 = paramMediaFormat.getInteger("height");
    int m = paramMediaFormat.getInteger(LEFT);
    int i4 = paramMediaFormat.getInteger(RIGHT);
    int i5 = paramMediaFormat.getInteger(TOP);
    int i3 = paramMediaFormat.getInteger(BOTTOM);
    int k = paramMediaFormat.getInteger(STRIDE);
    int j = paramMediaFormat.getInteger(SLICEHEIGHT);
    int i6 = paramMediaFormat.getInteger("color-format");
    int i = j;
    if (j < i2) {
      i = i2;
    }
    j = k;
    if (k < i1) {
      j = i1;
    }
    int n = i;
    k = i5;
    if (i6 == 2130706688)
    {
      n = i - i5 / 2;
      k = 0;
      m = 0;
    }
    i = j;
    if (j < i1) {
      i = i1;
    }
    if (((2141391876 == i6) || (2130706433 == i6) || (2130706944 == i6)) && (i2 < n)) {}
    for (j = n;; j = i2)
    {
      if (m + i4 + k + i3 == 0)
      {
        m = 0;
        i2 -= 1;
        k = 0;
        i3 = i1 - 1;
        i1 = j;
        n = i;
        j = i3;
        i = i2;
        if ((n <= 0) || (i1 <= 0) || (j <= 0) || (i <= 0))
        {
          if (QLog.isColorLevel()) {
            QLog.e("NativeCodec", 0, "error decoderInfomations.");
          }
          return false;
        }
      }
      else
      {
        i2 = i4 - m + 1;
        i1 = i3 - k + 1;
        n = i;
        if (i < i2) {
          n = i2;
        }
        if (j >= i1) {
          break label380;
        }
      }
      label380:
      for (i = i1;; i = j)
      {
        j = i4;
        i1 = i;
        i = i3;
        break;
        SystemClock.elapsedRealtime();
        paramInt = readOutputDataEx(paramByteBuffer, paramInt, n, i1, m, k, j - m + 1, i - k + 1, i6);
        SystemClock.elapsedRealtime();
        return paramInt > 0;
      }
    }
  }
  
  private static void setLevel(MediaCodecInfo.CodecProfileLevel paramCodecProfileLevel, NativeCodec.AVCCaps paramAVCCaps)
  {
    if (paramCodecProfileLevel.level == 1) {
      if ((paramAVCCaps.width < 176) || (paramAVCCaps.height < 144))
      {
        paramAVCCaps.width = 176;
        paramAVCCaps.height = 144;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    return;
                                    if (paramCodecProfileLevel.level != 4) {
                                      break;
                                    }
                                  } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                                  paramAVCCaps.width = 352;
                                  paramAVCCaps.height = 288;
                                  return;
                                  if (paramCodecProfileLevel.level != 8) {
                                    break;
                                  }
                                } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                                paramAVCCaps.width = 352;
                                paramAVCCaps.height = 288;
                                return;
                                if (paramCodecProfileLevel.level != 16) {
                                  break;
                                }
                              } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                              paramAVCCaps.width = 352;
                              paramAVCCaps.height = 288;
                              return;
                              if (paramCodecProfileLevel.level != 2) {
                                break;
                              }
                            } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                            paramAVCCaps.width = 352;
                            paramAVCCaps.height = 288;
                            return;
                            if (paramCodecProfileLevel.level != 32) {
                              break;
                            }
                          } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 288));
                          paramAVCCaps.width = 352;
                          paramAVCCaps.height = 288;
                          return;
                          if (paramCodecProfileLevel.level != 64) {
                            break;
                          }
                        } while ((paramAVCCaps.width >= 352) && (paramAVCCaps.height >= 576));
                        paramAVCCaps.width = 352;
                        paramAVCCaps.height = 576;
                        return;
                        if (paramCodecProfileLevel.level != 128) {
                          break;
                        }
                      } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                      paramAVCCaps.width = 720;
                      paramAVCCaps.height = 576;
                      return;
                      if (paramCodecProfileLevel.level != 256) {
                        break;
                      }
                    } while ((paramAVCCaps.width >= 720) && (paramAVCCaps.height >= 576));
                    paramAVCCaps.width = 720;
                    paramAVCCaps.height = 576;
                    return;
                    if (paramCodecProfileLevel.level != 512) {
                      break;
                    }
                  } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 720));
                  paramAVCCaps.width = 1280;
                  paramAVCCaps.height = 720;
                  return;
                  if (paramCodecProfileLevel.level != 1024) {
                    break;
                  }
                } while ((paramAVCCaps.width >= 1280) && (paramAVCCaps.height >= 1024));
                paramAVCCaps.width = 1280;
                paramAVCCaps.height = 1024;
                return;
                if (paramCodecProfileLevel.level != 2048) {
                  break;
                }
              } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
              paramAVCCaps.width = 2048;
              paramAVCCaps.height = 1024;
              return;
              if (paramCodecProfileLevel.level != 4096) {
                break;
              }
            } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1024));
            paramAVCCaps.width = 2048;
            paramAVCCaps.height = 1024;
            return;
            if (paramCodecProfileLevel.level != 8192) {
              break;
            }
          } while ((paramAVCCaps.width >= 2048) && (paramAVCCaps.height >= 1088));
          paramAVCCaps.width = 2048;
          paramAVCCaps.height = 1088;
          return;
          if (paramCodecProfileLevel.level != 16384) {
            break;
          }
        } while ((paramAVCCaps.width >= 3680) && (paramAVCCaps.height >= 1536));
        paramAVCCaps.width = 3680;
        paramAVCCaps.height = 1536;
        return;
        if (paramCodecProfileLevel.level != 32768) {
          break;
        }
      } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2304));
      paramAVCCaps.width = 4096;
      paramAVCCaps.height = 2304;
      return;
      if (paramCodecProfileLevel.level != 65536) {
        break;
      }
    } while ((paramAVCCaps.width >= 4096) && (paramAVCCaps.height >= 2304));
    paramAVCCaps.width = 4096;
    paramAVCCaps.height = 2304;
    return;
    QLog.e("NativeCodec", 0, "initAVCEncoderCaps level.level = " + paramCodecProfileLevel.level);
  }
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.mCodec == null) {}
    do
    {
      do
      {
        do
        {
          return;
        } while (paramString == null);
        if (!paramString.equalsIgnoreCase("frame-rate")) {
          break;
        }
      } while (paramInt <= 0);
      this.mFrameRate = paramInt;
      this.mFrameInverval = (1000000 / this.mFrameRate);
      resetCodec();
      if (QLog.isColorLevel()) {
        QLog.d("NativeCodec", 0, "HWENC setParameters mFrameRate = " + this.mFrameRate);
      }
    } while (Build.VERSION.SDK_INT < 19);
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, paramInt);
    this.mCodec.setParameters(localBundle);
  }
  
  public static native void set_device_infos(String paramString);
  
  public native boolean attachCodec(Object paramObject);
  
  Long calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    Long localLong1 = (Long)this.mDebugIndexMap.get(paramBufferInfo.presentationTimeUs);
    if (this.mDebugDelay)
    {
      Long localLong2 = (Long)this.mDebugDelayMap.get(paramBufferInfo.presentationTimeUs);
      if (localLong2 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeCodec", 0, this.mDebugTag + "small, " + paramBufferInfo.presentationTimeUs + ", takes:" + (System.currentTimeMillis() - localLong2.longValue()));
        }
        this.mDebugDelayMap.remove(paramBufferInfo.presentationTimeUs);
      }
      if (localLong1 != null)
      {
        localLong2 = (Long)this.mDebugDelayMap2.get(localLong1.longValue());
        if (localLong2 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("NativeCodec", 0, this.mDebugTag + "big, " + paramBufferInfo.presentationTimeUs + ", takes:" + (System.currentTimeMillis() - localLong2.longValue()));
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
    int i;
    Object localObject;
    label61:
    int j;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    if (this.mCodec == null) {
      try
      {
        List localList = AndroidCodec.getEndoderInfos(this.mMime);
        this.mColorFormat = 21;
        i = 0;
        if (i < localList.size())
        {
          localObject = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), AndroidCodec.AVC_CODEC_MIME);
          if (localObject == null)
          {
            i = 0;
            this.mCodec = new AndroidCodec();
            localObject = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
            ((MediaFormat)localObject).setInteger("color-format", this.mColorFormat);
            ((MediaFormat)localObject).setInteger("frame-rate", this.mFrameRate);
            ((MediaFormat)localObject).setInteger("bitrate", this.mBitRate);
            j = 30;
            if (this.mFrameRate * 30 > 255) {
              j = 255 / this.mFrameRate;
            }
            if (QLog.isColorLevel()) {
              QLog.d("NativeCodec", 0, "KEY_I_FRAME_INTERVAL = " + j + ", mFrameRate = " + this.mFrameRate);
            }
            if (Build.VERSION.SDK_INT >= 19) {
              break label287;
            }
            ((MediaFormat)localObject).setInteger("i-frame-interval", j);
          }
          for (;;)
          {
            localCodecCapabilities = AndroidCodec.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
            j = 16;
            if (localCodecCapabilities != null) {
              break label329;
            }
            this.mCodec = null;
            return;
            if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21))
            {
              this.mColorFormat = 21;
              break;
            }
            if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
              break label493;
            }
            this.mColorFormat = 19;
            break;
            label287:
            ((MediaFormat)localObject).setInteger("i-frame-interval", j);
          }
          m = 0;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("NativeCodec", 0, "createEncCodec", localException);
        }
        this.mCodec = null;
        return;
      }
    }
    for (;;)
    {
      label329:
      int m;
      if (m < localCodecCapabilities.profileLevels.length) {}
      switch (localCodecCapabilities.profileLevels[m].profile)
      {
      case 1: 
        ((MediaFormat)localObject).setInteger("profile", 1);
        int k = j;
        if (j < localCodecCapabilities.profileLevels[m].level) {
          k = localCodecCapabilities.profileLevels[m].level;
        }
        ((MediaFormat)localObject).setInteger("level", k);
        j = k;
        break label500;
        this.mFormat = ((MediaFormat)localObject);
        if (this.mFrameRate > 0) {}
        for (this.mFrameInverval = (1000000 / this.mFrameRate);; this.mFrameInverval = 40000)
        {
          this.mCodec.init(this.mFormat, ((MediaCodecInfo)localException.get(i)).getName(), this);
          return;
        }
        i = 0;
        break label61;
        return;
        i += 1;
        break;
      default: 
        label493:
        label500:
        m += 1;
      }
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
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: aload_0
    //   7: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   10: iload_2
    //   11: invokevirtual 655	com/tencent/TMG/mediacodec/AndroidCodec:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +36 -> 54
    //   21: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   24: ifeq +29 -> 53
    //   27: ldc 20
    //   29: iconst_0
    //   30: new 214	java/lang/StringBuilder
    //   33: dup
    //   34: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   37: ldc_w 657
    //   40: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 365	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: return
    //   54: iload 5
    //   56: istore_3
    //   57: aload_0
    //   58: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   61: astore_1
    //   62: iload 5
    //   64: istore_3
    //   65: aload_1
    //   66: monitorenter
    //   67: aload_0
    //   68: getfield 134	com/tencent/TMG/mediacodec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   71: invokevirtual 558	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   74: ifeq +81 -> 155
    //   77: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   80: ifeq +12 -> 92
    //   83: ldc 20
    //   85: iconst_0
    //   86: ldc_w 659
    //   89: invokestatic 365	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   92: aload_1
    //   93: monitorexit
    //   94: aload_0
    //   95: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   98: astore_1
    //   99: aload_1
    //   100: monitorenter
    //   101: aload_0
    //   102: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   105: iconst_0
    //   106: invokeinterface 277 2 0
    //   111: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   114: iconst_0
    //   115: putfield 570	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   118: aload_1
    //   119: monitorexit
    //   120: return
    //   121: astore 6
    //   123: aload_1
    //   124: monitorexit
    //   125: aload 6
    //   127: athrow
    //   128: astore 6
    //   130: aload 6
    //   132: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   135: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   138: ifeq -20 -> 118
    //   141: ldc 20
    //   143: iconst_0
    //   144: ldc_w 661
    //   147: aload 6
    //   149: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   152: goto -34 -> 118
    //   155: aload_0
    //   156: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   159: new 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   162: dup
    //   163: aload 6
    //   165: iload_2
    //   166: invokespecial 664	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   169: invokeinterface 667 2 0
    //   174: pop
    //   175: aload_0
    //   176: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   179: iconst_0
    //   180: invokeinterface 277 2 0
    //   185: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   188: iconst_1
    //   189: putfield 570	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   192: aload_1
    //   193: monitorexit
    //   194: iload 5
    //   196: istore_3
    //   197: aload_0
    //   198: getfield 157	com/tencent/TMG/mediacodec/NativeCodec:misdecoder	Z
    //   201: ifeq +248 -> 449
    //   204: iload 5
    //   206: istore_3
    //   207: aload_0
    //   208: aload_0
    //   209: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   212: iconst_0
    //   213: invokeinterface 277 2 0
    //   218: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   221: getfield 565	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   224: iconst_1
    //   225: invokevirtual 451	com/tencent/TMG/mediacodec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   228: istore_2
    //   229: iload_2
    //   230: ifle +114 -> 344
    //   233: iload_2
    //   234: istore_3
    //   235: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   238: ifeq +31 -> 269
    //   241: iload_2
    //   242: istore_3
    //   243: ldc 20
    //   245: iconst_0
    //   246: new 214	java/lang/StringBuilder
    //   249: dup
    //   250: invokespecial 215	java/lang/StringBuilder:<init>	()V
    //   253: ldc_w 669
    //   256: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: iload_2
    //   260: invokevirtual 224	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   263: invokevirtual 230	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   266: invokestatic 234	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   269: iload_2
    //   270: istore_3
    //   271: aload_0
    //   272: aload_0
    //   273: getfield 106	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   276: aload_0
    //   277: getfield 122	com/tencent/TMG/mediacodec/NativeCodec:mFrameInverval	I
    //   280: i2l
    //   281: ladd
    //   282: putfield 106	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   285: iload_2
    //   286: istore_3
    //   287: aload_0
    //   288: getfield 136	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelay	Z
    //   291: ifeq +22 -> 313
    //   294: iload_2
    //   295: istore_3
    //   296: aload_0
    //   297: getfield 138	com/tencent/TMG/mediacodec/NativeCodec:mDebugDelayMap	Landroid/support/v4/util/LongSparseArray;
    //   300: aload_0
    //   301: getfield 106	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   304: invokestatic 392	java/lang/System:currentTimeMillis	()J
    //   307: invokestatic 398	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   310: invokevirtual 402	android/support/v4/util/LongSparseArray:put	(JLjava/lang/Object;)V
    //   313: iload_2
    //   314: istore_3
    //   315: aload_0
    //   316: getfield 253	com/tencent/TMG/mediacodec/NativeCodec:mCodec	Lcom/tencent/TMG/mediacodec/AndroidCodec;
    //   319: aload_0
    //   320: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   323: iconst_0
    //   324: invokeinterface 277 2 0
    //   329: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   332: getfield 576	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:index	I
    //   335: iload_2
    //   336: aload_0
    //   337: getfield 106	com/tencent/TMG/mediacodec/NativeCodec:mLastEncFrameTime	J
    //   340: iconst_0
    //   341: invokevirtual 475	com/tencent/TMG/mediacodec/AndroidCodec:queueInputBuffer	(IIJI)V
    //   344: aload_0
    //   345: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   348: astore_1
    //   349: aload_1
    //   350: monitorenter
    //   351: aload_0
    //   352: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   355: iconst_0
    //   356: invokeinterface 277 2 0
    //   361: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   364: iconst_0
    //   365: putfield 570	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   368: iload_2
    //   369: ifle +14 -> 383
    //   372: aload_0
    //   373: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   376: iconst_0
    //   377: invokeinterface 575 2 0
    //   382: pop
    //   383: aload_1
    //   384: monitorexit
    //   385: return
    //   386: astore 6
    //   388: aload_1
    //   389: monitorexit
    //   390: aload 6
    //   392: athrow
    //   393: astore 6
    //   395: aload_1
    //   396: monitorexit
    //   397: iload 5
    //   399: istore_3
    //   400: aload 6
    //   402: athrow
    //   403: astore 6
    //   405: aload_0
    //   406: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   409: astore_1
    //   410: aload_1
    //   411: monitorenter
    //   412: aload_0
    //   413: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   416: iconst_0
    //   417: invokeinterface 277 2 0
    //   422: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   425: iconst_0
    //   426: putfield 570	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:processing	Z
    //   429: iload_3
    //   430: ifle +14 -> 444
    //   433: aload_0
    //   434: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   437: iconst_0
    //   438: invokeinterface 575 2 0
    //   443: pop
    //   444: aload_1
    //   445: monitorexit
    //   446: aload 6
    //   448: athrow
    //   449: iload 5
    //   451: istore_3
    //   452: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   455: ifeq +15 -> 470
    //   458: iload 5
    //   460: istore_3
    //   461: ldc 20
    //   463: iconst_0
    //   464: ldc_w 671
    //   467: invokestatic 234	com/tencent/TMG/utils/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iload 5
    //   472: istore_3
    //   473: aload_0
    //   474: aload_0
    //   475: getfield 127	com/tencent/TMG/mediacodec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   478: iconst_0
    //   479: invokeinterface 277 2 0
    //   484: checkcast 564	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData
    //   487: getfield 565	com/tencent/TMG/mediacodec/AndroidCodec$InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   490: aload_0
    //   491: getfield 464	com/tencent/TMG/mediacodec/NativeCodec:mColorFormat	I
    //   494: iconst_1
    //   495: invokevirtual 468	com/tencent/TMG/mediacodec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   498: istore_2
    //   499: goto -270 -> 229
    //   502: astore_1
    //   503: iload 5
    //   505: istore_3
    //   506: aload_1
    //   507: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   510: iload 4
    //   512: istore_2
    //   513: iload 5
    //   515: istore_3
    //   516: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   519: ifeq -290 -> 229
    //   522: iload 5
    //   524: istore_3
    //   525: ldc 20
    //   527: iconst_0
    //   528: ldc_w 673
    //   531: aload_1
    //   532: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   535: iload 4
    //   537: istore_2
    //   538: goto -309 -> 229
    //   541: astore_1
    //   542: iload_2
    //   543: istore_3
    //   544: aload_1
    //   545: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   548: iload_2
    //   549: istore_3
    //   550: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   553: ifeq -209 -> 344
    //   556: iload_2
    //   557: istore_3
    //   558: ldc 20
    //   560: iconst_0
    //   561: ldc_w 675
    //   564: aload_1
    //   565: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   568: goto -224 -> 344
    //   571: astore 6
    //   573: aload 6
    //   575: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   578: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   581: ifeq -198 -> 383
    //   584: ldc 20
    //   586: iconst_0
    //   587: ldc_w 661
    //   590: aload 6
    //   592: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   595: goto -212 -> 383
    //   598: astore 7
    //   600: aload 7
    //   602: invokevirtual 247	java/lang/Exception:printStackTrace	()V
    //   605: invokestatic 212	com/tencent/TMG/utils/QLog:isColorLevel	()Z
    //   608: ifeq -164 -> 444
    //   611: ldc 20
    //   613: iconst_0
    //   614: ldc_w 661
    //   617: aload 7
    //   619: invokestatic 251	com/tencent/TMG/utils/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Exception;)V
    //   622: goto -178 -> 444
    //   625: astore 6
    //   627: aload_1
    //   628: monitorexit
    //   629: aload 6
    //   631: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	632	0	this	NativeCodec
    //   0	632	2	paramInt	int
    //   56	502	3	i	int
    //   4	532	4	j	int
    //   1	522	5	k	int
    //   14	3	6	localByteBuffer	ByteBuffer
    //   121	5	6	localObject1	Object
    //   128	36	6	localException1	Exception
    //   386	5	6	localObject2	Object
    //   393	8	6	localObject3	Object
    //   403	44	6	localObject4	Object
    //   571	20	6	localException2	Exception
    //   625	5	6	localObject5	Object
    //   598	20	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   101	118	121	finally
    //   118	120	121	finally
    //   123	125	121	finally
    //   130	152	121	finally
    //   101	118	128	java/lang/Exception
    //   351	368	386	finally
    //   372	383	386	finally
    //   383	385	386	finally
    //   388	390	386	finally
    //   573	595	386	finally
    //   67	92	393	finally
    //   92	94	393	finally
    //   155	194	393	finally
    //   395	397	393	finally
    //   57	62	403	finally
    //   65	67	403	finally
    //   197	204	403	finally
    //   207	229	403	finally
    //   235	241	403	finally
    //   243	269	403	finally
    //   271	285	403	finally
    //   287	294	403	finally
    //   296	313	403	finally
    //   315	344	403	finally
    //   400	403	403	finally
    //   452	458	403	finally
    //   461	470	403	finally
    //   473	499	403	finally
    //   506	510	403	finally
    //   516	522	403	finally
    //   525	535	403	finally
    //   544	548	403	finally
    //   550	556	403	finally
    //   558	568	403	finally
    //   197	204	502	java/lang/Exception
    //   207	229	502	java/lang/Exception
    //   452	458	502	java/lang/Exception
    //   461	470	502	java/lang/Exception
    //   473	499	502	java/lang/Exception
    //   315	344	541	java/lang/Exception
    //   351	368	571	java/lang/Exception
    //   372	383	571	java/lang/Exception
    //   412	429	598	java/lang/Exception
    //   433	444	598	java/lang/Exception
    //   412	429	625	finally
    //   433	444	625	finally
    //   444	446	625	finally
    //   600	622	625	finally
    //   627	629	625	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get()) {
      if (QLog.isColorLevel()) {
        QLog.e("NativeCodec", 0, "codec exit, return onOutputBufferAvailable");
      }
    }
    do
    {
      return;
      paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.misdecoder)
    {
      MediaFormat localMediaFormat = this.mCodec.getOutputFormat(paramInt);
      if (localMediaFormat != null)
      {
        calcDelay(false, paramBufferInfo);
        setFrame(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
      }
    }
    for (;;)
    {
      this.mCodec.releaseOutputBuffer(paramInt);
      return;
      if (QLog.isColorLevel())
      {
        QLog.e("NativeCodec", 0, "getOutputFormat null");
        continue;
        if (paramBufferInfo.flags == 1) {}
        calcDelay(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
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
      if (this.setBitRatePending > 0) {
        localBundle.putInt("bitrate", this.setBitRatePending);
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