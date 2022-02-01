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
    if (paramShortVideoResult.a == 0)
    {
      paramShortVideoResult = (DownCallBack.DownResult)paramShortVideoResult.d;
      this.a.mThumbFilePath = paramShortVideoResult.e;
      this.b.setSourceMessageRecord(this.a);
      this.b.serial();
      this.c.getMessageFacade().a(this.a.frienduin, this.a.istroop, this.a.uniseq, this.a.msgData);
      ReplyTextItemBuilder.a(this.a.thumbWidth, this.a.thumbHeight, this.a.mThumbFilePath, this.d);
      return;
    }
    QLog.d("ReplyTextItemBuilder", 2, "reply render get thumbPath Fail");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ReplyTextItemBuilder.11
 * JD-Core Version:    0.7.0.1
 */