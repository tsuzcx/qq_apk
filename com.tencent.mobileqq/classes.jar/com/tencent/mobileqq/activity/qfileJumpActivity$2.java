package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticAssist;
import mqq.app.MobileQQ;

class qfileJumpActivity$2
  implements Runnable
{
  qfileJumpActivity$2(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    StatisticAssist.a(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_share_my_pc");
    Intent localIntent2 = this.this$0.getIntent();
    try
    {
      Bundle localBundle = localIntent2.getExtras();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      localIntent1 = null;
    }
    Object localObject = localIntent1;
    if (localIntent1 == null) {
      localObject = new Bundle();
    }
    ((Bundle)localObject).putString("leftBackText", HardCodeUtil.a(2131907368));
    ((Bundle)localObject).putBoolean("isBack2Root", true);
    Intent localIntent1 = new Intent(this.this$0, LiteActivity.class);
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(67108864);
    localIntent1.putExtra("dataline_share_finish", false);
    localIntent1.putExtras((Bundle)localObject);
    localIntent1.putExtra("targetUin", this.this$0.a);
    localIntent1.putExtras(localIntent2);
    localIntent1.setAction(localIntent2.getAction());
    localIntent1.setType(localIntent2.getType());
    if (localIntent2.getAction() == "android.intent.action.SEND_MULTIPLE")
    {
      localIntent1.setAction("android.intent.action.MAIN");
      localIntent1.putExtra("system_share_multi_send", true);
    }
    this.this$0.startActivity(localIntent1);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity.2
 * JD-Core Version:    0.7.0.1
 */