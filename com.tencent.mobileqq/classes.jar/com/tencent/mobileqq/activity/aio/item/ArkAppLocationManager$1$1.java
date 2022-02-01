package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.ark.API.ArkAppEventObserverManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

class ArkAppLocationManager$1$1
  implements Runnable
{
  ArkAppLocationManager$1$1(ArkAppLocationManager.1 param1, boolean paramBoolean, SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    double d2 = 0.0D;
    double d1;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo != null)) {
      if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84) > 1.0E-006D) && (Math.abs(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84) > 1.0E-006D))
      {
        d1 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84;
        d2 = this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84;
      }
    }
    for (;;)
    {
      synchronized (ArkAppLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a))
      {
        Object localObject2 = new ArrayList(ArkAppLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a));
        if (((ArrayList)localObject2).size() == 0) {
          ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).removeOnLocationListener(ArkAppLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
          ((ArkAppLocationManager.LocationCallback)localObject2).a(this.jdField_a_of_type_Boolean, d1, d2);
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          ((ArkAppLocationManager.LocationCallback)localObject2).a();
          continue;
          if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02) <= 1.0E-006D) || (Math.abs(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02) <= 1.0E-006D)) {
            break label577;
          }
          ??? = ArkAppEventObserverManager.a(this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon02, this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat02);
          d2 = ???[0];
          d1 = ???[1];
          this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLat84 = d1;
          this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo.mLocation.mLon84 = d2;
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        synchronized (ArkAppLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a))
        {
          ArkAppLocationManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a).clear();
        }
      }
      synchronized (ArkAppLocationManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a))
      {
        Object localObject4 = new ArrayList(ArkAppLocationManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a));
        ArkAppLocationManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (ArkAppLocationManager.LocationCallback)((Iterator)???).next();
          ((ArkAppLocationManager.LocationCallback)localObject4).a(this.jdField_a_of_type_Boolean, d1, d2);
          ((ArkAppLocationManager.LocationCallback)localObject4).a();
          continue;
          localObject5 = finally;
          throw localObject5;
        }
      }
      synchronized (ArkAppLocationManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a))
      {
        ArrayList localArrayList = new ArrayList(ArkAppLocationManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a));
        ArkAppLocationManager.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemArkAppLocationManager$1.a).removeAll(localArrayList);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((ArkAppLocationManager.AddressCallback)((Iterator)???).next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqSosoLocationDataSosoLbsInfo);
        }
      }
      return;
      label577:
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.1.1
 * JD-Core Version:    0.7.0.1
 */