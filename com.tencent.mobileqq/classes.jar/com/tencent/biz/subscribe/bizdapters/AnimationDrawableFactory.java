package com.tencent.biz.subscribe.bizdapters;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.AnimationDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class AnimationDrawableFactory
{
  private static volatile AnimationDrawableFactory a;
  private MQLruCache<String, AnimationDrawable> b = new MQLruCache(10);
  
  private Bitmap a(File paramFile)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getBitMapFromFile fileName:");
    localStringBuilder.append(paramFile.getName());
    QLog.i("AnimationDrawableFactory", 2, localStringBuilder.toString());
    if ((paramFile.exists()) && (paramFile.isFile())) {
      return BitmapFactory.decodeFile(paramFile.getAbsolutePath());
    }
    return null;
  }
  
  public static AnimationDrawableFactory a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new AnimationDrawableFactory();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(String paramString)
  {
    MQLruCache localMQLruCache = this.b;
    if ((localMQLruCache != null) && (localMQLruCache.get(paramString) != null)) {
      this.b.remove(paramString);
    }
  }
  
  @Deprecated
  public void a(String paramString, int paramInt, AnimationDrawableFactory.CreateDrawableResultListener paramCreateDrawableResultListener, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("createFromDirectory dirPath=");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" allDuration=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" useCache=");
    localStringBuilder.append(paramBoolean);
    QLog.i("AnimationDrawableFactory", 2, localStringBuilder.toString());
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("AnimationDrawableFactory", 2, "createFromDirectory error dirPath is invalid");
      if (paramCreateDrawableResultListener != null) {
        paramCreateDrawableResultListener.a(false, null);
      }
    }
    RFThreadManager.execute(new AnimationDrawableFactory.1(this, paramBoolean, paramString, paramInt, paramCreateDrawableResultListener), RFThreadManager.Normal);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.bizdapters.AnimationDrawableFactory
 * JD-Core Version:    0.7.0.1
 */