package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.adapter.AvatarPendantAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import java.util.List;

class AvatarPendantActivity$19$1
  implements Runnable
{
  AvatarPendantActivity$19$1(AvatarPendantActivity.19 param19) {}
  
  public void run()
  {
    if (this.a.a.B == null) {
      return;
    }
    Object localObject = (AvatarPendantManager)this.a.a.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER);
    if (localObject == null) {
      return;
    }
    localObject = ((AvatarPendantManager)localObject).f();
    this.a.a.B.a((List)localObject, this.a.a.aj, AvatarPendantActivity.c(this.a.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.19.1
 * JD-Core Version:    0.7.0.1
 */