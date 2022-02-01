package com.tencent.mobileqq.app;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.qphone.base.util.QLog;

class BabyQFriendStatusWebViewPlugin$1
  extends BroadcastReceiver
{
  BabyQFriendStatusWebViewPlugin$1(BabyQFriendStatusWebViewPlugin paramBabyQFriendStatusWebViewPlugin) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (!TextUtils.isEmpty(BabyQFriendStatusWebViewPlugin.a(this.a)))
    {
      int i = paramIntent.getIntExtra("result", -1);
      paramContext = new StringBuilder();
      paramContext.append("{ \"ret\": ");
      paramContext.append(i);
      paramContext.append(" }");
      paramContext = paramContext.toString();
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("babyqWeb js req method = setFriendStatus, return = ");
        paramIntent.append(paramContext);
        QLog.d("BabyQFriendStatusWebViewPlugin", 2, paramIntent.toString());
      }
      if (i == 0)
      {
        if (BabyQFriendStatusWebViewPlugin.b(this.a) != null)
        {
          paramContext = new Intent(BabyQFriendStatusWebViewPlugin.b(this.a), ChatActivity.class);
          paramContext.putExtra("uin", AppConstants.BABY_Q_UIN);
          paramContext.putExtra("uintype", 0);
          paramContext.putExtra("uinname", "babyQ");
          paramContext.putExtra("selfSet_leftViewText", BabyQFriendStatusWebViewPlugin.b(this.a).getString(2131887625));
          BabyQFriendStatusWebViewPlugin.b(this.a).startActivity(paramContext);
          BabyQFriendStatusWebViewPlugin.b(this.a).finish();
        }
      }
      else
      {
        paramIntent = this.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(BabyQFriendStatusWebViewPlugin.a(this.a));
        localStringBuilder.append("(");
        localStringBuilder.append(paramContext);
        localStringBuilder.append(");");
        paramIntent.callJs(localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.BabyQFriendStatusWebViewPlugin.1
 * JD-Core Version:    0.7.0.1
 */