package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.utils.TroopNotificationFlagMsg;
import com.tencent.mobileqq.troop.utils.TroopNotificationHelper;
import com.tencent.qphone.base.util.QLog;

public class TroopNotificationAIOHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public TroopNotificationAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void b()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.bj()) && (this.a.F() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.1(this), 8, null, true);
    }
  }
  
  private void c()
  {
    BaseChatPie localBaseChatPie = this.a;
    if ((localBaseChatPie != null) && (localBaseChatPie.F() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.2(this), 8, null, true);
    }
  }
  
  public boolean a()
  {
    boolean bool = TroopNotificationHelper.c(this.a.aE().b);
    TroopNotificationFlagMsg localTroopNotificationFlagMsg = TroopNotificationHelper.d(this.a.d, this.a.aE().b);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleTroopNotificationMsg. hasNewGuide = ");
      localStringBuilder.append(bool);
      QLog.d("TroopNotificationAIOHelper", 2, localStringBuilder.toString());
    }
    if ((this.a.aE().a == 1) && (!bool) && (localTroopNotificationFlagMsg != null) && (!localTroopNotificationFlagMsg.a.isEmpty()))
    {
      ThreadManager.post(new TroopNotificationAIOHelper.3(this), 8, null, true);
      return true;
    }
    return false;
  }
  
  public String getTag()
  {
    return "TroopNotificationAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 7, 12 };
  }
  
  public void onMoveToState(int paramInt)
  {
    if (paramInt != 7)
    {
      if (paramInt != 12) {
        return;
      }
      c();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper
 * JD-Core Version:    0.7.0.1
 */