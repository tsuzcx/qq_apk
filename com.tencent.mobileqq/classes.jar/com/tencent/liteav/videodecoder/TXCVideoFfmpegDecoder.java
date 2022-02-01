package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class TXCVideoFfmpegDecoder
  implements b
{
  private boolean mFirstDec;
  private g mListener;
  private long mNativeDecoder;
  private long mNativeNotify;
  private ByteBuffer mPps;
  private byte[] mRawData;
  private ByteBuffer mSps;
  private int mVideoHeight;
  private int mVideoWidth;
  
  static
  {
    f.f();
    nativeClassInit();
  }
  
  private static native void nativeClassInit();
  
  private native boolean nativeDecode(byte[] paramArrayOfByte, long paramLong1, long paramLong2, long paramLong3);
  
  private native void nativeInit(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, boolean paramBoolean);
  
  private native void nativeLoadRawData(byte[] paramArrayOfByte, long paramLong, int paramInt);
  
  private native void nativeRelease();
  
  private static void postEventFromNative(WeakReference<TXCVideoFfmpegDecoder> paramWeakReference, long paramLong1, int paramInt1, int paramInt2, long paramLong2, long paramLong3, int paramInt3) {}
  
  public int GetDecodeCost()
  {
    return 0;
  }
  
  public int config(Surface paramSurface)
  {
    return 0;
  }
  
  public void config(JSONArray paramJSONArray) {}
  
  public void decode(TXSNALPacket paramTXSNALPacket)
  {
    if (this.mFirstDec)
    {
      Object localObject = this.mSps;
      if ((localObject != null) && (this.mPps != null))
      {
        localObject = ((ByteBuffer)localObject).array();
        byte[] arrayOfByte1 = this.mPps.array();
        byte[] arrayOfByte2 = new byte[localObject.length + arrayOfByte1.length];
        System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
        if (!nativeDecode(arrayOfByte2, paramTXSNALPacket.pts - 1L, paramTXSNALPacket.dts - 1L, paramTXSNALPacket.rotation))
        {
          localObject = this.mListener;
          if (localObject != null) {
            ((g)localObject).onDecodeFailed(-2);
          }
        }
      }
      this.mFirstDec = false;
    }
    if (!nativeDecode(paramTXSNALPacket.nalData, paramTXSNALPacket.pts, paramTXSNALPacket.dts, paramTXSNALPacket.rotation))
    {
      paramTXSNALPacket = this.mListener;
      if (paramTXSNALPacket != null) {
        paramTXSNALPacket.onDecodeFailed(-2);
      }
    }
  }
  
  public void enableLimitDecCache(boolean paramBoolean) {}
  
  public boolean isHevc()
  {
    return false;
  }
  
  public void loadNativeData(byte[] paramArrayOfByte, long paramLong, int paramInt)
  {
    nativeLoadRawData(paramArrayOfByte, paramLong, paramInt);
  }
  
  public void setListener(g paramg)
  {
    this.mListener = paramg;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference) {}
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mSps = paramByteBuffer1;
    this.mPps = paramByteBuffer2;
    this.mFirstDec = true;
    this.mVideoWidth = 0;
    this.mVideoHeight = 0;
    nativeInit(new WeakReference(this), paramBoolean1);
    return 0;
  }
  
  public void stop()
  {
    nativeRelease();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.TXCVideoFfmpegDecoder
 * JD-Core Version:    0.7.0.1
 */