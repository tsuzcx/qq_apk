package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.concurrent.ConcurrentHashMap;

class UIUtils$URLDrawableMonitor
{
  private static volatile URLDrawableMonitor a;
  public static ConcurrentHashMap<UIUtils.DrawableListenerHolder, Boolean> a;
  
  static
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  }
  
  public static URLDrawableMonitor a()
  {
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor == null) {
      try
      {
        if (jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor == null) {
          jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor = new URLDrawableMonitor();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor;
  }
  
  public static void a(URLDrawable paramURLDrawable, String paramString)
  {
    paramString = new UIUtils.DrawableListenerHolder(a(), paramURLDrawable, paramString);
    paramURLDrawable.setDownloadListener(paramString);
    paramURLDrawable.setURLDrawableListener(paramString);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Boolean.valueOf(true));
  }
  
  public void a(@NonNull UIUtils.DrawableListenerHolder paramDrawableListenerHolder)
  {
    boolean bool = jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(paramDrawableListenerHolder);
    SLog.a("Q.qqstory.UIViewUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool)
    {
      Throwable localThrowable = StoryDebugUtils.StoryExceptionCallback.a(HardCodeUtil.a(2131715645), null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Story.UIViewUtils.monitor ");
      localStringBuilder.append(paramDrawableListenerHolder.toString());
      CaughtExceptionReport.a(localThrowable, localStringBuilder.toString());
    }
    paramDrawableListenerHolder.a.setDownloadListener(null);
    paramDrawableListenerHolder.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDrawableListenerHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.URLDrawableMonitor
 * JD-Core Version:    0.7.0.1
 */