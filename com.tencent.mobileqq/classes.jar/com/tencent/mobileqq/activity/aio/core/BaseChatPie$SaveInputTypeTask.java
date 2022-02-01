package com.tencent.mobileqq.activity.aio.core;

import anvk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.NoC2CExtensionInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.lang.ref.WeakReference;

public class BaseChatPie$SaveInputTypeTask
  implements Runnable
{
  private WeakReference<QQAppInterface> appWeakref;
  private Entity mInfo;
  
  public BaseChatPie$SaveInputTypeTask(Entity paramEntity, QQAppInterface paramQQAppInterface)
  {
    this.mInfo = paramEntity;
    if (paramQQAppInterface != null) {
      this.appWeakref = new WeakReference(paramQQAppInterface);
    }
  }
  
  public void run()
  {
    if (this.appWeakref == null) {}
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = (QQAppInterface)this.appWeakref.get();
      } while (localObject == null);
      localObject = (anvk)((QQAppInterface)localObject).getManager(QQManagerFactory.FRIENDS_MANAGER);
      if ((this.mInfo instanceof ExtensionInfo))
      {
        ((anvk)localObject).a((ExtensionInfo)this.mInfo);
        return;
      }
    } while (!(this.mInfo instanceof NoC2CExtensionInfo));
    ((anvk)localObject).a((NoC2CExtensionInfo)this.mInfo, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.SaveInputTypeTask
 * JD-Core Version:    0.7.0.1
 */