package com.tencent.mobileqq.activity.qwallet.notifymsg;

import agkn;
import agon;
import agoo;
import agop;
import agoq;
import agwj;
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
      synchronized (agop.jdField_a_of_type_JavaLangObject)
      {
        if (agop.jdField_a_of_type_Agon == null) {
          agop.jdField_a_of_type_Agon = new agon(BaseApplicationImpl.getContext());
        }
        ??? = agwj.a();
        if (??? == null) {
          return;
        }
      }
      if (agop.jdField_a_of_type_Agon != null) {
        agop.jdField_a_of_type_Agon.a(((QQAppInterface)???).c(), agop.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < agop.b.size())
      {
        agoo localagoo1 = (agoo)agop.b.get(i);
        if (localagoo1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          agoo localagoo2 = agop.a(agop.c, localagoo1.b, localagoo1.a);
          if (localagoo2 != null)
          {
            ((ArrayList)localObject4).add(agop.a(localagoo1, localagoo2));
          }
          else
          {
            agop.c.add(localagoo1);
            ((ArrayList)localObject3).add(localagoo1);
          }
        }
      }
      agop.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        agop.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        agop.a((ArrayList)localObject4, false);
      }
      agop.jdField_a_of_type_Int = 2;
      agop.a(agop.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = agop.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (agoq)((Iterator)localObject3).next();
        if (localObject4 != null) {
          agop.a((agoq)localObject4);
        }
      }
      agop.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = agkn.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((agop.jdField_a_of_type_Agon == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    agop.jdField_a_of_type_Agon.a(2592000L, null);
    if (agop.jdField_a_of_type_Agon != null) {
      agop.jdField_a_of_type_Agon.a(172800L, new int[] { 2 });
    }
    agkn.a(((QQAppInterface)???).c(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */