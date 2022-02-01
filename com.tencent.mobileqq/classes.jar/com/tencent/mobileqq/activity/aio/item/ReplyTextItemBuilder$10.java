package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.QLog;

final class ReplyTextItemBuilder$10
  implements ReplyTextItemBuilder.SourceMessagePulledCallBack
{
  ReplyTextItemBuilder$10(ETTextView paramETTextView1, ETTextView paramETTextView2, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, TextView paramTextView, int paramInt, String paramString, MessageRecord paramMessageRecord, Context paramContext) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramView instanceof ChatThumbView)) {
      if (paramMessageRecord2 != null)
      {
        if (((paramMessageRecord2 instanceof MessageForText)) && (((MessageForText)paramMessageRecord2).msg != null))
        {
          ReplyTextItemBuilder.a(this.a, this.b, 1, this.c.mSourceMsgText, paramMessageRecord2);
          if (QLog.isColorLevel())
          {
            paramContext = new StringBuilder();
            paramContext.append("returned text msg error!");
            paramContext.append(this.c.mSourceMsgText);
            QLog.e("ReplyTextItemBuilder", 1, paramContext.toString());
          }
        }
        else
        {
          if ((paramMessageRecord1 instanceof MessageForReplyText))
          {
            paramContext = (MessageForReplyText)paramMessageRecord1;
            if (paramContext.getSourceMessage() != null) {
              paramContext.setSourceMessageRecord(paramMessageRecord2);
            }
          }
          ReplyTextItemBuilder.a(paramMessageRecord2, this.c, this.d, this.e, this.a, this.b, this.f, this.g, this.h, this.i, paramQQAppInterface, paramString);
        }
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.w("ReplyTextItemBuilder", 2, "processReplyMsg:source msg has been deleted.");
        }
        paramContext = this.d;
        if (paramContext != null)
        {
          paramContext.setVisibility(0);
          ReplyTextItemBuilder.a(this.e, 0);
          ReplyTextItemBuilder.a(this.i, paramQQAppInterface, this.d, this.h, null);
          ReplyTextItemBuilder.a(this.a, this.b, 1, this.c.mSourceMsgText, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */