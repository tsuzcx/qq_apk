package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.ThreadManager;

public class TroopNotificationAIOHelper
  implements ILifeCycleHelper
{
  private BaseChatPie a;
  
  public TroopNotificationAIOHelper(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
  }
  
  private void a()
  {
    if ((this.a != null) && (this.a.x()) && (this.a.b() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.1(this), 8, null, true);
    }
  }
  
  private void b()
  {
    if ((this.a != null) && (this.a.b() == 1)) {
      ThreadManager.post(new TroopNotificationAIOHelper.2(this), 8, null, true);
    }
  }
  
  public String getTag()
  {
    return "TroopNotificationAIOHelper";
  }
  
  public int[] interestedIn()
  {
    return new int[] { 6, 11 };
  }
  
  public void onMoveToState(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      a();
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopNotificationAIOHelper
 * JD-Core Version:    0.7.0.1
 */