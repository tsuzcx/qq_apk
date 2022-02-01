package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.widget.BubbleImageView;

final class ReplyTextItemBuilder$2
  implements ReplyTextItemBuilder.SourceMessagePulledCallBack
{
  ReplyTextItemBuilder$2(MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, BubbleImageView paramBubbleImageView, TextView paramTextView, ETTextView paramETTextView1, ETTextView paramETTextView2, int paramInt, String paramString, MessageRecord paramMessageRecord) {}
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, View paramView, MessageRecord paramMessageRecord1, MessageRecord paramMessageRecord2, String paramString)
  {
    if ((paramMessageRecord2 != null) && (ReplyTextItemBuilder.a(paramMessageRecord2)))
    {
      if ((paramMessageRecord1 instanceof MessageForReplyText))
      {
        paramView = (MessageForReplyText)paramMessageRecord1;
        if (paramView.getSourceMessage() == null) {
          paramView.setSourceMessageRecord(paramMessageRecord2);
        }
      }
      ReplyTextItemBuilder.a(paramMessageRecord2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, paramContext, paramQQAppInterface, paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */