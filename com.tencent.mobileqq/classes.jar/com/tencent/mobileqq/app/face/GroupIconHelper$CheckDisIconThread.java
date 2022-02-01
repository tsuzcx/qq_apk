package com.tencent.mobileqq.app.face;

import android.util.Pair;
import anks;
import aocy;
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
  
  private int a(int paramInt, long paramLong, ArrayList<Pair<String, aocy>> paramArrayList, ArrayList<String> paramArrayList1, String paramString, aocy paramaocy)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if ((paramaocy.jdField_a_of_type_Byte == 1) && (paramLong - paramaocy.jdField_a_of_type_Long >= GroupIconHelper.a(this.this$0)))
    {
      paramArrayList1 = paramString;
      if (GroupIconHelper.a(paramString)) {
        paramArrayList1 = GroupIconHelper.b(paramString);
      }
      i = paramaocy.jdField_a_of_type_JavaUtilArrayList.size();
      paramaocy.jdField_a_of_type_Byte = 2;
      if (i > 0)
      {
        if (paramaocy.jdField_b_of_type_JavaLangString == null) {
          break label299;
        }
        paramString = GroupIconHelper.a(paramaocy.jdField_a_of_type_JavaUtilArrayList, false);
        if (!paramaocy.jdField_b_of_type_JavaLangString.equals(paramString)) {
          break label299;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1)
      {
        paramArrayList.add(Pair.create(paramArrayList1, paramaocy));
        GroupIconHelper.a(this.this$0).remove(paramArrayList1);
        bool2 = bool1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + paramArrayList1 + ", isTryCreate: " + bool2 + paramaocy.toString());
      }
      i = paramInt + 1;
      do
      {
        return i;
        if ((paramaocy.jdField_a_of_type_Byte == 2) && (paramLong - paramaocy.jdField_a_of_type_Long >= GroupIconHelper.b(this.this$0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + paramString + paramaocy.toString());
          }
          paramArrayList1.add(paramString);
          return paramInt + 1;
        }
        i = paramInt;
      } while (paramaocy.jdField_a_of_type_Byte == 3);
      return paramInt + 1;
      label299:
      bool1 = true;
    }
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    for (;;)
    {
      if (this.a)
      {
        int i = 0;
        long l = System.currentTimeMillis();
        Object localObject2 = new ArrayList();
        ArrayList localArrayList1 = new ArrayList();
        for (;;)
        {
          String str;
          aocy localaocy;
          synchronized (GroupIconHelper.a(this.this$0))
          {
            Iterator localIterator = GroupIconHelper.a(this.this$0).keySet().iterator();
            if (!localIterator.hasNext()) {
              break;
            }
            str = (String)localIterator.next();
            localaocy = (aocy)GroupIconHelper.a(this.this$0).get(str);
            if ((localaocy != null) && (localaocy.jdField_b_of_type_Int >= 8))
            {
              if ((GroupIconHelper.a(this.this$0) instanceof anks)) {
                ((anks)GroupIconHelper.a(this.this$0)).a(false, true, str);
              }
              if (!QLog.isColorLevel()) {
                continue;
              }
              QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + str + ",crateIconCount=" + localaocy.jdField_b_of_type_Int);
            }
          }
          if ((localaocy != null) && (!localaocy.e))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + str + ",fromCreate is false");
            }
          }
          else if ((localaocy != null) && (localaocy.jdField_a_of_type_JavaLangString != null) && (localaocy.jdField_a_of_type_Byte != 3)) {
            i = a(i, l, (ArrayList)localObject2, localArrayList2, str, localaocy);
          }
        }
        int j;
        if ((this.a) && (localObject2 != null))
        {
          j = 0;
          while ((j < ((ArrayList)localObject2).size()) && (this.a))
          {
            ??? = (Pair)((ArrayList)localObject2).get(j);
            GroupIconHelper.a(this.this$0, (String)((Pair)???).first, (aocy)((Pair)???).second, true);
            j += 1;
          }
        }
        if ((this.a) && (localArrayList2 != null))
        {
          j = 0;
          while ((j < localArrayList2.size()) && (this.a))
          {
            localObject2 = (String)localArrayList2.get(j);
            this.this$0.b((String)localObject2);
            j += 1;
          }
        }
        if (i != 0) {
          break label502;
        }
      }
      synchronized (GroupIconHelper.a(this.this$0))
      {
        GroupIconHelper.a(this.this$0, null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.a);
        }
        return;
        label502:
        if (!this.a) {}
      }
    }
    try
    {
      label542:
      synchronized (GroupIconHelper.a(this.this$0))
      {
        GroupIconHelper.a(this.this$0).wait(GroupIconHelper.a(this.this$0) / 10);
      }
      localObject4 = finally;
      throw localObject4;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label542;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.CheckDisIconThread
 * JD-Core Version:    0.7.0.1
 */