package com.tencent.liteav.muxer.jni;

import com.tencent.liteav.basic.log.TXCLog;
import java.nio.ByteBuffer;

public class TXSWMuxerJNI
{
  private long a = -1L;
  private volatile boolean b = true;
  private volatile boolean c;
  
  private byte[] b(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (paramByteBuffer == null) {
      return null;
    }
    byte[] arrayOfByte = new byte[paramInt];
    paramByteBuffer.get(arrayOfByte);
    return arrayOfByte;
  }
  
  private native long init();
  
  private native void release(long paramLong);
  
  private native void setAVParams(long paramLong, TXSWMuxerJNI.AVOptions paramAVOptions);
  
  private native void setAudioCSD(long paramLong, byte[] paramArrayOfByte);
  
  private native void setDstPath(long paramLong, String paramString);
  
  private native void setVideoCSD(long paramLong, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);
  
  private native int start(long paramLong);
  
  private native int stop(long paramLong);
  
  private native int writeFrame(long paramLong1, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong2);
  
  public int a()
  {
    if (this.b)
    {
      int i = start(this.a);
      if (i == 0)
      {
        this.c = true;
        return i;
      }
      TXCLog.e("TXSWMuxerJNI", "Start Muxer Error!!!");
      return i;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    return -1;
  }
  
  public int a(ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong)
  {
    if (this.b)
    {
      if (this.c)
      {
        paramInt1 = writeFrame(this.a, b(paramByteBuffer, paramInt3), paramInt1, paramInt2, paramInt3, paramInt4, paramLong);
        if (paramInt1 != 0) {
          TXCLog.e("TXSWMuxerJNI", "Muxer write frame error!");
        }
        return paramInt1;
      }
      TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
      return -1;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    return -1;
  }
  
  public void a(TXSWMuxerJNI.AVOptions paramAVOptions)
  {
    if (this.b)
    {
      setAVParams(this.a, paramAVOptions);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
  }
  
  public void a(String paramString)
  {
    if (this.b)
    {
      setDstPath(this.a, paramString);
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
  }
  
  public void a(ByteBuffer paramByteBuffer, int paramInt)
  {
    if (this.b)
    {
      setAudioCSD(this.a, b(paramByteBuffer, paramInt));
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
  }
  
  public void a(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2)
  {
    if (this.b)
    {
      setVideoCSD(this.a, b(paramByteBuffer1, paramInt1), b(paramByteBuffer2, paramInt2));
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
  }
  
  public int b()
  {
    if (this.b)
    {
      if (this.c)
      {
        this.c = false;
        int i = stop(this.a);
        if (i != 0) {
          TXCLog.e("TXSWMuxerJNI", "Stop Muxer Error!!!");
        }
        return i;
      }
      TXCLog.e("TXSWMuxerJNI", "Muxer isn't start yet!");
      return -1;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
    return -1;
  }
  
  public void c()
  {
    if (this.b)
    {
      release(this.a);
      this.b = false;
      this.c = false;
      return;
    }
    TXCLog.e("TXSWMuxerJNI", "Muxer isn't init yet!");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.muxer.jni.TXSWMuxerJNI
 * JD-Core Version:    0.7.0.1
 */