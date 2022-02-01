package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;

class AIOAvatarHelper$1
  extends AvatarObserver
{
  AIOAvatarHelper$1(AIOAvatarHelper paramAIOAvatarHelper) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onUpdateCustomHead isSuccess: ");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append("uin: ");
      localStringBuilder.append(paramString);
      QLog.i("AIOAvatarHelper", 2, localStringBuilder.toString());
    }
    if (paramString == null) {
      return;
    }
    AvatarLayout.a(AIOAvatarHelper.a(this.a), AIOAvatarHelper.b(this.a).U, Collections.singletonList(paramString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOAvatarHelper.1
 * JD-Core Version:    0.7.0.1
 */