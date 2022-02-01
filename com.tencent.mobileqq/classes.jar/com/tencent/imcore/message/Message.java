package com.tencent.imcore.message;

import com.tencent.mobileqq.app.msgnotify.MsgCacheInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.notColumn;
import java.util.ArrayList;

public class Message
  extends MessageRecord
{
  public String actMsgContentValue;
  public String action = null;
  public int bizType = -1;
  public int counter = 0;
  public CharSequence emoRecentMsg;
  public long fileSize = -1L;
  public int fileType = -1;
  public boolean hasReply;
  @notColumn
  public boolean isCacheValid = true;
  @notColumn
  public boolean isFromLS;
  public MessageRecord lastMsg;
  public ArrayList<MsgCacheInfo> msgInfoList;
  public String nickName = null;
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
  
  protected Class<? extends Entity> getClassForTable()
  {
    return Message.class;
  }
  
  public CharSequence getMessageText()
  {
    CharSequence localCharSequence = this.emoRecentMsg;
    Object localObject = localCharSequence;
    if (localCharSequence == null) {
      localObject = this.msg;
    }
    return localObject;
  }
  
  public boolean needNotification()
  {
    int i = this.bizType;
    return (i == 24) || (i == 17) || (i == 16) || (i == 5) || (i == 13) || (i == 26) || (i == 4) || (i == 14) || (i == 12);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imcore.message.Message
 * JD-Core Version:    0.7.0.1
 */