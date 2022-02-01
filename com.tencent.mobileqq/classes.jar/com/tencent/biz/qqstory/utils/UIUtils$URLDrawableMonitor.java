package com.tencent.biz.qqstory.utils;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.CaughtExceptionReport;
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
    if (jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor == null) {
        jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor = new URLDrawableMonitor();
      }
      return jdField_a_of_type_ComTencentBizQqstoryUtilsUIUtils$URLDrawableMonitor;
    }
    finally {}
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
    SLog.a("Q.qqstory.UIUtils", "remove(), contains %b", Boolean.valueOf(bool));
    if (!bool) {
      CaughtExceptionReport.a(StoryDebugUtils.StoryExceptionCallback.a(HardCodeUtil.a(2131715721), null), "Story.UIUtils.monitor " + paramDrawableListenerHolder.toString());
    }
    paramDrawableListenerHolder.a.setDownloadListener(null);
    paramDrawableListenerHolder.a.setURLDrawableListener(null);
    jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramDrawableListenerHolder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.utils.UIUtils.URLDrawableMonitor
 * JD-Core Version:    0.7.0.1
 */