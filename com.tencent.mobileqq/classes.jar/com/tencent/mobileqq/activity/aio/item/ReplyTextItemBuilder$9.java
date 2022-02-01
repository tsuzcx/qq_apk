package com.tencent.mobileqq.activity.aio.item;

import android.text.SpannableString;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForReplyText.SourceMsgInfo;
import com.tencent.mobileqq.text.ColorNickText;
import com.tencent.mobileqq.utils.ContactUtils;
import mqq.os.MqqHandler;

final class ReplyTextItemBuilder$9
  implements Runnable
{
  ReplyTextItemBuilder$9(QQAppInterface paramQQAppInterface, int paramInt, String paramString1, MessageForReplyText.SourceMsgInfo paramSourceMsgInfo, TextView paramTextView1, TextView paramTextView2, String paramString2) {}
  
  public void run()
  {
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    int i = this.jdField_a_of_type_Int;
    Object localObject2 = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText$SourceMsgInfo.mSourceMsgSenderUin);
    localStringBuilder.append("");
    localObject1 = ContactUtils.a((QQAppInterface)localObject1, i, (String)localObject2, localStringBuilder.toString());
    localObject2 = new ColorNickText((CharSequence)localObject1, 16).a();
    ThreadManager.getUIHandler().post(new ReplyTextItemBuilder.9.1(this, (String)localObject1, (SpannableString)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.9
 * JD-Core Version:    0.7.0.1
 */