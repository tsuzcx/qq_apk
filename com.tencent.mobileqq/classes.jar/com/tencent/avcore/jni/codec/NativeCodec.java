package com.tencent.avcore.jni.codec;

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
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.avcore.util.AVCoreLog;
import com.tencent.avcore.util.ArrayUtils;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
public class NativeCodec
  extends NativeCodecBase
  implements IMediaCodecCallback
{
  public static final String AVCPPS = "csd-1";
  public static final String AVCSPS = "csd-0";
  public static final String BOTTOM = "crop-bottom";
  public static final String HEVCVPSSPSPPS = "csd-0";
  public static final String LEFT = "crop-left";
  public static final String RIGHT = "crop-right";
  public static final String SLICEHEIGHT = "slice-height";
  public static final String STRIDE = "stride";
  public static final String TOP = "crop-top";
  public static boolean printLog = false;
  private int mBitRate;
  private AndroidCodecBase mCodec;
  private AtomicBoolean mCodersExit = new AtomicBoolean(false);
  private int mColorFormat;
  private boolean mDebugDelay = false;
  private Map<Long, Long> mDebugDelayMap = null;
  private Map<Integer, Long> mDebugDelayMap2 = null;
  private Map<Long, Integer> mDebugIndexMap = null;
  private MediaFormat mFormat = null;
  private int mFrameInterval = 40000;
  private int mFrameRate = 20;
  private int mHeight = 240;
  private int mHwDetectMode = 0;
  private boolean mIsDecoder;
  private long mLastEncFrameTime = 0L;
  private String mMime;
  private long mNativeContext = 0L;
  private final List<InputBufferData> mPendingInputBuffers = new ArrayList();
  public final String mTag;
  private long mTimeStamp = 0L;
  private int mTotalDecInFrameNum = 0;
  private int mTotalDecOutFrameNum = 0;
  private int mTryAgainLaterCount = 0;
  private int mTryAgainLaterCount2 = 0;
  private int mWidth = 320;
  private int setBitRatePending = 0;
  private boolean setIFramePending = false;
  
  public NativeCodec()
  {
    this.mTag = ("NativeCodec_" + AVCoreLog.genDebugSeq());
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, long paramLong, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.mIsDecoder = paramBoolean;
    Object localObject2 = new StringBuilder().append("NativeCodec_");
    Object localObject1;
    if (sUseAsyncAPI)
    {
      localObject1 = "Async_";
      localObject2 = ((StringBuilder)localObject2).append((String)localObject1);
      if (!this.mIsDecoder) {
        break label627;
      }
      localObject1 = "DEC";
      label178:
      this.mTag = ((String)localObject1 + "_i" + paramLong + "_" + AVCoreLog.genDebugSeq());
      this.mMime = paramString;
      this.mNativeContext = paramLong;
      this.mWidth = ((Integer)paramMap.get("width")).intValue();
      this.mHeight = ((Integer)paramMap.get("height")).intValue();
      if ((AVCoreLog.isDebugVersion()) || (AVCoreLog.isGrayVersion())) {
        this.mHwDetectMode = ((Integer)paramMap.get("hw-detect-mode")).intValue();
      }
      if (AVCoreLog.isLogColorOrGary()) {
        AVCoreLog.e(this.mTag, "NativeCodec, w[" + this.mWidth + "], h[" + this.mHeight + "], isDecoder[" + this.mIsDecoder + "], mMime[" + this.mMime + "], hwDetectMode[" + this.mHwDetectMode + "]");
      }
      if (!this.mIsDecoder) {
        break label644;
      }
    }
    for (;;)
    {
      try
      {
        int i = this.mWidth;
        int j = this.mHeight;
        this.mFormat = MediaFormat.createVideoFormat(paramString, i, j);
        if (paramString.contains("video/avc"))
        {
          this.mFormat.setInteger("max-input-size", i * j);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          localObject1 = (ByteBuffer)paramMap.get("csd-0");
          localObject2 = (ByteBuffer)paramMap.get("csd-1");
          this.mFormat.setByteBuffer("csd-0", (ByteBuffer)localObject1);
          this.mFormat.setByteBuffer("csd-1", (ByteBuffer)localObject2);
        }
        if (paramString.contains("video/hevc"))
        {
          this.mFormat.setInteger("max-input-size", i * j);
          this.mFormat.setInteger("color-format", 21);
          this.mFormat.setInteger("frame-rate", 25);
          paramString = (ByteBuffer)paramMap.get("csd-0");
          this.mFormat.setByteBuffer("csd-0", paramString);
        }
        createDecCodec();
      }
      catch (Exception paramString)
      {
        label627:
        this.mCodec = null;
        continue;
      }
      if (this.mDebugDelay)
      {
        this.mDebugDelayMap = new HashMap();
        this.mDebugDelayMap2 = new HashMap();
        this.mDebugIndexMap = new HashMap();
      }
      return;
      localObject1 = "Sync_";
      break;
      localObject1 = "ENC";
      break label178;
      try
      {
        label644:
        this.mBitRate = ((Integer)paramMap.get("bitrate")).intValue();
        this.mFrameRate = ((Integer)paramMap.get("frame-rate")).intValue();
        createEncCodec();
      }
      catch (Exception paramString)
      {
        this.mCodec = null;
        AVCoreLog.e(this.mTag, "NativeCodec, createEncCodec Exception", paramString);
      }
    }
  }
  
  public static boolean canLog()
  {
    return (AVCoreLog.isDevelopLevel()) || ((AVCoreLog.isColorLevel()) && (printLog));
  }
  
  private void createDecCodec()
  {
    this.mCodec = AndroidCodecAdapterProxy.getInstance().createDecCodec(this.mTag);
    List localList;
    if (this.mIsDecoder)
    {
      localList = AndroidCodecBase.getDecoderInfos(this.mMime);
      if (localList.size() != 0) {
        break label51;
      }
      AVCoreLog.e(this.mTag, "createDecCodec fail, list.size为0");
    }
    label51:
    label204:
    for (;;)
    {
      return;
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      int i = 0;
      Object localObject;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (i >= localList.size()) {
          break label143;
        }
        localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject != null) {
          break;
        }
        i += 1;
      }
      if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19))
      {
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 19);
      }
      for (;;)
      {
        if (this.mCodec.init(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
          break label204;
        }
        this.mCodec = null;
        return;
        if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {
          break;
        }
        localObject = (MediaCodecInfo)localList.get(i);
        this.mFormat.setInteger("color-format", 21);
      }
    }
  }
  
  private void createEncCodec()
  {
    int m = 0;
    int i;
    Object localObject;
    label85:
    int j;
    MediaCodecInfo.CodecCapabilities localCodecCapabilities;
    int k;
    if (this.mCodec == null)
    {
      try
      {
        List localList = AndroidCodecBase.getEndoderInfos(this.mMime);
        this.mColorFormat = 21;
        i = 0;
        if (i >= localList.size()) {
          break label745;
        }
        localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject == null) {
          break label750;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 21)) {}
        for (this.mColorFormat = 21;; this.mColorFormat = 19)
        {
          localObject = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
          ((MediaFormat)localObject).setInteger("color-format", this.mColorFormat);
          ((MediaFormat)localObject).setInteger("frame-rate", this.mFrameRate);
          ((MediaFormat)localObject).setInteger("bitrate", this.mBitRate);
          j = 30;
          if (this.mFrameRate * 30 > 255) {
            j = 255 / this.mFrameRate;
          }
          AVCoreLog.e(this.mTag, "KEY_I_FRAME_INTERVAL =" + j + ", mFrameRate = " + this.mFrameRate);
          ((MediaFormat)localObject).setInteger("i-frame-interval", j);
          localCodecCapabilities = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
          if (localCodecCapabilities == null) {
            break;
          }
          if (!this.mMime.contains("video/avc")) {
            break label466;
          }
          j = 0;
          if (j >= localCodecCapabilities.profileLevels.length) {
            break label466;
          }
          switch (localCodecCapabilities.profileLevels[j].profile)
          {
          case 1: 
            if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject).colorFormats, 19)) {
              break label750;
            }
          }
        }
        k = 512;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (512 < localCodecCapabilities.profileLevels[j].level) {
          k = localCodecCapabilities.profileLevels[j].level;
        }
        ((MediaFormat)localObject).setInteger("level", k);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        AVCoreLog.e(this.mTag, "Exception at CreateCodec!!!!");
        this.mCodec = null;
      }
    }
    else
    {
      return;
      if (((!AVCoreLog.isDebugVersion()) && (!AVCoreLog.isGrayVersion())) || (this.mHwDetectMode != 2)) {
        break label757;
      }
      k = 512;
      ((MediaFormat)localObject).setInteger("profile", 8);
      if (512 < localCodecCapabilities.profileLevels[j].level) {
        k = localCodecCapabilities.profileLevels[j].level;
      }
      ((MediaFormat)localObject).setInteger("level", k);
      break label757;
    }
    label466:
    if (this.mMime.contains("video/hevc")) {
      j = m;
    }
    for (;;)
    {
      if (j < localCodecCapabilities.profileLevels.length) {}
      switch (localCodecCapabilities.profileLevels[j].profile)
      {
      case 1: 
        k = 16384;
        ((MediaFormat)localObject).setInteger("profile", 1);
        if (16384 < localCodecCapabilities.profileLevels[j].level) {
          k = localCodecCapabilities.profileLevels[j].level;
        }
        String str = AVCoreSystemInfo.getCpuModel();
        if ((str != null) && ((str.equalsIgnoreCase("QualcommTechnologies,IncMSM8953")) || (str.equalsIgnoreCase("QualcommTechnologies,Inc625"))))
        {
          ((MediaFormat)localObject).setInteger("level", 16384);
        }
        else
        {
          ((MediaFormat)localObject).setInteger("level", k);
          break label764;
          this.mFormat = ((MediaFormat)localObject);
          if (this.mFrameRate > 0) {}
          for (this.mFrameInterval = (1000000 / this.mFrameRate);; this.mFrameInterval = 40000)
          {
            this.mCodec = AndroidCodecAdapterProxy.getInstance().createEncCodec(this.mTag);
            AVCoreLog.e(this.mTag, "createEncCodec format: " + localObject + ", codec name: " + ((MediaCodecInfo)localException.get(i)).getName());
            this.mCodec.init(this.mFormat, ((MediaCodecInfo)localException.get(i)).getName(), this);
            return;
          }
          i = 0;
          break label85;
          i += 1;
          break;
          j += 1;
        }
        break;
      default: 
        label745:
        label750:
        label757:
        label764:
        j += 1;
      }
    }
  }
  
  private boolean dequeueLastFrame(int paramInt)
  {
    if (this.mCodec == null)
    {
      if (AVCoreLog.isLogColorOrGary()) {
        AVCoreLog.e(this.mTag, "dequeueLastFrame err!! mCodec is null");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        BufferData localBufferData = this.mCodec.getInputBuffer();
        int i = 0;
        Object localObject = localBufferData;
        int j;
        if (localBufferData == null)
        {
          j = i + 1;
          if (this.mIsDecoder) {
            dequeueOutFrameMore(3000000L);
          }
          localBufferData = this.mCodec.getInputBuffer();
          if (localBufferData != null) {
            localObject = localBufferData;
          }
        }
        else
        {
          ((BufferData)localObject).buffer = null;
          this.mCodec.queueInputBuffer(((BufferData)localObject).index, 0, 0L, 4);
          i = 0;
          j = 0;
          if (i >= 10) {
            break;
          }
          i += 1;
          localBufferData = this.mCodec.dequeueOutputBuffer();
          if ((localBufferData == null) || (localBufferData.index < 0)) {
            break label508;
          }
          if (localBufferData.success) {
            continue;
          }
          if (!AVCoreLog.isLogColorOrGary()) {
            break label505;
          }
          AVCoreLog.e(this.mTag, "dequeueLastFrame output.success is false");
          continue;
        }
        i = j;
        if (j <= 8) {
          continue;
        }
        if (!AVCoreLog.isLogColorOrGary()) {
          break label511;
        }
        AVCoreLog.e(this.mTag, "dequeueLastFrame not available, try count=" + j);
        break label511;
        if ((localBufferData.format == null) || (localBufferData.buffer == null))
        {
          if (AVCoreLog.isLogColorOrGary())
          {
            localObject = this.mTag;
            StringBuilder localStringBuilder = new StringBuilder().append("dequeueLastFrame err! output.format == null: ");
            if (localBufferData.format != null) {
              break label513;
            }
            bool = true;
            localStringBuilder = localStringBuilder.append(bool).append(", output.buffer == null: ");
            if (localBufferData.buffer != null) {
              break label519;
            }
            bool = true;
            AVCoreLog.e((String)localObject, bool);
          }
          this.mCodec.releaseOutputBuffer(localBufferData.index);
          continue;
        }
        if (this.mIsDecoder)
        {
          setFrame(localBufferData.buffer, localBufferData.info.size, localBufferData.format);
          this.mCodec.releaseOutputBuffer(localBufferData.index);
          if ((localBufferData.info.flags & 0x4) != 0)
          {
            if (!AVCoreLog.isLogColorOrGary()) {
              break;
            }
            AVCoreLog.e(this.mTag, "dequeueLastFrame reach eof getFrame: " + j + ", lastFrameCount: " + paramInt + ", loopCount:" + i);
            break;
          }
        }
        else
        {
          readOutputStream(localBufferData.buffer, localBufferData.info.presentationTimeUs, localBufferData.info.offset, localBufferData.info.size, localBufferData.info.flags);
          continue;
        }
        j += 1;
      }
      catch (Exception localException)
      {
        if (AVCoreLog.isLogColorOrGary()) {
          AVCoreLog.e(this.mTag, "dequeueLastFrame CodecException!!", localException);
        }
        return false;
      }
      label505:
      label508:
      for (;;)
      {
        break;
        break;
      }
      label511:
      return false;
      label513:
      boolean bool = false;
      continue;
      label519:
      bool = false;
    }
    return true;
  }
  
  private boolean dequeueOutFrameMore(long paramLong)
  {
    long l1 = 0L;
    while (l1 < paramLong)
    {
      long l2 = System.nanoTime();
      BufferData localBufferData = this.mCodec.dequeueDecoderOutputBuffer(3000L);
      l2 = l1 + (System.nanoTime() - l2);
      l1 = l2;
      if (localBufferData != null)
      {
        l1 = l2;
        if (localBufferData.index != -1)
        {
          l1 = l2;
          if (localBufferData.index >= 0) {
            if (!localBufferData.success)
            {
              AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer failed with exception");
              l1 = l2;
            }
            else if ((localBufferData.format == null) || (localBufferData.buffer == null))
            {
              AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer error");
              this.mCodec.releaseOutputBuffer(localBufferData.index);
              l1 = l2;
            }
            else
            {
              setFrame(localBufferData.buffer, localBufferData.info.size, localBufferData.format);
              this.mCodec.releaseOutputBuffer(localBufferData.index);
              return true;
            }
          }
        }
      }
    }
    return false;
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = getIntValuesImp("NativeCodec", paramString1, paramString2, paramBoolean);
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e("NativeCodec", "getIntValues, mime[" + paramString1 + "], isDecoder[" + paramBoolean + "], key[" + paramString2 + "], value[" + i + "]");
    }
    return i;
  }
  
  public static native int getVersion();
  
  private static boolean onAttach(String paramString, long paramLong, boolean paramBoolean, Map<String, Object> paramMap)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return false;
    }
    NativeCodec localNativeCodec = new NativeCodec(paramString, paramLong, paramMap, paramBoolean);
    AVCoreLog.e(localNativeCodec.mTag, "onAttach, mime[" + paramString + "], instance[" + paramLong + "], isDecoder[" + paramBoolean + "]");
    AVCoreLog.print(localNativeCodec.mTag, paramMap, true);
    if (localNativeCodec.mCodec == null)
    {
      AVCoreLog.e(localNativeCodec.mTag, "onAttach, fail");
      return false;
    }
    localNativeCodec.attachCodec(localNativeCodec);
    localNativeCodec.mTimeStamp = 0L;
    localNativeCodec.mTryAgainLaterCount = 0;
    localNativeCodec.mLastEncFrameTime = 0L;
    localNativeCodec.mTotalDecOutFrameNum = 0;
    localNativeCodec.mTotalDecInFrameNum = 0;
    return localNativeCodec.mCodec.start();
  }
  
  private boolean onCalcDelay(int paramInt)
  {
    if (this.mDebugDelay)
    {
      long l = System.currentTimeMillis();
      if (canLog()) {
        AVCoreLog.e(this.mTag, "onCalcDelay, frameIndex[" + paramInt + "], cur[" + l + "]");
      }
      this.mDebugDelayMap2.put(Integer.valueOf(paramInt), Long.valueOf(l));
    }
    return true;
  }
  
  private static void onDetach(Object arg0)
  {
    if (Build.VERSION.SDK_INT < 16) {
      return;
    }
    NativeCodec localNativeCodec;
    if ((??? instanceof NativeCodec))
    {
      localNativeCodec = (NativeCodec)???;
      localNativeCodec.detachCodec();
      localNativeCodec.mTryAgainLaterCount = 0;
      localNativeCodec.mTimeStamp = 0L;
      localNativeCodec.mFormat = null;
      localNativeCodec.mLastEncFrameTime = 0L;
      localNativeCodec.mTotalDecOutFrameNum = 0;
      localNativeCodec.mTotalDecInFrameNum = 0;
      synchronized (localNativeCodec.mPendingInputBuffers)
      {
        localNativeCodec.mCodersExit.set(true);
        localNativeCodec.mPendingInputBuffers.clear();
        if (localNativeCodec.mDebugDelay)
        {
          localNativeCodec.mDebugDelayMap.clear();
          localNativeCodec.mDebugDelayMap2.clear();
          localNativeCodec.mDebugIndexMap.clear();
        }
        AndroidCodecBase localAndroidCodecBase = localNativeCodec.mCodec;
        if (localAndroidCodecBase == null) {}
      }
    }
    try
    {
      localNativeCodec.mCodec.stop();
      localNativeCodec.mCodec.release();
      label136:
      localNativeCodec.mCodec = null;
      AVCoreLog.e(localNativeCodec.mTag, "onDetach");
      return;
      localObject = finally;
      throw localObject;
      AVCoreLog.e("NativeCodec", "onDetach, nativeCodec[" + ??? + "]");
      return;
    }
    catch (Exception localException)
    {
      break label136;
    }
  }
  
  private boolean onDoCodec(int paramInt1, int paramInt2)
  {
    if (this.mCodec == null)
    {
      AVCoreLog.e(this.mTag, "onDoCodec err!! mCodec is null");
      return false;
    }
    if (AVCoreLog.isLogColorOrGary()) {
      AVCoreLog.e(this.mTag, "onDoCodec,frameIndex[" + paramInt2 + "], flag[" + paramInt1 + "], mTryAgainLaterCount[" + this.mTryAgainLaterCount + "]");
    }
    if ((this.mTryAgainLaterCount >= 10) && (paramInt1 == 0))
    {
      AVCoreLog.e(this.mTag, "onDoCodec err!! restCodec mTryAgainLaterCount: " + this.mTryAgainLaterCount + ", flag: " + paramInt1);
      resetCodec();
      if (this.mCodec == null) {
        return false;
      }
    }
    Object localObject4;
    Object localObject5;
    label349:
    for (;;)
    {
      try
      {
        Object localObject1 = this.mCodec.getInputBuffer();
        paramInt1 = 0;
        localObject4 = localObject1;
        int j;
        if (localObject1 == null)
        {
          j = paramInt1;
          localObject5 = localObject1;
        }
        try
        {
          Thread.sleep(50L);
          j = paramInt1;
          localObject5 = localObject1;
          localObject4 = this.mCodec.getInputBuffer();
          int i = paramInt1 + 1;
          if (localObject4 != null)
          {
            if (!this.mIsDecoder) {
              break label349;
            }
            paramInt1 = writeInputData(((BufferData)localObject4).buffer, false);
            if (paramInt1 >= 0) {
              break;
            }
            AVCoreLog.e(this.mTag, "writeInputData, SampleSize < 0");
            return false;
          }
          j = i;
          localObject5 = localObject4;
          if (AVCoreLog.isLogColorOrGary())
          {
            j = i;
            localObject5 = localObject4;
            AVCoreLog.e(this.mTag, "onDoCodec not available");
          }
          paramInt1 = i;
          localObject1 = localObject4;
          if (i <= 8) {
            continue;
          }
          j = i;
          localObject5 = localObject4;
          AVCoreLog.e(this.mTag, "onDoCodec not available, try count=" + i);
          return false;
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          paramInt1 = j;
          Object localObject2 = localObject5;
        }
        continue;
        paramInt1 = writeInputData2(((BufferData)localObject4).buffer, this.mColorFormat, false);
      }
      catch (Exception localException)
      {
        AVCoreLog.e(this.mTag, "onDoCodec Exception!", localException);
        return false;
      }
    }
    this.mLastEncFrameTime += this.mFrameInterval;
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
      this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
    }
    this.mCodec.queueInputBuffer(((BufferData)localObject4).index, paramInt1, this.mLastEncFrameTime, 0);
    this.mTotalDecInFrameNum += 1;
    long l2 = System.nanoTime();
    long l1 = 33000000L;
    Object localObject3;
    if (this.mIsDecoder)
    {
      if (paramInt2 < 4) {
        l1 = 45000000L;
      }
      localObject3 = this.mCodec.dequeueDecoderOutputBuffer(l1);
    }
    for (;;)
    {
      if (localObject3 != null) {
        if (((BufferData)localObject3).index == -1)
        {
          this.mTryAgainLaterCount += 1;
          if (AVCoreLog.isLogColorOrGary()) {
            AVCoreLog.e(this.mTag, "onDoCodec, try again, count[" + this.mTryAgainLaterCount + "]");
          }
          if ((this.mIsDecoder) && (dequeueOutFrameMore(l1 - (System.nanoTime() - l2))))
          {
            this.mTryAgainLaterCount = 0;
            return true;
            localObject3 = this.mCodec.dequeueOutputBuffer();
            l1 = 33000000L;
            continue;
          }
          if (this.mTryAgainLaterCount >= 16) {
            return false;
          }
        }
        else
        {
          this.mTryAgainLaterCount = 0;
          if (!((BufferData)localObject3).success)
          {
            AVCoreLog.e(this.mTag, "onDoCodec err!");
            return false;
          }
          if ((((BufferData)localObject3).format == null) || (((BufferData)localObject3).buffer == null))
          {
            this.mCodec.releaseOutputBuffer(((BufferData)localObject3).index);
            localObject4 = this.mTag;
            localObject5 = new StringBuilder().append("onDoCodec err! output.format == null: ");
            if (((BufferData)localObject3).format != null) {
              break label1262;
            }
            bool = true;
            localObject5 = ((StringBuilder)localObject5).append(bool).append(", output.buffer == null: ");
            if (((BufferData)localObject3).buffer != null) {
              break label1268;
            }
            bool = true;
            label732:
            AVCoreLog.e((String)localObject4, bool);
            return false;
          }
          if (this.mIsDecoder)
          {
            calcDelay(true, ((BufferData)localObject3).info);
            setFrame(((BufferData)localObject3).buffer, ((BufferData)localObject3).info.size, ((BufferData)localObject3).format);
            this.mCodec.releaseOutputBuffer(((BufferData)localObject3).index);
            if ((!this.mIsDecoder) || (this.mTotalDecInFrameNum - this.mTotalDecOutFrameNum <= 0)) {
              break label1274;
            }
            bool = dequeueOutFrameMore(l1 - (System.nanoTime() - l2));
            if (!AVCoreLog.isLogColorOrGary()) {
              break label1274;
            }
            AVCoreLog.e(this.mTag, "dequeue one store Frame status: " + bool);
            break label1274;
          }
          if (((BufferData)localObject3).info.flags == 1) {
            AVCoreLog.e(this.mTag, "onDoCodec err flags = 1");
          }
          if (((BufferData)localObject3).info.flags == 2)
          {
            this.mCodec.releaseOutputBuffer(((BufferData)localObject3).index);
            readOutputStream(((BufferData)localObject3).buffer, ((BufferData)localObject3).info.presentationTimeUs, ((BufferData)localObject3).info.offset, ((BufferData)localObject3).info.size, ((BufferData)localObject3).info.flags);
            localObject4 = this.mCodec.dequeueOutputBuffer();
            if (localObject4 != null)
            {
              if (((BufferData)localObject4).index == -1)
              {
                this.mTryAgainLaterCount2 += 1;
                if (AVCoreLog.isColorLevel()) {
                  AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue dequeueOutputBuffer, try again later,count =" + this.mTryAgainLaterCount2);
                }
                if (this.mTryAgainLaterCount2 < 16) {
                  break label1276;
                }
                AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue dequeueOutputBuffer >= 16 times");
                return false;
              }
              this.mTryAgainLaterCount2 = 0;
              if (!((BufferData)localObject4).success)
              {
                AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue onDoCodec err!");
                return false;
              }
              if ((((BufferData)localObject4).format == null) || (((BufferData)localObject4).buffer == null))
              {
                this.mCodec.releaseOutputBuffer(((BufferData)localObject4).index);
                localObject3 = this.mTag;
                localObject5 = new StringBuilder().append("onDoCodec err! output.format == null: ");
                if (((BufferData)localObject4).format != null) {
                  break label1278;
                }
                bool = true;
                label1135:
                localObject5 = ((StringBuilder)localObject5).append(bool).append(", output.buffer == null: ");
                if (((BufferData)localObject4).buffer != null) {
                  break label1284;
                }
              }
            }
          }
        }
      }
    }
    label1284:
    for (boolean bool = true;; bool = false)
    {
      AVCoreLog.e((String)localObject3, bool);
      return false;
      localObject3 = localObject4;
      if (AVCoreLog.isColorLevel())
      {
        AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue success");
        localObject3 = localObject4;
      }
      for (;;)
      {
        calcDelay(true, ((BufferData)localObject3).info);
        readOutputStream(((BufferData)localObject3).buffer, ((BufferData)localObject3).info.presentationTimeUs, ((BufferData)localObject3).info.offset, ((BufferData)localObject3).info.size, ((BufferData)localObject3).info.flags);
        break;
      }
      return true;
      label1262:
      bool = false;
      break;
      label1268:
      bool = false;
      break label732;
      label1274:
      return true;
      label1276:
      return true;
      label1278:
      bool = false;
      break label1135;
    }
  }
  
  private int onDoCodecAsync(int paramInt1, int paramInt2)
  {
    if (!sUseAsyncAPI)
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "NOT in async mode.");
      }
      return -1;
    }
    for (;;)
    {
      synchronized (this.mPendingInputBuffers)
      {
        if (this.mCodersExit.get())
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "hardware coders exit, return.");
          }
          return 2;
        }
        if (this.mPendingInputBuffers.size() <= 0) {
          break;
        }
        if (canLog()) {
          AVCoreLog.e(this.mTag, "InputData pendingInputBuffers exist, size:" + this.mPendingInputBuffers.size());
        }
        InputBufferData localInputBufferData = (InputBufferData)this.mPendingInputBuffers.get(0);
        if (localInputBufferData == null) {
          return 2;
        }
        if (localInputBufferData.buffer == null)
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "inputbuffer null, return");
          }
          return -1;
        }
        if (localInputBufferData.processing)
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.mIsDecoder)
        {
          paramInt1 = writeInputData(localInputBufferData.buffer, false);
          if (canLog()) {
            AVCoreLog.e(this.mTag, "onDoCodecAsync, sampleSize[" + paramInt1 + "]");
          }
          if (paramInt1 <= 0) {
            break label389;
          }
          this.mLastEncFrameTime += this.mFrameInterval;
          this.mPendingInputBuffers.remove(0);
          if (this.mDebugDelay)
          {
            this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
            this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
          }
          this.mCodec.queueInputBuffer(localInputBufferData.index, paramInt1, this.mLastEncFrameTime, 0);
          return 1;
        }
      }
      paramInt1 = writeInputData2(localObject.buffer, this.mColorFormat, false);
    }
    for (;;)
    {
      return 0;
      label389:
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
    //   1: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   4: ifnull +82 -> 86
    //   7: aload_0
    //   8: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   11: astore_1
    //   12: aload_1
    //   13: monitorenter
    //   14: aload_0
    //   15: getfield 120	com/tencent/avcore/jni/codec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   18: iconst_1
    //   19: invokevirtual 565	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   22: aload_0
    //   23: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   26: invokeinterface 568 1 0
    //   31: aload_0
    //   32: getfield 122	com/tencent/avcore/jni/codec/NativeCodec:mDebugDelay	Z
    //   35: ifeq +30 -> 65
    //   38: aload_0
    //   39: getfield 124	com/tencent/avcore/jni/codec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   42: invokeinterface 569 1 0
    //   47: aload_0
    //   48: getfield 126	com/tencent/avcore/jni/codec/NativeCodec:mDebugDelayMap2	Ljava/util/Map;
    //   51: invokeinterface 569 1 0
    //   56: aload_0
    //   57: getfield 128	com/tencent/avcore/jni/codec/NativeCodec:mDebugIndexMap	Ljava/util/Map;
    //   60: invokeinterface 569 1 0
    //   65: aload_0
    //   66: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   69: invokevirtual 572	com/tencent/avcore/jni/codec/AndroidCodecBase:stop	()V
    //   72: aload_0
    //   73: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   76: invokevirtual 575	com/tencent/avcore/jni/codec/AndroidCodecBase:release	()V
    //   79: aload_0
    //   80: aconst_null
    //   81: putfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   84: aload_1
    //   85: monitorexit
    //   86: aload_0
    //   87: getfield 165	com/tencent/avcore/jni/codec/NativeCodec:mIsDecoder	Z
    //   90: ifeq +64 -> 154
    //   93: aload_0
    //   94: invokespecial 263	com/tencent/avcore/jni/codec/NativeCodec:createDecCodec	()V
    //   97: aload_0
    //   98: lconst_0
    //   99: putfield 85	com/tencent/avcore/jni/codec/NativeCodec:mTimeStamp	J
    //   102: aload_0
    //   103: lconst_0
    //   104: putfield 87	com/tencent/avcore/jni/codec/NativeCodec:mLastEncFrameTime	J
    //   107: aload_0
    //   108: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   111: invokevirtual 533	com/tencent/avcore/jni/codec/AndroidCodecBase:start	()Z
    //   114: pop
    //   115: aload_0
    //   116: getfield 120	com/tencent/avcore/jni/codec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   119: iconst_0
    //   120: invokevirtual 565	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   123: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   126: ifeq +13 -> 139
    //   129: aload_0
    //   130: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   133: ldc_w 677
    //   136: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   139: return
    //   140: astore_2
    //   141: aload_1
    //   142: monitorexit
    //   143: aload_2
    //   144: athrow
    //   145: astore_1
    //   146: aload_0
    //   147: aconst_null
    //   148: putfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   151: goto -65 -> 86
    //   154: aload_0
    //   155: invokespecial 279	com/tencent/avcore/jni/codec/NativeCodec:createEncCodec	()V
    //   158: goto -61 -> 97
    //   161: astore_1
    //   162: goto -39 -> 123
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	165	0	this	NativeCodec
    //   145	1	1	localException1	Exception
    //   161	1	1	localException2	Exception
    //   140	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	65	140	finally
    //   65	86	140	finally
    //   141	143	140	finally
    //   7	14	145	java/lang/Exception
    //   143	145	145	java/lang/Exception
    //   86	97	161	java/lang/Exception
    //   97	123	161	java/lang/Exception
    //   154	158	161	java/lang/Exception
  }
  
  public static native void setDeviceInfo(String paramString);
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i9 = paramMediaFormat.getInteger("width");
    int i6 = paramMediaFormat.getInteger("height");
    int m = paramMediaFormat.getInteger("crop-left");
    int i7 = paramMediaFormat.getInteger("crop-right");
    int k = paramMediaFormat.getInteger("crop-top");
    int i8 = paramMediaFormat.getInteger("crop-bottom");
    int i = paramMediaFormat.getInteger("stride");
    int j = paramMediaFormat.getInteger("slice-height");
    int i10 = paramMediaFormat.getInteger("color-format");
    j = Math.max(j, i6);
    int i11 = Math.max(i, i9);
    if (i10 == 2130706688)
    {
      j -= k / 2;
      k = 0;
      m = 0;
    }
    for (;;)
    {
      int i1 = Math.max(i11, i9);
      if (((2141391876 == i10) || (2130706433 == i10) || (2130706944 == i10)) && (i6 < j)) {}
      for (i = j;; i = i6)
      {
        int i4;
        int i2;
        int i5;
        int i3;
        int n;
        if (m + i7 + k + i8 == 0)
        {
          i4 = 0;
          i2 = i6 - 1;
          i5 = 0;
          i3 = i9 - 1;
          n = i1;
          if ((n <= 0) || (i <= 0) || (i3 <= 0) || (i2 <= 0))
          {
            if (AVCoreLog.isColorLevel()) {
              AVCoreLog.e(this.mTag, "setFrame, error, size[" + paramInt + "], colorFormat[0x" + Integer.toHexString(i10).toUpperCase() + "]");
            }
            return false;
          }
        }
        else
        {
          i3 = i7 - m + 1;
          i2 = i8 - k + 1;
          n = i1;
          if (i1 < i3) {
            n = i3;
          }
          if (i >= i2) {
            break label637;
          }
          i = i2;
        }
        label637:
        for (;;)
        {
          i3 = i7;
          i4 = m;
          i1 = k;
          i2 = i8;
          i5 = i1;
          break;
          long l1 = SystemClock.elapsedRealtime();
          i1 = readOutputDataEx(paramByteBuffer, paramInt, n, i, i4, i5, i3 - i4 + 1, i2 - i5 + 1, i10);
          this.mTotalDecOutFrameNum += 1;
          long l2 = SystemClock.elapsedRealtime();
          if (canLog()) {
            AVCoreLog.e(this.mTag, "setFrame, size[" + paramInt + "], width[" + i9 + "], height[" + i6 + "], crop_left[" + paramMediaFormat.getInteger("crop-left") + "->" + m + "], crop_right[" + i7 + "], crop_top[" + paramMediaFormat.getInteger("crop-top") + "->" + k + "], crop_bottom[" + i8 + "], stride[" + paramMediaFormat.getInteger("stride") + "->" + i11 + "], slice_height[" + paramMediaFormat.getInteger("slice-height") + "->" + j + "], picWidth[" + n + "], picHeight[" + i + "], colorFormat[0x" + Integer.toHexString(i10).toUpperCase() + "], cost[" + (l2 - l1) + "]");
          }
          return i1 > 0;
        }
      }
    }
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
      this.mFrameInterval = (1000000 / this.mFrameRate);
      resetCodec();
      AVCoreLog.e(this.mTag, "HWENC setParameters mFrameRate =" + this.mFrameRate);
    } while (Build.VERSION.SDK_INT < 19);
    int i = paramInt;
    if (paramString.equalsIgnoreCase("i-frame-interval"))
    {
      AVCoreLog.e(this.mTag, "HWENC setParameters i-frame-interval: " + paramInt + ", frameRate: " + this.mFrameRate);
      i = paramInt;
      if (this.mFrameRate * paramInt > 255)
      {
        i = 255 / this.mFrameRate;
        AVCoreLog.e(this.mTag, "HWENC setParameters i-frame-interval changed: " + i);
      }
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt(paramString, i);
    this.mCodec.setParameters(localBundle);
  }
  
  public native boolean attachCodec(Object paramObject);
  
  void calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mDebugDelay)
    {
      Object localObject = (Long)this.mDebugDelayMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        if (canLog()) {
          AVCoreLog.e(this.mTag, "calcDelay, small[" + paramBufferInfo.presentationTimeUs + "], takes[" + (System.currentTimeMillis() - ((Long)localObject).longValue()) + "]");
        }
        this.mDebugDelayMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject = (Integer)this.mDebugIndexMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject != null)
      {
        Long localLong = (Long)this.mDebugDelayMap2.get(localObject);
        if (localLong != null)
        {
          if (canLog()) {
            AVCoreLog.e(this.mTag, "calcDelay, big[" + paramBufferInfo.presentationTimeUs + "], takes[" + (System.currentTimeMillis() - localLong.longValue()) + "]");
          }
          this.mDebugDelayMap2.remove(localObject);
        }
        this.mDebugIndexMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.mCodersExit.get()) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onError");
      }
    }
    while (!AVCoreLog.isColorLevel()) {
      return;
    }
    AVCoreLog.e(this.mTag, "onError", paramException);
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
    //   7: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   10: iload_2
    //   11: invokevirtual 777	com/tencent/avcore/jni/codec/AndroidCodecBase:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   14: astore 6
    //   16: aload 6
    //   18: ifnonnull +37 -> 55
    //   21: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   24: ifeq +30 -> 54
    //   27: aload_0
    //   28: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   31: new 136	java/lang/StringBuilder
    //   34: dup
    //   35: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   38: ldc_w 779
    //   41: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: iload_2
    //   45: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   48: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   51: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: iload 5
    //   57: istore_3
    //   58: aload_0
    //   59: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   62: astore_1
    //   63: iload 5
    //   65: istore_3
    //   66: aload_1
    //   67: monitorenter
    //   68: aload_0
    //   69: getfield 120	com/tencent/avcore/jni/codec/NativeCodec:mCodersExit	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   72: invokevirtual 654	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   75: ifeq +76 -> 151
    //   78: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   81: ifeq +13 -> 94
    //   84: aload_0
    //   85: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   88: ldc_w 781
    //   91: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   94: aload_1
    //   95: monitorexit
    //   96: aload_0
    //   97: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   100: astore_1
    //   101: aload_1
    //   102: monitorenter
    //   103: aload_0
    //   104: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   107: iconst_0
    //   108: invokeinterface 319 2 0
    //   113: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   116: iconst_0
    //   117: putfield 666	com/tencent/avcore/jni/codec/InputBufferData:processing	Z
    //   120: aload_1
    //   121: monitorexit
    //   122: return
    //   123: astore 6
    //   125: aload_1
    //   126: monitorexit
    //   127: aload 6
    //   129: athrow
    //   130: astore 6
    //   132: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   135: ifeq -15 -> 120
    //   138: aload_0
    //   139: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   142: ldc_w 783
    //   145: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   148: goto -28 -> 120
    //   151: aload_0
    //   152: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   155: new 660	com/tencent/avcore/jni/codec/InputBufferData
    //   158: dup
    //   159: aload 6
    //   161: iload_2
    //   162: invokespecial 786	com/tencent/avcore/jni/codec/InputBufferData:<init>	(Ljava/nio/ByteBuffer;I)V
    //   165: invokeinterface 789 2 0
    //   170: pop
    //   171: aload_0
    //   172: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   175: iconst_0
    //   176: invokeinterface 319 2 0
    //   181: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   184: iconst_1
    //   185: putfield 666	com/tencent/avcore/jni/codec/InputBufferData:processing	Z
    //   188: aload_1
    //   189: monitorexit
    //   190: iload 5
    //   192: istore_3
    //   193: invokestatic 540	com/tencent/avcore/jni/codec/NativeCodec:canLog	()Z
    //   196: ifeq +41 -> 237
    //   199: iload 5
    //   201: istore_3
    //   202: aload_0
    //   203: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   206: new 136	java/lang/StringBuilder
    //   209: dup
    //   210: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   213: ldc_w 791
    //   216: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: aload_0
    //   220: getfield 165	com/tencent/avcore/jni/codec/NativeCodec:mIsDecoder	Z
    //   223: invokevirtual 218	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   226: ldc 224
    //   228: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iload 5
    //   239: istore_3
    //   240: aload_0
    //   241: getfield 165	com/tencent/avcore/jni/codec/NativeCodec:mIsDecoder	Z
    //   244: ifeq +255 -> 499
    //   247: iload 5
    //   249: istore_3
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   255: iconst_0
    //   256: invokeinterface 319 2 0
    //   261: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   264: getfield 661	com/tencent/avcore/jni/codec/InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   267: iconst_1
    //   268: invokevirtual 609	com/tencent/avcore/jni/codec/NativeCodec:writeInputData	(Ljava/nio/ByteBuffer;Z)I
    //   271: istore_2
    //   272: iload_2
    //   273: ifle +121 -> 394
    //   276: iload_2
    //   277: istore_3
    //   278: invokestatic 540	com/tencent/avcore/jni/codec/NativeCodec:canLog	()Z
    //   281: ifeq +32 -> 313
    //   284: iload_2
    //   285: istore_3
    //   286: aload_0
    //   287: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   290: new 136	java/lang/StringBuilder
    //   293: dup
    //   294: invokespecial 137	java/lang/StringBuilder:<init>	()V
    //   297: ldc_w 793
    //   300: invokevirtual 143	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: iload_2
    //   304: invokevirtual 211	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   307: invokevirtual 156	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   313: iload_2
    //   314: istore_3
    //   315: aload_0
    //   316: aload_0
    //   317: getfield 87	com/tencent/avcore/jni/codec/NativeCodec:mLastEncFrameTime	J
    //   320: aload_0
    //   321: getfield 104	com/tencent/avcore/jni/codec/NativeCodec:mFrameInterval	I
    //   324: i2l
    //   325: ladd
    //   326: putfield 87	com/tencent/avcore/jni/codec/NativeCodec:mLastEncFrameTime	J
    //   329: iload_2
    //   330: istore_3
    //   331: aload_0
    //   332: getfield 122	com/tencent/avcore/jni/codec/NativeCodec:mDebugDelay	Z
    //   335: ifeq +28 -> 363
    //   338: iload_2
    //   339: istore_3
    //   340: aload_0
    //   341: getfield 124	com/tencent/avcore/jni/codec/NativeCodec:mDebugDelayMap	Ljava/util/Map;
    //   344: aload_0
    //   345: getfield 87	com/tencent/avcore/jni/codec/NativeCodec:mLastEncFrameTime	J
    //   348: invokestatic 553	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   351: invokestatic 538	java/lang/System:currentTimeMillis	()J
    //   354: invokestatic 553	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   357: invokeinterface 557 3 0
    //   362: pop
    //   363: iload_2
    //   364: istore_3
    //   365: aload_0
    //   366: getfield 272	com/tencent/avcore/jni/codec/NativeCodec:mCodec	Lcom/tencent/avcore/jni/codec/AndroidCodecBase;
    //   369: aload_0
    //   370: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   373: iconst_0
    //   374: invokeinterface 319 2 0
    //   379: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   382: getfield 674	com/tencent/avcore/jni/codec/InputBufferData:index	I
    //   385: iload_2
    //   386: aload_0
    //   387: getfield 87	com/tencent/avcore/jni/codec/NativeCodec:mLastEncFrameTime	J
    //   390: iconst_0
    //   391: invokevirtual 423	com/tencent/avcore/jni/codec/AndroidCodecBase:queueInputBuffer	(IIJI)V
    //   394: aload_0
    //   395: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   398: astore_1
    //   399: aload_1
    //   400: monitorenter
    //   401: aload_0
    //   402: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   405: iconst_0
    //   406: invokeinterface 319 2 0
    //   411: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   414: iconst_0
    //   415: putfield 666	com/tencent/avcore/jni/codec/InputBufferData:processing	Z
    //   418: iload_2
    //   419: ifle +14 -> 433
    //   422: aload_0
    //   423: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   426: iconst_0
    //   427: invokeinterface 673 2 0
    //   432: pop
    //   433: aload_1
    //   434: monitorexit
    //   435: return
    //   436: astore 6
    //   438: aload_1
    //   439: monitorexit
    //   440: aload 6
    //   442: athrow
    //   443: astore 6
    //   445: aload_1
    //   446: monitorexit
    //   447: iload 5
    //   449: istore_3
    //   450: aload 6
    //   452: athrow
    //   453: astore 6
    //   455: aload_0
    //   456: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   459: astore_1
    //   460: aload_1
    //   461: monitorenter
    //   462: aload_0
    //   463: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   466: iconst_0
    //   467: invokeinterface 319 2 0
    //   472: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   475: iconst_0
    //   476: putfield 666	com/tencent/avcore/jni/codec/InputBufferData:processing	Z
    //   479: iload_3
    //   480: ifle +14 -> 494
    //   483: aload_0
    //   484: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   487: iconst_0
    //   488: invokeinterface 673 2 0
    //   493: pop
    //   494: aload_1
    //   495: monitorexit
    //   496: aload 6
    //   498: athrow
    //   499: iload 5
    //   501: istore_3
    //   502: aload_0
    //   503: aload_0
    //   504: getfield 113	com/tencent/avcore/jni/codec/NativeCodec:mPendingInputBuffers	Ljava/util/List;
    //   507: iconst_0
    //   508: invokeinterface 319 2 0
    //   513: checkcast 660	com/tencent/avcore/jni/codec/InputBufferData
    //   516: getfield 661	com/tencent/avcore/jni/codec/InputBufferData:buffer	Ljava/nio/ByteBuffer;
    //   519: aload_0
    //   520: getfield 348	com/tencent/avcore/jni/codec/NativeCodec:mColorFormat	I
    //   523: iconst_1
    //   524: invokevirtual 622	com/tencent/avcore/jni/codec/NativeCodec:writeInputData2	(Ljava/nio/ByteBuffer;IZ)I
    //   527: istore_2
    //   528: goto -256 -> 272
    //   531: astore_1
    //   532: iload 4
    //   534: istore_2
    //   535: iload 5
    //   537: istore_3
    //   538: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   541: ifeq -269 -> 272
    //   544: iload 5
    //   546: istore_3
    //   547: aload_0
    //   548: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   551: ldc_w 795
    //   554: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   557: iload 4
    //   559: istore_2
    //   560: goto -288 -> 272
    //   563: astore_1
    //   564: iload_2
    //   565: istore_3
    //   566: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   569: ifeq -175 -> 394
    //   572: iload_2
    //   573: istore_3
    //   574: aload_0
    //   575: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   578: ldc_w 797
    //   581: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   584: goto -190 -> 394
    //   587: astore 6
    //   589: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   592: ifeq -159 -> 433
    //   595: aload_0
    //   596: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   599: ldc_w 783
    //   602: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   605: goto -172 -> 433
    //   608: astore 7
    //   610: invokestatic 294	com/tencent/avcore/util/AVCoreLog:isColorLevel	()Z
    //   613: ifeq -119 -> 494
    //   616: aload_0
    //   617: getfield 158	com/tencent/avcore/jni/codec/NativeCodec:mTag	Ljava/lang/String;
    //   620: ldc_w 783
    //   623: invokestatic 228	com/tencent/avcore/util/AVCoreLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   626: goto -132 -> 494
    //   629: astore 6
    //   631: aload_1
    //   632: monitorexit
    //   633: aload 6
    //   635: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	636	0	this	NativeCodec
    //   0	636	2	paramInt	int
    //   57	517	3	i	int
    //   4	554	4	j	int
    //   1	544	5	k	int
    //   14	3	6	localByteBuffer	ByteBuffer
    //   123	5	6	localObject1	Object
    //   130	30	6	localException1	Exception
    //   436	5	6	localObject2	Object
    //   443	8	6	localObject3	Object
    //   453	44	6	localObject4	Object
    //   587	1	6	localException2	Exception
    //   629	5	6	localObject5	Object
    //   608	1	7	localException3	Exception
    // Exception table:
    //   from	to	target	type
    //   103	120	123	finally
    //   120	122	123	finally
    //   125	127	123	finally
    //   132	148	123	finally
    //   103	120	130	java/lang/Exception
    //   401	418	436	finally
    //   422	433	436	finally
    //   433	435	436	finally
    //   438	440	436	finally
    //   589	605	436	finally
    //   68	94	443	finally
    //   94	96	443	finally
    //   151	190	443	finally
    //   445	447	443	finally
    //   58	63	453	finally
    //   66	68	453	finally
    //   193	199	453	finally
    //   202	237	453	finally
    //   240	247	453	finally
    //   250	272	453	finally
    //   278	284	453	finally
    //   286	313	453	finally
    //   315	329	453	finally
    //   331	338	453	finally
    //   340	363	453	finally
    //   365	394	453	finally
    //   450	453	453	finally
    //   502	528	453	finally
    //   538	544	453	finally
    //   547	557	453	finally
    //   566	572	453	finally
    //   574	584	453	finally
    //   193	199	531	java/lang/Exception
    //   202	237	531	java/lang/Exception
    //   240	247	531	java/lang/Exception
    //   250	272	531	java/lang/Exception
    //   502	528	531	java/lang/Exception
    //   365	394	563	java/lang/Exception
    //   401	418	587	java/lang/Exception
    //   422	433	587	java/lang/Exception
    //   462	479	608	java/lang/Exception
    //   483	494	608	java/lang/Exception
    //   462	479	629	finally
    //   483	494	629	finally
    //   494	496	629	finally
    //   610	626	629	finally
    //   631	633	629	finally
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get()) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onOutputBufferAvailable");
      }
    }
    do
    {
      return;
      paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    } while ((paramMediaCodec == null) || (paramBufferInfo == null));
    if (this.mIsDecoder)
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
      if (AVCoreLog.isColorLevel())
      {
        AVCoreLog.e(this.mTag, "getOutputFormat null");
        continue;
        if (paramBufferInfo.flags == 1) {}
        calcDelay(false, paramBufferInfo);
        readOutputStream(paramMediaCodec, paramBufferInfo.presentationTimeUs, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.flags);
      }
    }
  }
  
  public void onOutputFormatChanged(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    if (this.mCodersExit.get()) {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onOutputFormatChanged");
      }
    }
    while (!AVCoreLog.isColorLevel()) {
      return;
    }
    AVCoreLog.e(this.mTag, "onOutputFormatChanged");
  }
  
  public native int readOutputData(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10);
  
  public native int readOutputDataEx(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8);
  
  public native int readOutputStream(ByteBuffer paramByteBuffer, long paramLong, int paramInt1, int paramInt2, int paramInt3);
  
  public native int setAVCParams(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2);
  
  void setParams_impl()
  {
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e(this.mTag, "setParams_impl");
    }
    Bundle localBundle;
    if (this.setIFramePending)
    {
      localBundle = new Bundle();
      localBundle.putInt("request-sync", 1);
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
        localBundle.putInt("request-sync", 1);
      }
      this.mCodec.setParameters(localBundle);
      this.setBitRatePending = 0;
      this.setIFramePending = false;
    }
  }
  
  public String toString()
  {
    return this.mTag;
  }
  
  public native int writeInputData(ByteBuffer paramByteBuffer, boolean paramBoolean);
  
  public native int writeInputData2(ByteBuffer paramByteBuffer, int paramInt, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */