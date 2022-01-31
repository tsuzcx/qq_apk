package com.tencent.mobileqq.ark.API;

import anjo;
import anjp;
import anjt;
import anjx;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(anjp paramanjp, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(anjo.a(this.jdField_a_of_type_Anjp.a)).append(", mPositionCallbackId=").append(anjo.b(this.jdField_a_of_type_Anjp.a)).append(", mGetCurrentPositionCallback=").append(anjo.a(this.jdField_a_of_type_Anjp.a)).append(", mGetCurrentPositionCallbackId=").append(anjo.a(this.jdField_a_of_type_Anjp.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((anjo.a(this.jdField_a_of_type_Anjp.a) != null) || (anjo.a(this.jdField_a_of_type_Anjp.a) != null)) {
        break label180;
      }
      SosoInterface.b(anjo.a(this.jdField_a_of_type_Anjp.a));
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
        if (anjo.a(this.jdField_a_of_type_Anjp.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + anjo.a(this.jdField_a_of_type_Anjp.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + anjo.b(this.jdField_a_of_type_Anjp.a) + ", mLastLon=" + anjo.a(this.jdField_a_of_type_Anjp.a));
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
          localObject = anjo.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((anjo.a(this.jdField_a_of_type_Anjp.a) != null) && ((Math.abs(d1 - anjo.b(this.jdField_a_of_type_Anjp.a)) >= 1.0E-006D) || (Math.abs(d2 - anjo.a(this.jdField_a_of_type_Anjp.a)) >= 1.0E-006D)))
      {
        localObject = anjo.a(this.jdField_a_of_type_Anjp.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((anjx)localObject).a(bool, d1, d2);
        anjo.a(this.jdField_a_of_type_Anjp.a, d1);
        anjo.b(this.jdField_a_of_type_Anjp.a, d2);
      }
    } while (anjo.a(this.jdField_a_of_type_Anjp.a) == null);
    Object localObject = anjo.a(this.jdField_a_of_type_Anjp.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((anjt)localObject).a(bool, d1, d2);
      if (anjo.a(this.jdField_a_of_type_Anjp.a) != 0L) {
        anjo.a(this.jdField_a_of_type_Anjp.a).a(anjo.a(this.jdField_a_of_type_Anjp.a));
      }
      anjo.a(this.jdField_a_of_type_Anjp.a, null);
      anjo.a(this.jdField_a_of_type_Anjp.a, 0L);
      if (anjo.a(this.jdField_a_of_type_Anjp.a) != null) {
        break;
      }
      SosoInterface.b(anjo.a(this.jdField_a_of_type_Anjp.a));
      return;
      label760:
      if (anjo.a(this.jdField_a_of_type_Anjp.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + anjo.a(this.jdField_a_of_type_Anjp.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + anjo.b(this.jdField_a_of_type_Anjp.a) + ", mLastLon=" + anjo.a(this.jdField_a_of_type_Anjp.a));
      break label367;
      label927:
      bool = false;
      break label588;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */