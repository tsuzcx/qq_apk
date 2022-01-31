package com.tencent.mobileqq.app;

import alzv;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class TroopManager$10$1
  implements Runnable
{
  TroopManager$10$1(TroopManager.10 param10, TroopMemberInfo paramTroopMemberInfo) {}
  
  public void run()
  {
    Object localObject = (List)this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$10.this$0.b.remove(this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$10.a + "_" + this.jdField_a_of_type_ComTencentMobileqqAppTroopManager$10.b);
    if (QLog.isColorLevel()) {
      QLog.i("TroopManager", 2, "getTroopMemberInfo, size=" + ((List)localObject).size());
    }
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      alzv localalzv = (alzv)((WeakReference)((Iterator)localObject).next()).get();
      if (localalzv != null) {
        localalzv.a(this.jdField_a_of_type_ComTencentMobileqqDataTroopMemberInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopManager.10.1
 * JD-Core Version:    0.7.0.1
 */