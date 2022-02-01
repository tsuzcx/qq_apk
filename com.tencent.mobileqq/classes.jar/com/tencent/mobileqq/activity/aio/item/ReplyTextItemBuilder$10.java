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
    if ((paramView instanceof ChatThumbView))
    {
      if (paramMessageRecord2 != null)
      {
        if (((paramMessageRecord2 instanceof MessageForText)) && (((MessageForText)paramMessageRecord2).msg != null))
        {
          ReplyTextItemBuilder.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, 1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText, paramMessageRecord2);
          paramContext = new StringBuilder();
          paramContext.append("returned text msg error!");
          paramContext.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText);
          QLog.e("ReplyTextItemBuilder", 1, paramContext.toString());
          return;
        }
        if ((paramMessageRecord1 instanceof MessageForReplyText))
        {
          paramContext = (MessageForReplyText)paramMessageRecord1;
          if (paramContext.getSourceMessage() != null) {
            paramContext.setSourceMessageRecord(paramMessageRecord2);
          }
        }
        ReplyTextItemBuilder.a(paramMessageRecord2, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface, paramString);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ReplyTextItemBuilder", 2, "processReplyMsg:source msg has been deleted.");
      }
      paramContext = this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView;
      if (paramContext != null)
      {
        paramContext.setVisibility(0);
        ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidWidgetTextView, 0);
        ReplyTextItemBuilder.a(this.jdField_a_of_type_AndroidContentContext, paramQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqWidgetBubbleImageView, this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord, null);
        ReplyTextItemBuilder.a(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView, this.b, 1, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgText, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.10
 * JD-Core Version:    0.7.0.1
 */