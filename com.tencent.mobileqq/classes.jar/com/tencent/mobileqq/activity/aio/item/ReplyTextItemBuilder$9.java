package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableString;
import android.widget.TextView;
import bamb;
import bdgc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import mqq.os.MqqHandler;

public final class ReplyTextItemBuilder$9
  implements Runnable
{
  public ReplyTextItemBuilder$9(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, TextView paramTextView1, TextView paramTextView2, String paramString2) {}
  
  public void run()
  {
    String str = bdgc.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin + "");
    SpannableString localSpannableString = new bamb(str, 16).a();
    ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.9.1(this, str, localSpannableString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */