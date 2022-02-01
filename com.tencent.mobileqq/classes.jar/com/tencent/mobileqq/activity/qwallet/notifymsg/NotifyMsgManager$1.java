package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akms;
import akrn;
import akro;
import akrp;
import akrq;
import akww;
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
      synchronized (akrp.jdField_a_of_type_JavaLangObject)
      {
        if (akrp.jdField_a_of_type_Akrn == null) {
          akrp.jdField_a_of_type_Akrn = new akrn(BaseApplicationImpl.getContext());
        }
        ??? = akww.a();
        if (??? == null) {
          return;
        }
      }
      if (akrp.jdField_a_of_type_Akrn != null) {
        akrp.jdField_a_of_type_Akrn.a(((QQAppInterface)???).c(), akrp.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < akrp.b.size())
      {
        akro localakro1 = (akro)akrp.b.get(i);
        if (localakro1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          akro localakro2 = akrp.a(akrp.c, localakro1.b, localakro1.a);
          if (localakro2 != null)
          {
            ((ArrayList)localObject4).add(akrp.a(localakro1, localakro2));
          }
          else
          {
            akrp.c.add(localakro1);
            ((ArrayList)localObject3).add(localakro1);
          }
        }
      }
      akrp.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        akrp.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        akrp.a((ArrayList)localObject4, false);
      }
      akrp.jdField_a_of_type_Int = 2;
      akrp.a(akrp.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = akrp.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (akrq)((Iterator)localObject3).next();
        if (localObject4 != null) {
          akrp.a((akrq)localObject4);
        }
      }
      akrp.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = akms.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((akrp.jdField_a_of_type_Akrn == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    akrp.jdField_a_of_type_Akrn.a(2592000L, null);
    if (akrp.jdField_a_of_type_Akrn != null) {
      akrp.jdField_a_of_type_Akrn.a(172800L, new int[] { 2 });
    }
    akms.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */