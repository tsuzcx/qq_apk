package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

class ArkFlashChatContainerWrapper$2$1
  implements Runnable
{
  ArkFlashChatContainerWrapper$2$1(ArkFlashChatContainerWrapper.2 param2, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    Object localObject;
    int i;
    if (this.a)
    {
      localObject = this.b;
      if (localObject != null)
      {
        i = ((Bundle)localObject).getInt("resourceId");
        if ((i != -1) && (this.c.a.b == i))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onDownloadRes onSuccess resouceId ");
            ((StringBuilder)localObject).append(i);
            QLog.d("ArkApp", 2, ((StringBuilder)localObject).toString());
          }
          localObject = ArkAppContainer.f();
          if (localObject != null)
          {
            localObject = (FlashChatManager)((QQAppInterface)localObject).getManager(QQManagerFactory.FLASH_CHAT_MANAGER);
            ArkFlashChatContainerWrapper.e(this.c.a).path = ((FlashChatManager)localObject).a(this.c.a.b, ArkFlashChatContainerWrapper.f(this.c.a).name, ArkFlashChatContainerWrapper.g(this.c.a).appMinVersion);
            this.c.a.a(ArkFlashChatContainerWrapper.h(this.c.a).path, 0, null);
          }
        }
      }
    }
    else
    {
      localObject = this.b;
      if (localObject != null)
      {
        i = ((Bundle)localObject).getInt("resourceId");
        if ((i != -1) && (this.c.a.b == i))
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onDownloadRes onError resouceId ");
            ((StringBuilder)localObject).append(i);
            QLog.d("ArkApp.ArkAioContainerWrapper", 2, ((StringBuilder)localObject).toString());
          }
          this.c.a.a(ArkFlashChatContainerWrapper.i(this.c.a).path, -2, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2.1
 * JD-Core Version:    0.7.0.1
 */