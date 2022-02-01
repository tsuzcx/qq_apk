package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class GetMsgFin
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 3021)
    {
      switch (paramInt)
      {
      default: 
        switch (paramInt)
        {
        default: 
          return;
        case 4013: 
          paramMessageObserver.getAllProxyTroopMsg(paramBoolean, paramArrayOfObject);
          return;
        case 4012: 
          paramMessageObserver.sendSystemMsgActionError((ToServiceMsg)paramObject);
          return;
        }
        paramMessageObserver.sendSystemMsgActionFin(paramBoolean, (ToServiceMsg)paramObject);
        return;
      case 4006: 
        paramMessageObserver.getSystemMsgFin(false, true, null);
        return;
      case 4005: 
        paramMessageObserver.getSystemMsgFin(paramBoolean, false, (List)paramObject);
        return;
      case 4004: 
        paramMessageObserver.registerProxyFin(paramBoolean, paramObject);
        return;
      case 4003: 
        paramMessageObserver.getTroopMsgFin(paramBoolean, paramArrayOfObject);
        return;
      case 4002: 
        paramMessageObserver.getDiscussionMsgFin(paramBoolean);
        return;
      }
      paramMessageObserver.getMsgFin(paramBoolean);
      return;
    }
    paramMessageObserver.receiptErrorRsp((Long[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.GetMsgFin
 * JD-Core Version:    0.7.0.1
 */