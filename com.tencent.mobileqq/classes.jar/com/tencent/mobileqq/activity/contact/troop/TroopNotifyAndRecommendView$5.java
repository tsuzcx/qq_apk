package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$5
  extends TroopNotificationObserver
{
  TroopNotifyAndRecommendView$5(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if ((!paramBoolean) || (paramObject == null)) {
      return;
    }
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.5
 * JD-Core Version:    0.7.0.1
 */