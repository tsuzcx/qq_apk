package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.extendfriend.ExtendFriendManager;
import com.tencent.qphone.base.util.QLog;

class LimitChatPie$19
  implements Runnable
{
  LimitChatPie$19(LimitChatPie paramLimitChatPie) {}
  
  public void run()
  {
    ExtendFriendManager localExtendFriendManager;
    if (this.this$0.a != null)
    {
      localExtendFriendManager = (ExtendFriendManager)this.this$0.a.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localExtendFriendManager != null) {
        break label45;
      }
      QLog.e(this.this$0.b, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (LimitChatPie.a(this.this$0) == null) {
      return;
    }
    localExtendFriendManager.a(LimitChatPie.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.19
 * JD-Core Version:    0.7.0.1
 */