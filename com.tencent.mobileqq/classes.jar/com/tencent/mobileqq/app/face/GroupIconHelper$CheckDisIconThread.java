package com.tencent.mobileqq.app.face;

import android.util.Pair;
import com.tencent.mobileqq.app.DiscussionHandler;
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
  
  private int a(int paramInt, long paramLong, ArrayList<Pair<String, GroupIconHelper.GroupIconInfo>> paramArrayList, ArrayList<String> paramArrayList1)
  {
    Iterator localIterator = GroupIconHelper.a(this.this$0).keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      GroupIconHelper.GroupIconInfo localGroupIconInfo = (GroupIconHelper.GroupIconInfo)GroupIconHelper.a(this.this$0).get(str);
      if ((localGroupIconInfo != null) && (localGroupIconInfo.jdField_b_of_type_Int >= 8))
      {
        if ((GroupIconHelper.a(this.this$0) instanceof DiscussionHandler)) {
          ((DiscussionHandler)GroupIconHelper.a(this.this$0)).a(false, true, str);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + str + ",crateIconCount=" + localGroupIconInfo.jdField_b_of_type_Int);
        }
      }
      else if ((localGroupIconInfo != null) && (!localGroupIconInfo.e))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + str + ",fromCreate is false");
        }
      }
      else if ((localGroupIconInfo != null) && (localGroupIconInfo.jdField_a_of_type_JavaLangString != null) && (localGroupIconInfo.jdField_a_of_type_Byte != 3))
      {
        paramInt = a(paramInt, paramLong, paramArrayList, paramArrayList1, str, localGroupIconInfo);
      }
    }
    return paramInt;
  }
  
  private int a(int paramInt, long paramLong, ArrayList<Pair<String, GroupIconHelper.GroupIconInfo>> paramArrayList, ArrayList<String> paramArrayList1, String paramString, GroupIconHelper.GroupIconInfo paramGroupIconInfo)
  {
    boolean bool2 = false;
    boolean bool1 = false;
    int i;
    if ((paramGroupIconInfo.jdField_a_of_type_Byte == 1) && (paramLong - paramGroupIconInfo.jdField_a_of_type_Long >= GroupIconHelper.a(this.this$0)))
    {
      paramArrayList1 = paramString;
      if (GroupIconHelper.a(paramString)) {
        paramArrayList1 = GroupIconHelper.b(paramString);
      }
      i = paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.size();
      paramGroupIconInfo.jdField_a_of_type_Byte = 2;
      if (i > 0)
      {
        if (paramGroupIconInfo.jdField_b_of_type_JavaLangString == null) {
          break label299;
        }
        paramString = GroupIconHelper.a(paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList, false);
        if (!paramGroupIconInfo.jdField_b_of_type_JavaLangString.equals(paramString)) {
          break label299;
        }
      }
    }
    for (;;)
    {
      bool2 = bool1;
      if (bool1)
      {
        paramArrayList.add(Pair.create(paramArrayList1, paramGroupIconInfo));
        GroupIconHelper.a(this.this$0).remove(paramArrayList1);
        bool2 = bool1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + paramArrayList1 + ", isTryCreate: " + bool2 + paramGroupIconInfo.toString());
      }
      i = paramInt + 1;
      do
      {
        return i;
        if ((paramGroupIconInfo.jdField_a_of_type_Byte == 2) && (paramLong - paramGroupIconInfo.jdField_a_of_type_Long >= GroupIconHelper.b(this.this$0)))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + paramString + paramGroupIconInfo.toString());
          }
          paramArrayList1.add(paramString);
          return paramInt + 1;
        }
        i = paramInt;
      } while (paramGroupIconInfo.jdField_a_of_type_Byte == 3);
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
        long l = System.currentTimeMillis();
        Object localObject3 = new ArrayList();
        ArrayList localArrayList = new ArrayList();
        int j;
        int i;
        synchronized (GroupIconHelper.a(this.this$0))
        {
          j = a(0, l, (ArrayList)localObject3, localArrayList);
          if ((this.a) && (localObject3 != null))
          {
            i = 0;
            if ((i < ((ArrayList)localObject3).size()) && (this.a))
            {
              ??? = (Pair)((ArrayList)localObject3).get(i);
              GroupIconHelper.a(this.this$0, (String)((Pair)???).first, (GroupIconHelper.GroupIconInfo)((Pair)???).second, true);
              i += 1;
            }
          }
        }
        if ((this.a) && (localObject1 != null))
        {
          i = 0;
          while ((i < localObject1.size()) && (this.a))
          {
            localObject3 = (String)localObject1.get(i);
            this.this$0.b((String)localObject3);
            i += 1;
          }
        }
        if (j != 0) {
          break label269;
        }
      }
      synchronized (GroupIconHelper.a(this.this$0))
      {
        GroupIconHelper.a(this.this$0, null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.a);
        }
        return;
        label269:
        if (!this.a) {}
      }
    }
    try
    {
      label309:
      synchronized (GroupIconHelper.a(this.this$0))
      {
        GroupIconHelper.a(this.this$0).wait(GroupIconHelper.a(this.this$0) / 10);
      }
      localObject5 = finally;
      throw localObject5;
    }
    catch (InterruptedException localInterruptedException)
    {
      break label309;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.CheckDisIconThread
 * JD-Core Version:    0.7.0.1
 */