package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aiqz;
import aivf;
import aivg;
import aivh;
import aivi;
import ajaf;
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
      synchronized (aivh.jdField_a_of_type_JavaLangObject)
      {
        if (aivh.jdField_a_of_type_Aivf == null) {
          aivh.jdField_a_of_type_Aivf = new aivf(BaseApplicationImpl.getContext());
        }
        ??? = ajaf.a();
        if (??? == null) {
          return;
        }
      }
      if (aivh.jdField_a_of_type_Aivf != null) {
        aivh.jdField_a_of_type_Aivf.a(((QQAppInterface)???).c(), aivh.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < aivh.b.size())
      {
        aivg localaivg1 = (aivg)aivh.b.get(i);
        if (localaivg1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          aivg localaivg2 = aivh.a(aivh.c, localaivg1.b, localaivg1.a);
          if (localaivg2 != null)
          {
            ((ArrayList)localObject4).add(aivh.a(localaivg1, localaivg2));
          }
          else
          {
            aivh.c.add(localaivg1);
            ((ArrayList)localObject3).add(localaivg1);
          }
        }
      }
      aivh.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        aivh.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        aivh.a((ArrayList)localObject4, false);
      }
      aivh.jdField_a_of_type_Int = 2;
      aivh.a(aivh.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = aivh.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aivi)((Iterator)localObject3).next();
        if (localObject4 != null) {
          aivh.a((aivi)localObject4);
        }
      }
      aivh.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = aiqz.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((aivh.jdField_a_of_type_Aivf == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    aivh.jdField_a_of_type_Aivf.a(2592000L, null);
    if (aivh.jdField_a_of_type_Aivf != null) {
      aivh.jdField_a_of_type_Aivf.a(172800L, new int[] { 2 });
    }
    aiqz.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */