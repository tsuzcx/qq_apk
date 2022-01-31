package com.tencent.mobileqq.ark.API;

import alop;
import aloq;
import alou;
import aloy;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(aloq paramaloq, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(alop.a(this.jdField_a_of_type_Aloq.a)).append(", mPositionCallbackId=").append(alop.b(this.jdField_a_of_type_Aloq.a)).append(", mGetCurrentPositionCallback=").append(alop.a(this.jdField_a_of_type_Aloq.a)).append(", mGetCurrentPositionCallbackId=").append(alop.a(this.jdField_a_of_type_Aloq.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((alop.a(this.jdField_a_of_type_Aloq.a) != null) || (alop.a(this.jdField_a_of_type_Aloq.a) != null)) {
        break label180;
      }
      SosoInterface.b(alop.a(this.jdField_a_of_type_Aloq.a));
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
        if (alop.a(this.jdField_a_of_type_Aloq.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + alop.a(this.jdField_a_of_type_Aloq.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + alop.b(this.jdField_a_of_type_Aloq.a) + ", mLastLon=" + alop.a(this.jdField_a_of_type_Aloq.a));
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
          localObject = alop.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((alop.a(this.jdField_a_of_type_Aloq.a) != null) && ((Math.abs(d1 - alop.b(this.jdField_a_of_type_Aloq.a)) >= 1.0E-006D) || (Math.abs(d2 - alop.a(this.jdField_a_of_type_Aloq.a)) >= 1.0E-006D)))
      {
        localObject = alop.a(this.jdField_a_of_type_Aloq.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((aloy)localObject).a(bool, d1, d2);
        alop.a(this.jdField_a_of_type_Aloq.a, d1);
        alop.b(this.jdField_a_of_type_Aloq.a, d2);
      }
    } while (alop.a(this.jdField_a_of_type_Aloq.a) == null);
    Object localObject = alop.a(this.jdField_a_of_type_Aloq.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((alou)localObject).a(bool, d1, d2);
      if (alop.a(this.jdField_a_of_type_Aloq.a) != 0L) {
        alop.a(this.jdField_a_of_type_Aloq.a).a(alop.a(this.jdField_a_of_type_Aloq.a));
      }
      alop.a(this.jdField_a_of_type_Aloq.a, null);
      alop.a(this.jdField_a_of_type_Aloq.a, 0L);
      if (alop.a(this.jdField_a_of_type_Aloq.a) != null) {
        break;
      }
      SosoInterface.b(alop.a(this.jdField_a_of_type_Aloq.a));
      return;
      label760:
      if (alop.a(this.jdField_a_of_type_Aloq.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + alop.a(this.jdField_a_of_type_Aloq.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + alop.b(this.jdField_a_of_type_Aloq.a) + ", mLastLon=" + alop.a(this.jdField_a_of_type_Aloq.a));
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