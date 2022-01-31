package com.tencent.mobileqq.app.soso;

import aatd;
import aate;
import aatf;
import aath;
import aati;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import tencent.gdt.qq_ad_get.QQAdGet.DeviceInfo;

final class SosoInterface$7
  implements Runnable
{
  public void run()
  {
    aath.a().a(BaseApplication.getContext(), new aati());
    Object localObject = new aate();
    ((aate)localObject).a = "8b5c3a";
    localObject = aatd.a(BaseApplication.getContext(), (aate)localObject);
    if (localObject != null) {
      localObject = ((aatf)localObject).a;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.7
 * JD-Core Version:    0.7.0.1
 */