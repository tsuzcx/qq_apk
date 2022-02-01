package com.tencent.mobileqq.activity.aio.rebuild;

import ahhp;
import arhi;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class LimitChatPie$15
  implements Runnable
{
  public LimitChatPie$15(ahhp paramahhp) {}
  
  public void run()
  {
    arhi localarhi;
    if (this.this$0.app != null)
    {
      localarhi = (arhi)this.this$0.app.getManager(264);
      if (localarhi != null) {
        break label45;
      }
      QLog.e(this.this$0.tag, 2, "saveExtendFriendInfoInSubThread  extendFriendManager Is null");
    }
    label45:
    while (ahhp.a(this.this$0) == null) {
      return;
    }
    localarhi.a(ahhp.a(this.this$0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.LimitChatPie.15
 * JD-Core Version:    0.7.0.1
 */