package com.tencent.mobileqq.activity.aio.rebuild;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class LimitChatPie$4
  extends AvatarObserver
{
  LimitChatPie$4(LimitChatPie paramLimitChatPie) {}
  
  public void onUpdateApolloHead(boolean paramBoolean, String paramString, int paramInt)
  {
    if ((this.a.a != null) && (TextUtils.equals(paramString, this.a.a.getCurrentAccountUin()))) {
      this.a.g(65536);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.4
 * JD-Core Version:    0.7.0.1
 */