package com.tencent.mobileqq.app;

import almt;
import alpj;
import android.util.Pair;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

class GroupIconHelper$CheckDisIconThread
  implements Runnable
{
  public boolean a = true;
  
  private GroupIconHelper$CheckDisIconThread(GroupIconHelper paramGroupIconHelper) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    int i;
    long l;
    Object localObject4;
    label62:
    Object localObject7;
    alpj localalpj;
    label319:
    label334:
    int j;
    boolean bool1;
    if (this.a)
    {
      i = 0;
      l = System.currentTimeMillis();
      localObject4 = null;
      Object localObject1 = null;
      for (;;)
      {
        synchronized (GroupIconHelper.a(this.this$0))
        {
          Iterator localIterator = GroupIconHelper.a(this.this$0).keySet().iterator();
          if (!localIterator.hasNext()) {
            break label604;
          }
          localObject7 = (String)localIterator.next();
          localalpj = (alpj)GroupIconHelper.a(this.this$0).get(localObject7);
          if ((localalpj != null) && (localalpj.jdField_b_of_type_Int >= 8))
          {
            if ((GroupIconHelper.a(this.this$0) instanceof almt)) {
              ((almt)GroupIconHelper.a(this.this$0)).a(false, true, (String)localObject7);
            }
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + (String)localObject7 + ",crateIconCount=" + localalpj.jdField_b_of_type_Int);
          }
        }
        if ((localalpj != null) && (!localalpj.e))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + (String)localObject7 + ",fromCreate is false");
          }
        }
        else
        {
          if ((localalpj == null) || (localalpj.jdField_a_of_type_JavaLangString == null) || (localalpj.jdField_a_of_type_Byte == 3)) {
            break label866;
          }
          if ((localalpj.jdField_a_of_type_Byte == 1) && (l - localalpj.jdField_a_of_type_Long >= GroupIconHelper.a(this.this$0)))
          {
            if (localObject4 != null) {
              break label875;
            }
            localObject4 = new ArrayList();
            if (!GroupIconHelper.a((String)localObject7)) {
              break label872;
            }
            localObject7 = GroupIconHelper.b((String)localObject7);
            j = localalpj.jdField_a_of_type_JavaUtilArrayList.size();
            localalpj.jdField_a_of_type_Byte = 2;
            if (j <= 0) {
              break label885;
            }
            bool2 = true;
            bool1 = bool2;
            if (localalpj.jdField_b_of_type_JavaLangString != null)
            {
              String str = GroupIconHelper.a(localalpj.jdField_a_of_type_JavaUtilArrayList, false);
              bool1 = bool2;
              if (localalpj.jdField_b_of_type_JavaLangString.equals(str)) {
                bool1 = false;
              }
            }
            bool2 = bool1;
            if (bool1)
            {
              ((ArrayList)localObject4).add(Pair.create(localObject7, localalpj));
              GroupIconHelper.a(this.this$0).remove(localObject7);
            }
          }
        }
      }
    }
    label604:
    label866:
    label869:
    label872:
    label875:
    label878:
    label882:
    label885:
    for (boolean bool2 = bool1;; bool2 = false)
    {
      if (QLog.isColorLevel())
      {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + (String)localObject7 + ", isTryCreate: " + bool2 + localalpj.toString());
        break label878;
        if ((localalpj.jdField_a_of_type_Byte == 2) && (l - localalpj.jdField_a_of_type_Long >= GroupIconHelper.b(this.this$0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + (String)localObject7 + localalpj.toString());
          }
          if (localObject2 != null) {
            break label869;
          }
          ??? = new ArrayList();
        }
        for (;;)
        {
          for (;;)
          {
            ((ArrayList)???).add(localObject7);
            i += 1;
            break label882;
            if (localalpj.jdField_a_of_type_Byte == 3) {
              break label866;
            }
            i += 1;
            break label882;
            if ((this.a) && (localObject4 != null))
            {
              j = 0;
              while ((j < ((ArrayList)localObject4).size()) && (this.a))
              {
                localObject7 = (Pair)((ArrayList)localObject4).get(j);
                GroupIconHelper.a(this.this$0, (String)((Pair)localObject7).first, (alpj)((Pair)localObject7).second, true);
                j += 1;
              }
            }
            if ((this.a) && (??? != null))
            {
              j = 0;
              while ((j < ((ArrayList)???).size()) && (this.a))
              {
                localObject4 = (String)((ArrayList)???).get(j);
                this.this$0.b((String)localObject4);
                j += 1;
              }
            }
            if (i == 0) {}
            synchronized (GroupIconHelper.a(this.this$0))
            {
              GroupIconHelper.a(this.this$0, null);
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.a);
              }
              return;
              if (!this.a) {
                break;
              }
            }
          }
          try
          {
            synchronized (GroupIconHelper.a(this.this$0))
            {
              GroupIconHelper.a(this.this$0).wait(GroupIconHelper.a(this.this$0) / 10);
            }
            localObject6 = finally;
            throw localObject6;
          }
          catch (InterruptedException localInterruptedException)
          {
            break label839;
          }
          break label882;
        }
        break label334;
        break label319;
      }
      i += 1;
      break label62;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper.CheckDisIconThread
 * JD-Core Version:    0.7.0.1
 */