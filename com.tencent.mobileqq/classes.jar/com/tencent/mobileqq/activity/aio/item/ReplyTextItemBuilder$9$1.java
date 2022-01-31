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
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setTag(2131311050, this.jdField_a_of_type_JavaLangString);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setTag(2131311051, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin));
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_AndroidTextSpannableString);
    this.this$0.jdField_b_of_type_AndroidWidgetTextView.setText(" " + this.this$0.jdField_b_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9.1
 * JD-Core Version:    0.7.0.1
 */