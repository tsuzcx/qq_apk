package com.tencent.mobileqq.activity.phone;

import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

class BindVerifyActivity$3
  implements Runnable
{
  BindVerifyActivity$3(BindVerifyActivity paramBindVerifyActivity) {}
  
  public void run()
  {
    this.this$0.app.execute(new BindVerifyActivity.3.1(this));
    Intent localIntent = new Intent();
    localIntent.putExtra("bind_mobile", this.this$0.a());
    localIntent.putExtra("check_permission_result", "permission_granted");
    this.this$0.setResult(-1, localIntent);
    this.this$0.finish();
    if (BindVerifyActivity.e(this.this$0) == 15)
    {
      ReportController.b(this.this$0.app, "dc00898", "", "", "0X80077C7", "0X80077C7", 0, 0, "", "", "", "");
      return;
    }
    if (BindVerifyActivity.e(this.this$0) == 17) {
      ReportController.b(this.this$0.app, "dc00898", "", "", "0X80077CB", "0X80077CB", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.BindVerifyActivity.3
 * JD-Core Version:    0.7.0.1
 */