package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;

class AvatarPendantActivity$6
  implements Runnable
{
  AvatarPendantActivity$6(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void run()
  {
    IRedTouchManager localIRedTouchManager = (IRedTouchManager)this.this$0.app.getRuntimeService(IRedTouchManager.class, "");
    this.this$0.a = localIRedTouchManager.getAppInfoByPath("100100.100125.100127");
    this.this$0.runOnUiThread(new AvatarPendantActivity.6.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.6
 * JD-Core Version:    0.7.0.1
 */