package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vipgift.VipGiftDownloadInfo;
import com.tencent.mobileqq.vipgift.VipGiftManager;

class StructingMsgItemBuilder$4
  implements Runnable
{
  StructingMsgItemBuilder$4(StructingMsgItemBuilder paramStructingMsgItemBuilder, VipGiftDownloadInfo paramVipGiftDownloadInfo, VipGiftManager paramVipGiftManager) {}
  
  public void run()
  {
    if ((this.a.f == 1L) && (this.a.b.equalsIgnoreCase(this.this$0.f.b)))
    {
      this.b.a(6L, this.a.c);
      ((BaseActivity)this.this$0.e).runOnUiThread(new StructingMsgItemBuilder.4.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */