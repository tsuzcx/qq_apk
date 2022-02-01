package com.tencent.mobileqq.app.face;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
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
  private boolean jdField_a_of_type_Boolean = false;
  
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
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    GroupIconHelper.GroupIconInfo localGroupIconInfo = new GroupIconHelper.GroupIconInfo(this.this$0, null);
    localGroupIconInfo = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, localGroupIconInfo, true, false);
    boolean bool1 = localGroupIconInfo.jdField_a_of_type_Boolean;
    boolean bool2 = false;
    if (bool1)
    {
      if (GroupIconHelper.a(this.this$0).containsKey(this.jdField_a_of_type_JavaLangString))
      {
        this.this$0.d(this.jdField_a_of_type_JavaLangString);
        this.this$0.a(this.jdField_a_of_type_JavaLangString);
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          File localFile = new File(paramQQAppInterface.getCustomFaceFilePath(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0));
          if (localFile.exists()) {
            localFile.delete();
          }
          paramQQAppInterface.removeFaceIconCache(this.this$0.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, 0);
          GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
          bool1 = bool2;
        }
      }
    }
    else
    {
      GroupIconHelper.a(this.this$0).remove(this.jdField_a_of_type_JavaLangString);
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("refreshDisIcon: ");
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.append(", isChanged=");
      paramQQAppInterface.append(localGroupIconInfo.jdField_a_of_type_Boolean);
      paramQQAppInterface.append(", isCreated=");
      paramQQAppInterface.append(bool1);
      QLog.d("Q.qqhead.dih", 2, paramQQAppInterface.toString());
    }
  }
  
  private void a(GroupIconHelper.GroupIconInfo paramGroupIconInfo)
  {
    paramGroupIconInfo = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, true, paramGroupIconInfo, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckAndCreateDisIcon Done: ");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
      localStringBuilder.append(", isChanged=");
      localStringBuilder.append(paramGroupIconInfo.jdField_a_of_type_Boolean);
      QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
    }
    if (paramGroupIconInfo.jdField_a_of_type_Boolean)
    {
      if (paramGroupIconInfo.c)
      {
        GroupIconHelper.a(this.this$0, GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
        return;
      }
      GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    }
  }
  
  private void a(GroupIconHelper.GroupIconInfo arg1, int paramInt)
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
  
  private void a(GroupIconHelper.GroupIconInfo paramGroupIconInfo, QQAppInterface paramQQAppInterface)
  {
    paramGroupIconInfo.e = true;
    if (!paramGroupIconInfo.jdField_b_of_type_Boolean)
    {
      paramGroupIconInfo.jdField_b_of_type_Boolean = true;
      paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.clear();
      if ((paramGroupIconInfo.jdField_a_of_type_JavaLangString != null) && (paramGroupIconInfo.jdField_a_of_type_JavaLangString.length() > 1))
      {
        String[] arrayOfString = paramGroupIconInfo.jdField_a_of_type_JavaLangString.split(";");
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            String str = arrayOfString[i];
            if ((str != null) && (str.length() != 0)) {
              if (!paramQQAppInterface.isFaceFileExist(1, str, 0, 0)) {
                ((IQQAvatarHandlerService)paramQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).getCustomHead(str, (byte)0, (byte)2);
              } else {
                paramGroupIconInfo.jdField_a_of_type_JavaUtilArrayList.add(str);
              }
            }
            i += 1;
          }
        }
      }
    }
    try
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("TYPE_CREAT. disUin=");
      paramQQAppInterface.append(this.jdField_a_of_type_JavaLangString);
      paramQQAppInterface.append(paramGroupIconInfo.toString());
      QLog.d("Q.qqhead.dih", 1, paramQQAppInterface.toString());
      return;
    }
    catch (Exception paramGroupIconInfo)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", paramGroupIconInfo);
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {
      return;
    }
    Object localObject1 = (GroupIconHelper.GroupIconInfo)GroupIconHelper.a(this.this$0).get(this.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {
      localObject1 = (GroupIconHelper.GroupIconInfo)GroupIconHelper.a(this.this$0).get(GroupIconHelper.a(this.jdField_a_of_type_JavaLangString));
    }
    if ((localObject1 == null) && (this.jdField_a_of_type_Int != 3)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = this.jdField_a_of_type_Int;
    String str;
    Object localObject3;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        a(localQQAppInterface);
        return;
      }
      str = this.jdField_a_of_type_JavaLangString;
      localObject3 = localObject1;
      if (localObject1 != null) {
        localObject3 = localObject1;
      }
    }
    try
    {
      if (((GroupIconHelper.GroupIconInfo)localObject1).jdField_a_of_type_JavaLangString == null) {
        localObject3 = GroupIconHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString, false, (GroupIconHelper.GroupIconInfo)localObject1, true);
      }
      if (localObject3 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TYPE_CREAT. iconinfo is null, disUin=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TYPE_CREAT. disUin=");
        ((StringBuilder)localObject1).append(this.jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject1).append(" ,isSyncFace=");
        ((StringBuilder)localObject1).append(((GroupIconHelper.GroupIconInfo)localObject3).jdField_b_of_type_Boolean);
        ((StringBuilder)localObject1).append(", faceUinSet=");
        ((StringBuilder)localObject1).append(((GroupIconHelper.GroupIconInfo)localObject3).jdField_a_of_type_JavaLangString);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
      }
      a((GroupIconHelper.GroupIconInfo)localObject3, localQQAppInterface);
      if ((((GroupIconHelper.GroupIconInfo)localObject3).jdField_a_of_type_Byte == 2) && (((GroupIconHelper.GroupIconInfo)localObject3).jdField_b_of_type_JavaLangString != null))
      {
        localObject1 = GroupIconHelper.a(((GroupIconHelper.GroupIconInfo)localObject3).jdField_a_of_type_JavaUtilArrayList, false);
        if (((GroupIconHelper.GroupIconInfo)localObject3).jdField_b_of_type_JavaLangString.equals(localObject1)) {
          return;
        }
      }
      a((GroupIconHelper.GroupIconInfo)localObject3, ((GroupIconHelper.GroupIconInfo)localObject3).jdField_a_of_type_JavaUtilArrayList.size());
      return;
    }
    finally
    {
      label324:
      break label324;
    }
    throw ((Throwable)localObject1);
    a((GroupIconHelper.GroupIconInfo)localObject1);
  }
  
  public void run()
  {
    a();
    this.this$0.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.decrementAndGet();
    GroupIconHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.GenerateIconRunner
 * JD-Core Version:    0.7.0.1
 */