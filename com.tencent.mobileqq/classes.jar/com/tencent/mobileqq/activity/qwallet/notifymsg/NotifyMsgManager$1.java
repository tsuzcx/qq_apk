package com.tencent.mobileqq.activity.qwallet.notifymsg;

import akrn;
import akwk;
import akwl;
import akwm;
import akwn;
import albw;
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
      synchronized (akwm.jdField_a_of_type_JavaLangObject)
      {
        if (akwm.jdField_a_of_type_Akwk == null) {
          akwm.jdField_a_of_type_Akwk = new akwk(BaseApplicationImpl.getContext());
        }
        ??? = albw.a();
        if (??? == null) {
          return;
        }
      }
      if (akwm.jdField_a_of_type_Akwk != null) {
        akwm.jdField_a_of_type_Akwk.a(((QQAppInterface)???).getCurrentUin(), akwm.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < akwm.b.size())
      {
        akwl localakwl1 = (akwl)akwm.b.get(i);
        if (localakwl1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          akwl localakwl2 = akwm.a(akwm.c, localakwl1.b, localakwl1.a);
          if (localakwl2 != null)
          {
            ((ArrayList)localObject4).add(akwm.a(localakwl1, localakwl2));
          }
          else
          {
            akwm.c.add(localakwl1);
            ((ArrayList)localObject3).add(localakwl1);
          }
        }
      }
      akwm.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        akwm.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        akwm.a((ArrayList)localObject4, false);
      }
      akwm.jdField_a_of_type_Int = 2;
      akwm.a(akwm.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = akwm.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (akwn)((Iterator)localObject3).next();
        if (localObject4 != null) {
          akwm.a((akwn)localObject4);
        }
      }
      akwm.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = akrn.a(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((akwm.jdField_a_of_type_Akwk == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    akwm.jdField_a_of_type_Akwk.a(2592000L, null);
    if (akwm.jdField_a_of_type_Akwk != null) {
      akwm.jdField_a_of_type_Akwk.a(172800L, new int[] { 2 });
    }
    akrn.a(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */