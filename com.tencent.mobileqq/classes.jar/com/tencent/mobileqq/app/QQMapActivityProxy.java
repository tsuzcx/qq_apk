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
  private Context a;
  private QQAppInterface b;
  private BroadcastReceiver c = new QQMapActivityProxy.1(this);
  private LBSObserver d = new QQMapActivityProxy.2(this);
  
  public QQMapActivityProxy(String paramString)
  {
    try
    {
      this.a = BaseApplication.getContext();
      this.b = ((QQAppInterface)BaseApplicationImpl.getApplication().getAppRuntime(paramString));
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
    this.a.registerReceiver(this.c, paramString);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("QQMapActivityProxy-create, registerReceiver:");
      paramString.append(hashCode());
      paramString.append(", ");
      paramString.append(this.c.hashCode());
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
    Object localObject = this.b;
    if (localObject != null) {
      ((QQAppInterface)localObject).removeObserver(this.d);
    }
    try
    {
      this.a.unregisterReceiver(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQMapActivityProxy
 * JD-Core Version:    0.7.0.1
 */