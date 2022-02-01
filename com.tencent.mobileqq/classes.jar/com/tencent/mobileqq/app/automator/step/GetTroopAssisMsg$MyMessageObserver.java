package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;

class GetTroopAssisMsg$MyMessageObserver
  extends MessageObserver
{
  private GetTroopAssisMsg$MyMessageObserver(GetTroopAssisMsg paramGetTroopAssisMsg) {}
  
  public void onGetAllProxyTroopMsgFin(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    if (paramLong2 == 1L) {
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label95;
      }
    }
    label95:
    for (int i = 1; i == 0; i = 0)
    {
      this.a.a(6);
      return;
    }
    this.a.a(7);
  }
  
  public void onGetTroopMsgFin(boolean paramBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on GetTroopMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.getInstance().markGrpFinishCost();
    this.a.a(7);
  }
  
  public void onRegisterProxyFin(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    if (!paramBoolean) {
      this.a.a(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetTroopAssisMsg.MyMessageObserver
 * JD-Core Version:    0.7.0.1
 */