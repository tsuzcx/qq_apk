package com.tencent.mobileqq.activity.aio.rebuild;

import aici;
import aslo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;

public class LimitChatPie$15
  implements Runnable
{
  public LimitChatPie$15(aici paramaici) {}
  
  public void run()
  {
    aslo localaslo;
    if (this.this$0.app != null)
    {
      localaslo = (aslo)this.this$0.app.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
      if (localaslo != null) {
        break label45;
      }
      QLog.e(this.this$0.tag, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (aici.a(this.this$0) == null) {
      return;
    }
    localaslo.a(aici.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.15
 * JD-Core Version:    0.7.0.1
 */