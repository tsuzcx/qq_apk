package com.tencent.mobileqq.activity.aio.core;

import afqz;
import bfgl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.ScrollerRunnable;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$37$1
  implements Runnable
{
  BaseChatPie$37$1(BaseChatPie.37 param37, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    if (this.this$1.this$0.getActivity().isFinishing()) {}
    int i;
    do
    {
      do
      {
        return;
      } while ((this.val$mr == null) || (this.this$1.val$unreadMsgCount > 200));
      if (QLog.isColorLevel()) {
        QLog.d(this.this$1.this$0.tag + ".troop.special_msg", 2, "refreshHeadMessage==>fistseq:" + this.this$1.val$firstSeqFinal + ", mr.shmsgseq:" + this.val$mr.shmsgseq);
      }
      if ((int)this.this$1.val$firstSeqFinal >= this.val$mr.shmsgseq + 1L)
      {
        if (this.this$1.this$0.mTroopTips != null) {
          this.this$1.this$0.mTroopTips.a(this.this$1.val$firstSeqFinal, this.val$mr.shmsgseq, false);
        }
        if (this.this$1.val$type == 5) {
          this.this$1.this$0.mScrollerRunnable.a(this.val$mr.uniseq);
        }
        this.this$1.this$0.mScrollerRunnable.a(this.this$1.val$type, 0, -1, this.this$1.val$showOverScrollHeaderRunnable, 6);
        return;
      }
      i = this.this$1.this$0.listAdapter.a((ChatMessage)this.val$mr);
    } while (i == -1);
    this.this$1.this$0.mScrollerRunnable.a(this.this$1.val$type, i, i, null, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.37.1
 * JD-Core Version:    0.7.0.1
 */