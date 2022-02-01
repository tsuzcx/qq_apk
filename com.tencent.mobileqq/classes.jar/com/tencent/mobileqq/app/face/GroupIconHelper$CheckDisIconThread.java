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
      Object localObject = (GroupIconHelper.GroupIconInfo)GroupIconHelper.a(this.this$0).get(str);
      if ((localObject != null) && (((GroupIconHelper.GroupIconInfo)localObject).jdField_b_of_type_Int >= 8))
      {
        if ((GroupIconHelper.a(this.this$0) instanceof DiscussionHandler)) {
          ((DiscussionHandler)GroupIconHelper.a(this.this$0)).a(false, true, str);
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("CheckDisIcon, maxCreateCnt: ");
          localStringBuilder.append(str);
          localStringBuilder.append(",crateIconCount=");
          localStringBuilder.append(((GroupIconHelper.GroupIconInfo)localObject).jdField_b_of_type_Int);
          QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
        }
      }
      else if ((localObject != null) && (!((GroupIconHelper.GroupIconInfo)localObject).e))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("CheckDisIcon isFromCreate: ");
          ((StringBuilder)localObject).append(str);
          ((StringBuilder)localObject).append(",fromCreate is false");
          QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject).toString());
        }
      }
      else if ((localObject != null) && (((GroupIconHelper.GroupIconInfo)localObject).jdField_a_of_type_JavaLangString != null) && (((GroupIconHelper.GroupIconInfo)localObject).jdField_a_of_type_Byte != 3))
      {
        paramInt = a(paramInt, paramLong, paramArrayList, paramArrayList1, str, (GroupIconHelper.GroupIconInfo)localObject);
      }
    }
    return paramInt;
  }
  
  private int a(int paramInt, long paramLong, ArrayList<Pair<String, GroupIconHelper.GroupIconInfo>> paramArrayList, ArrayList<String> paramArrayList1, String paramString, GroupIconHelper.GroupIconInfo paramGroupIconInfo)
  {
    if ((paramGroupIconInfo.jdField_a_of_type_Byte == 1) && (paramLong - paramGroupIconInfo.jdField_a_of_type_Long >= GroupIconHelper.a(this.this$0)))
    {
      paramArrayList1 = paramString;
      if (GroupIconHelper.a(paramString)) {
        paramArrayList1 = GroupIconHelper.b(paramString);
      }
      i = paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.size();
      paramGroupIconInfo.jdField_a_of_type_Byte = 2;
      boolean bool2 = false;
      boolean bool1 = false;
      if (i > 0)
      {
        if (paramGroupIconInfo.jdField_b_of_type_JavaLangString != null)
        {
          paramString = GroupIconHelper.a(paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList, false);
          if (paramGroupIconInfo.jdField_b_of_type_JavaLangString.equals(paramString)) {}
        }
        else
        {
          bool1 = true;
        }
        bool2 = bool1;
        if (bool1)
        {
          paramArrayList.add(Pair.create(paramArrayList1, paramGroupIconInfo));
          GroupIconHelper.a(this.this$0).remove(paramArrayList1);
          bool2 = bool1;
        }
      }
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("CheckDisIcon expired: ");
        paramArrayList.append(paramArrayList1);
        paramArrayList.append(", isTryCreate: ");
        paramArrayList.append(bool2);
        paramArrayList.append(paramGroupIconInfo.toString());
        QLog.d("Q.qqhead.dih", 2, paramArrayList.toString());
      }
    }
    else if ((paramGroupIconInfo.jdField_a_of_type_Byte == 2) && (paramLong - paramGroupIconInfo.jdField_a_of_type_Long >= GroupIconHelper.b(this.this$0)))
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("CheckDisIcon timeout: ");
        paramArrayList.append(paramString);
        paramArrayList.append(paramGroupIconInfo.toString());
        QLog.d("Q.qqhead.dih", 2, paramArrayList.toString());
      }
      paramArrayList1.add(paramString);
    }
    else
    {
      i = paramInt;
      if (paramGroupIconInfo.jdField_a_of_type_Byte == 3) {
        break label332;
      }
    }
    int i = paramInt + 1;
    label332:
    return i;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
    }
    while (this.a)
    {
      long l = System.currentTimeMillis();
      Object localObject4 = new ArrayList();
      ??? = new ArrayList();
      synchronized (GroupIconHelper.a(this.this$0))
      {
        int k = a(0, l, (ArrayList)localObject4, (ArrayList)???);
        boolean bool = this.a;
        int j = 0;
        int i;
        if (bool)
        {
          i = 0;
          while ((i < ((ArrayList)localObject4).size()) && (this.a))
          {
            ??? = (Pair)((ArrayList)localObject4).get(i);
            GroupIconHelper.a(this.this$0, (String)((Pair)???).first, (GroupIconHelper.GroupIconInfo)((Pair)???).second, true);
            i += 1;
          }
        }
        if (this.a)
        {
          i = j;
          while ((i < ((ArrayList)???).size()) && (this.a))
          {
            localObject4 = (String)((ArrayList)???).get(i);
            this.this$0.b((String)localObject4);
            i += 1;
          }
        }
        if ((k == 0) || (this.a)) {}
        try
        {
          synchronized (GroupIconHelper.a(this.this$0))
          {
            GroupIconHelper.a(this.this$0).wait(GroupIconHelper.a(this.this$0) / 10);
          }
        }
        catch (InterruptedException localInterruptedException)
        {
          label251:
          break label251;
        }
        continue;
        throw localObject5;
      }
    }
    synchronized (GroupIconHelper.a(this.this$0))
    {
      GroupIconHelper.a(this.this$0, null);
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("CheckDisIconThread exit. isRunning=");
        ((StringBuilder)???).append(this.a);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)???).toString());
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.CheckDisIconThread
 * JD-Core Version:    0.7.0.1
 */