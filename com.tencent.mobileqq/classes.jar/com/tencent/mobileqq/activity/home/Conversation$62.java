package com.tencent.mobileqq.activity.home;

import android.os.Bundle;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.qphone.base.util.QLog;

class Conversation$62
  extends OnlineStatusObserver
{
  Conversation$62(Conversation paramConversation) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.recent", 2, new Object[] { "onSetOnlineStatus, isSuccess", Boolean.valueOf(paramBoolean) });
      }
      this.a.a.a("OnlineStatusObserver.onSetOnlineStatus");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.62
 * JD-Core Version:    0.7.0.1
 */