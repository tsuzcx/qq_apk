package com.tencent.mobileqq.activity.home;

import android.os.Handler;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class Conversation$30
  extends AvatarObserver
{
  Conversation$30(Conversation paramConversation) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, " Conversation.onUpdateCustomHead: uin:" + paramString + ", success :" + paramBoolean);
    }
    if (!paramBoolean) {
      return;
    }
    if (!Utils.a(paramString, this.a.a().getCurrentAccountUin()))
    {
      this.a.b(new Conversation.30.2(this, paramString));
      return;
    }
    this.a.a.a.sendEmptyMessage(3);
  }
  
  public void onUpdateTroopHead(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.a.b(new Conversation.30.1(this, paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.30
 * JD-Core Version:    0.7.0.1
 */