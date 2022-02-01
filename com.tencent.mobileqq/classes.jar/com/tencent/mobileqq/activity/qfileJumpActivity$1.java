package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import anvx;
import bdlq;
import com.dataline.activities.LiteActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.MobileQQ;

class qfileJumpActivity$1
  implements Runnable
{
  qfileJumpActivity$1(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    bdlq.a(this.this$0.app.getApplication().getApplicationContext(), this.this$0.app.getCurrentAccountUin(), "dl_share_my_pc");
    Intent localIntent = this.this$0.getIntent();
    Object localObject1 = null;
    try
    {
      localObject2 = localIntent.getExtras();
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject2;
        localException.printStackTrace();
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new Bundle();
    }
    ((Bundle)localObject2).putString("leftBackText", anvx.a(2131709123));
    ((Bundle)localObject2).putBoolean("isBack2Root", true);
    localObject1 = new Intent(this.this$0, LiteActivity.class);
    ((Intent)localObject1).addFlags(268435456);
    ((Intent)localObject1).addFlags(67108864);
    ((Intent)localObject1).putExtra("dataline_share_finish", false);
    ((Intent)localObject1).putExtras((Bundle)localObject2);
    ((Intent)localObject1).putExtra("targetUin", this.this$0.a);
    ((Intent)localObject1).putExtras(localIntent);
    ((Intent)localObject1).setAction(localIntent.getAction());
    ((Intent)localObject1).setType(localIntent.getType());
    if (localIntent.getAction() == "android.intent.action.SEND_MULTIPLE")
    {
      ((Intent)localObject1).setAction("android.intent.action.MAIN");
      ((Intent)localObject1).putExtra("system_share_multi_send", true);
    }
    this.this$0.startActivity((Intent)localObject1);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */