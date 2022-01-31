package com.tencent.mobileqq.activity.aio.item;

import afem;
import afen;
import afep;
import afeq;
import anff;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class ArkAppLocationManager$1$1
  implements Runnable
{
  public ArkAppLocationManager$1$1(afen paramafen, boolean paramBoolean, SosoInterface.SosoLbsInfo paramSosoLbsInfo) {}
  
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
      synchronized (afem.a(this.jdField_a_of_type_Afen.a))
      {
        Object localObject2 = new ArrayList(afem.a(this.jdField_a_of_type_Afen.a));
        if (((ArrayList)localObject2).size() == 0) {
          SosoInterface.b(afem.a(this.jdField_a_of_type_Afen.a));
        }
        ??? = ((ArrayList)localObject2).iterator();
        if (((Iterator)???).hasNext())
        {
          localObject2 = (afeq)((Iterator)???).next();
          ((afeq)localObject2).a(this.jdField_a_of_type_Boolean, d1, d2);
          if (this.jdField_a_of_type_Boolean) {
            continue;
          }
          ((afeq)localObject2).a();
          continue;
          if ((Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a) <= 1.0E-006D) || (Math.abs(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b) <= 1.0E-006D)) {
            break label567;
          }
          ??? = anff.a(this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.b, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.a);
          d2 = ???[0];
          d1 = ???[1];
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.c = d1;
          this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo.a.d = d2;
        }
      }
      if (!this.jdField_a_of_type_Boolean) {
        synchronized (afem.a(this.jdField_a_of_type_Afen.a))
        {
          afem.a(this.jdField_a_of_type_Afen.a).clear();
        }
      }
      synchronized (afem.b(this.jdField_a_of_type_Afen.a))
      {
        Object localObject4 = new ArrayList(afem.b(this.jdField_a_of_type_Afen.a));
        afem.b(this.jdField_a_of_type_Afen.a).removeAll((Collection)localObject4);
        ??? = ((ArrayList)localObject4).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject4 = (afeq)((Iterator)???).next();
          ((afeq)localObject4).a(this.jdField_a_of_type_Boolean, d1, d2);
          ((afeq)localObject4).a();
          continue;
          localObject5 = finally;
          throw localObject5;
        }
      }
      synchronized (afem.c(this.jdField_a_of_type_Afen.a))
      {
        ArrayList localArrayList = new ArrayList(afem.c(this.jdField_a_of_type_Afen.a));
        afem.c(this.jdField_a_of_type_Afen.a).removeAll(localArrayList);
        ??? = localArrayList.iterator();
        if (((Iterator)???).hasNext()) {
          ((afep)((Iterator)???).next()).a(this.jdField_a_of_type_Boolean, this.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLbsInfo);
        }
      }
      return;
      label567:
      d1 = 0.0D;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkAppLocationManager.1.1
 * JD-Core Version:    0.7.0.1
 */