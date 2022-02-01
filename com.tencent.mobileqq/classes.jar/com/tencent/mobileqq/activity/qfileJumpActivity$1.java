package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

class qfileJumpActivity$1
  implements Runnable
{
  qfileJumpActivity$1(qfileJumpActivity paramqfileJumpActivity) {}
  
  public void run()
  {
    Intent localIntent1 = new Intent();
    Intent localIntent2 = this.this$0.getIntent();
    Bundle localBundle;
    if ((localIntent2 != null) && (localIntent2.getExtras() != null)) {
      localBundle = localIntent2.getExtras();
    } else {
      localBundle = new Bundle();
    }
    localBundle.putString("leftBackText", HardCodeUtil.a(2131907368));
    localBundle.putBoolean("isBack2Root", true);
    localIntent1.addFlags(268435456);
    localIntent1.addFlags(67108864);
    localIntent1.putExtras(localBundle);
    localIntent1.putExtras(localIntent2);
    localIntent1.setAction(localIntent2.getAction());
    localIntent1.setType(localIntent2.getType());
    if (localIntent2.getAction() == "android.intent.action.SEND_MULTIPLE")
    {
      localIntent1.setAction("android.intent.action.MAIN");
      localIntent1.putExtra("system_share_multi_send", true);
    }
    QFileAssistantUtils.a(this.this$0, localIntent1);
    this.this$0.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qfileJumpActivity.1
 * JD-Core Version:    0.7.0.1
 */