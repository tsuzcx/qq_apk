package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class GetOfflineMsgSigFin
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    default: 
      switch (paramInt)
      {
      default: 
        return;
      case 5005: 
        paramMessageObserver.setOfflineFileState(paramBoolean, paramArrayOfObject);
        return;
      case 5004: 
        paramMessageObserver.sendOfflineFile(paramBoolean, paramArrayOfObject, paramStatictisInfo);
        return;
      case 5003: 
        paramMessageObserver.sendGetC2CSig(paramBoolean, paramArrayOfObject, paramStatictisInfo);
        return;
      }
      paramMessageObserver.sendGetSig(paramBoolean);
      return;
    case 4019: 
      paramMessageObserver.getSuspiciousSystemMsgFin(paramBoolean, paramObject);
      return;
    case 4018: 
      paramMessageObserver.newRegisterProxyFin(paramBoolean);
      return;
    case 4017: 
      paramMessageObserver.getGroupFirstMsgFin(paramBoolean);
      return;
    case 4016: 
      paramMessageObserver.getPAFin(paramBoolean);
      return;
    case 4015: 
      paramMessageObserver.getDelSystemMsgError();
      return;
    }
    paramMessageObserver.getDelSystemMsgFin(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.GetOfflineMsgSigFin
 * JD-Core Version:    0.7.0.1
 */