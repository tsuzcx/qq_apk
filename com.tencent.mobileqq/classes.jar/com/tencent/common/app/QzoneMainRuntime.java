package com.tencent.common.app;

import android.os.Bundle;
import bfpr;
import bglx;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class QzoneMainRuntime
  extends ToolRuntimeBase
{
  private static String TAG = "QzoneMainRuntime";
  private static MobileQQ appContext;
  
  public String getModuleId()
  {
    return "qzone";
  }
  
  public void onCreate(Bundle paramBundle)
  {
    QLog.i(TAG, 1, "QzoneMainRuntime onCreate");
    super.onCreate(paramBundle);
    appContext = getApplication();
    getAppRuntime("qzone_plugin.apk");
  }
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    AppRuntime localAppRuntime = null;
    if (QLog.isColorLevel()) {
      QLog.i(TAG, 2, "QzoneMainRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    if (paramString.equals("qzone_plugin.apk")) {
      localAppRuntime = bfpr.a(BaseApplicationImpl.getApplication(), MobileQQ.processName);
    }
    do
    {
      return localAppRuntime;
      if (paramString.equals("qzone_widgetai.apk")) {
        return bglx.a(BaseApplicationImpl.getApplication(), MobileQQ.processName);
      }
    } while (!paramString.equals("qzone_vertical_video_plugin.apk"));
    return bfpr.c(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.QzoneMainRuntime
 * JD-Core Version:    0.7.0.1
 */