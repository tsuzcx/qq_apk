package com.nostra13.universalimageloader.cache.disc;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.utils.IoUtils.CopyListener;
import java.io.File;
import java.io.InputStream;

public abstract interface DiskCache
{
  public abstract void clear();
  
  public abstract void close();
  
  public abstract File get(String paramString);
  
  public abstract File getDirectory();
  
  public abstract boolean remove(String paramString);
  
  public abstract boolean save(String paramString, Bitmap paramBitmap);
  
  public abstract boolean save(String paramString, InputStream paramInputStream, IoUtils.CopyListener paramCopyListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.nostra13.universalimageloader.cache.disc.DiskCache
 * JD-Core Version:    0.7.0.1
 */