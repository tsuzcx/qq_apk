package com.tencent.common.app;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQzonePatchApi;
import cooperation.qzone.QZoneHelper;
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
    if (QLog.isColorLevel())
    {
      String str = a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QzoneLiveMainRuntime.onGetSubRuntime() moduleId ");
      localStringBuilder.append(paramString);
      QLog.i(str, 2, localStringBuilder.toString());
    }
    if (paramString.equals(((IQzonePatchApi)QRoute.api(IQzonePatchApi.class)).getLoadQZoneLivePluginId())) {
      return QZoneHelper.createQzoneLiveAppInterface(BaseApplicationImpl.getApplication());
    }
    if (paramString.equals("qzone_weishi_feeds_plugin.apk")) {
      return QZoneHelper.createWeishiFeedsAppInterface(BaseApplicationImpl.getApplication());
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.QzoneLiveMainRuntime
 * JD-Core Version:    0.7.0.1
 */