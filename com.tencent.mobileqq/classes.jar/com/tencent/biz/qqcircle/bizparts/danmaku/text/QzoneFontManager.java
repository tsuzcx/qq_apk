package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.biz.qcircleshadow.lib.QCircleHostQzoneThreadHelper;
import com.tencent.biz.qcircleshadow.lib.QCirclrHostFontHelper;
import com.tencent.biz.qcircleshadow.lib.listener.QCircleTrueTypeResult;
import com.tencent.biz.qqcircle.bizparts.danmaku.model.MultiHashMap;

public class QzoneFontManager
{
  private static Object a = new Object();
  private static volatile QzoneFontManager b;
  private LruCache<Integer, Typeface> c = new LruCache(8);
  private MultiHashMap<Integer, QzoneFontManager.OnFontLoadListener> d = new MultiHashMap();
  private QCircleTrueTypeResult e;
  
  public static QzoneFontManager a()
  {
    if (b == null) {
      synchronized (a)
      {
        if (b == null) {
          b = new QzoneFontManager();
        }
      }
    }
    return b;
  }
  
  private void a(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    QCircleHostQzoneThreadHelper.postNormalThread(new QzoneFontManager.2(this, paramString, paramInt));
  }
  
  public Typeface a(int paramInt, String paramString, QzoneFontManager.OnFontLoadListener paramOnFontLoadListener)
  {
    ??? = (Typeface)this.c.get(Integer.valueOf(paramInt));
    if (??? != null) {
      return ???;
    }
    synchronized (a)
    {
      if (this.d.contains(Integer.valueOf(paramInt), paramOnFontLoadListener)) {
        return null;
      }
      if (this.d.containsKey(Integer.valueOf(paramInt)))
      {
        this.d.add(Integer.valueOf(paramInt), paramOnFontLoadListener);
        return null;
      }
      this.d.add(Integer.valueOf(paramInt), paramOnFontLoadListener);
      if (this.e == null) {
        this.e = new QzoneFontManager.1(this, paramInt);
      }
      a(paramInt, QCirclrHostFontHelper.getTrueTypeFont(paramInt, paramString, null, false, this.e));
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.QzoneFontManager
 * JD-Core Version:    0.7.0.1
 */