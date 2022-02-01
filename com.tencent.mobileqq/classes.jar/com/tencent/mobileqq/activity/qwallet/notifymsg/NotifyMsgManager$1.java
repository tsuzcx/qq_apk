package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akyd;
import alcy;
import alcz;
import alda;
import aldb;
import alil;
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
      synchronized (alda.jdField_a_of_type_JavaLangObject)
      {
        if (alda.jdField_a_of_type_Alcy == null) {
          alda.jdField_a_of_type_Alcy = new alcy(BaseApplicationImpl.getContext());
        }
        ??? = alil.a();
        if (??? == null) {
          return;
        }
      }
      if (alda.jdField_a_of_type_Alcy != null) {
        alda.jdField_a_of_type_Alcy.a(((QQAppInterface)???).c(), alda.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < alda.b.size())
      {
        alcz localalcz1 = (alcz)alda.b.get(i);
        if (localalcz1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          alcz localalcz2 = alda.a(alda.c, localalcz1.b, localalcz1.a);
          if (localalcz2 != null)
          {
            ((ArrayList)localObject4).add(alda.a(localalcz1, localalcz2));
          }
          else
          {
            alda.c.add(localalcz1);
            ((ArrayList)localObject3).add(localalcz1);
          }
        }
      }
      alda.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        alda.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        alda.a((ArrayList)localObject4, false);
      }
      alda.jdField_a_of_type_Int = 2;
      alda.a(alda.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = alda.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aldb)((Iterator)localObject3).next();
        if (localObject4 != null) {
          alda.a((aldb)localObject4);
        }
      }
      alda.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = akyd.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((alda.jdField_a_of_type_Alcy == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    alda.jdField_a_of_type_Alcy.a(2592000L, null);
    if (alda.jdField_a_of_type_Alcy != null) {
      alda.jdField_a_of_type_Alcy.a(172800L, new int[] { 2 });
    }
    akyd.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */