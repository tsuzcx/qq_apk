package com.tencent.mobileqq.app.soso;

import acwb;
import acwc;
import acwd;
import acwf;
import acwg;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

final class SosoInterface$8
  implements Runnable
{
  public void run()
  {
    acwf.a().a(BaseApplication.getContext(), new acwg());
    Object localObject = new acwc();
    ((acwc)localObject).a = "8b5c3a";
    localObject = acwb.a(BaseApplication.getContext(), (acwc)localObject);
    if (localObject != null) {
      localObject = ((acwd)localObject).a;
    }
    for (;;)
    {
      if (localObject != null) {
        SosoInterface.a = ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get();
      }
      if (!TextUtils.isEmpty(SosoInterface.a))
      {
        if (SosoInterface.a() == null) {
          SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
        }
        try
        {
          SosoInterface.a().setDeviceID(new Pair("oaId", SosoInterface.a));
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "mLocationManager.setDeviceId（） mOaid = " + SosoInterface.a);
          }
          return;
          localObject = null;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.d("SOSO.LBS", 1, "setDeviceId（） has exception = " + localException);
          }
        }
      }
    }
    QLog.d("SOSO.LBS", 1, "getOaid（） mOaid is empty ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.8
 * JD-Core Version:    0.7.0.1
 */