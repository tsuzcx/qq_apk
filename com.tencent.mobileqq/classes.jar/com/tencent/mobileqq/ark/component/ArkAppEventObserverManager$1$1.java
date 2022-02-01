package com.tencent.mobileqq.ark.component;

import com.tencent.mobileqq.ark.util.LocationUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$1$1
  implements Runnable
{
  ArkAppEventObserverManager$1$1(ArkAppEventObserverManager.1 param1, SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=");
      localStringBuilder.append(ArkAppEventObserverManager.e(this.c.a));
      localStringBuilder.append(", mPositionCallbackId=");
      localStringBuilder.append(ArkAppEventObserverManager.d(this.c.a));
      localStringBuilder.append(", mGetCurrentPositionCallback=");
      localStringBuilder.append(ArkAppEventObserverManager.c(this.c.a));
      localStringBuilder.append(", mGetCurrentPositionCallbackId=");
      localStringBuilder.append(ArkAppEventObserverManager.b(this.c.a));
      localStringBuilder.append(", lbsInfo=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", lbsInfo.mLocation=");
      localObject = this.a;
      if (localObject != null) {
        localObject = ((SosoLbsInfo)localObject).mLocation;
      } else {
        localObject = "NULL";
      }
      localStringBuilder.append(localObject);
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    if ((ArkAppEventObserverManager.e(this.c.a) == null) && (ArkAppEventObserverManager.c(this.c.a) == null))
    {
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.f(this.c.a));
      return;
    }
    Object localObject = this.a;
    if ((localObject != null) && (((SosoLbsInfo)localObject).mLocation != null))
    {
      if (QLog.isColorLevel()) {
        if (ArkAppEventObserverManager.e(this.c.a) != null)
        {
          localObject = new StringBuilder("onLocationFinish errCode=");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append(", positionCallback=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.e(this.c.a));
          ((StringBuilder)localObject).append(", lat02=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLat02);
          ((StringBuilder)localObject).append(", lon02=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLon02);
          ((StringBuilder)localObject).append(", lat84=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLat84);
          ((StringBuilder)localObject).append(", lon84=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLon84);
          ((StringBuilder)localObject).append(", mLastLat=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.h(this.c.a));
          ((StringBuilder)localObject).append(", mLastLon=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.g(this.c.a));
          QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
        }
        else if (ArkAppEventObserverManager.c(this.c.a) != null)
        {
          localObject = new StringBuilder("onLocationFinish errCode=");
          ((StringBuilder)localObject).append(this.b);
          ((StringBuilder)localObject).append(", getcurrentPositionCallback=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.c(this.c.a));
          ((StringBuilder)localObject).append(", lat02=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLat02);
          ((StringBuilder)localObject).append(", lon02=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLon02);
          ((StringBuilder)localObject).append(", lat84=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLat84);
          ((StringBuilder)localObject).append(", lon84=");
          ((StringBuilder)localObject).append(this.a.mLocation.mLon84);
          ((StringBuilder)localObject).append(", mLastLat=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.h(this.c.a));
          ((StringBuilder)localObject).append(", mLastLon=");
          ((StringBuilder)localObject).append(ArkAppEventObserverManager.g(this.c.a));
          QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
        }
      }
      double d3 = this.a.mLocation.mLat84;
      double d4 = this.a.mLocation.mLon84;
      double d2 = d3;
      double d1 = d4;
      if (d3 <= 1.0E-006D)
      {
        d2 = d3;
        d1 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = LocationUtil.a(this.a.mLocation.mLon02, this.a.mLocation.mLat02);
          d1 = localObject[0];
          d2 = localObject[1];
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder("onLocationFinish gcj02towgs84 curLat=");
            ((StringBuilder)localObject).append(d2);
            ((StringBuilder)localObject).append(", curLon=");
            ((StringBuilder)localObject).append(d1);
            QLog.d("ArkAppEventObserverManager", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
      boolean bool;
      if ((ArkAppEventObserverManager.e(this.c.a) != null) && ((Math.abs(d2 - ArkAppEventObserverManager.h(this.c.a)) >= 1.0E-006D) || (Math.abs(d1 - ArkAppEventObserverManager.g(this.c.a)) >= 1.0E-006D)))
      {
        localObject = ArkAppEventObserverManager.e(this.c.a);
        if (this.b == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((ArkAppEventObserverManager.PositionCallback)localObject).a(bool, d2, d1);
        ArkAppEventObserverManager.a(this.c.a, d2);
        ArkAppEventObserverManager.b(this.c.a, d1);
      }
      if (ArkAppEventObserverManager.c(this.c.a) != null)
      {
        localObject = ArkAppEventObserverManager.c(this.c.a);
        if (this.b == 0) {
          bool = true;
        } else {
          bool = false;
        }
        ((ArkAppEventObserverManager.GetCurrentPositionCallback)localObject).a(bool, d2, d1);
        if (ArkAppEventObserverManager.b(this.c.a) != 0L) {
          ArkAppEventObserverManager.c(this.c.a).a(ArkAppEventObserverManager.b(this.c.a));
        }
        ArkAppEventObserverManager.a(this.c.a, null);
        ArkAppEventObserverManager.a(this.c.a, 0L);
        if (ArkAppEventObserverManager.e(this.c.a) == null) {
          ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.f(this.c.a));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */