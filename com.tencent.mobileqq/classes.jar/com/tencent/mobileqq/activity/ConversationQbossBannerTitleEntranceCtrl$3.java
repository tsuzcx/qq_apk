package com.tencent.mobileqq.activity;

import adty;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;

public class ConversationQbossBannerTitleEntranceCtrl$3
  implements Runnable
{
  public ConversationQbossBannerTitleEntranceCtrl$3(adty paramadty) {}
  
  public void run()
  {
    ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH)).onSmallRedPointClick("circle_entrance", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.3
 * JD-Core Version:    0.7.0.1
 */