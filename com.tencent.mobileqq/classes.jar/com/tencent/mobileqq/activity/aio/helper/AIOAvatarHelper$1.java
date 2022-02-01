package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.extendfriend.apollo.aio.AioApolloHelper;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;

class AIOAvatarHelper$1
  extends AvatarObserver
{
  AIOAvatarHelper$1(AIOAvatarHelper paramAIOAvatarHelper) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOAvatarHelper", 2, "onUpdateCustomHead isSuccess: " + paramBoolean + "uin: " + paramString);
    }
    if (paramString == null) {
      return;
    }
    if (AioApolloHelper.a(AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a)))
    {
      AioApolloHelper.a(AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a).a, Collections.singletonList(paramString));
      return;
    }
    AvatarLayout.a(AIOAvatarHelper.a(this.a), AIOAvatarHelper.a(this.a).a, Collections.singletonList(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOAvatarHelper.1
 * JD-Core Version:    0.7.0.1
 */