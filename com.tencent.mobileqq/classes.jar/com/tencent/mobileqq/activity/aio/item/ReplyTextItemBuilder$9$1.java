package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;

class ReplyTextItemBuilder$9$1
  implements Runnable
{
  ReplyTextItemBuilder$9$1(ReplyTextItemBuilder.9 param9, String paramString, SpannableString paramSpannableString) {}
  
  public void run()
  {
    this.this$0.e.setTag(2131446809, this.a);
    this.this$0.e.setTag(2131446810, Long.valueOf(this.this$0.d.mSourceMsgSenderUin));
    this.this$0.e.setText(this.b);
    TextView localTextView = this.this$0.f;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" ");
    localStringBuilder.append(this.this$0.g);
    localTextView.setText(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */