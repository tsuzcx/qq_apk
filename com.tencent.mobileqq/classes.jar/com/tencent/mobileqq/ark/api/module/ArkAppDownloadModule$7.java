package com.tencent.mobileqq.ark.api.module;

import android.content.Context;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;

class ArkAppDownloadModule$7
  implements INetInfoHandler
{
  ArkAppDownloadModule$7(ArkAppDownloadModule paramArkAppDownloadModule) {}
  
  public void onNetMobile2None()
  {
    QLog.e("ark.download.module", 1, "onNetMobile2None");
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    QLog.e("ark.download.module", 1, new Object[] { "onNetMobile2Wifi", paramString });
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    QLog.e("ark.download.module", 1, new Object[] { "ark.dctrl.onNetNone2Mobile", paramString });
    paramString = BaseActivity.sTopActivity;
    if ((ArkAppDownloadModule.i(this.a)) && (!ArkAppDownloadModule.j(this.a)) && (paramString != null))
    {
      paramString = paramString.getString(2131887055);
      if (ArkAppDownloadModule.a(this.a, paramString)) {
        ArkAppDownloadModule.b(this.a, true);
      }
    }
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    QLog.e("ark.download.module", 1, new Object[] { "onNetNone2Wifi", paramString });
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    QLog.e("ark.download.module", 1, new Object[] { "onNetWifi2Mobile", paramString });
  }
  
  public void onNetWifi2None()
  {
    QLog.e("ark.download.module", 1, "onNetWifi2None");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppDownloadModule.7
 * JD-Core Version:    0.7.0.1
 */