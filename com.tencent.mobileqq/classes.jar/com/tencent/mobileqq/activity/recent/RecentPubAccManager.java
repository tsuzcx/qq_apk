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
  private Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean = false;
  
  public RecentPubAccManager()
  {
    a();
  }
  
  public static RecentPubAccManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccManager == null) {
          jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccManager = new RecentPubAccManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqActivityRecentRecentPubAccManager;
  }
  
  private void a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_Boolean = SharedPreUtils.o(((QQAppInterface)localObject).getApp(), ((QQAppInterface)localObject).getCurrentUin());
    BaseApplication localBaseApplication = ((QQAppInterface)localObject).getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("RecentPubAccManager");
    localStringBuilder.append(((QQAppInterface)localObject).getCurrentAccountUin());
    this.jdField_a_of_type_JavaUtilSet = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getStringSet("white_list_key", null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("loadFromSp   mBlackUinList:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilSet);
      ((StringBuilder)localObject).append(",  Switch: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Boolean);
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
      this.jdField_a_of_type_JavaUtilSet = paramSet;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    SharedPreUtils.h(paramQQAppInterface.getApp(), paramQQAppInterface.getCurrentAccountUin(), paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(String paramString)
  {
    Set localSet = this.jdField_a_of_type_JavaUtilSet;
    return (localSet != null) && (localSet.contains(paramString));
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccManager
 * JD-Core Version:    0.7.0.1
 */