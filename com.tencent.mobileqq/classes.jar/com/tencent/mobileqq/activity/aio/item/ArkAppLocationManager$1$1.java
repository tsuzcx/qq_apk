package com.tencent.mobileqq.activity.aio.item;

import afwc;
import afwd;
import afwf;
import afwg;
import aopa;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArkAppLocationManager$1$1
  implements Runnable
{
  public ArkAppLocationManager$1$1(afwd paramafwd, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    double d2 = 0.0D;
    double d1;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)) {
      if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84) > 1.0E-006D) && (Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84) > 1.0E-006D))
      {
        d1 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84;
        d2 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84;
      }
    }
    for (;;)
    {
      synchronized (afwc.a(this.jdField_a_of_type_Afwd.a))
      {
        Object localObject2 = new ArrayList(afwc.a(this.jdField_a_of_type_Afwd.a));
        if (((ArrayList)localObject2).size() == 0) {
          SosoInterface.removeOnLocationListener(afwc.a(this.jdField_a_of_type_Afwd.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (afwg)((Iterator)???).next();
          ((afwg)localObject2).a(this.jdField_a_of_type_Boolean, d1, d2);
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          ((afwg)localObject2).a();
          continue;
          if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02) <= 1.0E-006D) || (Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02) <= 1.0E-006D)) {
            break label567;
          }
          ??? = aopa.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon02, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat02);
          d2 = ???[0];
          d1 = ???[1];
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLat84 = d1;
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.mLocation.mLon84 = d2;
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        synchronized (afwc.a(this.jdField_a_of_type_Afwd.a))
        {
          afwc.a(this.jdField_a_of_type_Afwd.a).clear();
        }
      }
      synchronized (afwc.b(this.jdField_a_of_type_Afwd.a))
      {
        Object localObject4 = new ArrayList(afwc.b(this.jdField_a_of_type_Afwd.a));
        afwc.b(this.jdField_a_of_type_Afwd.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (afwg)((Iterator)???).next();
          ((afwg)localObject4).a(this.jdField_a_of_type_Boolean, d1, d2);
          ((afwg)localObject4).a();
          continue;
          localObject5 = finally;
          throw localObject5;
        }
      }
      synchronized (afwc.c(this.jdField_a_of_type_Afwd.a))
      {
        ArrayList localArrayList = new ArrayList(afwc.c(this.jdField_a_of_type_Afwd.a));
        afwc.c(this.jdField_a_of_type_Afwd.a).removeAll(localArrayList);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((afwf)((Iterator)???).next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo);
        }
      }
      return;
      label567:
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.1.1
 * JD-Core Version:    0.7.0.1
 */