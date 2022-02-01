package com.tencent.mobileqq.activity;

import adtz;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQManagerFactory;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;

public class ConversationTitleBtnCtrl$4
  implements Runnable
{
  public ConversationTitleBtnCtrl$4(adtz paramadtz) {}
  
  public void run()
  {
    ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH)).onSmallRedPointClick("circle_entrance", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4
 * JD-Core Version:    0.7.0.1
 */