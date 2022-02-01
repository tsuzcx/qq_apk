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
import mqq.app.MobileQQ;

class GroupIconHelper$GenerateIconRunner
  implements Runnable
{
  private int a = 2;
  private String b;
  private boolean c = false;
  
  public GroupIconHelper$GenerateIconRunner(GroupIconHelper paramGroupIconHelper, int paramInt, String paramString)
  {
    this.a = paramInt;
    this.b = paramString;
    if (GroupIconHelper.i(paramString))
    {
      this.b = GroupIconHelper.h(paramString);
      this.c = true;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    GroupIconHelper.GroupIconInfo localGroupIconInfo = new GroupIconHelper.GroupIconInfo(this.this$0, null);
    localGroupIconInfo = GroupIconHelper.a(this.this$0, this.b, true, localGroupIconInfo, true, false);
    boolean bool1 = localGroupIconInfo.a;
    boolean bool2 = false;
    if (bool1)
    {
      if (GroupIconHelper.b(this.this$0).containsKey(this.b))
      {
        this.this$0.d(this.b);
        this.this$0.a(this.b);
        bool1 = true;
      }
      else
      {
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          File localFile = new File(paramQQAppInterface.getCustomFaceFilePath(this.this$0.a, this.b, 0));
          if (localFile.exists()) {
            localFile.delete();
          }
          paramQQAppInterface.removeFaceIconCache(this.this$0.a, this.b, 0);
          GroupIconHelper.c(this.this$0).remove(this.b);
          bool1 = bool2;
        }
      }
    }
    else
    {
      GroupIconHelper.c(this.this$0).remove(this.b);
      bool1 = bool2;
    }
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("refreshDisIcon: ");
      paramQQAppInterface.append(this.b);
      paramQQAppInterface.append(", isChanged=");
      paramQQAppInterface.append(localGroupIconInfo.a);
      paramQQAppInterface.append(", isCreated=");
      paramQQAppInterface.append(bool1);
      QLog.d("Q.qqhead.dih", 2, paramQQAppInterface.toString());
    }
  }
  
  private void a(GroupIconHelper.GroupIconInfo paramGroupIconInfo)
  {
    paramGroupIconInfo = GroupIconHelper.a(this.this$0, this.b, true, paramGroupIconInfo, false);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CheckAndCreateDisIcon Done: ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", isChanged=");
      localStringBuilder.append(paramGroupIconInfo.a);
      QLog.d("Q.qqhead.dih", 2, localStringBuilder.toString());
    }
    if (paramGroupIconInfo.a)
    {
      if (paramGroupIconInfo.j)
      {
        GroupIconHelper.a(this.this$0, GroupIconHelper.g(this.b));
        return;
      }
      GroupIconHelper.a(this.this$0, this.b);
    }
  }
  
  private void a(GroupIconHelper.GroupIconInfo arg1, int paramInt)
  {
    if ((paramInt >= ???.f) || ((???.b == 1) && (paramInt >= 4) && (???.f > 4)) || ((???.b == 2) && (paramInt > 0)) || (???.k))
    {
      GroupIconHelper.a(this.this$0, this.b, ???, false);
      if (paramInt >= ???.f) {
        GroupIconHelper.c(this.this$0).remove(this.b);
      }
    }
    if ((paramInt < ???.f) && (GroupIconHelper.d(this.this$0) == null)) {
      synchronized (GroupIconHelper.e(this.this$0))
      {
        if (GroupIconHelper.d(this.this$0) == null)
        {
          GroupIconHelper.a(this.this$0, new GroupIconHelper.CheckDisIconThread(this.this$0, null));
          ThreadManager.post(GroupIconHelper.d(this.this$0), 8, null, false);
        }
        return;
      }
    }
  }
  
  private void a(GroupIconHelper.GroupIconInfo paramGroupIconInfo, QQAppInterface paramQQAppInterface)
  {
    paramGroupIconInfo.l = true;
    if (!paramGroupIconInfo.c)
    {
      paramGroupIconInfo.c = true;
      paramGroupIconInfo.i.clear();
      if ((paramGroupIconInfo.e != null) && (paramGroupIconInfo.e.length() > 1))
      {
        String[] arrayOfString = paramGroupIconInfo.e.split(";");
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
                paramGroupIconInfo.i.add(str);
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
      paramQQAppInterface.append(MobileQQ.getShortUinStr(this.b));
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
    if (this.b == null) {
      return;
    }
    Object localObject1 = (GroupIconHelper.GroupIconInfo)GroupIconHelper.b(this.this$0).get(this.b);
    if (this.c) {
      localObject1 = (GroupIconHelper.GroupIconInfo)GroupIconHelper.b(this.this$0).get(GroupIconHelper.g(this.b));
    }
    if ((localObject1 == null) && (this.a != 3)) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    int i = this.a;
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
      str = this.b;
      localObject3 = localObject1;
      if (localObject1 != null) {
        localObject3 = localObject1;
      }
    }
    try
    {
      if (((GroupIconHelper.GroupIconInfo)localObject1).e == null) {
        localObject3 = GroupIconHelper.a(this.this$0, this.b, false, (GroupIconHelper.GroupIconInfo)localObject1, true);
      }
      if (localObject3 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TYPE_CREAT. iconinfo is null, disUin=");
        ((StringBuilder)localObject1).append(this.b);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("TYPE_CREAT. disUin=");
        ((StringBuilder)localObject1).append(this.b);
        ((StringBuilder)localObject1).append(" ,isSyncFace=");
        ((StringBuilder)localObject1).append(((GroupIconHelper.GroupIconInfo)localObject3).c);
        ((StringBuilder)localObject1).append(", faceUinSet=");
        ((StringBuilder)localObject1).append(((GroupIconHelper.GroupIconInfo)localObject3).e);
        QLog.d("Q.qqhead.dih", 2, ((StringBuilder)localObject1).toString());
      }
      a((GroupIconHelper.GroupIconInfo)localObject3, localQQAppInterface);
      if ((((GroupIconHelper.GroupIconInfo)localObject3).b == 2) && (((GroupIconHelper.GroupIconInfo)localObject3).h != null))
      {
        localObject1 = GroupIconHelper.a(((GroupIconHelper.GroupIconInfo)localObject3).i, false);
        if (((GroupIconHelper.GroupIconInfo)localObject3).h.equals(localObject1)) {
          return;
        }
      }
      a((GroupIconHelper.GroupIconInfo)localObject3, ((GroupIconHelper.GroupIconInfo)localObject3).i.size());
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
    this.this$0.c.decrementAndGet();
    GroupIconHelper.a(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper.GenerateIconRunner
 * JD-Core Version:    0.7.0.1
 */