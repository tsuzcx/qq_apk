package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.concurrent.ConcurrentHashMap;

class UIUtils$URLDrawableMonitor
{
  public static ConcurrentHashMap<UIUtils.DrawableListenerHolder, Boolean> a = new ConcurrentHashMap();
  private static volatile URLDrawableMonitor b;
  
  public static URLDrawableMonitor a()
  {
    if (b == null) {
      try
      {
        if (b == null) {
          b = new URLDrawableMonitor();
        }
      }
      finally {}
    }
    return b;
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new UIUtils.DrawableListenerHolder(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    a.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull UIUtils.DrawableListenerHolder paramDrawableListenerHolder)
  {
    boolean bool = a.containsKey(paramDrawableListenerHolder);
    SLog.a("Q.qqstory.UIViewUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool)
    {
      Throwable localThrowable = StoryDebugUtils.StoryExceptionCallback.a(HardCodeUtil.a(2131913113), null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Story.UIViewUtils.monitor ");
      localStringBuilder.append(paramDrawableListenerHolder.toString());
      CaughtExceptionReport.a(localThrowable, localStringBuilder.toString());
    }
    paramDrawableListenerHolder.a.setDownloadListener(null);
    paramDrawableListenerHolder.a.setURLDrawableListener(null);
    a.remove(paramDrawableListenerHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.URLDrawableMonitor
 * JD-Core Version:    0.7.0.1
 */