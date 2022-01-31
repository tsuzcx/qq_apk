package com.tencent.mobileqq.ark.API;

import alad;
import alae;
import alai;
import alam;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(alae paramalae, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(alad.a(this.jdField_a_of_type_Alae.a)).append(", mPositionCallbackId=").append(alad.b(this.jdField_a_of_type_Alae.a)).append(", mGetCurrentPositionCallback=").append(alad.a(this.jdField_a_of_type_Alae.a)).append(", mGetCurrentPositionCallbackId=").append(alad.a(this.jdField_a_of_type_Alae.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((alad.a(this.jdField_a_of_type_Alae.a) != null) || (alad.a(this.jdField_a_of_type_Alae.a) != null)) {
        break label180;
      }
      SosoInterface.b(alad.a(this.jdField_a_of_type_Alae.a));
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
        if (alad.a(this.jdField_a_of_type_Alae.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + alad.a(this.jdField_a_of_type_Alae.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + alad.b(this.jdField_a_of_type_Alae.a) + ", mLastLon=" + alad.a(this.jdField_a_of_type_Alae.a));
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
          localObject = alad.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((alad.a(this.jdField_a_of_type_Alae.a) != null) && ((Math.abs(d1 - alad.b(this.jdField_a_of_type_Alae.a)) >= 1.0E-006D) || (Math.abs(d2 - alad.a(this.jdField_a_of_type_Alae.a)) >= 1.0E-006D)))
      {
        localObject = alad.a(this.jdField_a_of_type_Alae.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((alam)localObject).a(bool, d1, d2);
        alad.a(this.jdField_a_of_type_Alae.a, d1);
        alad.b(this.jdField_a_of_type_Alae.a, d2);
      }
    } while (alad.a(this.jdField_a_of_type_Alae.a) == null);
    Object localObject = alad.a(this.jdField_a_of_type_Alae.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((alai)localObject).a(bool, d1, d2);
      if (alad.a(this.jdField_a_of_type_Alae.a) != 0L) {
        alad.a(this.jdField_a_of_type_Alae.a).a(alad.a(this.jdField_a_of_type_Alae.a));
      }
      alad.a(this.jdField_a_of_type_Alae.a, null);
      alad.a(this.jdField_a_of_type_Alae.a, 0L);
      if (alad.a(this.jdField_a_of_type_Alae.a) != null) {
        break;
      }
      SosoInterface.b(alad.a(this.jdField_a_of_type_Alae.a));
      return;
      label760:
      if (alad.a(this.jdField_a_of_type_Alae.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + alad.a(this.jdField_a_of_type_Alae.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + alad.b(this.jdField_a_of_type_Alae.a) + ", mLastLon=" + alad.a(this.jdField_a_of_type_Alae.a));
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