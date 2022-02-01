package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class BlacklistStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6005: 
      paramMessageObserver.getOfflineFinish(paramBoolean);
      return;
    case 6004: 
      paramMessageObserver.pushReadedNotify(paramBoolean, paramObject);
      return;
    case 6006: 
      paramMessageObserver.getOfflineStart(paramBoolean);
      return;
    case 6003: 
      paramMessageObserver.sendResult(paramBoolean, paramArrayOfObject);
      return;
    case 6001: 
      paramMessageObserver.reqInsertBlacklist(paramBoolean, paramObject);
      return;
    case 6002: 
      paramMessageObserver.reqDeleteBlacklist(paramBoolean, (Object[])paramObject);
      return;
    case 6007: 
      paramMessageObserver.pcOnlinesStatus(paramArrayOfObject);
      return;
    case 5006: 
      paramMessageObserver.richSendNotifyMsg(paramBoolean, paramArrayOfObject, paramStatictisInfo);
      return;
    case 5012: 
      paramMessageObserver.c2cOnlineFile(paramBoolean, paramArrayOfObject);
      return;
    case 5010: 
      paramMessageObserver.updateSecretfileStatus();
      return;
    }
    paramMessageObserver.updateSelfMsgSeqAndTime(paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.BlacklistStatus
 * JD-Core Version:    0.7.0.1
 */