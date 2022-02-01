package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
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
  
  protected AppRuntime onGetSubRuntime(String paramString)
  {
    if (QLog.isColorLevel())
    {
      String str = TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QzoneMainRuntime.onGetSubRuntime() moduleId ");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (paramString.equals("qzone_plugin.apk")) {
      return QZoneHelper.createQZoneAppInterface(BaseApplicationImpl.getApplication(), MobileQQ.processName);
    }
    if (paramString.equals("qzone_vertical_video_plugin.apk")) {
      return QZoneHelper.createVerticalVideoAppInterface(BaseApplicationImpl.getApplication());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.QzoneMainRuntime
 * JD-Core Version:    0.7.0.1
 */