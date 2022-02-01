package com.tencent.mobileqq.activity.aio.helper;

import android.content.res.Resources;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.tips.AVGameStatusTipsBar;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class AVGameHelper$1$2
  implements Runnable
{
  AVGameHelper$1$2(AVGameHelper.1 param1, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a).a();
      ReportController.b(null, "dc00898", "", "", "0X800B033", "0X800B033", 0, 0, "", "", AVGameHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a).a, "");
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a.a, 1, this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperAVGameHelper$1.a.a.getResources().getString(2131690577), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AVGameHelper.1.2
 * JD-Core Version:    0.7.0.1
 */