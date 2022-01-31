package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.plugin.QZonePluginUtils;
import mqq.app.AppRuntime;

public class QzoneLiveMainRuntime
  extends ToolRuntimeBase
{
  private static String a = "QzoneLiveMainRuntime";
  
  public String getModuleId()
  {
    return "qzonelive";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i(a, 1, "QzoneLiveMainRuntime onCreate");
    super.onCreate(paramBundle);
  }
  
  protected AppRuntime onGetSubRuntime(String paramString)
  {
    AppRuntime localAppRuntime = null;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "QzoneLiveMainRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    if (paramString.equals(QZonePluginUtils.a())) {
      localAppRuntime = QZoneHelper.b(BaseApplicationImpl.getApplication());
    }
    while (!paramString.equals("qzone_vertical_video_plugin.apk")) {
      return localAppRuntime;
    }
    return QZoneHelper.c(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.QzoneLiveMainRuntime
 * JD-Core Version:    0.7.0.1
 */