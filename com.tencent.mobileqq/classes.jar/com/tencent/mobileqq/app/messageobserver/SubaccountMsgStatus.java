package com.tencent.mobileqq.app.messageobserver;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.StatictisInfo;

public class SubaccountMsgStatus
  implements HandleUpdateType
{
  public void a(MessageObserver paramMessageObserver, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, StatictisInfo paramStatictisInfo)
  {
    if (paramInt != 6008)
    {
      if (paramInt != 8007)
      {
        if (paramInt != 8011)
        {
          if (paramInt != 8013)
          {
            if (paramInt != 8015)
            {
              if (paramInt != 8003)
              {
                if (paramInt != 8004)
                {
                  switch (paramInt)
                  {
                  default: 
                    return;
                  case 6016: 
                    paramMessageObserver.pushUpdateLoginDevStatus(paramArrayOfObject);
                    return;
                  case 6015: 
                    paramMessageObserver.receiptRead((Long[])paramObject);
                    return;
                  }
                  paramMessageObserver.iPadOnlinesStatus(paramArrayOfObject);
                  return;
                }
                paramMessageObserver.subaccountPushMsg(paramBoolean, paramObject);
                return;
              }
              paramMessageObserver.subaccountGetMsg(paramBoolean, paramObject);
              return;
            }
            paramMessageObserver.roamMessageSearchInCloud(paramBoolean, paramObject);
            return;
          }
          paramMessageObserver.pcActiveNotify(paramBoolean, paramArrayOfObject);
          return;
        }
        paramMessageObserver.subaccountMsgNumReadedConfirm(paramBoolean, paramObject);
        return;
      }
      paramMessageObserver.recommandDevLock(paramBoolean, paramArrayOfObject);
      return;
    }
    paramMessageObserver.refreshRecentListFinish(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.messageobserver.SubaccountMsgStatus
 * JD-Core Version:    0.7.0.1
 */