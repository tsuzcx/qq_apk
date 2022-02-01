package com.tencent.mobileqq.activity.home;

import android.os.Message;
import com.tencent.mobileqq.onlinestatus.api.IOnLineStatueHelperApi;
import com.tencent.mobileqq.onlinestatus.observer.OnAutoStatusBannerObserver;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.os.MqqHandler;

class Conversation$35
  extends OnAutoStatusBannerObserver
{
  Conversation$35(Conversation paramConversation) {}
  
  public void a()
  {
    this.a.A.sendEmptyMessage(1074);
  }
  
  public void a(int paramInt)
  {
    Message localMessage = new Message();
    localMessage.what = 1075;
    localMessage.obj = ((IOnLineStatueHelperApi)QRoute.api(IOnLineStatueHelperApi.class)).getStatusItem(paramInt);
    if (localMessage.obj != null) {
      this.a.A.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.35
 * JD-Core Version:    0.7.0.1
 */