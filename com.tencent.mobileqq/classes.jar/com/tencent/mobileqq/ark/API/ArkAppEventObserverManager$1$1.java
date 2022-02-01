package com.tencent.mobileqq.ark.API;

import apsb;
import apsc;
import apsg;
import apsk;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$1$1
  implements Runnable
{
  public ArkAppEventObserverManager$1$1(apsc paramapsc, SosoInterface.SosoLbsInfo paramSosoLbsInfo, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(apsb.a(this.jdField_a_of_type_Apsc.a)).append(", mPositionCallbackId=").append(apsb.b(this.jdField_a_of_type_Apsc.a)).append(", mGetCurrentPositionCallback=").append(apsb.a(this.jdField_a_of_type_Apsc.a)).append(", mGetCurrentPositionCallbackId=").append(apsb.a(this.jdField_a_of_type_Apsc.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((apsb.a(this.jdField_a_of_type_Apsc.a) != null) || (apsb.a(this.jdField_a_of_type_Apsc.a) != null)) {
        break label180;
      }
      SosoInterface.removeOnLocationListener(apsb.a(this.jdField_a_of_type_Apsc.a));
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
        if (apsb.a(this.jdField_a_of_type_Apsc.a) == null) {
          break label760;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + apsb.a(this.jdField_a_of_type_Apsc.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + apsb.b(this.jdField_a_of_type_Apsc.a) + ", mLastLon=" + apsb.a(this.jdField_a_of_type_Apsc.a));
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
          localObject = apsb.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02);
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
      if ((apsb.a(this.jdField_a_of_type_Apsc.a) != null) && ((Math.abs(d1 - apsb.b(this.jdField_a_of_type_Apsc.a)) >= 1.0E-006D) || (Math.abs(d2 - apsb.a(this.jdField_a_of_type_Apsc.a)) >= 1.0E-006D)))
      {
        localObject = apsb.a(this.jdField_a_of_type_Apsc.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label927;
        }
        bool = true;
        ((apsk)localObject).a(bool, d1, d2);
        apsb.a(this.jdField_a_of_type_Apsc.a, d1);
        apsb.b(this.jdField_a_of_type_Apsc.a, d2);
      }
    } while (apsb.a(this.jdField_a_of_type_Apsc.a) == null);
    Object localObject = apsb.a(this.jdField_a_of_type_Apsc.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((apsg)localObject).a(bool, d1, d2);
      if (apsb.a(this.jdField_a_of_type_Apsc.a) != 0L) {
        apsb.a(this.jdField_a_of_type_Apsc.a).a(apsb.a(this.jdField_a_of_type_Apsc.a));
      }
      apsb.a(this.jdField_a_of_type_Apsc.a, null);
      apsb.a(this.jdField_a_of_type_Apsc.a, 0L);
      if (apsb.a(this.jdField_a_of_type_Apsc.a) != null) {
        break;
      }
      SosoInterface.removeOnLocationListener(apsb.a(this.jdField_a_of_type_Apsc.a));
      return;
      label760:
      if (apsb.a(this.jdField_a_of_type_Apsc.a) == null) {
        break label367;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + apsb.a(this.jdField_a_of_type_Apsc.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + apsb.b(this.jdField_a_of_type_Apsc.a) + ", mLastLon=" + apsb.a(this.jdField_a_of_type_Apsc.a));
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