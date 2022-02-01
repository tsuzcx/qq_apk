package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import android.support.v4.util.MQLruCache;
import java.util.concurrent.ConcurrentHashMap;

public class GlobalImageCache
{
  public static MQLruCache<String, Object> a;
  public static ConcurrentHashMap<String, Bitmap> b;
  public static int c;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.GlobalImageCache
 * JD-Core Version:    0.7.0.1
 */