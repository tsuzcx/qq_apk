package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyChatPie$10
  implements Runnable
{
  NearbyChatPie$10(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    String[] arrayOfString = NearbyRecommenderUtils.a(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    String str = this.this$0.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getIntent().getStringExtra("uin");
    ReportController.b(this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.N = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.10
 * JD-Core Version:    0.7.0.1
 */