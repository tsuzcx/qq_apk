package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.data.ChatMessage;

class WriteTogetherItemBuilder$2
  implements Runnable
{
  WriteTogetherItemBuilder$2(WriteTogetherItemBuilder paramWriteTogetherItemBuilder, TextItemBuilder.Holder paramHolder, int paramInt, ChatMessage paramChatMessage1, RelativeLayout paramRelativeLayout, ChatMessage paramChatMessage2) {}
  
  public void run()
  {
    if ((this.a.h.getMeasuredWidth() < this.b) && (this.c.isSend()))
    {
      WriteTogetherItemBuilder.a(this.this$0, this.a.A, this.d);
      return;
    }
    WriteTogetherItemBuilder.a(this.this$0, this.e, this.a.j, this.d);
    this.this$0.a(this.a.A, this.a.j, Integer.valueOf(2131450255), this.c, -4, Boolean.valueOf(true));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.WriteTogetherItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */