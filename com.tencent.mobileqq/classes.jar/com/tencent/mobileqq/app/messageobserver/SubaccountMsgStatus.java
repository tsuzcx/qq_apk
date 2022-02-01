package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class SubaccountMsgStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6008: 
      paramMessageObserver.refreshRecentListFinish(paramBoolean);
      return;
    case 8015: 
      paramMessageObserver.roamMessageSearchInCloud(paramBoolean, paramObject);
      return;
    case 6014: 
      paramMessageObserver.iPadOnlinesStatus(paramArrayOfObject);
      return;
    case 6016: 
      paramMessageObserver.pushUpdateLoginDevStatus(paramArrayOfObject);
      return;
    case 8003: 
      paramMessageObserver.subaccountGetMsg(paramBoolean, paramObject);
      return;
    case 8011: 
      paramMessageObserver.subaccountMsgNumReadedConfirm(paramBoolean, paramObject);
      return;
    case 8004: 
      paramMessageObserver.subaccountPushMsg(paramBoolean, paramObject);
      return;
    case 8007: 
      paramMessageObserver.recommandDevLock(paramBoolean, paramArrayOfObject);
      return;
    case 8013: 
      paramMessageObserver.pcActiveNotify(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.receiptRead((Long[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.SubaccountMsgStatus
 * JD-Core Version:    0.7.0.1
 */