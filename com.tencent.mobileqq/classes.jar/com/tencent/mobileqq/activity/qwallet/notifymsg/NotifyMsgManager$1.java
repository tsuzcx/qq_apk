package com.tencent.mobileqq.activity.qwallet.notifymsg;

import ajvu;
import akar;
import akas;
import akat;
import akau;
import akgd;
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
      synchronized (akat.jdField_a_of_type_JavaLangObject)
      {
        if (akat.jdField_a_of_type_Akar == null) {
          akat.jdField_a_of_type_Akar = new akar(BaseApplicationImpl.getContext());
        }
        ??? = akgd.a();
        if (??? == null) {
          return;
        }
      }
      if (akat.jdField_a_of_type_Akar != null) {
        akat.jdField_a_of_type_Akar.a(((QQAppInterface)???).getCurrentUin(), akat.c);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < akat.b.size())
      {
        akas localakas1 = (akas)akat.b.get(i);
        if (localakas1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          akas localakas2 = akat.a(akat.c, localakas1.b, localakas1.a);
          if (localakas2 != null)
          {
            ((ArrayList)localObject4).add(akat.a(localakas1, localakas2));
          }
          else
          {
            akat.c.add(localakas1);
            ((ArrayList)localObject3).add(localakas1);
          }
        }
      }
      akat.b.clear();
      if (((ArrayList)localObject3).size() > 0) {
        akat.a((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        akat.a((ArrayList)localObject4, false);
      }
      akat.jdField_a_of_type_Int = 2;
      akat.a(akat.jdField_a_of_type_JavaUtilArrayList);
      localObject3 = akat.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (akau)((Iterator)localObject3).next();
        if (localObject4 != null) {
          akat.a((akau)localObject4);
        }
      }
      akat.jdField_a_of_type_JavaUtilArrayList.clear();
      l1 = ajvu.a(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((akat.jdField_a_of_type_Akar == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    akat.jdField_a_of_type_Akar.a(2592000L, null);
    if (akat.jdField_a_of_type_Akar != null) {
      akat.jdField_a_of_type_Akar.a(172800L, new int[] { 2 });
    }
    ajvu.a(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */