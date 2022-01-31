package com.qflutter.qflutter_skin_engine;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

public class CacheItem
{
  public Bitmap bitmap;
  public ByteBuffer byteBuffer;
  public byte[] bytes;
  private int ref_count = 0;
  
  public void cache(Object paramObject)
  {
    if ((paramObject instanceof Bitmap)) {
      this.bitmap = ((Bitmap)paramObject);
    }
    do
    {
      return;
      if ((paramObject instanceof ByteBuffer))
      {
        this.byteBuffer = ((ByteBuffer)paramObject);
        return;
      }
    } while (!(paramObject instanceof byte[]));
    this.bytes = ((byte[])paramObject);
  }
  
  public boolean decrement()
  {
    if (this.ref_count > 0) {
      this.ref_count -= 1;
    }
    return this.ref_count <= 0;
  }
  
  public void increment()
  {
    this.ref_count += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.qflutter.qflutter_skin_engine.CacheItem
 * JD-Core Version:    0.7.0.1
 */