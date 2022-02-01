package com.tencent.mobileqq.activity.aio.rebuild;

import aezn;
import ahgz;
import bdzi;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

public class HotChatPie$14
  implements Runnable
{
  public HotChatPie$14(ahgz paramahgz) {}
  
  public void run()
  {
    if (this.this$0.listView.getVisibility() == 0) {
      this.this$0.listView.setVisibility(4);
    }
    int i = this.this$0.listAdapter.getCount();
    if ((this.this$0.listAdapter != null) && (this.this$0.f != i)) {
      this.this$0.a.a(true);
    }
    if ((this.this$0.mTroopTips != null) && (this.this$0.mTroopTips.a() > 0)) {
      this.this$0.mTroopTips.c(4);
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.tag + "Q.hotchat.aio_post_red_point", 2, "update, mLastMsgCountBeforeSwitch2PostTab:" + this.this$0.f + ",current msgItemCount:" + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.14
 * JD-Core Version:    0.7.0.1
 */