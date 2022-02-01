package com.tencent.mobileqq.ark.API;

import apvn;
import apvo;
import apvs;
import apvw;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(apvo paramapvo, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(apvn.a(this.jdField_a_of_type_Apvo.a)).append(", mPositionCallbackId=").append(apvn.b(this.jdField_a_of_type_Apvo.a)).append(", mGetCurrentPositionCallback=").append(apvn.a(this.jdField_a_of_type_Apvo.a)).append(", mGetCurrentPositionCallbackId=").append(apvn.a(this.jdField_a_of_type_Apvo.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((apvn.a(this.jdField_a_of_type_Apvo.a) != null) || (apvn.a(this.jdField_a_of_type_Apvo.a) != null)) {
        break label180;
      }
      SosoInterface.b(apvn.a(this.jdField_a_of_type_Apvo.a));
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
        if (apvn.a(this.jdField_a_of_type_Apvo.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + apvn.a(this.jdField_a_of_type_Apvo.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + apvn.b(this.jdField_a_of_type_Apvo.a) + ", mLastLon=" + apvn.a(this.jdField_a_of_type_Apvo.a));
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
          localObject = apvn.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((apvn.a(this.jdField_a_of_type_Apvo.a) != null) && ((Math.abs(d1 - apvn.b(this.jdField_a_of_type_Apvo.a)) >= 1.0E-006D) || (Math.abs(d2 - apvn.a(this.jdField_a_of_type_Apvo.a)) >= 1.0E-006D)))
      {
        localObject = apvn.a(this.jdField_a_of_type_Apvo.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((apvw)localObject).a(bool, d1, d2);
        apvn.a(this.jdField_a_of_type_Apvo.a, d1);
        apvn.b(this.jdField_a_of_type_Apvo.a, d2);
      }
    } while (apvn.a(this.jdField_a_of_type_Apvo.a) == null);
    Object localObject = apvn.a(this.jdField_a_of_type_Apvo.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((apvs)localObject).a(bool, d1, d2);
      if (apvn.a(this.jdField_a_of_type_Apvo.a) != 0L) {
        apvn.a(this.jdField_a_of_type_Apvo.a).a(apvn.a(this.jdField_a_of_type_Apvo.a));
      }
      apvn.a(this.jdField_a_of_type_Apvo.a, null);
      apvn.a(this.jdField_a_of_type_Apvo.a, 0L);
      if (apvn.a(this.jdField_a_of_type_Apvo.a) != null) {
        break;
      }
      SosoInterface.b(apvn.a(this.jdField_a_of_type_Apvo.a));
      return;
      label760:
      if (apvn.a(this.jdField_a_of_type_Apvo.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + apvn.a(this.jdField_a_of_type_Apvo.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + apvn.b(this.jdField_a_of_type_Apvo.a) + ", mLastLon=" + apvn.a(this.jdField_a_of_type_Apvo.a));
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