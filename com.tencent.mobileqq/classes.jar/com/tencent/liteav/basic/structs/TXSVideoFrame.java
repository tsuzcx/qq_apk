package com.tencent.liteav.basic.structs;

import android.opengl.GLES20;
import java.nio.ByteBuffer;

public class TXSVideoFrame
{
  public ByteBuffer buffer;
  public byte[] data;
  public Object eglContext;
  public int frameType;
  public int height;
  public long pts;
  public int rotation;
  public int textureId;
  public int width;
  
  private native void nativeLoadArrayFromBuffer(byte[] paramArrayOfByte, int paramInt);
  
  private native void nativeLoadArrayFromGL(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  private native void nativeLoadBufferFromGL(int paramInt1, int paramInt2);
  
  private native void nativeLoadNV21BufferFromI420Buffer(int paramInt1, int paramInt2);
  
  public byte[] I420toNV21(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = paramArrayOfByte2;
    if (paramArrayOfByte2 == null) {
      arrayOfByte = new byte[paramArrayOfByte1.length];
    }
    int i = paramInt1 * paramInt2;
    int j = i / 4 + i;
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, i);
    paramInt1 = i;
    paramInt2 = j;
    while (i < j)
    {
      arrayOfByte[paramInt1] = paramArrayOfByte1[paramInt2];
      arrayOfByte[(paramInt1 + 1)] = paramArrayOfByte1[i];
      i += 1;
      paramInt2 += 1;
      paramInt1 += 2;
    }
    return arrayOfByte;
  }
  
  public TXSVideoFrame clone()
  {
    TXSVideoFrame localTXSVideoFrame = new TXSVideoFrame();
    localTXSVideoFrame.width = this.width;
    localTXSVideoFrame.height = this.height;
    localTXSVideoFrame.frameType = this.frameType;
    localTXSVideoFrame.rotation = this.rotation;
    localTXSVideoFrame.pts = this.pts;
    localTXSVideoFrame.data = this.data;
    localTXSVideoFrame.textureId = this.textureId;
    localTXSVideoFrame.eglContext = this.eglContext;
    localTXSVideoFrame.nativeClone(this.buffer);
    return localTXSVideoFrame;
  }
  
  public void finalize()
  {
    release();
    super.finalize();
  }
  
  public void loadNV21BufferFromI420Buffer()
  {
    nativeLoadNV21BufferFromI420Buffer(this.width, this.height);
  }
  
  public void loadYUVArray(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null)
    {
      int i = paramArrayOfByte.length;
      int j = this.width;
      int k = this.height;
      if (i < j * k * 3 / 2) {
        return;
      }
      if (this.buffer == null)
      {
        GLES20.glReadPixels(0, 0, j, k * 3 / 8, 6408, 5121, ByteBuffer.wrap(paramArrayOfByte));
        return;
      }
      nativeLoadArrayFromBuffer(paramArrayOfByte, j * k * 3 / 2);
    }
  }
  
  public void loadYUVBufferFromGL()
  {
    nativeLoadBufferFromGL(this.width, this.height);
  }
  
  public native void nativeClone(ByteBuffer paramByteBuffer);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.basic.structs.TXSVideoFrame
 * JD-Core Version:    0.7.0.1
 */