package com.tencent.mobileqq.activity.aio.rebuild;

import android.os.Bundle;
import android.os.Handler;
import mqq.observer.BusinessObserver;

class PublicAccountChatPie$3
  implements BusinessObserver
{
  PublicAccountChatPie$3(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      if (paramBundle.getInt("update_type") == 2) {
        return;
      }
      this.a.ce.sendEmptyMessage(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.3
 * JD-Core Version:    0.7.0.1
 */