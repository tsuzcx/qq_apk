package com.tencent.mobileqq.activity.recent;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class RecentPubAccManager
  implements Manager
{
  public static RecentPubAccManager a;
  private boolean b = false;
  private Set<String> c = new HashSet();
  
  public RecentPubAccManager()
  {
    c();
  }
  
  public static RecentPubAccManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new RecentPubAccManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return;
    }
    this.b = SharedPreUtils.bq(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getCurrentUin());
    BaseApplication localBaseApplication = ((QQAppInterface)localObject).getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentPubAccManager");
    localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
    this.c = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getStringSet("white_list_key", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFromSp   mBlackUinList:");
      ((StringBuilder)localObject).append(this.c);
      ((StringBuilder)localObject).append(",  Switch: ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("RecentPubAccManager", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Set<String> paramSet)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    try
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setUnFollowPubAccWhiteList: ");
        ((StringBuilder)localObject).append(paramSet);
        QLog.d("RecentPubAccManager", 2, ((StringBuilder)localObject).toString());
      }
      this.c = paramSet;
      Object localObject = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RecentPubAccManager");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0).edit().putStringSet("white_list_key", paramSet).apply();
      return;
    }
    finally {}
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setUnFollowPubAccSwitch: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("RecentPubAccManager", 2, localStringBuilder.toString());
    }
    this.b = paramBoolean;
    SharedPreUtils.g(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a(String paramString)
  {
    Set localSet = this.c;
    return (localSet != null) && (localSet.contains(paramString));
  }
  
  public boolean b()
  {
    return this.b;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccManager
 * JD-Core Version:    0.7.0.1
 */