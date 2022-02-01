package com.tencent.mobileqq.activity.home;

import android.os.Handler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;

class Conversation$42
  extends CardObserver
{
  Conversation$42(Conversation paramConversation) {}
  
  protected void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" conversation onGetCalReactiveDays isAllow= ");
        localStringBuilder.append(paramBoolean2);
        QLog.d("interactive", 2, localStringBuilder.toString());
      }
      this.a.a(0L);
    }
  }
  
  public void onGetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onGetNotDisturb(paramBoolean, paramString1, paramString2);
    Conversation.a(this.a.A, this.a.P());
  }
  
  protected void onGreetingRecv(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.s().getCurrentAccountUin().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.LBS_HELLO_UIN, 1001);
    }
  }
  
  protected void onSetNick(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      Conversation.a(this.a, "onSetNick", paramString);
    }
  }
  
  protected void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_conversation".equals(paramString2))
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("onSetNotDisturb NOT FROM THIS");
        paramString1.append(paramString2);
        QLog.d("Q.recent", 4, paramString1.toString());
      }
      return;
    }
    if (!paramBoolean)
    {
      ThreadManagerV2.getUIHandlerV2().post(new Conversation.42.1(this));
      return;
    }
    Conversation.a(this.a.A, this.a.P());
    if (!FriendsStatusUtil.a(this.a.P())) {
      ThreadManagerV2.getUIHandlerV2().post(new Conversation.42.2(this));
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Conversation.onUpdateAvatar: uin:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", success :");
      localStringBuilder.append(paramBoolean);
      QLog.d("Q.recent", 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.aF != null) && (Utils.a(paramString, this.a.s().getCurrentAccountUin()))) {
      this.a.Y.q.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.42
 * JD-Core Version:    0.7.0.1
 */