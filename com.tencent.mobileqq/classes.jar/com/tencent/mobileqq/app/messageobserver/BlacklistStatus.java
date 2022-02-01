package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class BlacklistStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 5006)
    {
      if (paramInt != 5010)
      {
        if (paramInt != 5012)
        {
          if (paramInt != 6017)
          {
            if (paramInt != 8047)
            {
              switch (paramInt)
              {
              default: 
                return;
              case 6007: 
                paramMessageObserver.pcOnlinesStatus(paramArrayOfObject);
                return;
              case 6006: 
                paramMessageObserver.getOfflineStart(paramBoolean);
                return;
              case 6005: 
                paramMessageObserver.getOfflineFinish(paramBoolean);
                return;
              case 6004: 
                paramMessageObserver.pushReadedNotify(paramBoolean, paramObject);
                return;
              case 6003: 
                paramMessageObserver.sendResult(paramBoolean, paramArrayOfObject);
                return;
              case 6002: 
                paramMessageObserver.reqDeleteBlacklist(paramBoolean, (Object[])paramObject);
                return;
              }
              paramMessageObserver.reqInsertBlacklist(paramBoolean, paramObject);
              return;
            }
            paramMessageObserver.updateSelfMsgSeqAndTime(paramObject);
            return;
          }
          paramMessageObserver.recvEmoticonRandomResult(paramBoolean, paramArrayOfObject);
          return;
        }
        paramMessageObserver.c2cOnlineFile(paramBoolean, paramArrayOfObject);
        return;
      }
      paramMessageObserver.updateSecretfileStatus();
      return;
    }
    paramMessageObserver.richSendNotifyMsg(paramBoolean, paramArrayOfObject, paramStatictisInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.BlacklistStatus
 * JD-Core Version:    0.7.0.1
 */