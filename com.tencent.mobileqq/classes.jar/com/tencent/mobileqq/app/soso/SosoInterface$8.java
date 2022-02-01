package com.tencent.mobileqq.app.soso;

import acim;
import acin;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.util.GdtDeviceInfoHelper;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Params;
import com.tencent.gdtad.util.GdtDeviceInfoHelper.Result;
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
    acim.a().a(BaseApplication.getContext(), new acin());
    Object localObject = new GdtDeviceInfoHelper.Params();
    ((GdtDeviceInfoHelper.Params)localObject).businessIdForAidTicketAndTaidTicket = "8b5c3a";
    localObject = GdtDeviceInfoHelper.create(BaseApplication.getContext(), (GdtDeviceInfoHelper.Params)localObject);
    if (localObject != null) {
      localObject = ((GdtDeviceInfoHelper.Result)localObject).deviceInfo;
    }
    for (;;)
    {
      if (localObject != null) {
        SosoInterface.mOaid = ((qq_ad_get.QQAdGet.DeviceInfo)localObject).aid_ticket.get();
      }
      if (!TextUtils.isEmpty(SosoInterface.mOaid))
      {
        if (SosoInterface.access$2600() == null) {
          SosoInterface.access$2602(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
        }
        try
        {
          SosoInterface.access$2600().setDeviceID(new Pair("oaId", SosoInterface.mOaid));
          if (QLog.isColorLevel()) {
            QLog.d("SOSO.LBS", 2, "mLocationManager.setDeviceId（） mOaid = " + SosoInterface.mOaid);
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