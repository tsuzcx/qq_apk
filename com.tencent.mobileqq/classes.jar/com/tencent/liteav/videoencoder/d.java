package com.tencent.liteav.videoencoder;

import android.media.MediaFormat;
import com.tencent.liteav.basic.c.h;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import org.json.JSONArray;

public class d
  extends a
{
  protected boolean mEnableXMirror = false;
  protected JSONArray mEncFmt = null;
  protected h mEncodeFilter;
  private boolean mEncodeFirstGOP = false;
  protected Object mGLContextExternal = null;
  protected boolean mInit;
  protected h mInputFilter;
  protected int mInputHeight = 0;
  protected int mInputTextureID = -1;
  protected int mInputWidth = 0;
  protected e mListener = null;
  protected int mOutputHeight = 0;
  protected int mOutputWidth = 0;
  protected int mRotation = 0;
  protected int mStreamType = 2;
  private long mVideoGOPEncode = 0L;
  
  protected void callDelegate(int paramInt)
  {
    callDelegate(new TXSNALPacket(), paramInt);
  }
  
  protected void callDelegate(MediaFormat paramMediaFormat)
  {
    e locale = this.mListener;
    if (locale != null) {
      locale.a(paramMediaFormat);
    }
  }
  
  protected void callDelegate(TXSNALPacket paramTXSNALPacket, int paramInt)
  {
    e locale = this.mListener;
    if (locale != null)
    {
      paramTXSNALPacket.streamType = this.mStreamType;
      locale.a(paramTXSNALPacket, paramInt);
      if (paramTXSNALPacket.nalType == 0)
      {
        long l = this.mVideoGOPEncode;
        if (l != 0L)
        {
          this.mEncodeFirstGOP = true;
          setStatusValue(4006, Long.valueOf(l));
        }
        this.mVideoGOPEncode = 1L;
        return;
      }
      this.mVideoGOPEncode += 1L;
      if (!this.mEncodeFirstGOP) {
        setStatusValue(4006, Long.valueOf(this.mVideoGOPEncode));
      }
    }
  }
  
  public void enableNearestRPS(int paramInt) {}
  
  public int getEncodeCost()
  {
    return 0;
  }
  
  public long getRealBitrate()
  {
    return 0L;
  }
  
  public double getRealFPS()
  {
    return 0.0D;
  }
  
  public int getVideoHeight()
  {
    return this.mOutputHeight;
  }
  
  public int getVideoWidth()
  {
    return this.mOutputWidth;
  }
  
  public boolean isHevcEncoder()
  {
    return false;
  }
  
  protected void onEncodeFinished(int paramInt, long paramLong1, long paramLong2)
  {
    e locale = this.mListener;
    if (locale != null) {
      locale.a(paramInt, paramLong1, paramLong2);
    }
  }
  
  public long pushVideoFrame(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public long pushVideoFrameAsync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public long pushVideoFrameSync(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    return 10000002L;
  }
  
  public void restartIDR() {}
  
  public void setBitrate(int paramInt) {}
  
  public void setBitrateFromQos(int paramInt1, int paramInt2) {}
  
  public void setEncodeIdrFpsFromQos(int paramInt) {}
  
  public void setFPS(int paramInt) {}
  
  public void setListener(e parame)
  {
    this.mListener = parame;
  }
  
  public void setRPSRefBitmap(int paramInt1, int paramInt2, long paramLong) {}
  
  public void setRotation(int paramInt)
  {
    this.mRotation = paramInt;
  }
  
  public void setXMirror(boolean paramBoolean)
  {
    this.mEnableXMirror = paramBoolean;
  }
  
  public void signalEOSAndFlush() {}
  
  public int start(TXSVideoEncoderParam paramTXSVideoEncoderParam)
  {
    if (paramTXSVideoEncoderParam != null)
    {
      this.mOutputWidth = paramTXSVideoEncoderParam.width;
      this.mOutputHeight = paramTXSVideoEncoderParam.height;
      this.mInputWidth = paramTXSVideoEncoderParam.width;
      this.mInputHeight = paramTXSVideoEncoderParam.height;
      this.mGLContextExternal = paramTXSVideoEncoderParam.glContext;
      this.mStreamType = paramTXSVideoEncoderParam.streamType;
      this.mEncFmt = paramTXSVideoEncoderParam.encFmt;
    }
    this.mVideoGOPEncode = 0L;
    this.mEncodeFirstGOP = false;
    return 10000002;
  }
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videoencoder.d
 * JD-Core Version:    0.7.0.1
 */