package com.tencent.imcore.message;

import aoqz;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.imcore.message.IMCoreMessageStub;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.ArrayList;

public class QQMessageFacade$Message
  extends MessageRecord
  implements IMCoreMessageStub
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
  @notColumn
  public boolean isFromLS;
  public MessageRecord lastMsg;
  public ArrayList<aoqz> msgInfoList;
  public String nickName;
  @notColumn
  public CharSequence prefixOfNickname;
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
  
  public Class<? extends Entity> getClassForTable()
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
  
  public long getTime()
  {
    return this.time;
  }
  
  public boolean needNotification()
  {
    return (this.bizType == 24) || (this.bizType == 17) || (this.bizType == 16) || (this.bizType == 5) || (this.bizType == 13) || (this.bizType == 27) || (this.bizType == 4) || (this.bizType == 14) || (this.bizType == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.Message
 * JD-Core Version:    0.7.0.1
 */