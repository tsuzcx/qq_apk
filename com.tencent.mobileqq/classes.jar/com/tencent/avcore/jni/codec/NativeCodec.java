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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NativeCodec_");
    localStringBuilder.append(AVCoreLog.genDebugSeq());
    this.mTag = localStringBuilder.toString();
  }
  
  @SuppressLint({"NewApi"})
  @TargetApi(16)
  public NativeCodec(String paramString, long paramLong, Map<String, Object> paramMap, boolean paramBoolean)
  {
    this.mIsDecoder = paramBoolean;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("NativeCodec_");
    Object localObject1;
    if (sUseAsyncAPI) {
      localObject1 = "Async_";
    } else {
      localObject1 = "Sync_";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    if (this.mIsDecoder) {
      localObject1 = "DEC";
    } else {
      localObject1 = "ENC";
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    ((StringBuilder)localObject2).append("_i");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(AVCoreLog.genDebugSeq());
    this.mTag = ((StringBuilder)localObject2).toString();
    this.mMime = paramString;
    this.mNativeContext = paramLong;
    this.mWidth = ((Integer)paramMap.get("width")).intValue();
    this.mHeight = ((Integer)paramMap.get("height")).intValue();
    if ((AVCoreLog.isDebugVersion()) || (AVCoreLog.isGrayVersion())) {
      this.mHwDetectMode = ((Integer)paramMap.get("hw-detect-mode")).intValue();
    }
    if (AVCoreLog.isLogColorOrGary())
    {
      localObject1 = this.mTag;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("NativeCodec, w[");
      ((StringBuilder)localObject2).append(this.mWidth);
      ((StringBuilder)localObject2).append("], h[");
      ((StringBuilder)localObject2).append(this.mHeight);
      ((StringBuilder)localObject2).append("], isDecoder[");
      ((StringBuilder)localObject2).append(this.mIsDecoder);
      ((StringBuilder)localObject2).append("], mMime[");
      ((StringBuilder)localObject2).append(this.mMime);
      ((StringBuilder)localObject2).append("], hwDetectMode[");
      ((StringBuilder)localObject2).append(this.mHwDetectMode);
      ((StringBuilder)localObject2).append("]");
      AVCoreLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
    }
    if (this.mIsDecoder) {}
    try
    {
      int i = this.mWidth;
      int j = this.mHeight;
      this.mFormat = MediaFormat.createVideoFormat(paramString, i, j);
      paramBoolean = paramString.contains("video/avc");
      if (paramBoolean)
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
      label657:
      break label657;
    }
    this.mCodec = null;
    break label728;
    try
    {
      this.mBitRate = ((Integer)paramMap.get("bitrate")).intValue();
      this.mFrameRate = ((Integer)paramMap.get("frame-rate")).intValue();
      createEncCodec();
    }
    catch (Exception paramString)
    {
      this.mCodec = null;
      AVCoreLog.e(this.mTag, "NativeCodec, createEncCodec Exception", paramString);
    }
    label728:
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap = new HashMap();
      this.mDebugDelayMap2 = new HashMap();
      this.mDebugIndexMap = new HashMap();
    }
  }
  
  public static boolean canLog()
  {
    return (AVCoreLog.isDevelopLevel()) || ((AVCoreLog.isColorLevel()) && (printLog));
  }
  
  private void createDecCodec()
  {
    this.mCodec = AndroidCodecAdapterProxy.getInstance().createDecCodec(this.mTag);
    if (this.mIsDecoder)
    {
      List localList = AndroidCodecBase.getDecoderInfos(this.mMime);
      if (localList.size() == 0)
      {
        AVCoreLog.e(this.mTag, "createDecCodec fail, list.size为0");
        return;
      }
      int i = 0;
      MediaCodecInfo localMediaCodecInfo = (MediaCodecInfo)localList.get(0);
      Object localObject;
      for (;;)
      {
        localObject = localMediaCodecInfo;
        if (i >= localList.size()) {
          break;
        }
        localObject = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject != null)
        {
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
        }
        i += 1;
      }
      if (!this.mCodec.init(this.mFormat, ((MediaCodecInfo)localObject).getName(), this)) {
        this.mCodec = null;
      }
    }
  }
  
  private void createEncCodec()
  {
    if (this.mCodec == null) {}
    for (;;)
    {
      int j;
      try
      {
        List localList = AndroidCodecBase.getEndoderInfos(this.mMime);
        this.mColorFormat = 21;
        int m = 0;
        i = 0;
        if (i >= localList.size()) {
          break label774;
        }
        Object localObject1 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject1 == null) {
          break label767;
        }
        if (ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats, 21))
        {
          this.mColorFormat = 21;
        }
        else
        {
          if (!ArrayUtils.contains(((MediaCodecInfo.CodecCapabilities)localObject1).colorFormats, 19)) {
            break label767;
          }
          this.mColorFormat = 19;
        }
        localObject1 = MediaFormat.createVideoFormat(this.mMime, this.mWidth, this.mHeight);
        ((MediaFormat)localObject1).setInteger("color-format", this.mColorFormat);
        ((MediaFormat)localObject1).setInteger("frame-rate", this.mFrameRate);
        ((MediaFormat)localObject1).setInteger("bitrate", this.mBitRate);
        j = 30;
        if (this.mFrameRate * 30 > 255) {
          j = 255 / this.mFrameRate;
        }
        Object localObject2 = this.mTag;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("KEY_I_FRAME_INTERVAL =");
        ((StringBuilder)localObject3).append(j);
        ((StringBuilder)localObject3).append(", mFrameRate = ");
        ((StringBuilder)localObject3).append(this.mFrameRate);
        AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
        ((MediaFormat)localObject1).setInteger("i-frame-interval", j);
        localObject2 = AndroidCodecBase.getCodecCapabilities((MediaCodecInfo)localList.get(i), this.mMime);
        if (localObject2 != null)
        {
          boolean bool = this.mMime.contains("video/avc");
          if (bool)
          {
            j = 0;
            if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length)
            {
              int n = localObject2.profileLevels[j].profile;
              k = 512;
              if (n != 1)
              {
                if ((n != 8) || ((!AVCoreLog.isDebugVersion()) && (!AVCoreLog.isGrayVersion())) || (this.mHwDetectMode != 2)) {
                  break label779;
                }
                ((MediaFormat)localObject1).setInteger("profile", 8);
                if (512 < localObject2.profileLevels[j].level) {
                  k = localObject2.profileLevels[j].level;
                }
                ((MediaFormat)localObject1).setInteger("level", k);
                break label779;
              }
              ((MediaFormat)localObject1).setInteger("profile", 1);
              if (512 < localObject2.profileLevels[j].level) {
                k = localObject2.profileLevels[j].level;
              }
              ((MediaFormat)localObject1).setInteger("level", k);
              break label779;
            }
          }
          if (this.mMime.contains("video/hevc"))
          {
            j = m;
            if (j < ((MediaCodecInfo.CodecCapabilities)localObject2).profileLevels.length)
            {
              if (localObject2.profileLevels[j].profile != 1) {
                break label793;
              }
              ((MediaFormat)localObject1).setInteger("profile", 1);
              if (16384 >= localObject2.profileLevels[j].level) {
                break label786;
              }
              k = localObject2.profileLevels[j].level;
              localObject3 = AVCoreSystemInfo.getCpuModel();
              if ((localObject3 != null) && ((((String)localObject3).equalsIgnoreCase("QualcommTechnologies,IncMSM8953")) || (((String)localObject3).equalsIgnoreCase("QualcommTechnologies,Inc625"))))
              {
                ((MediaFormat)localObject1).setInteger("level", 16384);
                break label793;
              }
              ((MediaFormat)localObject1).setInteger("level", k);
              break label793;
            }
          }
          this.mFormat = ((MediaFormat)localObject1);
          if (this.mFrameRate > 0) {
            this.mFrameInterval = (1000000 / this.mFrameRate);
          } else {
            this.mFrameInterval = 40000;
          }
          this.mCodec = AndroidCodecAdapterProxy.getInstance().createEncCodec(this.mTag);
          localObject2 = this.mTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("createEncCodec format: ");
          ((StringBuilder)localObject3).append(localObject1);
          ((StringBuilder)localObject3).append(", codec name: ");
          ((StringBuilder)localObject3).append(((MediaCodecInfo)localList.get(i)).getName());
          AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
          this.mCodec.init(this.mFormat, ((MediaCodecInfo)localList.get(i)).getName(), this);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        AVCoreLog.e(this.mTag, "Exception at CreateCodec!!!!");
        this.mCodec = null;
      }
      return;
      label767:
      i += 1;
      continue;
      label774:
      int i = 0;
      continue;
      label779:
      j += 1;
      continue;
      label786:
      int k = 16384;
      continue;
      label793:
      j += 1;
    }
  }
  
  private boolean dequeueLastFrame(int paramInt)
  {
    Object localObject1 = this.mCodec;
    if (localObject1 == null)
    {
      if (AVCoreLog.isLogColorOrGary()) {
        AVCoreLog.e(this.mTag, "dequeueLastFrame err!! mCodec is null");
      }
      return false;
    }
    for (;;)
    {
      int j;
      int k;
      try
      {
        localObject1 = ((AndroidCodecBase)localObject1).getInputBuffer();
        i = 0;
        Object localObject2 = localObject1;
        if (localObject1 == null)
        {
          j = i + 1;
          if (this.mIsDecoder) {
            dequeueOutFrameMore(3000000L);
          }
          localObject1 = this.mCodec.getInputBuffer();
          if (localObject1 != null)
          {
            localObject2 = localObject1;
          }
          else
          {
            i = j;
            if (j <= 8) {
              continue;
            }
            if (!AVCoreLog.isLogColorOrGary()) {
              break label577;
            }
            localObject1 = this.mTag;
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("dequeueLastFrame not available, try count=");
            ((StringBuilder)localObject2).append(j);
            AVCoreLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
            return false;
          }
        }
        ((BufferData)localObject2).buffer = null;
        this.mCodec.queueInputBuffer(((BufferData)localObject2).index, 0, 0L, 4);
        i = 0;
        j = 0;
        if (i < 10)
        {
          k = i + 1;
          localObject1 = this.mCodec.dequeueOutputBuffer();
          i = k;
          if (localObject1 == null) {
            continue;
          }
          i = k;
          if (((BufferData)localObject1).index < 0) {
            continue;
          }
          if (!((BufferData)localObject1).success)
          {
            i = k;
            if (!AVCoreLog.isLogColorOrGary()) {
              continue;
            }
            AVCoreLog.e(this.mTag, "dequeueLastFrame output.success is false");
            i = k;
            continue;
          }
          if ((((BufferData)localObject1).format != null) && (((BufferData)localObject1).buffer != null))
          {
            if (this.mIsDecoder) {
              setFrame(((BufferData)localObject1).buffer, ((BufferData)localObject1).info.size, ((BufferData)localObject1).format);
            } else {
              readOutputStream(((BufferData)localObject1).buffer, ((BufferData)localObject1).info.presentationTimeUs, ((BufferData)localObject1).info.offset, ((BufferData)localObject1).info.size, ((BufferData)localObject1).info.flags);
            }
            this.mCodec.releaseOutputBuffer(((BufferData)localObject1).index);
            if ((((BufferData)localObject1).info.flags & 0x4) == 0) {
              break label579;
            }
            if (AVCoreLog.isLogColorOrGary())
            {
              localObject1 = this.mTag;
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("dequeueLastFrame reach eof getFrame: ");
              ((StringBuilder)localObject2).append(j);
              ((StringBuilder)localObject2).append(", lastFrameCount: ");
              ((StringBuilder)localObject2).append(paramInt);
              ((StringBuilder)localObject2).append(", loopCount:");
              ((StringBuilder)localObject2).append(k);
              AVCoreLog.e((String)localObject1, ((StringBuilder)localObject2).toString());
              return true;
            }
          }
          else
          {
            if (AVCoreLog.isLogColorOrGary())
            {
              localObject2 = this.mTag;
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("dequeueLastFrame err! output.format == null: ");
              if (((BufferData)localObject1).format != null) {
                break label589;
              }
              bool = true;
              localStringBuilder.append(bool);
              localStringBuilder.append(", output.buffer == null: ");
              if (((BufferData)localObject1).buffer != null) {
                break label595;
              }
              bool = true;
              localStringBuilder.append(bool);
              AVCoreLog.e((String)localObject2, localStringBuilder.toString());
            }
            this.mCodec.releaseOutputBuffer(((BufferData)localObject1).index);
            i = k;
            continue;
          }
        }
        return true;
      }
      catch (Exception localException)
      {
        if (AVCoreLog.isLogColorOrGary()) {
          AVCoreLog.e(this.mTag, "dequeueLastFrame CodecException!!", localException);
        }
        return false;
      }
      label577:
      return false;
      label579:
      j += 1;
      int i = k;
      continue;
      label589:
      boolean bool = false;
      continue;
      label595:
      bool = false;
    }
  }
  
  private boolean dequeueOutFrameMore(long paramLong)
  {
    long l1 = 0L;
    while (l1 < paramLong)
    {
      long l2 = System.nanoTime();
      BufferData localBufferData = this.mCodec.dequeueDecoderOutputBuffer(3000L);
      l2 = l1 + (System.nanoTime() - l2);
      if (localBufferData == null)
      {
        l1 = l2;
      }
      else if (localBufferData.index == -1)
      {
        l1 = l2;
      }
      else
      {
        l1 = l2;
        if (localBufferData.index >= 0) {
          if (!localBufferData.success)
          {
            AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer failed with exception");
            l1 = l2;
          }
          else
          {
            if ((localBufferData.format != null) && (localBufferData.buffer != null))
            {
              setFrame(localBufferData.buffer, localBufferData.info.size, localBufferData.format);
              this.mCodec.releaseOutputBuffer(localBufferData.index);
              return true;
            }
            AVCoreLog.e(this.mTag, "dequeueOutFrameMore get output buffer error");
            this.mCodec.releaseOutputBuffer(localBufferData.index);
            l1 = l2;
          }
        }
      }
    }
    return false;
  }
  
  private static int getIntValues(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = getIntValuesImp("NativeCodec", paramString1, paramString2, paramBoolean);
    if (AVCoreLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getIntValues, mime[");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("], isDecoder[");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("], key[");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("], value[");
      localStringBuilder.append(i);
      localStringBuilder.append("]");
      AVCoreLog.e("NativeCodec", localStringBuilder.toString());
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
    String str = localNativeCodec.mTag;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onAttach, mime[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("], instance[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("], isDecoder[");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("]");
    AVCoreLog.e(str, localStringBuilder.toString());
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
      if (canLog())
      {
        String str = this.mTag;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCalcDelay, frameIndex[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], cur[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        AVCoreLog.e(str, localStringBuilder.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDetach, nativeCodec[");
      localStringBuilder.append(???);
      localStringBuilder.append("]");
      AVCoreLog.e("NativeCodec", localStringBuilder.toString());
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
    Object localObject1;
    Object localObject3;
    if (AVCoreLog.isLogColorOrGary())
    {
      localObject1 = this.mTag;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onDoCodec,frameIndex[");
      ((StringBuilder)localObject3).append(paramInt2);
      ((StringBuilder)localObject3).append("], flag[");
      ((StringBuilder)localObject3).append(paramInt1);
      ((StringBuilder)localObject3).append("], mTryAgainLaterCount[");
      ((StringBuilder)localObject3).append(this.mTryAgainLaterCount);
      ((StringBuilder)localObject3).append("]");
      AVCoreLog.e((String)localObject1, ((StringBuilder)localObject3).toString());
    }
    if ((this.mTryAgainLaterCount >= 10) && (paramInt1 == 0))
    {
      localObject1 = this.mTag;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("onDoCodec err!! restCodec mTryAgainLaterCount: ");
      ((StringBuilder)localObject3).append(this.mTryAgainLaterCount);
      ((StringBuilder)localObject3).append(", flag: ");
      ((StringBuilder)localObject3).append(paramInt1);
      AVCoreLog.e((String)localObject1, ((StringBuilder)localObject3).toString());
      resetCodec();
      if (this.mCodec == null) {
        return false;
      }
    }
    try
    {
      localObject1 = this.mCodec.getInputBuffer();
      paramInt1 = 0;
      for (;;)
      {
        localObject3 = localObject1;
        if (localObject1 != null) {
          break;
        }
        localObject4 = localObject1;
        int j = paramInt1;
        try
        {
          Thread.sleep(50L);
          localObject4 = localObject1;
          j = paramInt1;
          localObject3 = this.mCodec.getInputBuffer();
          int i = paramInt1 + 1;
          if (localObject3 != null) {
            break;
          }
          localObject4 = localObject3;
          j = i;
          if (AVCoreLog.isLogColorOrGary())
          {
            localObject4 = localObject3;
            j = i;
            AVCoreLog.e(this.mTag, "onDoCodec not available");
          }
          localObject1 = localObject3;
          paramInt1 = i;
          if (i > 8)
          {
            localObject4 = localObject3;
            j = i;
            localObject1 = this.mTag;
            localObject4 = localObject3;
            j = i;
            StringBuilder localStringBuilder = new StringBuilder();
            localObject4 = localObject3;
            j = i;
            localStringBuilder.append("onDoCodec not available, try count=");
            localObject4 = localObject3;
            j = i;
            localStringBuilder.append(i);
            localObject4 = localObject3;
            j = i;
            AVCoreLog.e((String)localObject1, localStringBuilder.toString());
            return false;
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
          localObject2 = localObject4;
          paramInt1 = j;
        }
      }
      if (this.mIsDecoder) {
        paramInt1 = writeInputData(((BufferData)localObject3).buffer, false);
      } else {
        paramInt1 = writeInputData2(((BufferData)localObject3).buffer, this.mColorFormat, false);
      }
    }
    catch (Exception localException)
    {
      Object localObject4;
      Object localObject2;
      boolean bool3;
      boolean bool2;
      long l2;
      long l1;
      AVCoreLog.e(this.mTag, "onDoCodec Exception!", localException);
      return false;
    }
    if (paramInt1 < 0)
    {
      AVCoreLog.e(this.mTag, "writeInputData, SampleSize < 0");
      return false;
    }
    this.mLastEncFrameTime += this.mFrameInterval;
    if (this.mDebugDelay)
    {
      this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
      this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
    }
    this.mCodec.queueInputBuffer(((BufferData)localObject3).index, paramInt1, this.mLastEncFrameTime, 0);
    paramInt1 = this.mTotalDecInFrameNum;
    bool3 = true;
    bool2 = true;
    this.mTotalDecInFrameNum = (paramInt1 + 1);
    l2 = System.nanoTime();
    l1 = 33000000L;
    if (this.mIsDecoder)
    {
      if (paramInt2 < 4) {
        l1 = 45000000L;
      }
      localObject2 = this.mCodec.dequeueDecoderOutputBuffer(l1);
    }
    else
    {
      localObject2 = this.mCodec.dequeueOutputBuffer();
    }
    boolean bool1;
    if (localObject2 != null)
    {
      if (((BufferData)localObject2).index == -1)
      {
        this.mTryAgainLaterCount += 1;
        if (AVCoreLog.isLogColorOrGary())
        {
          localObject2 = this.mTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("onDoCodec, try again, count[");
          ((StringBuilder)localObject3).append(this.mTryAgainLaterCount);
          ((StringBuilder)localObject3).append("]");
          AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
        }
        if ((this.mIsDecoder) && (dequeueOutFrameMore(l1 - (System.nanoTime() - l2))))
        {
          this.mTryAgainLaterCount = 0;
          return true;
        }
        if (this.mTryAgainLaterCount < 16) {
          break label1451;
        }
        return false;
      }
      this.mTryAgainLaterCount = 0;
      if (!((BufferData)localObject2).success)
      {
        AVCoreLog.e(this.mTag, "onDoCodec err!");
        return false;
      }
      localObject3 = ((BufferData)localObject2).format;
      if ((localObject3 != null) && (((BufferData)localObject2).buffer != null))
      {
        if (this.mIsDecoder)
        {
          calcDelay(true, ((BufferData)localObject2).info);
          setFrame(((BufferData)localObject2).buffer, ((BufferData)localObject2).info.size, ((BufferData)localObject2).format);
        }
        else
        {
          if (((BufferData)localObject2).info.flags == 1) {
            AVCoreLog.e(this.mTag, "onDoCodec err flags = 1");
          }
          localObject3 = localObject2;
          if (((BufferData)localObject2).info.flags == 2)
          {
            this.mCodec.releaseOutputBuffer(((BufferData)localObject2).index);
            readOutputStream(((BufferData)localObject2).buffer, ((BufferData)localObject2).info.presentationTimeUs, ((BufferData)localObject2).info.offset, ((BufferData)localObject2).info.size, ((BufferData)localObject2).info.flags);
            localObject2 = this.mCodec.dequeueOutputBuffer();
            if (localObject2 != null)
            {
              if (((BufferData)localObject2).index == -1)
              {
                this.mTryAgainLaterCount2 += 1;
                if (AVCoreLog.isColorLevel())
                {
                  localObject2 = this.mTag;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("onDoCodec, re-dequeue dequeueOutputBuffer, try again later,count =");
                  ((StringBuilder)localObject3).append(this.mTryAgainLaterCount2);
                  AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
                }
                if (this.mTryAgainLaterCount2 < 16) {
                  break label1453;
                }
                AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue dequeueOutputBuffer >= 16 times");
                return false;
              }
              this.mTryAgainLaterCount2 = 0;
              if (!((BufferData)localObject2).success)
              {
                AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue onDoCodec err!");
                return false;
              }
              if ((((BufferData)localObject2).format == null) || (((BufferData)localObject2).buffer == null))
              {
                this.mCodec.releaseOutputBuffer(((BufferData)localObject2).index);
                localObject3 = this.mTag;
                localObject4 = new StringBuilder();
                ((StringBuilder)localObject4).append("onDoCodec err! output.format == null: ");
                if (((BufferData)localObject2).format != null) {
                  break label1455;
                }
                bool1 = true;
                label1100:
                ((StringBuilder)localObject4).append(bool1);
                ((StringBuilder)localObject4).append(", output.buffer == null: ");
                if (((BufferData)localObject2).buffer != null) {
                  break label1461;
                }
                bool1 = bool2;
                label1132:
                ((StringBuilder)localObject4).append(bool1);
                AVCoreLog.e((String)localObject3, ((StringBuilder)localObject4).toString());
                return false;
              }
            }
            localObject3 = localObject2;
            if (AVCoreLog.isColorLevel())
            {
              AVCoreLog.e(this.mTag, "onDoCodec, re-dequeue success");
              localObject3 = localObject2;
            }
          }
          calcDelay(true, ((BufferData)localObject3).info);
          readOutputStream(((BufferData)localObject3).buffer, ((BufferData)localObject3).info.presentationTimeUs, ((BufferData)localObject3).info.offset, ((BufferData)localObject3).info.size, ((BufferData)localObject3).info.flags);
          localObject2 = localObject3;
        }
        this.mCodec.releaseOutputBuffer(((BufferData)localObject2).index);
        if ((this.mIsDecoder) && (this.mTotalDecInFrameNum - this.mTotalDecOutFrameNum > 0))
        {
          bool1 = dequeueOutFrameMore(l1 - (System.nanoTime() - l2));
          if (AVCoreLog.isLogColorOrGary())
          {
            localObject2 = this.mTag;
            localObject3 = new StringBuilder();
            ((StringBuilder)localObject3).append("dequeue one store Frame status: ");
            ((StringBuilder)localObject3).append(bool1);
            AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
            return true;
          }
        }
      }
      else
      {
        this.mCodec.releaseOutputBuffer(((BufferData)localObject2).index);
        localObject3 = this.mTag;
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("onDoCodec err! output.format == null: ");
        if (((BufferData)localObject2).format != null) {
          break label1467;
        }
        bool1 = true;
        label1378:
        ((StringBuilder)localObject4).append(bool1);
        ((StringBuilder)localObject4).append(", output.buffer == null: ");
        if (((BufferData)localObject2).buffer != null) {
          break label1473;
        }
        bool1 = bool3;
      }
    }
    for (;;)
    {
      ((StringBuilder)localObject4).append(bool1);
      AVCoreLog.e((String)localObject3, ((StringBuilder)localObject4).toString());
      return false;
      return true;
      break;
      label1451:
      return true;
      label1453:
      return true;
      label1455:
      bool1 = false;
      break label1100;
      label1461:
      bool1 = false;
      break label1132;
      label1467:
      bool1 = false;
      break label1378;
      label1473:
      bool1 = false;
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
    label429:
    label432:
    synchronized (this.mPendingInputBuffers)
    {
      if (this.mCodersExit.get())
      {
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e(this.mTag, "hardware coders exit, return.");
        }
        return 2;
      }
      if (this.mPendingInputBuffers.size() > 0)
      {
        Object localObject3;
        if (canLog())
        {
          localObject1 = this.mTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("InputData pendingInputBuffers exist, size:");
          ((StringBuilder)localObject3).append(this.mPendingInputBuffers.size());
          AVCoreLog.e((String)localObject1, ((StringBuilder)localObject3).toString());
        }
        Object localObject1 = (InputBufferData)this.mPendingInputBuffers.get(0);
        if (localObject1 == null) {
          return 2;
        }
        if (((InputBufferData)localObject1).buffer == null)
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "inputbuffer null, return");
          }
          return -1;
        }
        if (((InputBufferData)localObject1).processing)
        {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "curr buffer is being processed by other thread, return");
          }
          return 2;
        }
        if (this.mIsDecoder)
        {
          paramInt1 = writeInputData(((InputBufferData)localObject1).buffer, false);
        }
        else
        {
          paramInt1 = writeInputData2(((InputBufferData)localObject1).buffer, this.mColorFormat, false);
          break label429;
          if (canLog())
          {
            localObject3 = this.mTag;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("onDoCodecAsync, sampleSize[");
            localStringBuilder.append(paramInt1);
            localStringBuilder.append("]");
            AVCoreLog.e((String)localObject3, localStringBuilder.toString());
          }
          if (paramInt1 <= 0) {
            break label432;
          }
          this.mLastEncFrameTime += this.mFrameInterval;
          this.mPendingInputBuffers.remove(0);
          if (this.mDebugDelay)
          {
            this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
            this.mDebugIndexMap.put(Long.valueOf(this.mLastEncFrameTime), Integer.valueOf(paramInt2));
          }
          this.mCodec.queueInputBuffer(((InputBufferData)localObject1).index, paramInt1, this.mLastEncFrameTime, 0);
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
    if (this.mCodec != null) {}
    try
    {
      synchronized (this.mPendingInputBuffers)
      {
        this.mCodersExit.set(true);
        this.mPendingInputBuffers.clear();
        if (this.mDebugDelay)
        {
          this.mDebugDelayMap.clear();
          this.mDebugDelayMap2.clear();
          this.mDebugIndexMap.clear();
        }
        this.mCodec.stop();
        this.mCodec.release();
        this.mCodec = null;
      }
    }
    catch (Exception localException1)
    {
      label94:
      break label94;
    }
    this.mCodec = null;
    try
    {
      if (this.mIsDecoder) {
        createDecCodec();
      } else {
        createEncCodec();
      }
      this.mTimeStamp = 0L;
      this.mLastEncFrameTime = 0L;
      this.mCodec.start();
      this.mCodersExit.set(false);
    }
    catch (Exception localException2)
    {
      label143:
      break label143;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e(this.mTag, "resetCodec");
    }
  }
  
  public static native void setDeviceInfo(String paramString);
  
  private boolean setFrame(ByteBuffer paramByteBuffer, int paramInt, MediaFormat paramMediaFormat)
  {
    int i8 = paramMediaFormat.getInteger("width");
    int i5 = paramMediaFormat.getInteger("height");
    int k = paramMediaFormat.getInteger("crop-left");
    int i6 = paramMediaFormat.getInteger("crop-right");
    int m = paramMediaFormat.getInteger("crop-top");
    int i7 = paramMediaFormat.getInteger("crop-bottom");
    int i = paramMediaFormat.getInteger("stride");
    int j = paramMediaFormat.getInteger("slice-height");
    int i9 = paramMediaFormat.getInteger("color-format");
    j = Math.max(j, i5);
    int i10 = Math.max(i, i8);
    boolean bool = false;
    if (i9 == 2130706688)
    {
      j -= m / 2;
      k = 0;
      m = 0;
    }
    int n = Math.max(i10, i8);
    if (((2141391876 == i9) || (2130706433 == i9) || (2130706944 == i9)) && (i5 < j)) {
      i = j;
    } else {
      i = i5;
    }
    int i2;
    int i3;
    int i4;
    int i1;
    if (k + i6 + m + i7 == 0)
    {
      i2 = i8 - 1;
      i3 = 0;
      i4 = 0;
      i1 = i5 - 1;
    }
    else
    {
      i2 = i6 - k + 1;
      i1 = i7 - m + 1;
      if (n < i2) {
        n = i2;
      }
      if (i < i1) {
        i = i1;
      }
      i4 = m;
      i1 = i7;
      i2 = i6;
      i3 = k;
    }
    if ((n > 0) && (i > 0) && (i2 > 0) && (i1 > 0))
    {
      long l1 = SystemClock.elapsedRealtime();
      i1 = readOutputDataEx(paramByteBuffer, paramInt, n, i, i3, i4, i2 - i3 + 1, i1 - i4 + 1, i9);
      this.mTotalDecOutFrameNum += 1;
      long l2 = SystemClock.elapsedRealtime();
      if (canLog())
      {
        paramByteBuffer = this.mTag;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setFrame, size[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], width[");
        localStringBuilder.append(i8);
        localStringBuilder.append("], height[");
        localStringBuilder.append(i5);
        localStringBuilder.append("], crop_left[");
        localStringBuilder.append(paramMediaFormat.getInteger("crop-left"));
        localStringBuilder.append("->");
        localStringBuilder.append(k);
        localStringBuilder.append("], crop_right[");
        localStringBuilder.append(i6);
        localStringBuilder.append("], crop_top[");
        localStringBuilder.append(paramMediaFormat.getInteger("crop-top"));
        localStringBuilder.append("->");
        localStringBuilder.append(m);
        localStringBuilder.append("], crop_bottom[");
        localStringBuilder.append(i7);
        localStringBuilder.append("], stride[");
        localStringBuilder.append(paramMediaFormat.getInteger("stride"));
        localStringBuilder.append("->");
        localStringBuilder.append(i10);
        localStringBuilder.append("], slice_height[");
        localStringBuilder.append(paramMediaFormat.getInteger("slice-height"));
        localStringBuilder.append("->");
        localStringBuilder.append(j);
        localStringBuilder.append("], picWidth[");
        localStringBuilder.append(n);
        localStringBuilder.append("], picHeight[");
        localStringBuilder.append(i);
        localStringBuilder.append("], colorFormat[0x");
        localStringBuilder.append(Integer.toHexString(i9).toUpperCase());
        localStringBuilder.append("], cost[");
        localStringBuilder.append(l2 - l1);
        localStringBuilder.append("]");
        AVCoreLog.e(paramByteBuffer, localStringBuilder.toString());
      }
      if (i1 > 0) {
        bool = true;
      }
      return bool;
    }
    if (AVCoreLog.isColorLevel())
    {
      paramByteBuffer = this.mTag;
      paramMediaFormat = new StringBuilder();
      paramMediaFormat.append("setFrame, error, size[");
      paramMediaFormat.append(paramInt);
      paramMediaFormat.append("], colorFormat[0x");
      paramMediaFormat.append(Integer.toHexString(i9).toUpperCase());
      paramMediaFormat.append("]");
      AVCoreLog.e(paramByteBuffer, paramMediaFormat.toString());
    }
    return false;
  }
  
  private void setParameters(String paramString, int paramInt)
  {
    if (this.mCodec == null) {
      return;
    }
    if (paramString == null) {
      return;
    }
    StringBuilder localStringBuilder;
    if (paramString.equalsIgnoreCase("frame-rate")) {
      if (paramInt > 0)
      {
        this.mFrameRate = paramInt;
        this.mFrameInterval = (1000000 / this.mFrameRate);
        resetCodec();
        localObject = this.mTag;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("HWENC setParameters mFrameRate =");
        localStringBuilder.append(this.mFrameRate);
        AVCoreLog.e((String)localObject, localStringBuilder.toString());
      }
      else
      {
        return;
      }
    }
    if (Build.VERSION.SDK_INT < 19) {
      return;
    }
    int i = paramInt;
    if (paramString.equalsIgnoreCase("i-frame-interval"))
    {
      localObject = this.mTag;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("HWENC setParameters i-frame-interval: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", frameRate: ");
      localStringBuilder.append(this.mFrameRate);
      AVCoreLog.e((String)localObject, localStringBuilder.toString());
      int j = this.mFrameRate;
      i = paramInt;
      if (paramInt * j > 255)
      {
        i = 255 / j;
        localObject = this.mTag;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("HWENC setParameters i-frame-interval changed: ");
        localStringBuilder.append(i);
        AVCoreLog.e((String)localObject, localStringBuilder.toString());
      }
    }
    Object localObject = new Bundle();
    ((Bundle)localObject).putInt(paramString, i);
    this.mCodec.setParameters((Bundle)localObject);
  }
  
  public native boolean attachCodec(Object paramObject);
  
  void calcDelay(boolean paramBoolean, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mDebugDelay)
    {
      Object localObject1 = (Long)this.mDebugDelayMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      Object localObject2;
      Object localObject3;
      if (localObject1 != null)
      {
        if (canLog())
        {
          localObject2 = this.mTag;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("calcDelay, small[");
          ((StringBuilder)localObject3).append(paramBufferInfo.presentationTimeUs);
          ((StringBuilder)localObject3).append("], takes[");
          ((StringBuilder)localObject3).append(System.currentTimeMillis() - ((Long)localObject1).longValue());
          ((StringBuilder)localObject3).append("]");
          AVCoreLog.e((String)localObject2, ((StringBuilder)localObject3).toString());
        }
        this.mDebugDelayMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
      localObject1 = (Integer)this.mDebugIndexMap.get(Long.valueOf(paramBufferInfo.presentationTimeUs));
      if (localObject1 != null)
      {
        localObject2 = (Long)this.mDebugDelayMap2.get(localObject1);
        if (localObject2 != null)
        {
          if (canLog())
          {
            localObject3 = this.mTag;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("calcDelay, big[");
            localStringBuilder.append(paramBufferInfo.presentationTimeUs);
            localStringBuilder.append("], takes[");
            localStringBuilder.append(System.currentTimeMillis() - ((Long)localObject2).longValue());
            localStringBuilder.append("]");
            AVCoreLog.e((String)localObject3, localStringBuilder.toString());
          }
          this.mDebugDelayMap2.remove(localObject1);
        }
        this.mDebugIndexMap.remove(Long.valueOf(paramBufferInfo.presentationTimeUs));
      }
    }
  }
  
  public native void detachCodec();
  
  public void onError(MediaCodec paramMediaCodec, Exception paramException)
  {
    if (this.mCodersExit.get())
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onError");
      }
      return;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e(this.mTag, "onError", paramException);
    }
  }
  
  public void onInputBufferAvailable(MediaCodec arg1, int paramInt)
  {
    Object localObject1 = this.mCodec.getInputBuffer(paramInt);
    if (localObject1 == null)
    {
      if (AVCoreLog.isColorLevel())
      {
        ??? = this.mTag;
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getInputBuffer null, index:");
        ((StringBuilder)localObject1).append(paramInt);
        AVCoreLog.e(???, ((StringBuilder)localObject1).toString());
      }
      return;
    }
    try
    {
      synchronized (this.mPendingInputBuffers)
      {
        if (this.mCodersExit.get()) {
          if (AVCoreLog.isColorLevel()) {
            AVCoreLog.e(this.mTag, "codec exit, return onInputBufferAvailable");
          }
        }
        try
        {
          synchronized (this.mPendingInputBuffers)
          {
            ((InputBufferData)this.mPendingInputBuffers.get(0)).processing = false;
          }
        }
        catch (Exception localException1)
        {
          label121:
          break label121;
        }
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
        }
        return;
        throw localByteBuffer;
        this.mPendingInputBuffers.add(new InputBufferData(localByteBuffer, paramInt));
        ((InputBufferData)this.mPendingInputBuffers.get(0)).processing = true;
        try
        {
          if (canLog())
          {
            ??? = this.mTag;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("call writeInputData2 in callback, mIsDecoder[");
            localStringBuilder.append(this.mIsDecoder);
            localStringBuilder.append("]");
            AVCoreLog.e(???, localStringBuilder.toString());
          }
          if (this.mIsDecoder) {
            paramInt = writeInputData(((InputBufferData)this.mPendingInputBuffers.get(0)).buffer, true);
          } else {
            paramInt = writeInputData2(((InputBufferData)this.mPendingInputBuffers.get(0)).buffer, this.mColorFormat, true);
          }
        }
        catch (Exception ???)
        {
          StringBuilder localStringBuilder;
          label294:
          break label294;
        }
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e(this.mTag, "input buffers cleared by other thread when writeInputData");
        }
        paramInt = 0;
        if (paramInt > 0) {
          label433:
          try
          {
            if (canLog())
            {
              ??? = this.mTag;
              localStringBuilder = new StringBuilder();
              localStringBuilder.append("writeInputData, SampleSize:");
              localStringBuilder.append(paramInt);
              AVCoreLog.e(???, localStringBuilder.toString());
            }
            this.mLastEncFrameTime += this.mFrameInterval;
            if (this.mDebugDelay) {
              this.mDebugDelayMap.put(Long.valueOf(this.mLastEncFrameTime), Long.valueOf(System.currentTimeMillis()));
            }
          }
          finally {}
        }
        try
        {
          this.mCodec.queueInputBuffer(((InputBufferData)this.mPendingInputBuffers.get(0)).index, paramInt, this.mLastEncFrameTime, 0);
        }
        catch (Exception ???)
        {
          break label433;
        }
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e(this.mTag, "input buffers cleared by other thread when queueInputBuffer");
        }
        try
        {
          synchronized (this.mPendingInputBuffers)
          {
            ((InputBufferData)this.mPendingInputBuffers.get(0)).processing = false;
            if (paramInt <= 0) {
              break label518;
            }
            this.mPendingInputBuffers.remove(0);
          }
        }
        catch (Exception localException2)
        {
          label502:
          break label502;
        }
        if (AVCoreLog.isColorLevel()) {
          AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
        }
        label518:
        return;
        throw localObject2;
      }
      try
      {
        synchronized (this.mPendingInputBuffers)
        {
          ((InputBufferData)this.mPendingInputBuffers.get(0)).processing = false;
          if (paramInt <= 0) {
            break label595;
          }
          this.mPendingInputBuffers.remove(0);
        }
      }
      catch (Exception localException3)
      {
        break label579;
      }
    }
    finally
    {
      paramInt = 0;
    }
    label579:
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e(this.mTag, "input buffers cleared by other thread when processing=false");
    }
    label595:
    throw ???;
    throw ???;
  }
  
  public void onOutputBufferAvailable(MediaCodec paramMediaCodec, int paramInt, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.mCodersExit.get())
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onOutputBufferAvailable");
      }
      return;
    }
    paramMediaCodec = this.mCodec.getOutputBuffer(paramInt);
    if ((paramMediaCodec != null) && (paramBufferInfo != null))
    {
      if (this.mIsDecoder)
      {
        MediaFormat localMediaFormat = this.mCodec.getOutputFormat(paramInt);
        if (localMediaFormat != null)
        {
          calcDelay(false, paramBufferInfo);
          setFrame(paramMediaCodec, paramBufferInfo.size, localMediaFormat);
        }
        else if (AVCoreLog.isColorLevel())
        {
          AVCoreLog.e(this.mTag, "getOutputFormat null");
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
    if (this.mCodersExit.get())
    {
      if (AVCoreLog.isColorLevel()) {
        AVCoreLog.e(this.mTag, "codec exit, return onOutputFormatChanged");
      }
      return;
    }
    if (AVCoreLog.isColorLevel()) {
      AVCoreLog.e(this.mTag, "onOutputFormatChanged");
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.jni.codec.NativeCodec
 * JD-Core Version:    0.7.0.1
 */