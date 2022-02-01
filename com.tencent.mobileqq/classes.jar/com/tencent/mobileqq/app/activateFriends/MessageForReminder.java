package com.tencent.mobileqq.app.activateFriends;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import tencent.im.s2c.msgtype0x210.submsgtype0x13a.submsgtype0x13a.MsgBody;

public class MessageForReminder
  extends ChatMessage
{
  private static final String TAG = "MessageForReminder.Message";
  public submsgtype0x13a.MsgBody mMsgBody;
  
  protected void doParse()
  {
    try
    {
      this.mMsgBody = new submsgtype0x13a.MsgBody();
      this.mMsgBody.mergeFrom(this.msgData);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MessageForReminder.Message", 2, "Message parse error.", localException);
      }
    }
  }
  
  public submsgtype0x13a.MsgBody getMsgBody()
  {
    if ((this.mMsgBody == null) && (!this.mIsParsed)) {
      parse();
    }
    return this.mMsgBody;
  }
  
  protected void postwrite() {}
  
  protected void prewrite() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.activateFriends.MessageForReminder
 * JD-Core Version:    0.7.0.1
 */