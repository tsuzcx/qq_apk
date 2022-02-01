package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.app.ActivityManager;
import android.app.Application;
import android.graphics.Bitmap;
import android.util.LruCache;
import com.tencent.qcircle.application.QCircleApplication;

public class TextCellLayoutCache
{
  private static final Object a = new Object();
  private static volatile LruCache<Integer, Bitmap> b = null;
  
  public static TextCellLayoutCache a()
  {
    return TextCellLayoutCache.SingletonHolder.a();
  }
  
  public LruCache<Integer, Bitmap> b()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null)
        {
          int j = ((ActivityManager)QCircleApplication.APP.getSystemService("activity")).getMemoryClass() * 131072;
          int i = j;
          if (j > 52428800) {
            i = 52428800;
          }
          b = new TextCellLayoutCache.1(this, i);
        }
      }
    }
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.TextCellLayoutCache
 * JD-Core Version:    0.7.0.1
 */