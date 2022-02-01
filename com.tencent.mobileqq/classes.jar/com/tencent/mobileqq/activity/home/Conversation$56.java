package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.app.ShortVideoObserver;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;

class Conversation$56
  extends ShortVideoObserver
{
  Conversation$56(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    if (!this.a.f) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, "VideoRedbag, onCheckRealNameRsp in conv");
      }
    } while ((!paramBoolean) || (paramInt != RedBagVideoManager.a));
    DialogUtil.a(this.a.a(), 0, null, this.a.a(2131719382), 2131719384, 2131719383, new Conversation.56.1(this), new Conversation.56.2(this)).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.56
 * JD-Core Version:    0.7.0.1
 */