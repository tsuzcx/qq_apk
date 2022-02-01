package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;

class DiscussChatPie$4$1
  implements DialogInterface.OnClickListener
{
  DiscussChatPie$4$1(DiscussChatPie.4 param4, Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
    paramDialogInterface.putExtra("uin", this.b.a.ah.b);
    paramDialogInterface.putExtra("uintype", 3000);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.DiscussChatPie.4.1
 * JD-Core Version:    0.7.0.1
 */