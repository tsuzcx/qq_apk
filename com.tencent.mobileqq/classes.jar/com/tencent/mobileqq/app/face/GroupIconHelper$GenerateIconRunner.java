package com.tencent.mobileqq.app.face;

import aokk;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
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
  
  private void a(aokk paramaokk)
  {
    paramaokk = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, paramaokk, false);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + paramaokk.jdField_a_of_type_Boolean);
    }
    if (paramaokk.jdField_a_of_type_Boolean)
    {
      if (paramaokk.c) {
        GroupIconHelper.a(this.this$0, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      }
    }
    else {
      return;
    }
    GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
  }
  
  private void a(aokk arg1, int paramInt)
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
  
  private void a(aokk paramaokk, QQAppInterface paramQQAppInterface)
  {
    paramaokk.e = true;
    if (!paramaokk.jdField_b_of_type_Boolean)
    {
      paramaokk.jdField_b_of_type_Boolean = true;
      paramaokk.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramaokk.jdField_a_of_type_JavaLangString != null) && (paramaokk.jdField_a_of_type_JavaLangString.length() > 1))
      {
        String[] arrayOfString = paramaokk.jdField_a_of_type_JavaLangString.split(";");
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
              if (!paramQQAppInterface.isFaceFileExist(1, str, 0, 0)) {
                ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getCustomHead(str, (byte)0, (byte)2);
              } else {
                paramaokk.jdField_a_of_type_JavaUtilArrayList.add(str);
              }
            }
          }
        }
      }
    }
    try
    {
      QLog.d("Q.qqhead.dih", 1, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + paramaokk.toString());
      return;
    }
    catch (Exception paramaokk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", paramaokk);
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    boolean bool = true;
    aokk localaokk = new aokk(this.this$0, null);
    localaokk = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, localaokk, true);
    if (localaokk.jdField_a_of_type_Boolean) {
      if (GroupIconHelper.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
      {
        this.this$0.d(this.jdField_a_of_type_JavaLangString);
        this.this$0.a(this.jdField_a_of_type_JavaLangString);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.jdField_a_of_type_JavaLangString + ", isChanged=" + localaokk.jdField_a_of_type_Boolean + ", isCreated=" + bool);
      }
      return;
      if (paramQQAppInterface != null)
      {
        File localFile = new File(paramQQAppInterface.getCustomFaceFilePath(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0));
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        paramQQAppInterface.removeFaceIconCache(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0);
        GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
        bool = false;
        continue;
        GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      }
      else
      {
        bool = false;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (;;)
    {
      return;
      aokk localaokk1 = (aokk)GroupIconHelper.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_Boolean) {
        localaokk1 = (aokk)GroupIconHelper.a(this.this$0).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
      }
      while ((localaokk1 != null) || (this.jdField_a_of_type_Int == 3))
      {
        QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        switch (this.jdField_a_of_type_Int)
        {
        default: 
          return;
        case 1: 
          a(localaokk1);
          return;
        case 2: 
          String str2 = this.jdField_a_of_type_JavaLangString;
          aokk localaokk2 = localaokk1;
          if (localaokk1 != null) {
            localaokk2 = localaokk1;
          }
          try
          {
            if (localaokk1.jdField_a_of_type_JavaLangString == null) {
              localaokk2 = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, false, localaokk1, true);
            }
            if (localaokk2 == null)
            {
              QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.jdField_a_of_type_JavaLangString);
              return;
            }
          }
          finally {}
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.jdField_a_of_type_JavaLangString + " ,isSyncFace=" + localaokk2.jdField_b_of_type_Boolean + ", faceUinSet=" + localaokk2.jdField_a_of_type_JavaLangString);
          }
          a(localaokk2, localQQAppInterface);
          if ((localaokk2.jdField_a_of_type_Byte == 2) && (localaokk2.jdField_b_of_type_JavaLangString != null))
          {
            String str1 = GroupIconHelper.a(localaokk2.jdField_a_of_type_JavaUtilArrayList, false);
            if (localaokk2.jdField_b_of_type_JavaLangString.equals(str1)) {
              return;
            }
          }
          a(localaokk2, localaokk2.jdField_a_of_type_JavaUtilArrayList.size());
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