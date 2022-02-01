package com.tencent.mobileqq.activity.contact.troop;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopNotifyAndRecommendView$6
  implements ThreadExcutor.IThreadListener
{
  TroopNotifyAndRecommendView$6(TroopNotifyAndRecommendView paramTroopNotifyAndRecommendView) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    ThreadManager.getUIHandler().post(new TroopNotifyAndRecommendView.6.1(this));
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.TroopNotifyAndRecommendView.6
 * JD-Core Version:    0.7.0.1
 */