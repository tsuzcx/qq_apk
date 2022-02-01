package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;

class NearbyChatPie$7
  implements Runnable
{
  NearbyChatPie$7(NearbyChatPie paramNearbyChatPie) {}
  
  public void run()
  {
    String[] arrayOfString = ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).getReasonTypeAndUins(this.this$0.d);
    String str = this.this$0.f.getIntent().getStringExtra("uin");
    ReportController.b(this.this$0.d, "CliOper", "", "", "0X80055FE", "0X80055FE", 0, 0, arrayOfString[0], str, "", "");
    this.this$0.bm = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.NearbyChatPie.7
 * JD-Core Version:    0.7.0.1
 */