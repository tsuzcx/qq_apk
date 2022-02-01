package com.tencent.mobileqq.app;

import aofn;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopManager$11$1
  implements Runnable
{
  TroopManager$11$1(TroopManager.11 param11, TroopInfo paramTroopInfo) {}
  
  public void run()
  {
    Object localObject = (List)this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$11.this$0.c.remove(this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$11.a);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "asyncGetTroopInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      aofn localaofn = (aofn)((WeakReference)((Iterator)localObject).next()).get();
      if (localaofn != null) {
        localaofn.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.11.1
 * JD-Core Version:    0.7.0.1
 */