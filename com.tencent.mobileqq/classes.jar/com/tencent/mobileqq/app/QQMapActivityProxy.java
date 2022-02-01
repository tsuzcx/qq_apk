package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AccountNotMatchException;

public class QQMapActivityProxy
{
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new QQMapActivityProxy.1(this);
  private Context jdField_a_of_type_AndroidContentContext;
  private LBSObserver jdField_a_of_type_ComTencentMobileqqAppLBSObserver = new QQMapActivityProxy.2(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public QQMapActivityProxy(String paramString)
  {
    try
    {
      this.jdField_a_of_type_AndroidContentContext = BaseApplication.getContext();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString));
    }
    catch (AccountNotMatchException paramString)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("AccountNotMatchException ");
        localStringBuilder.append(paramString.toString());
        QLog.d("QQMapActivityProxy", 2, localStringBuilder.toString());
      }
    }
    paramString = new IntentFilter();
    paramString.addAction("com.tencent.mobileqq.addLbsObserver");
    paramString.addAction("com.tencent.mobileqq.removeLbsObserver");
    paramString.addAction("com.tencent.mobileqq.getStreetViewUrl");
    paramString.addAction("com.tencent.mobileqq.unregisterReceiver");
    paramString.addAction("com.tencent.mobileqq.getLbsShareSearch");
    paramString.addAction("com.tencent.mobileqq.getLbsShareShop");
    paramString.addAction("com.tencent.mobileqq.getShareShopDetail");
    this.jdField_a_of_type_AndroidContentContext.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("QQMapActivityProxy-create, registerReceiver:");
      paramString.append(hashCode());
      paramString.append(", ");
      paramString.append(this.jdField_a_of_type_AndroidContentBroadcastReceiver.hashCode());
      QLog.d("QQMapActivityProxy", 2, paramString.toString());
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onDestory,  hashCode=");
      ((StringBuilder)localObject).append(hashCode());
      QLog.d("QQMapActivityProxy", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppLBSObserver);
    }
    try
    {
      this.jdField_a_of_type_AndroidContentContext.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDestory, mBroadcastReceiver throw an exception when receive UNREGISTER_RECEIVER : ");
        localStringBuilder.append(localException.toString());
        QLog.w("QQMapActivityProxy", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMapActivityProxy
 * JD-Core Version:    0.7.0.1
 */