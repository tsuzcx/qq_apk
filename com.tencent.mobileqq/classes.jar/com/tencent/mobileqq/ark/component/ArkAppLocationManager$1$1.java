package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.ark.util.LocationUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ArkAppLocationManager$1$1
  implements Runnable
{
  ArkAppLocationManager$1$1(ArkAppLocationManager.1 param1, boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    boolean bool = this.a;
    double d1 = 0.0D;
    if (bool)
    {
      ??? = this.b;
      if (??? != null)
      {
        if ((Math.abs(((SosoLbsInfo)???).mLocation.mLat84) > 1.0E-006D) && (Math.abs(this.b.mLocation.mLon84) > 1.0E-006D))
        {
          d1 = this.b.mLocation.mLat84;
          d2 = this.b.mLocation.mLon84;
          break label189;
        }
        if ((Math.abs(this.b.mLocation.mLat02) > 1.0E-006D) && (Math.abs(this.b.mLocation.mLon02) > 1.0E-006D))
        {
          ??? = LocationUtil.a(this.b.mLocation.mLon02, this.b.mLocation.mLat02);
          d2 = ???[0];
          d1 = ???[1];
          this.b.mLocation.mLat84 = d1;
          this.b.mLocation.mLon84 = d2;
          break label189;
        }
      }
    }
    double d2 = 0.0D;
    label189:
    synchronized (ArkAppLocationManager.a(this.c.a))
    {
      Object localObject2 = new ArrayList(ArkAppLocationManager.a(this.c.a));
      if (((ArrayList)localObject2).size() == 0) {
        ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppLocationManager.b(this.c.a));
      }
      ??? = ((ArrayList)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
        ((ArkAppLocationManager.LocationCallback)localObject2).a(this.a, d1, d2);
        if (!this.a) {
          ((ArkAppLocationManager.LocationCallback)localObject2).a();
        }
      }
      if (!this.a) {
        synchronized (ArkAppLocationManager.a(this.c.a))
        {
          ArkAppLocationManager.a(this.c.a).clear();
        }
      }
      synchronized (ArkAppLocationManager.c(this.c.a))
      {
        Object localObject4 = new ArrayList(ArkAppLocationManager.c(this.c.a));
        ArkAppLocationManager.c(this.c.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
          ((ArkAppLocationManager.LocationCallback)localObject4).a(this.a, d1, d2);
          ((ArkAppLocationManager.LocationCallback)localObject4).a();
        }
        synchronized (ArkAppLocationManager.d(this.c.a))
        {
          localObject4 = new ArrayList(ArkAppLocationManager.d(this.c.a));
          ArkAppLocationManager.d(this.c.a).removeAll((Collection)localObject4);
          ??? = ((ArrayList)localObject4).iterator();
          while (((Iterator)???).hasNext()) {
            ((ArkAppLocationManager.AddressCallback)((Iterator)???).next()).a(this.a, this.b);
          }
          return;
        }
      }
    }
    for (;;)
    {
      throw localObject7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppLocationManager.1.1
 * JD-Core Version:    0.7.0.1
 */