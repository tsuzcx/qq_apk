package com.tencent.mobileqq.app.message;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.ArrayList;

public class QQMessageFacade$Message
  extends MessageRecord
{
  public String actMsgContentValue;
  public String action;
  public int bizType = -1;
  public int counter;
  public CharSequence emoRecentMsg;
  public long fileSize = -1L;
  public int fileType = -1;
  public boolean hasReply;
  @notColumn
  public boolean isCacheValid = true;
  public MessageRecord lastMsg;
  public ArrayList msgInfoList;
  public String nickName;
  public String pttUrl;
  public long shareAppID;
  @Deprecated
  public int unReadNum;
  
  public void cleanMessageRecordBaseField()
  {
    this.msg = null;
    this.emoRecentMsg = null;
    this.fileType = -1;
  }
  
  protected Class getClassForTable()
  {
    return Message.class;
  }
  
  public CharSequence getMessageText()
  {
    if (this.emoRecentMsg == null) {
      return this.msg;
    }
    return this.emoRecentMsg;
  }
  
  public boolean needNotification()
  {
    return (this.bizType == 20) || (this.bizType == 14) || (this.bizType == 5) || (this.bizType == 12) || (this.bizType == 23) || (this.bizType == 4) || (this.bizType == 13) || (this.bizType == 11);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.message.QQMessageFacade.Message
 * JD-Core Version:    0.7.0.1
 */