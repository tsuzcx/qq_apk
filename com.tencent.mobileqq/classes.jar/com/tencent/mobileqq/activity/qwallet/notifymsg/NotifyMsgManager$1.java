package com.tencent.mobileqq.activity.qwallet.notifymsg;

import agxc;
import ahbc;
import ahbd;
import ahbe;
import ahbf;
import ahiy;
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
      synchronized (ahbe.jdField_a_of_type_JavaLangObject)
      {
        if (ahbe.jdField_a_of_type_Ahbc == null) {
          ahbe.jdField_a_of_type_Ahbc = new ahbc(BaseApplicationImpl.getContext());
        }
        ??? = ahiy.a();
        if (??? == null) {
          return;
        }
      }
      if (ahbe.jdField_a_of_type_Ahbc != null) {
        ahbe.jdField_a_of_type_Ahbc.a(((QQAppInterface)???).c(), ahbe.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < ahbe.b.size())
      {
        ahbd localahbd1 = (ahbd)ahbe.b.get(i);
        if (localahbd1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ahbd localahbd2 = ahbe.a(ahbe.c, localahbd1.b, localahbd1.a);
          if (localahbd2 != null)
          {
            ((ArrayList)localObject4).add(ahbe.a(localahbd1, localahbd2));
          }
          else
          {
            ahbe.c.add(localahbd1);
            ((ArrayList)localObject3).add(localahbd1);
          }
        }
      }
      ahbe.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        ahbe.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        ahbe.a((ArrayList)localObject4, false);
      }
      ahbe.jdField_a_of_type_Int = 2;
      ahbe.a(ahbe.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = ahbe.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ahbf)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ahbe.a((ahbf)localObject4);
        }
      }
      ahbe.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = agxc.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((ahbe.jdField_a_of_type_Ahbc == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    ahbe.jdField_a_of_type_Ahbc.a(2592000L, null);
    if (ahbe.jdField_a_of_type_Ahbc != null) {
      ahbe.jdField_a_of_type_Ahbc.a(172800L, new int[] { 2 });
    }
    agxc.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */