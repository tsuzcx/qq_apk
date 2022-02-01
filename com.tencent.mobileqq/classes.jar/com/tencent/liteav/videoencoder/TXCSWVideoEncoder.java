package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.b.o;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder
  extends d
{
  private static final boolean DEBUG = false;
  private static final String TAG = "TXCSWVideoEncoder";
  private int mBitrate = 0;
  private long mNativeEncoder = 0L;
  private long mPTS = 0L;
  private int mPopIdx = 0;
  private int mPushIdx = 0;
  private h mRawFrameFilter;
  private int mRendIdx = 0;
  private h mResizeFilter;
  
  static
  {
    f.f();
    nativeClassInit();
  }
  
  public static long getAndIncreaseGopIndex()
  {
    return nativeGetAndIncreaseGopIndex();
  }
  
  public static long getAndIncreateSeq()
  {
    return nativeGetAndIncreaseSeq();
  }
  
  private static native void nativeClassInit();
  
  private native void nativeEnableNearestRPS(long paramLong, int paramInt);
  
  private native int nativeEncode(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private native int nativeEncodeSync(long paramLong1, int paramInt1, int paramInt2, int paramInt3, long paramLong2);
  
  private static native long nativeGetAndIncreaseGopIndex();
  
  private static native long nativeGetAndIncreaseSeq();
  
  private native long nativeGetRealFPS(long paramLong);
  
  private native long nativeInit(WeakReference<TXCSWVideoEncoder> paramWeakReference);
  
  private native void nativeRelease(long paramLong);
  
  private native void nativeRestartIDR(long paramLong);
  
  private native void nativeSetBitrate(long paramLong, int paramInt);
  
  private native void nativeSetBitrateFromQos(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSetEncodeIdrFpsFromQos(long paramLong, int paramInt);
  
  private native void nativeSetFPS(long paramLong, int paramInt);
  
  private native void nativeSetID(long paramLong, String paramString);
  
  private native void nativeSetRPSRefBitmap(long paramLong1, int paramInt1, int paramInt2, long paramLong2);
  
  private native void nativeSignalEOSAndFlush(long paramLong);
  
  private native int nativeStart(long paramLong, TXSVideoEncoderParam paramTXSVideoEncoderParam);
  
  private native void nativeStop(long paramLong);
  
  private native long nativegetRealBitrate(long paramLong);
  
  private static void onEncodeFinishedFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, int paramInt, long paramLong1, long paramLong2)
  {
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null) {
      paramWeakReference.onEncodeFinished(paramInt, paramLong1, paramLong2);
    }
  }
  
  private static void postEventFromNative(WeakReference<TXCSWVideoEncoder> paramWeakReference, byte[] paramArrayOfByte, int paramInt1, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6, int paramInt2)
  {
    paramWeakReference = (TXCSWVideoEncoder)paramWeakReference.get();
    if (paramWeakReference != null)
    {
      TXSNALPacket localTXSNALPacket = new TXSNALPacket();
      localTXSNALPacket.nalData = paramArrayOfByte;
      localTXSNALPacket.nalType = paramInt1;
      localTXSNALPacket.gopIndex = paramLong1;
      localTXSNALPacket.gopFrameIndex = paramLong2;
      localTXSNALPacket.frameIndex = paramLong3;
      localTXSNALPacket.refFremeIndex = paramLong4;
      localTXSNALPacket.pts = paramLong5;
      localTXSNALPacket.dts = paramLong6;
      paramWeakReference.callDelegate(localTXSNALPacket, paramInt2);
    }
  }
  
  private long pushVideoFrameInternal(int paramInt1, int paramInt2, int paramInt3, long paramLong, boolean paramBoolean)
  {
    Object localObject2 = this.mResizeFilter;
    h localh = this.mRawFrameFilter;
    if (this.mGLContextExternal != null)
    {
      this.mInputWidth = paramInt2;
      this.mInputHeight = paramInt3;
      Object localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new h();
        this.mResizeFilter = ((h)localObject1);
        ((h)localObject1).a();
        ((h)localObject1).a(true);
      }
      ((h)localObject1).a(this.mOutputWidth, this.mOutputHeight);
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      if (localObject1 != null)
      {
        int k = (720 - this.mRotation) % 360;
        int i;
        if ((k != 90) && (k != 270)) {
          i = this.mOutputWidth;
        } else {
          i = this.mOutputHeight;
        }
        int j;
        if ((k != 90) && (k != 270)) {
          j = this.mOutputHeight;
        } else {
          j = this.mOutputWidth;
        }
        ((h)localObject1).a(paramInt2, paramInt3, k, null, i / j, this.mEnableXMirror, false);
        ((h)localObject1).b(paramInt1);
      }
      if (localObject1 != null) {
        paramInt1 = ((h)localObject1).l();
      }
      localObject2 = new int[1];
      this.mPTS = paramLong;
      localObject1 = localh;
      if (localh == null)
      {
        TXCLog.i(TAG, "pushVideoFrameInternal->create mRawFrameFilter");
        localObject1 = new o(1);
        this.mRawFrameFilter = ((h)localObject1);
        ((h)localObject1).a(true);
        if (!((h)localObject1).a())
        {
          TXCLog.i(TAG, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
          this.mRawFrameFilter = null;
          return 10000004L;
        }
        ((h)localObject1).a(this.mOutputWidth, this.mOutputHeight);
        ((h)localObject1).a(new TXCSWVideoEncoder.1(this, paramBoolean, paramInt1));
      }
      if (localObject1 == null) {
        return 10000004L;
      }
      GLES20.glViewport(0, 0, this.mOutputWidth, this.mOutputHeight);
      ((h)localObject1).b(paramInt1);
      paramInt1 = localObject2[0];
      if (paramInt1 != 0) {
        callDelegate(paramInt1);
      }
    }
    return 0L;
  }
  
  public void enableNearestRPS(int paramInt)
  {
    try
    {
      nativeEnableNearestRPS(this.mNativeEncoder, paramInt);
      return;
    }
    finally {}
  }
  
  public long getRealBitrate()
  {
    try
    {
      long l = nativegetRealBitrate(this.mNativeEncoder);
      return l;
    }
    finally {}
  }
  
  public double getRealFPS()
  {
    try
    {
      double d = nativeGetRealFPS(this.mNativeEncoder);
      return d;
    }
    finally {}
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, false);
  }
  
  public long pushVideoFrameAsync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return pushVideoFrameInternal(paramInt1, paramInt2, paramInt3, paramLong, true);
  }
  
  public void restartIDR()
  {
    try
    {
      nativeRestartIDR(this.mNativeEncoder);
      return;
    }
    finally {}
  }
  
  public void setBitrate(int paramInt)
  {
    this.mBitrate = paramInt;
    try
    {
      nativeSetBitrate(this.mNativeEncoder, paramInt);
      return;
    }
    finally {}
  }
  
  public void setBitrateFromQos(int paramInt1, int paramInt2)
  {
    this.mBitrate = paramInt1;
    try
    {
      nativeSetBitrateFromQos(this.mNativeEncoder, paramInt1, paramInt2);
      return;
    }
    finally {}
  }
  
  public void setEncodeIdrFpsFromQos(int paramInt)
  {
    try
    {
      nativeSetEncodeIdrFpsFromQos(this.mNativeEncoder, paramInt);
      return;
    }
    finally {}
  }
  
  public void setFPS(int paramInt)
  {
    try
    {
      nativeSetFPS(this.mNativeEncoder, paramInt);
      return;
    }
    finally {}
  }
  
  public void setID(String paramString)
  {
    super.setID(paramString);
    try
    {
      nativeSetID(this.mNativeEncoder, paramString);
      return;
    }
    finally {}
  }
  
  public void setRPSRefBitmap(int paramInt1, int paramInt2, long paramLong)
  {
    try
    {
      nativeSetRPSRefBitmap(this.mNativeEncoder, paramInt1, paramInt2, paramLong);
      return;
    }
    finally {}
  }
  
  public void signalEOSAndFlush()
  {
    try
    {
      nativeSignalEOSAndFlush(this.mNativeEncoder);
      return;
    }
    finally {}
  }
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    super.start(paramTXSVideoEncoderParam);
    int i = (paramTXSVideoEncoderParam.width + 7) / 8 * 8;
    int j = (paramTXSVideoEncoderParam.height + 1) / 2 * 2;
    if ((i != paramTXSVideoEncoderParam.width) || (j != paramTXSVideoEncoderParam.height))
    {
      TXCLog.w(TAG, "Encode Resolution not supportted, transforming...");
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramTXSVideoEncoderParam.width);
      localStringBuilder.append("x");
      localStringBuilder.append(paramTXSVideoEncoderParam.height);
      localStringBuilder.append("-> ");
      localStringBuilder.append(i);
      localStringBuilder.append("x");
      localStringBuilder.append(j);
      TXCLog.w(str, localStringBuilder.toString());
    }
    paramTXSVideoEncoderParam.width = i;
    paramTXSVideoEncoderParam.height = j;
    this.mOutputWidth = i;
    this.mOutputHeight = j;
    this.mInputWidth = i;
    this.mInputHeight = j;
    this.mRawFrameFilter = null;
    this.mResizeFilter = null;
    try
    {
      this.mNativeEncoder = nativeInit(new WeakReference(this));
      nativeSetBitrate(this.mNativeEncoder, this.mBitrate);
      nativeSetID(this.mNativeEncoder, getID());
      nativeStart(this.mNativeEncoder, paramTXSVideoEncoderParam);
      return 0;
    }
    finally {}
  }
  
  public void stop()
  {
    Object localObject1 = TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stop->enter with mRawFrameFilter:");
    localStringBuilder.append(this.mRawFrameFilter);
    TXCLog.i((String)localObject1, localStringBuilder.toString());
    this.mGLContextExternal = null;
    try
    {
      long l = this.mNativeEncoder;
      this.mNativeEncoder = 0L;
      nativeStop(l);
      nativeRelease(l);
      localObject1 = this.mRawFrameFilter;
      if (localObject1 != null)
      {
        ((h)localObject1).d();
        this.mRawFrameFilter = null;
      }
      localObject1 = this.mResizeFilter;
      if (localObject1 != null)
      {
        ((h)localObject1).d();
        this.mResizeFilter = null;
      }
      super.stop();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.TXCSWVideoEncoder
 * JD-Core Version:    0.7.0.1
 */