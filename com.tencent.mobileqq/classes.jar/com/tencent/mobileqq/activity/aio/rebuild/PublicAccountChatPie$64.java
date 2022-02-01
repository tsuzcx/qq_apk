package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.officialaccount.OfficialAccountReporter;
import com.tencent.biz.officialaccount.OfficialAccountReporter.Reporter;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;

class PublicAccountChatPie$64
  extends BroadcastReceiver
{
  PublicAccountChatPie$64(PublicAccountChatPie paramPublicAccountChatPie) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    boolean bool = HwNetworkUtil.isNetworkAvailable(this.a.a);
    if ((bool) && (PublicAccountChatPie.e(this.a)))
    {
      OfficialAccountReporter.a.a();
      PublicAccountChatPie.c(this.a, false);
    }
    while (bool) {
      return;
    }
    OfficialAccountReporter.a.a(this.a.d());
    PublicAccountChatPie.c(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.PublicAccountChatPie.64
 * JD-Core Version:    0.7.0.1
 */