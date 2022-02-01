package com.tencent.mobileqq.activity.aio.tips;

import android.os.Handler;
import android.os.Looper;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.TroopManager.ITroopMemberInfoCallBack;
import com.tencent.mobileqq.data.troop.TroopMemberInfo;

class HomeworkTroopSurveyBar$1
  implements TroopManager.ITroopMemberInfoCallBack
{
  HomeworkTroopSurveyBar$1(HomeworkTroopSurveyBar paramHomeworkTroopSurveyBar, TroopManager paramTroopManager, TipsManager paramTipsManager) {}
  
  public void a(TroopMemberInfo paramTroopMemberInfo)
  {
    Looper localLooper = Looper.getMainLooper();
    if (Thread.currentThread() != localLooper.getThread())
    {
      new Handler(localLooper).post(new HomeworkTroopSurveyBar.1.1(this, paramTroopMemberInfo));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsHomeworkTroopSurveyBar.a(this.jdField_a_of_type_ComTencentMobileqqAppTroopManager, this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager, paramTroopMemberInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.HomeworkTroopSurveyBar.1
 * JD-Core Version:    0.7.0.1
 */