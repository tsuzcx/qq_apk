package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aivo;
import aizu;
import aizv;
import aizw;
import aizx;
import ajeu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public final class NotifyMsgManager$1
  implements Runnable
{
  public void run()
  {
    long l1;
    long l2;
    do
    {
      synchronized (aizw.jdField_a_of_type_JavaLangObject)
      {
        if (aizw.jdField_a_of_type_Aizu == null) {
          aizw.jdField_a_of_type_Aizu = new aizu(BaseApplicationImpl.getContext());
        }
        ??? = ajeu.a();
        if (??? == null) {
          return;
        }
      }
      if (aizw.jdField_a_of_type_Aizu != null) {
        aizw.jdField_a_of_type_Aizu.a(((QQAppInterface)???).c(), aizw.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < aizw.b.size())
      {
        aizv localaizv1 = (aizv)aizw.b.get(i);
        if (localaizv1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          aizv localaizv2 = aizw.a(aizw.c, localaizv1.b, localaizv1.a);
          if (localaizv2 != null)
          {
            ((ArrayList)localObject4).add(aizw.a(localaizv1, localaizv2));
          }
          else
          {
            aizw.c.add(localaizv1);
            ((ArrayList)localObject3).add(localaizv1);
          }
        }
      }
      aizw.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        aizw.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        aizw.a((ArrayList)localObject4, false);
      }
      aizw.jdField_a_of_type_Int = 2;
      aizw.a(aizw.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = aizw.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aizx)((Iterator)localObject3).next();
        if (localObject4 != null) {
          aizw.a((aizx)localObject4);
        }
      }
      aizw.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = aivo.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((aizw.jdField_a_of_type_Aizu == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    aizw.jdField_a_of_type_Aizu.a(2592000L, null);
    if (aizw.jdField_a_of_type_Aizu != null) {
      aizw.jdField_a_of_type_Aizu.a(172800L, new int[] { 2 });
    }
    aivo.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */