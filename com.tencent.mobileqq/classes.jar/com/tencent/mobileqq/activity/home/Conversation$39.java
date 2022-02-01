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

class Conversation$39
  extends CardObserver
{
  Conversation$39(Conversation paramConversation) {}
  
  public void onGetCalReactiveDays(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("interactive", 2, " conversation onGetCalReactiveDays isAllow= " + paramBoolean2);
      }
      this.a.a(0L);
    }
  }
  
  public void onGetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onGetNotDisturb(paramBoolean, paramString1, paramString2);
    Conversation.a(this.a.jdField_a_of_type_MqqOsMqqHandler, this.a.a());
  }
  
  public void onGreetingRecv(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString != null) && (this.a.a().getCurrentAccountUin().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.recent", 2, "refresh recent, from_onGreetingRecv");
      }
      this.a.a(8, AppConstants.LBS_HELLO_UIN, 1001);
    }
  }
  
  public void onSetNick(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      Conversation.a(this.a, "onSetNick", paramString);
    }
  }
  
  public void onSetNotDisturb(boolean paramBoolean, String paramString1, String paramString2)
  {
    super.onSetNotDisturb(paramBoolean, paramString1, paramString2);
    if (!"not_disturb_from_conversation".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 4, "onSetNotDisturb NOT FROM THIS" + paramString2);
      }
    }
    do
    {
      return;
      if (!paramBoolean)
      {
        ThreadManagerV2.getUIHandlerV2().post(new Conversation.39.1(this));
        return;
      }
      Conversation.a(this.a.jdField_a_of_type_MqqOsMqqHandler, this.a.a());
    } while (FriendsStatusUtil.a(this.a.a()));
    ThreadManagerV2.getUIHandlerV2().post(new Conversation.39.2(this));
  }
  
  public void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "Conversation.onUpdateAvatar: uin:" + paramString + ", success :" + paramBoolean);
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_MqqAppAppRuntime != null) && (Utils.a(paramString, this.a.a().getCurrentAccountUin()))) {
      this.a.jdField_a_of_type_ComTencentMobileqqAppFrameHelperActivity.a.sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.39
 * JD-Core Version:    0.7.0.1
 */