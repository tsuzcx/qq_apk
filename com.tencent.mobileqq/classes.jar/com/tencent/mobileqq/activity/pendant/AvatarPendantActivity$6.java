package com.tencent.mobileqq.activity.pendant;

import bbbq;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AvatarPendantActivity$6
  implements Runnable
{
  AvatarPendantActivity$6(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    bbbq localbbbq = (bbbq)this.this$0.app.getManager(QQManagerFactory.MGR_RED_TOUCH);
    this.this$0.a = localbbbq.a("100100.100125.100127");
    this.this$0.runOnUiThread(new AvatarPendantActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.6
 * JD-Core Version:    0.7.0.1
 */