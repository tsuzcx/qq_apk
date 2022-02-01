package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyChatPie$8
  implements Runnable
{
  NearbyChatPie$8(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    String[] arrayOfString = ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).getReasonTypeAndUins(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getIntent().getStringExtra("uin");
    ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.D = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.8
 * JD-Core Version:    0.7.0.1
 */