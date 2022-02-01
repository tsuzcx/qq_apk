package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class SpecialMsgDevStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    case 8037: 
    case 8040: 
    case 8041: 
    case 8042: 
    case 8043: 
    case 8044: 
    case 8045: 
    default: 
      return;
    case 8033: 
      paramMessageObserver.macOnlinesStatus(paramArrayOfObject);
      return;
    case 8038: 
      paramMessageObserver.watchOnlineStatus(paramArrayOfObject);
      return;
    case 8034: 
      paramMessageObserver.danceMachine(paramObject);
      return;
    case 8035: 
      paramMessageObserver.handle_NOTIFY_TYPE_CONFESS_TMP(paramBoolean, paramArrayOfObject);
      return;
    case 8036: 
      paramMessageObserver.hiboomAuth(paramArrayOfObject);
      return;
    case 8039: 
      paramMessageObserver.deleteAllSystemMsg(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.sendResultWithTransinfo(paramBoolean, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.SpecialMsgDevStatus
 * JD-Core Version:    0.7.0.1
 */