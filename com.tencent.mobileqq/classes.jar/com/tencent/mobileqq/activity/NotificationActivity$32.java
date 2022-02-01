package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.statistics.ReportController;

class NotificationActivity$32
  extends ClickableSpan
{
  NotificationActivity$32(NotificationActivity paramNotificationActivity, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (!this.a) {
      ReportController.a(this.b.getAppRuntime(), "dc00898", "", NotificationActivity.access$1000(this.b), "0X800AA31", "0X800AA31", 0, 0, "", "", "", NotificationActivity.access$300(this.b));
    }
    NotificationActivity.access$1200(this.b, "0X800B656");
    paramView = new Intent();
    RouteUtils.a(this.b, paramView.putExtra("url", "https://myun.tenpay.com/mqq/banneduser/index.shtml?_wv=1027"), "/base/browser");
    this.b.finish();
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(paramTextPaint.linkColor);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.NotificationActivity.32
 * JD-Core Version:    0.7.0.1
 */