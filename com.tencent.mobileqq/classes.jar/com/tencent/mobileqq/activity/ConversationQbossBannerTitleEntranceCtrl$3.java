package com.tencent.mobileqq.activity;

import adcw;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;

public class ConversationQbossBannerTitleEntranceCtrl$3
  implements Runnable
{
  public ConversationQbossBannerTitleEntranceCtrl$3(adcw paramadcw) {}
  
  public void run()
  {
    ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).onSmallRedPointClick("circle_entrance", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.3
 * JD-Core Version:    0.7.0.1
 */