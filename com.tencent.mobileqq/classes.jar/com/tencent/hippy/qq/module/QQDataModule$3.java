package com.tencent.hippy.qq.module;

import android.content.Intent;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.subscribe.event.FollowUpdateEvent;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class QQDataModule$3
  extends IPublicAccountObserver.OnCallback
{
  QQDataModule$3(QQDataModule paramQQDataModule, Promise paramPromise) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    this.val$promise.resolve(Integer.valueOf(paramBoolean ^ true));
    try
    {
      localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
      ((Intent)localObject).putExtra("action", "follow");
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(1, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onFollowPublicAccount sendBroadcast failed! ");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
      QLog.e("QQDataModule", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onUnfollowPublicAccount(paramBoolean, paramString);
    this.val$promise.resolve(Integer.valueOf(paramBoolean ^ true));
    try
    {
      localObject = new Intent("com.tencent.mobileqq.PublicAccountObserver");
      ((Intent)localObject).putExtra("action", "unFollow");
      ((Intent)localObject).putExtra("isSuccess", paramBoolean);
      ((Intent)localObject).putExtra("uin", paramString);
      BaseApplicationImpl.getContext().sendBroadcast((Intent)localObject);
      SimpleEventBus.getInstance().dispatchEvent(new FollowUpdateEvent(0, paramString));
      return;
    }
    catch (Throwable paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onUnfollowPublicAccount sendBroadcast failed! ");
      ((StringBuilder)localObject).append(QLog.getStackTraceString(paramString));
      QLog.e("QQDataModule", 2, ((StringBuilder)localObject).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQDataModule.3
 * JD-Core Version:    0.7.0.1
 */