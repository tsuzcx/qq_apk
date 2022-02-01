package com.tencent.mobileqq.app.face;

import aopk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
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
  
  private void a(aopk paramaopk)
  {
    paramaopk = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, paramaopk, false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + paramaopk.jdField_a_of_type_Boolean);
    }
    if (paramaopk.jdField_a_of_type_Boolean)
    {
      if (paramaopk.c) {
        GroupIconHelper.a(this.this$0, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    else {
      return;
    }
    GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(aopk arg1, int paramInt)
  {
    if ((paramInt >= ???.jdField_a_of_type_Int) || ((???.jdField_a_of_type_Byte == 1) && (paramInt >= 4) && (???.jdField_a_of_type_Int > 4)) || ((???.jdField_a_of_type_Byte == 2) && (paramInt > 0)) || (???.d))
    {
      GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, ???, false);
      if (paramInt >= ???.jdField_a_of_type_Int) {
        GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      }
    }
    if ((paramInt < ???.jdField_a_of_type_Int) && (GroupIconHelper.a(this.this$0) == null)) {
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
  }
  
  private void a(aopk paramaopk, QQAppInterface paramQQAppInterface)
  {
    paramaopk.e = true;
    if (!paramaopk.jdField_b_of_type_Boolean)
    {
      paramaopk.jdField_b_of_type_Boolean = true;
      paramaopk.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramaopk.jdField_a_of_type_JavaLangString != null) && (paramaopk.jdField_a_of_type_JavaLangString.length() > 1))
      {
        String[] arrayOfString = paramaopk.jdField_a_of_type_JavaLangString.split(";");
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          if (i < j)
          {
            String str = arrayOfString[i];
            if ((str == null) || (str.length() == 0)) {}
            for (;;)
            {
              i += 1;
              break;
              if (!paramQQAppInterface.a(1, str, 0)) {
                ((FriendListHandler)paramQQAppInterface.a(1)).a(str, (byte)0, (byte)2);
              } else {
                paramaopk.jdField_a_of_type_JavaUtilArrayList.add(str);
              }
            }
          }
        }
      }
    }
    try
    {
      QLog.d("Q.qqhead.dih", 1, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + paramaopk.toString());
      return;
    }
    catch (Exception paramaopk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", paramaopk);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    aopk localaopk = new aopk(this.this$0, null);
    localaopk = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, localaopk, true);
    if (localaopk.jdField_a_of_type_Boolean) {
      if (GroupIconHelper.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
      {
        this.this$0.d(this.jdField_a_of_type_JavaLangString);
        this.this$0.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localaopk.jdField_a_of_type_Boolean + ", isCreated=" + bool);
      }
      return;
      File localFile = new File(paramQQAppInterface.a(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0));
      if ((localFile != null) && (localFile.exists())) {
        localFile.delete();
      }
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0);
      }
      GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      bool = false;
      continue;
      GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      bool = false;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (;;)
    {
      return;
      aopk localaopk1 = (aopk)GroupIconHelper.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {
        localaopk1 = (aopk)GroupIconHelper.a(this.this$0).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      }
      while ((localaopk1 != null) || (this.jdField_a_of_type_Int == 3))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 1: 
          a(localaopk1);
          return;
        case 2: 
          String str2 = this.jdField_a_of_type_JavaLangString;
          aopk localaopk2 = localaopk1;
          if (localaopk1 != null) {
            localaopk2 = localaopk1;
          }
          try
          {
            if (localaopk1.jdField_a_of_type_JavaLangString == null) {
              localaopk2 = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, false, localaopk1, true);
            }
            if (localaopk2 == null)
            {
              QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          finally {}
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + " ,isSyncFace=" + localaopk2.jdField_b_of_type_Boolean + ", faceUinSet=" + localaopk2.jdField_a_of_type_JavaLangString);
          }
          a(localaopk2, localQQAppInterface);
          if ((localaopk2.jdField_a_of_type_Byte == 2) && (localaopk2.jdField_b_of_type_JavaLangString != null))
          {
            String str1 = GroupIconHelper.a(localaopk2.jdField_a_of_type_JavaUtilArrayList, false);
            if (localaopk2.jdField_b_of_type_JavaLangString.equals(str1)) {
              return;
            }
          }
          a(localaopk2, localaopk2.jdField_a_of_type_JavaUtilArrayList.size());
          return;
        }
        a(localQQAppInterface);
        return;
      }
    }
  }
  
  public void run()
  {
    a();
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    GroupIconHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.GenerateIconRunner
 * JD-Core Version:    0.7.0.1
 */