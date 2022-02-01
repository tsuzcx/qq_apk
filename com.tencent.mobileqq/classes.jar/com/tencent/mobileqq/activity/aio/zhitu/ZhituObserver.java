package com.tencent.mobileqq.activity.aio.zhitu;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

public class ZhituObserver
  implements BusinessObserver
{
  private Handler a;
  
  ZhituObserver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramInt = paramBundle.getInt("ErrorCode");
    Object localObject1 = paramBundle.getString("UniqueKey");
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("observer onReceive with code: ");
      ((StringBuilder)localObject2).append(paramInt);
      QLog.d("ZhituObserver", 2, ZhituManager.a((String)localObject1, "onReceive", ((StringBuilder)localObject2).toString()));
    }
    Object localObject2 = ZhituManager.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).d();
    if (!((String)localObject2).equals(localObject1))
    {
      if (QLog.isColorLevel())
      {
        paramBundle = new StringBuilder();
        paramBundle.append("response with ");
        paramBundle.append((String)localObject1);
        paramBundle.append(" but the last one is ");
        paramBundle.append((String)localObject2);
        paramBundle.append(", skip.");
        QLog.d("ZhituObserver", 2, ZhituManager.a((String)localObject1, "onReceive", paramBundle.toString()));
      }
      return;
    }
    localObject1 = this.a;
    if (localObject1 != null)
    {
      paramBundle = ((Handler)localObject1).obtainMessage(2, paramBundle);
      this.a.sendMessage(paramBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituObserver
 * JD-Core Version:    0.7.0.1
 */