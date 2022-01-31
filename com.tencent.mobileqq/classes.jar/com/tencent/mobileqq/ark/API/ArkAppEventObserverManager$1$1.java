package com.tencent.mobileqq.ark.API;

import anff;
import anfg;
import anfk;
import anfo;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(anfg paramanfg, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(anff.a(this.jdField_a_of_type_Anfg.a)).append(", mPositionCallbackId=").append(anff.b(this.jdField_a_of_type_Anfg.a)).append(", mGetCurrentPositionCallback=").append(anff.a(this.jdField_a_of_type_Anfg.a)).append(", mGetCurrentPositionCallbackId=").append(anff.a(this.jdField_a_of_type_Anfg.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((anff.a(this.jdField_a_of_type_Anfg.a) != null) || (anff.a(this.jdField_a_of_type_Anfg.a) != null)) {
        break label180;
      }
      SosoInterface.b(anff.a(this.jdField_a_of_type_Anfg.a));
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
        if (anff.a(this.jdField_a_of_type_Anfg.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + anff.a(this.jdField_a_of_type_Anfg.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + anff.b(this.jdField_a_of_type_Anfg.a) + ", mLastLon=" + anff.a(this.jdField_a_of_type_Anfg.a));
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
          localObject = anff.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
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
      if ((anff.a(this.jdField_a_of_type_Anfg.a) != null) && ((Math.abs(d1 - anff.b(this.jdField_a_of_type_Anfg.a)) >= 1.0E-006D) || (Math.abs(d2 - anff.a(this.jdField_a_of_type_Anfg.a)) >= 1.0E-006D)))
      {
        localObject = anff.a(this.jdField_a_of_type_Anfg.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((anfo)localObject).a(bool, d1, d2);
        anff.a(this.jdField_a_of_type_Anfg.a, d1);
        anff.b(this.jdField_a_of_type_Anfg.a, d2);
      }
    } while (anff.a(this.jdField_a_of_type_Anfg.a) == null);
    Object localObject = anff.a(this.jdField_a_of_type_Anfg.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((anfk)localObject).a(bool, d1, d2);
      if (anff.a(this.jdField_a_of_type_Anfg.a) != 0L) {
        anff.a(this.jdField_a_of_type_Anfg.a).a(anff.a(this.jdField_a_of_type_Anfg.a));
      }
      anff.a(this.jdField_a_of_type_Anfg.a, null);
      anff.a(this.jdField_a_of_type_Anfg.a, 0L);
      if (anff.a(this.jdField_a_of_type_Anfg.a) != null) {
        break;
      }
      SosoInterface.b(anff.a(this.jdField_a_of_type_Anfg.a));
      return;
      label760:
      if (anff.a(this.jdField_a_of_type_Anfg.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + anff.a(this.jdField_a_of_type_Anfg.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d + ", mLastLat=" + anff.b(this.jdField_a_of_type_Anfg.a) + ", mLastLon=" + anff.a(this.jdField_a_of_type_Anfg.a));
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