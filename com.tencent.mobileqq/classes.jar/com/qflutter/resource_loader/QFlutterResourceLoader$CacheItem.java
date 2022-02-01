package com.qflutter.resource_loader;

import android.graphics.Bitmap;
import java.nio.ByteBuffer;

class QFlutterResourceLoader$CacheItem
{
  public Bitmap bitmap;
  public ByteBuffer byteBuffer;
  public byte[] bytes;
  private int ref_count = 0;
  
  private QFlutterResourceLoader$CacheItem(QFlutterResourceLoader paramQFlutterResourceLoader) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qflutter.resource_loader.QFlutterResourceLoader.CacheItem
 * JD-Core Version:    0.7.0.1
 */