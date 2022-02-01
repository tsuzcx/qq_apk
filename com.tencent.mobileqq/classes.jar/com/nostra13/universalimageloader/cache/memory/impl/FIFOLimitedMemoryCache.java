package com.nostra13.universalimageloader.cache.memory.impl;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.cache.memory.LimitedMemoryCache;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FIFOLimitedMemoryCache
  extends LimitedMemoryCache
{
  private final List<Bitmap> queue = Collections.synchronizedList(new LinkedList());
  
  public FIFOLimitedMemoryCache(int paramInt)
  {
    super(paramInt);
  }
  
  public void clear()
  {
    this.queue.clear();
    super.clear();
  }
  
  protected Reference<Bitmap> createReference(Bitmap paramBitmap)
  {
    return new WeakReference(paramBitmap);
  }
  
  protected int getSize(Bitmap paramBitmap)
  {
    return paramBitmap.getRowBytes() * paramBitmap.getHeight();
  }
  
  public boolean put(String paramString, Bitmap paramBitmap)
  {
    if (super.put(paramString, paramBitmap))
    {
      this.queue.add(paramBitmap);
      return true;
    }
    return false;
  }
  
  public Bitmap remove(String paramString)
  {
    Bitmap localBitmap = super.get(paramString);
    if (localBitmap != null) {
      this.queue.remove(localBitmap);
    }
    return super.remove(paramString);
  }
  
  protected Bitmap removeNext()
  {
    return (Bitmap)this.queue.remove(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.memory.impl.FIFOLimitedMemoryCache
 * JD-Core Version:    0.7.0.1
 */