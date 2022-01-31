package com.tencent.mobileqq.activity.qwallet.notifymsg;

import agxa;
import ahba;
import ahbb;
import ahbc;
import ahbd;
import ahiw;
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
      synchronized (ahbc.jdField_a_of_type_JavaLangObject)
      {
        if (ahbc.jdField_a_of_type_Ahba == null) {
          ahbc.jdField_a_of_type_Ahba = new ahba(BaseApplicationImpl.getContext());
        }
        ??? = ahiw.a();
        if (??? == null) {
          return;
        }
      }
      if (ahbc.jdField_a_of_type_Ahba != null) {
        ahbc.jdField_a_of_type_Ahba.a(((QQAppInterface)???).c(), ahbc.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < ahbc.b.size())
      {
        ahbb localahbb1 = (ahbb)ahbc.b.get(i);
        if (localahbb1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          ahbb localahbb2 = ahbc.a(ahbc.c, localahbb1.b, localahbb1.a);
          if (localahbb2 != null)
          {
            ((ArrayList)localObject4).add(ahbc.a(localahbb1, localahbb2));
          }
          else
          {
            ahbc.c.add(localahbb1);
            ((ArrayList)localObject3).add(localahbb1);
          }
        }
      }
      ahbc.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        ahbc.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        ahbc.a((ArrayList)localObject4, false);
      }
      ahbc.jdField_a_of_type_Int = 2;
      ahbc.a(ahbc.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = ahbc.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (ahbd)((Iterator)localObject3).next();
        if (localObject4 != null) {
          ahbc.a((ahbd)localObject4);
        }
      }
      ahbc.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = agxa.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((ahbc.jdField_a_of_type_Ahba == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    ahbc.jdField_a_of_type_Ahba.a(2592000L, null);
    if (ahbc.jdField_a_of_type_Ahba != null) {
      ahbc.jdField_a_of_type_Ahba.a(172800L, new int[] { 2 });
    }
    agxa.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */