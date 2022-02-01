package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class SpecialMsgDevStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 8038)
    {
      if (paramInt != 8039)
      {
        if (paramInt != 8046)
        {
          switch (paramInt)
          {
          default: 
            return;
          case 8036: 
            paramMessageObserver.hiboomAuth(paramArrayOfObject);
            return;
          case 8035: 
            paramMessageObserver.handle_NOTIFY_TYPE_CONFESS_TMP(paramBoolean, paramArrayOfObject);
            return;
          case 8034: 
            paramMessageObserver.danceMachine(paramObject);
            return;
          }
          paramMessageObserver.macOnlinesStatus(paramArrayOfObject);
          return;
        }
        paramMessageObserver.sendResultWithTransinfo(paramBoolean, paramObject);
        return;
      }
      paramMessageObserver.deleteAllSystemMsg(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.watchOnlineStatus(paramArrayOfObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.SpecialMsgDevStatus
 * JD-Core Version:    0.7.0.1
 */