package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.app.DiscussionManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;

class DiscussionInfoCardActivity$11$2
  implements DialogInterface.OnClickListener
{
  DiscussionInfoCardActivity$11$2(DiscussionInfoCardActivity.11 param11, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DiscussionInfoCardActivity.d(this.b.a).g(this.a);
    paramDialogInterface = this.b.a.app.getProxyManager().g();
    paramDialogInterface.a(paramDialogInterface.b(this.a, 3000));
    paramDialogInterface = new Intent();
    paramDialogInterface.putExtra("isNeedFinish", true);
    this.b.a.setResult(-1, paramDialogInterface);
    this.b.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionInfoCardActivity.11.2
 * JD-Core Version:    0.7.0.1
 */