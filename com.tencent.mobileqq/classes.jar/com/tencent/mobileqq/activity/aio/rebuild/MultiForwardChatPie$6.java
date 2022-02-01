package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;

class MultiForwardChatPie$6
  implements Runnable
{
  MultiForwardChatPie$6(MultiForwardChatPie paramMultiForwardChatPie, CharSequence paramCharSequence) {}
  
  public void run()
  {
    MultiForwardChatPie.d(this.this$0).setVisibility(8);
    MultiForwardChatPie.a(this.this$0).setVisibility(0);
    MultiForwardChatPie.e(this.this$0).setVisibility(0);
    this.this$0.C.setText(this.this$0.bm);
    MultiForwardChatPie.f(this.this$0).a(MultiForwardChatPie.b(this.this$0), this.a);
    this.this$0.bz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.6
 * JD-Core Version:    0.7.0.1
 */