package com.tencent.mobileqq.ark.API;

import aloo;
import alop;
import alot;
import alox;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(alop paramalop, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(aloo.a(this.jdField_a_of_type_Alop.a)).append(", mPositionCallbackId=").append(aloo.b(this.jdField_a_of_type_Alop.a)).append(", mGetCurrentPositionCallback=").append(aloo.a(this.jdField_a_of_type_Alop.a)).append(", mGetCurrentPositionCallbackId=").append(aloo.a(this.jdField_a_of_type_Alop.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((aloo.a(this.jdField_a_of_type_Alop.a) != null) || (aloo.a(this.jdField_a_of_type_Alop.a) != null)) {
        break label180;
      }
      SosoInterface.b(aloo.a(this.jdField_a_of_type_Alop.a));
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
        if (aloo.a(this.jdField_a_of_type_Alop.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + aloo.a(this.jdField_a_of_type_Alop.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + aloo.b(this.jdField_a_of_type_Alop.a) + ", mLastLon=" + aloo.a(this.jdField_a_of_type_Alop.a));
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
          localObject = aloo.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((aloo.a(this.jdField_a_of_type_Alop.a) != null) && ((Math.abs(d1 - aloo.b(this.jdField_a_of_type_Alop.a)) >= 1.0E-006D) || (Math.abs(d2 - aloo.a(this.jdField_a_of_type_Alop.a)) >= 1.0E-006D)))
      {
        localObject = aloo.a(this.jdField_a_of_type_Alop.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((alox)localObject).a(bool, d1, d2);
        aloo.a(this.jdField_a_of_type_Alop.a, d1);
        aloo.b(this.jdField_a_of_type_Alop.a, d2);
      }
    } while (aloo.a(this.jdField_a_of_type_Alop.a) == null);
    Object localObject = aloo.a(this.jdField_a_of_type_Alop.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((alot)localObject).a(bool, d1, d2);
      if (aloo.a(this.jdField_a_of_type_Alop.a) != 0L) {
        aloo.a(this.jdField_a_of_type_Alop.a).a(aloo.a(this.jdField_a_of_type_Alop.a));
      }
      aloo.a(this.jdField_a_of_type_Alop.a, null);
      aloo.a(this.jdField_a_of_type_Alop.a, 0L);
      if (aloo.a(this.jdField_a_of_type_Alop.a) != null) {
        break;
      }
      SosoInterface.b(aloo.a(this.jdField_a_of_type_Alop.a));
      return;
      label760:
      if (aloo.a(this.jdField_a_of_type_Alop.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + aloo.a(this.jdField_a_of_type_Alop.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + aloo.b(this.jdField_a_of_type_Alop.a) + ", mLastLon=" + aloo.a(this.jdField_a_of_type_Alop.a));
      break label367;
      label927:
      bool = false;
      break label588;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */