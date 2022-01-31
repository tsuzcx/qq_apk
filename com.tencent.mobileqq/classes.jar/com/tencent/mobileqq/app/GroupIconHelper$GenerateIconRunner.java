package com.tencent.mobileqq.app;

import ajjt;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicInteger;

class GroupIconHelper$GenerateIconRunner
  implements Runnable
{
  private int jdField_a_of_type_Int = 2;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  
  public GroupIconHelper$GenerateIconRunner(GroupIconHelper paramGroupIconHelper, int paramInt, String paramString)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (GroupIconHelper.a(paramString))
    {
      this.jdField_a_of_type_JavaLangString = GroupIconHelper.b(paramString);
      this.jdField_a_of_type_Boolean = true;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    ajjt localajjt1;
    label56:
    Object localObject3;
    do
    {
      return;
      localajjt1 = (ajjt)GroupIconHelper.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if (!this.jdField_a_of_type_Boolean) {
        break;
      }
      localajjt1 = (ajjt)GroupIconHelper.a(this.this$0).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      if ((localajjt1 == null) && (this.jdField_a_of_type_Int != 3)) {
        break label1047;
      }
      localObject3 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      switch (this.jdField_a_of_type_Int)
      {
      default: 
        return;
      case 1: 
        localajjt1 = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, localajjt1, false);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localajjt1.jdField_a_of_type_Boolean);
        }
        break;
      }
    } while (!localajjt1.jdField_a_of_type_Boolean);
    Object localObject2;
    label247:
    String[] arrayOfString;
    int j;
    int i;
    if (localajjt1.c)
    {
      GroupIconHelper.a(this.this$0, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      return;
      localObject2 = this.jdField_a_of_type_JavaLangString;
      if (localajjt1 == null) {
        break label1043;
      }
      try
      {
        if (localajjt1.jdField_a_of_type_JavaLangString != null) {
          break label1043;
        }
        localajjt1 = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, false, localajjt1, true);
        if (localajjt1 == null)
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.jdField_a_of_type_JavaLangString);
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + " ,isSyncFace=" + localajjt2.jdField_b_of_type_Boolean + ", faceUinSet=" + localajjt2.jdField_a_of_type_JavaLangString);
      }
      localajjt2.e = true;
      if (!localajjt2.jdField_b_of_type_Boolean)
      {
        localajjt2.jdField_b_of_type_Boolean = true;
        localajjt2.jdField_a_of_type_JavaUtilArrayList.clear();
        if ((localajjt2.jdField_a_of_type_JavaLangString != null) && (localajjt2.jdField_a_of_type_JavaLangString.length() > 1))
        {
          arrayOfString = localajjt2.jdField_a_of_type_JavaLangString.split(";");
          if (arrayOfString != null)
          {
            j = arrayOfString.length;
            i = 0;
          }
        }
      }
    }
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        if ((str != null) && (str.length() != 0)) {
          if (!((QQAppInterface)localObject3).a(1, str, 0)) {
            ((FriendListHandler)((QQAppInterface)localObject3).a(1)).a(str, (byte)0, (byte)2);
          } else {
            localajjt2.jdField_a_of_type_JavaUtilArrayList.add(str);
          }
        }
      }
      else
      {
        try
        {
          QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + localajjt2.toString());
          if ((localajjt2.jdField_a_of_type_Byte == 2) && (localajjt2.jdField_b_of_type_JavaLangString != null))
          {
            localObject3 = GroupIconHelper.a(localajjt2.jdField_a_of_type_JavaUtilArrayList, false);
            if (localajjt2.jdField_b_of_type_JavaLangString.equals(localObject3)) {
              return;
            }
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", localException);
            }
          }
          i = localajjt2.jdField_a_of_type_JavaUtilArrayList.size();
          if ((i >= localajjt2.jdField_a_of_type_Int) || ((localajjt2.jdField_a_of_type_Byte == 1) && (i >= 4) && (localajjt2.jdField_a_of_type_Int > 4)) || ((localajjt2.jdField_a_of_type_Byte == 2) && (i > 0)) || (localajjt2.d))
          {
            GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, localajjt2, false);
            if (i >= localajjt2.jdField_a_of_type_Int) {
              GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
            }
          }
          if ((i < localajjt2.jdField_a_of_type_Int) && (GroupIconHelper.a(this.this$0) == null)) {}
          synchronized (GroupIconHelper.a(this.this$0))
          {
            if (GroupIconHelper.a(this.this$0) == null)
            {
              GroupIconHelper.a(this.this$0, new GroupIconHelper.CheckDisIconThread(this.this$0, null));
              ThreadManager.post(GroupIconHelper.a(this.this$0), 8, null, false);
            }
            return;
          }
        }
        GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
        return;
        ??? = new ajjt(this.this$0, null);
        ??? = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, (ajjt)???, true);
        boolean bool;
        if (((ajjt)???).jdField_a_of_type_Boolean) {
          if (GroupIconHelper.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
          {
            this.this$0.d(this.jdField_a_of_type_JavaLangString);
            this.this$0.a(this.jdField_a_of_type_JavaLangString);
            bool = true;
          }
        }
        while (QLog.isColorLevel())
        {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + ((ajjt)???).jdField_a_of_type_Boolean + ", isCreated=" + bool);
          return;
          localObject2 = new File(localObject4.a(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0));
          if ((localObject2 != null) && (((File)localObject2).exists())) {
            ((File)localObject2).delete();
          }
          if (localObject4 != null) {
            localObject4.a(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0);
          }
          GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
          continue;
          GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
          bool = false;
        }
        break;
        label1043:
        break label247;
        break label56;
        label1047:
        break;
      }
      i += 1;
    }
  }
  
  public void run()
  {
    a();
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    GroupIconHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.GroupIconHelper.GenerateIconRunner
 * JD-Core Version:    0.7.0.1
 */