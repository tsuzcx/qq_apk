package com.tencent.mobileqq.activity.aio.item;

import agzq;
import agzr;
import agzt;
import agzu;
import apvn;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArkAppLocationManager$1$1
  implements Runnable
{
  public ArkAppLocationManager$1$1(agzr paramagzr, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
  public void run()
  {
    double d2 = 0.0D;
    double d1;
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo != null)) {
      if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c) > 1.0E-006D) && (Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d) > 1.0E-006D))
      {
        d1 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c;
        d2 = this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d;
      }
    }
    for (;;)
    {
      synchronized (agzq.a(this.jdField_a_of_type_Agzr.a))
      {
        Object localObject2 = new ArrayList(agzq.a(this.jdField_a_of_type_Agzr.a));
        if (((ArrayList)localObject2).size() == 0) {
          SosoInterface.b(agzq.a(this.jdField_a_of_type_Agzr.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (agzu)((Iterator)???).next();
          ((agzu)localObject2).a(this.jdField_a_of_type_Boolean, d1, d2);
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          ((agzu)localObject2).a();
          continue;
          if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a) <= 1.0E-006D) || (Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b) <= 1.0E-006D)) {
            break label567;
          }
          ??? = apvn.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
          d2 = ???[0];
          d1 = ???[1];
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c = d1;
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d = d2;
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        synchronized (agzq.a(this.jdField_a_of_type_Agzr.a))
        {
          agzq.a(this.jdField_a_of_type_Agzr.a).clear();
        }
      }
      synchronized (agzq.b(this.jdField_a_of_type_Agzr.a))
      {
        Object localObject4 = new ArrayList(agzq.b(this.jdField_a_of_type_Agzr.a));
        agzq.b(this.jdField_a_of_type_Agzr.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (agzu)((Iterator)???).next();
          ((agzu)localObject4).a(this.jdField_a_of_type_Boolean, d1, d2);
          ((agzu)localObject4).a();
          continue;
          localObject5 = finally;
          throw localObject5;
        }
      }
      synchronized (agzq.c(this.jdField_a_of_type_Agzr.a))
      {
        ArrayList localArrayList = new ArrayList(agzq.c(this.jdField_a_of_type_Agzr.a));
        agzq.c(this.jdField_a_of_type_Agzr.a).removeAll(localArrayList);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((agzt)((Iterator)???).next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo);
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