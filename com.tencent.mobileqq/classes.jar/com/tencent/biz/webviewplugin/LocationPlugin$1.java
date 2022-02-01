package com.tencent.biz.webviewplugin;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

class LocationPlugin$1
{
  LocationPlugin$1(LocationPlugin paramLocationPlugin, String paramString) {}
  
  @QQPermissionDenied(1)
  public void denied()
  {
    this.b.callJs(this.a, new String[] { "-3", "{}" });
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(new LocationPlugin.1.1(this, "webview"));
    if (QLog.isColorLevel()) {
      QLog.d("LocationPlugin", 2, "SosoInterface.startLocation");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.LocationPlugin.1
 * JD-Core Version:    0.7.0.1
 */