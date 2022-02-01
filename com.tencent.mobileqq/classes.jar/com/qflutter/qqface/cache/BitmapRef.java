package com.qflutter.qqface.cache;

import android.graphics.Bitmap;
import android.util.Log;
import java.nio.ByteBuffer;

public class BitmapRef
{
  public Bitmap bitmap;
  public ByteBuffer byteBuffer;
  public byte[] bytes;
  private volatile int refCount = 0;
  
  public BitmapRef(Bitmap paramBitmap)
  {
    this.bitmap = paramBitmap;
  }
  
  public BitmapRef(ByteBuffer paramByteBuffer)
  {
    this.byteBuffer = paramByteBuffer;
  }
  
  public BitmapRef(byte[] paramArrayOfByte)
  {
    this.bytes = paramArrayOfByte;
  }
  
  public boolean canRelease()
  {
    return this.refCount == 0;
  }
  
  public void decRef()
  {
    try
    {
      this.refCount -= 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void incRef()
  {
    try
    {
      this.refCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void release()
  {
    Log.d("QQFaceLoader", "release");
    this.bitmap = null;
    this.bytes = null;
    this.byteBuffer = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.qflutter.qqface.cache.BitmapRef
 * JD-Core Version:    0.7.0.1
 */