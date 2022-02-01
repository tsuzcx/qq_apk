package com.tencent.mobileqq.activity.aio.rebuild;

import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.troop.data.TroopAioTips;
import com.tencent.mobileqq.troop.widget.RedDotRadioButton;
import com.tencent.qphone.base.util.QLog;

class HotChatPie$13
  implements Runnable
{
  HotChatPie$13(HotChatPie paramHotChatPie) {}
  
  public void run()
  {
    if (this.this$0.U.getVisibility() == 0) {
      this.this$0.U.setVisibility(4);
    }
    int i = this.this$0.V.getCount();
    if ((this.this$0.V != null) && (this.this$0.ch != i)) {
      this.this$0.cf.a(true);
    }
    if ((this.this$0.bp != null) && (this.this$0.bp.m() > 0)) {
      this.this$0.bp.d(4);
    }
    if (QLog.isColorLevel())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.this$0.c);
      ((StringBuilder)localObject).append("Q.hotchat.aio_post_red_point");
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("update, mLastMsgCountBeforeSwitch2PostTab:");
      localStringBuilder.append(this.this$0.ch);
      localStringBuilder.append(",current msgItemCount:");
      localStringBuilder.append(i);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.HotChatPie.13
 * JD-Core Version:    0.7.0.1
 */