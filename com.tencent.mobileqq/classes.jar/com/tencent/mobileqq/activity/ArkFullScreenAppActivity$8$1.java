package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.QQCustomArkDialog.AppInfo;

class ArkFullScreenAppActivity$8$1
  implements Runnable
{
  ArkFullScreenAppActivity$8$1(ArkFullScreenAppActivity.8 param8) {}
  
  public void run()
  {
    Intent localIntent = this.a.b.a(ArkFullScreenAppActivity.b(this.a.b).g);
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new ArkFullScreenAppActivity.8.1.1(this, localIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ArkFullScreenAppActivity.8.1
 * JD-Core Version:    0.7.0.1
 */