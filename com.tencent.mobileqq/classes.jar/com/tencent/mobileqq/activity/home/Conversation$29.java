package com.tencent.mobileqq.activity.home;

import android.os.Handler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class Conversation$29
  extends AvatarObserver
{
  Conversation$29(Conversation paramConversation) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" Conversation.onUpdateCustomHead: uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", success :");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.a().getCurrentAccountUin()))
    {
      this.a.b(new Conversation.29.2(this, paramString));
      return;
    }
    this.a.a.a.sendEmptyMessage(3);
  }
  
  protected void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.b(new Conversation.29.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.29
 * JD-Core Version:    0.7.0.1
 */