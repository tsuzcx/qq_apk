package com.tencent.imcore.message;

import acna;
import acnb;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public class QQMessageFacade$RefreshMessageContext
{
  public static final int REFRESH_REPULL_LONG_MSG_TIMES = 1;
  public static final int REFRESH_RETRY_MAX_TIMES = 9;
  public long c2cTempEct = 9223372036854775807L;
  public long c2cTempRand = 0L;
  public Object context;
  public int count;
  public boolean isComplete;
  public boolean isJoined = true;
  public boolean isLocalOnly;
  public boolean isOpInMIniAIo;
  public boolean isSuccess = true;
  public acna msgRefresher;
  public boolean needAutoNavigateTop;
  public boolean needNotifyUI = true;
  public boolean needRefreshAIO = true;
  public volatile boolean numTroopRefresh;
  public int repullLongMsgIndex;
  public int repullStickerMsgIndex;
  public List<MessageRecord> resultMsgList;
  public int retryIndex;
  public acnb roamMsgFetcher;
  public volatile boolean searchedMessageRefresh;
  public int topicId;
  public String uin;
  public int uinType;
  
  public String toString()
  {
    return "[isComplete = " + this.isComplete + ", isJoined = " + this.isJoined + ", isLocalOnly = " + this.isLocalOnly + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.RefreshMessageContext
 * JD-Core Version:    0.7.0.1
 */