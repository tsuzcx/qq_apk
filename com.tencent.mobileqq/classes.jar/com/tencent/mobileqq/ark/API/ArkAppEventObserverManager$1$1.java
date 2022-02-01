package com.tencent.mobileqq.ark.API;

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
      StringBuilder localStringBuilder = new StringBuilder("onLocationFinish mPositionCallback=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)).append(", mPositionCallbackId=").append(ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)).append(", mGetCurrentPositionCallback=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)).append(", mGetCurrentPositionCallbackId=").append(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)).append(", lbsInfo=").append(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo).append(", lbsInfo.mLocation=");
      if (this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation;
        QLog.d("ArkAppEventObserverManager", 2, localObject);
      }
    }
    else
    {
      if ((ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) != null) || (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) != null)) {
        break label190;
      }
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a));
    }
    label190:
    label377:
    double d1;
    double d2;
    label598:
    do
    {
      do
      {
        return;
        localObject = "NULL";
        break;
      } while ((this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo == null) || (this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation == null));
      if (QLog.isColorLevel())
      {
        if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) == null) {
          break label780;
        }
        QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", positionCallback=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) + ", mLastLon=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a));
      }
      double d3 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84;
      double d4 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84;
      d1 = d3;
      d2 = d4;
      if (d3 <= 1.0E-006D)
      {
        d1 = d3;
        d2 = d4;
        if (d4 <= 1.0E-006D)
        {
          localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02, this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02);
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
      if ((ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) != null) && ((Math.abs(d1 - ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)) >= 1.0E-006D) || (Math.abs(d2 - ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a)) >= 1.0E-006D)))
      {
        localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a);
        if (this.jdField_a_of_type_Int != 0) {
          break label947;
        }
        bool = true;
        ((ArkAppEventObserverManager.PositionCallback)localObject).a(bool, d1, d2);
        ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a, d1);
        ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a, d2);
      }
    } while (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) == null);
    Object localObject = ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a);
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      ((ArkAppEventObserverManager.GetCurrentPositionCallback)localObject).a(bool, d1, d2);
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) != 0L) {
        ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a).a(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a));
      }
      ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a, null);
      ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a, 0L);
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) != null) {
        break;
      }
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a));
      return;
      label780:
      if (ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) == null) {
        break label377;
      }
      QLog.d("ArkAppEventObserverManager", 2, "onLocationFinish errCode=" + this.jdField_a_of_type_Int + ", getcurrentPositionCallback=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) + ", lat02=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02 + ", lon02=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02 + ", lat84=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84 + ", lon84=" + this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84 + ", mLastLat=" + ArkAppEventObserverManager.b(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a) + ", mLastLon=" + ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager$1.a));
      break label377;
      label947:
      bool = false;
      break label598;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.1.1
 * JD-Core Version:    0.7.0.1
 */