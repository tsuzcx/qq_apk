package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

class GetTroopAssisMsg$MyMessageObserver
  extends MessageObserver
{
  private GetTroopAssisMsg$MyMessageObserver(GetTroopAssisMsg paramGetTroopAssisMsg) {}
  
  protected void onGetAllProxyTroopMsgFin(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onGetAllProxyMsgFin:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(", timeoutFlag=");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append(", type=");
      localStringBuilder.append(paramLong2);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    if (paramLong2 == 1L)
    {
      int i;
      if ((paramBoolean) && (paramLong1 != 8L) && (paramLong1 != 4L)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        this.a.setResult(6);
        return;
      }
      this.a.setResult(7);
    }
  }
  
  protected void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      paramArrayOfString = new StringBuilder();
      paramArrayOfString.append("on GetTroopMsg Fin:");
      paramArrayOfString.append(paramBoolean);
      QLog.d("QQInitHandler", 2, paramArrayOfString.toString());
    }
    MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
    this.a.setResult(7);
  }
  
  protected void onRegisterProxyFin(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("on RegisterProxy Fin:");
      paramObject.append(paramBoolean);
      QLog.d("QQInitHandler", 2, paramObject.toString());
    }
    if (!paramBoolean) {
      this.a.setResult(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */