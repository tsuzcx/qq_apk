package com.tencent.mobileqq.ark.API;

import aphx;
import aphy;
import apic;
import apig;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(aphy paramaphy, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(aphx.a(this.jdField_a_of_type_Aphy.a)).append(", mPositionCallbackId=").append(aphx.b(this.jdField_a_of_type_Aphy.a)).append(", mGetCurrentPositionCallback=").append(aphx.a(this.jdField_a_of_type_Aphy.a)).append(", mGetCurrentPositionCallbackId=").append(aphx.a(this.jdField_a_of_type_Aphy.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((aphx.a(this.jdField_a_of_type_Aphy.a) != null) || (aphx.a(this.jdField_a_of_type_Aphy.a) != null)) {
        break label180;
      }
      SosoInterface.b(aphx.a(this.jdField_a_of_type_Aphy.a));
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
      } while ((this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a == null));
      if (QLog.isColorLevel())
      {
        if (aphx.a(this.jdField_a_of_type_Aphy.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + aphx.a(this.jdField_a_of_type_Aphy.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + aphx.b(this.jdField_a_of_type_Aphy.a) + ", mLastLon=" + aphx.a(this.jdField_a_of_type_Aphy.a));
      }
      double d3 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c;
      double d4 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d;
      d1 = d3;
      d2 = d4;
      if (d3 <= 1.0E-006D)
      {
        d1 = d3;
        d2 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = aphx.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((aphx.a(this.jdField_a_of_type_Aphy.a) != null) && ((Math.abs(d1 - aphx.b(this.jdField_a_of_type_Aphy.a)) >= 1.0E-006D) || (Math.abs(d2 - aphx.a(this.jdField_a_of_type_Aphy.a)) >= 1.0E-006D)))
      {
        localObject = aphx.a(this.jdField_a_of_type_Aphy.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((apig)localObject).a(bool, d1, d2);
        aphx.a(this.jdField_a_of_type_Aphy.a, d1);
        aphx.b(this.jdField_a_of_type_Aphy.a, d2);
      }
    } while (aphx.a(this.jdField_a_of_type_Aphy.a) == null);
    Object localObject = aphx.a(this.jdField_a_of_type_Aphy.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((apic)localObject).a(bool, d1, d2);
      if (aphx.a(this.jdField_a_of_type_Aphy.a) != 0L) {
        aphx.a(this.jdField_a_of_type_Aphy.a).a(aphx.a(this.jdField_a_of_type_Aphy.a));
      }
      aphx.a(this.jdField_a_of_type_Aphy.a, null);
      aphx.a(this.jdField_a_of_type_Aphy.a, 0L);
      if (aphx.a(this.jdField_a_of_type_Aphy.a) != null) {
        break;
      }
      SosoInterface.b(aphx.a(this.jdField_a_of_type_Aphy.a));
      return;
      label760:
      if (aphx.a(this.jdField_a_of_type_Aphy.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + aphx.a(this.jdField_a_of_type_Aphy.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + aphx.b(this.jdField_a_of_type_Aphy.a) + ", mLastLon=" + aphx.a(this.jdField_a_of_type_Aphy.a));
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