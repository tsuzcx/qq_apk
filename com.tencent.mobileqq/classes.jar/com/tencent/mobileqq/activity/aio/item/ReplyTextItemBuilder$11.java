package com.tencent.mobileqq.activity.aio.item;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForReplyText;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.pic.DownCallBack.DownResult;
import com.tencent.mobileqq.shortvideo.ShortVideoResult;
import com.tencent.mobileqq.shortvideo.UiCallBack.DownAdapter;
import com.tencent.qphone.base.util.QLog;

final class ReplyTextItemBuilder$11
  extends UiCallBack.DownAdapter
{
  ReplyTextItemBuilder$11(MessageForShortVideo paramMessageForShortVideo, MessageForReplyText paramMessageForReplyText, QQAppInterface paramQQAppInterface, ChatThumbView paramChatThumbView) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ShortVideoResult paramShortVideoResult)
  {
    if (paramShortVideoResult.jdField_a_of_type_Int == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.jdField_a_of_type_JavaLangObject;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath = paramShortVideoResult.b;
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.setSourceMessageRecord(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo);
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForReplyText.serial();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.uniseq, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.msgData);
      ReplyTextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbWidth, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.thumbHeight, this.jdField_a_of_type_ComTencentMobileqqDataMessageForShortVideo.mThumbFilePath, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemChatThumbView);
      return;
    }
    QLog.d("ReplyTextItemBuilder", 2, "reply render get thumbPath Fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */