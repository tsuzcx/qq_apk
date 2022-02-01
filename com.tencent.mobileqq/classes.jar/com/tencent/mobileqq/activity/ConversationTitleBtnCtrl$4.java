package com.tencent.mobileqq.activity;

import adcx;
import com.tencent.common.app.BaseApplicationImpl;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.AppRuntime;

public class ConversationTitleBtnCtrl$4
  implements Runnable
{
  public ConversationTitleBtnCtrl$4(adcx paramadcx) {}
  
  public void run()
  {
    ((QCircleRedPointManager)BaseApplicationImpl.getApplication().getRuntime().getManager(376)).onSmallRedPointClick("circle_entrance", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationTitleBtnCtrl.4
 * JD-Core Version:    0.7.0.1
 */