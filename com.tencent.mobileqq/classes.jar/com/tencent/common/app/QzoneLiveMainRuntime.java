package com.tencent.common.app;

import android.os.Bundle;
import bgxy;
import bhjq;
import com.tencent.qphone.base.util.QLog;
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
  
  public AppRuntime onGetSubRuntime(String paramString)
  {
    AppRuntime localAppRuntime = null;
    if (QLog.isColorLevel()) {
      QLog.i(a, 2, "QzoneLiveMainRuntime.onGetSubRuntime() moduleId " + paramString);
    }
    if (paramString.equals(bhjq.a())) {
      localAppRuntime = bgxy.b(BaseApplicationImpl.getApplication());
    }
    while (!paramString.equals("qzone_weishi_feeds_plugin.apk")) {
      return localAppRuntime;
    }
    return bgxy.d(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.QzoneLiveMainRuntime
 * JD-Core Version:    0.7.0.1
 */