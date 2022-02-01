package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class TroopObserversHelper$4$1
  implements Runnable
{
  TroopObserversHelper$4$1(TroopObserversHelper.4 param4, Runnable paramRunnable, long paramLong) {}
  
  public void run()
  {
    if ((TroopObserversHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopObserversHelper$4.a) != null) && (TroopObserversHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTroopObserversHelper$4.a).isResume())) {
      ThreadManager.getSubThreadHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopObserversHelper.4.1
 * JD-Core Version:    0.7.0.1
 */