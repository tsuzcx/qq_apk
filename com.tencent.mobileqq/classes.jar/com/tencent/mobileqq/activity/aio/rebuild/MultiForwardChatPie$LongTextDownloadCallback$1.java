package com.tencent.mobileqq.activity.aio.rebuild;

import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.ChatAdapter1;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.bubble.ChatXListView;

class MultiForwardChatPie$LongTextDownloadCallback$1
  implements Runnable
{
  MultiForwardChatPie$LongTextDownloadCallback$1(MultiForwardChatPie.LongTextDownloadCallback paramLongTextDownloadCallback, MultiForwardChatPie paramMultiForwardChatPie, CharSequence paramCharSequence) {}
  
  public void run()
  {
    MultiForwardChatPie.d(this.a).setVisibility(8);
    MultiForwardChatPie.a(this.a).setVisibility(0);
    MultiForwardChatPie.e(this.a).setVisibility(0);
    this.a.C.setText(this.a.bm);
    MultiForwardChatPie.f(this.a).a(MultiForwardChatPie.b(this.a), this.b);
    this.a.bz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.MultiForwardChatPie.LongTextDownloadCallback.1
 * JD-Core Version:    0.7.0.1
 */