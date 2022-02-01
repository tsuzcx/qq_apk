package com.tencent.mobileqq.ark.API;

import aopa;
import aopb;
import aopf;
import aopj;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(aopb paramaopb, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(aopa.a(this.jdField_a_of_type_Aopb.a)).append(", mPositionCallbackId=").append(aopa.b(this.jdField_a_of_type_Aopb.a)).append(", mGetCurrentPositionCallback=").append(aopa.a(this.jdField_a_of_type_Aopb.a)).append(", mGetCurrentPositionCallbackId=").append(aopa.a(this.jdField_a_of_type_Aopb.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((aopa.a(this.jdField_a_of_type_Aopb.a) != null) || (aopa.a(this.jdField_a_of_type_Aopb.a) != null)) {
        break label180;
      }
      SosoInterface.removeOnLocationListener(aopa.a(this.jdField_a_of_type_Aopb.a));
    }
    label180:
    label367:
    double d1;
    double d2;
    label588:
    do
    {
      do
      {
        return;
        localObject = "NULL";
        break;
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation == null));
      if (QLog.isColorLevel())
      {
        if (aopa.a(this.jdField_a_of_type_Aopb.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + aopa.a(this.jdField_a_of_type_Aopb.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + aopa.b(this.jdField_a_of_type_Aopb.a) + ", mLastLon=" + aopa.a(this.jdField_a_of_type_Aopb.a));
      }
      double d3 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84;
      double d4 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84;
      d1 = d3;
      d2 = d4;
      if (d3 <= 1.0E-006D)
      {
        d1 = d3;
        d2 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = aopa.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02);
          d3 = localObject[0];
          d4 = localObject[1];
          d1 = d4;
          d2 = d3;
          if (QLog.isColorLevel())
          {
            QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish gcj02towgs84 curLat=" + d4 + ", curLon=" + d3);
            d2 = d3;
            d1 = d4;
          }
        }
      }
      if ((aopa.a(this.jdField_a_of_type_Aopb.a) != null) && ((Math.abs(d1 - aopa.b(this.jdField_a_of_type_Aopb.a)) >= 1.0E-006D) || (Math.abs(d2 - aopa.a(this.jdField_a_of_type_Aopb.a)) >= 1.0E-006D)))
      {
        localObject = aopa.a(this.jdField_a_of_type_Aopb.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((aopj)localObject).a(bool, d1, d2);
        aopa.a(this.jdField_a_of_type_Aopb.a, d1);
        aopa.b(this.jdField_a_of_type_Aopb.a, d2);
      }
    } while (aopa.a(this.jdField_a_of_type_Aopb.a) == null);
    Object localObject = aopa.a(this.jdField_a_of_type_Aopb.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((aopf)localObject).a(bool, d1, d2);
      if (aopa.a(this.jdField_a_of_type_Aopb.a) != 0L) {
        aopa.a(this.jdField_a_of_type_Aopb.a).a(aopa.a(this.jdField_a_of_type_Aopb.a));
      }
      aopa.a(this.jdField_a_of_type_Aopb.a, null);
      aopa.a(this.jdField_a_of_type_Aopb.a, 0L);
      if (aopa.a(this.jdField_a_of_type_Aopb.a) != null) {
        break;
      }
      SosoInterface.removeOnLocationListener(aopa.a(this.jdField_a_of_type_Aopb.a));
      return;
      label760:
      if (aopa.a(this.jdField_a_of_type_Aopb.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + aopa.a(this.jdField_a_of_type_Aopb.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + aopa.b(this.jdField_a_of_type_Aopb.a) + ", mLastLon=" + aopa.a(this.jdField_a_of_type_Aopb.a));
      break label367;
      label927:
      bool = false;
      break label588;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */