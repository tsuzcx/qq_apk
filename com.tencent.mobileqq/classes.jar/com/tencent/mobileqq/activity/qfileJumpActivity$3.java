package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.dataline.activities.LiteActivity;
import com.dataline.util.DataLineReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class qfileJumpActivity$3
  implements Runnable
{
  qfileJumpActivity$3(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    DataLineReportUtil.r(this.this$0.app);
    Intent localIntent = new Intent(this.this$0, LiteActivity.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("targetUin", this.this$0.a);
    localIntent.putExtra("leftViewText", this.this$0.app.getApp().getString(2131690706));
    this.this$0.startActivity(localIntent);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity.3
 * JD-Core Version:    0.7.0.1
 */