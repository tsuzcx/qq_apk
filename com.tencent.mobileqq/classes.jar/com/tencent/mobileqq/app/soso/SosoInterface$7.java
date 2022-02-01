package com.tencent.mobileqq.app.soso;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import aopa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.map.geolocation.TencentLocationRequest;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

final class SosoInterface$7
  implements Runnable
{
  SosoInterface$7(aopa paramaopa) {}
  
  public void run()
  {
    Object localObject = SosoInterface.a(this.a.maxCacheInterval, this.a.goonListener, this.a.level, this.a.reqLocation);
    if (localObject != null) {
      if (this.a.uiThread)
      {
        SosoInterface.a(this.a, 0, (SosoInterface.SosoLbsInfo)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 2, "startLocation() lis=" + this.a.tag + " use cache and callback now");
        }
        SosoInterface.a(true, this.a.reqLocation, 0L, 0, this.a.tag, "ERROR_OK", this.a.askGPS, this.a.level, true);
      }
    }
    label312:
    label584:
    label594:
    do
    {
      return;
      this.a.onLocationFinish(0, (SosoInterface.SosoLbsInfo)localObject);
      break;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("startLocation() reqLoc=").append(this.a.reqLocation).append(" askGPS=").append(this.a.askGPS).append(" level=").append(this.a.level).append(" caller=").append(this.a.tag).append(" ui=").append(this.a.uiThread).append(" goon=").append(this.a.goonListener);
        if (SosoInterface.a().get() == 0)
        {
          localObject = " do startLocation";
          QLog.d("SOSO.LBS", 2, (String)localObject);
        }
      }
      else
      {
        SosoInterface.c(this.a);
        if (SosoInterface.a().get() != 0) {
          continue;
        }
        if (this.a != SosoInterface.e()) {
          break label584;
        }
        SosoInterface.a().set(1);
        this.a.sTime = SystemClock.elapsedRealtime();
        localObject = TencentLocationRequest.create();
        ((TencentLocationRequest)localObject).setInterval(SosoInterface.a);
        ((TencentLocationRequest)localObject).setRequestLevel(this.a.level);
        ((TencentLocationRequest)localObject).setAllowCache(true);
        ((TencentLocationRequest)localObject).setAllowGPS(this.a.askGPS);
        ((TencentLocationRequest)localObject).setCheckInterval(30000L);
        if (this.a.reqLocation) {
          break label594;
        }
      }
      for (boolean bool = true;; bool = false)
      {
        TencentExtraKeys.setRequestRawData((TencentLocationRequest)localObject, bool);
        ((TencentLocationRequest)localObject).getExtras().putInt("qq_level", this.a.level);
        ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_reqLocation", this.a.reqLocation);
        ((TencentLocationRequest)localObject).getExtras().putString("qq_caller", this.a.tag);
        ((TencentLocationRequest)localObject).getExtras().putBoolean("qq_goonListener", this.a.goonListener);
        SosoInterface.b(0);
        SosoInterface.a(SystemClock.elapsedRealtime());
        SosoInterface.c(0);
        aopa.access$2002(this.a, true);
        if (SosoInterface.a() == null) {
          SosoInterface.a(TencentLocationManager.getInstance(BaseApplicationImpl.getContext()));
        }
        if (SosoInterface.a().hasMessages(1001)) {
          SosoInterface.a().removeMessages(1001);
        }
        SosoInterface.a().sendEmptyMessageDelayed(1001, 35000L);
        SosoInterface.d(0);
        int i = SosoInterface.a().requestLocationUpdates((TencentLocationRequest)localObject, SosoInterface.a(), ThreadManager.getSubThreadLooper());
        QLog.i("SOSO.LBS", 1, "location manager requestLocationUpdates result is: " + i);
        return;
        localObject = " waitting...";
        break;
        SosoInterface.a().set(2);
        break label312;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SOSO.LBS", 2, "status != REQ_STOP");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.7
 * JD-Core Version:    0.7.0.1
 */