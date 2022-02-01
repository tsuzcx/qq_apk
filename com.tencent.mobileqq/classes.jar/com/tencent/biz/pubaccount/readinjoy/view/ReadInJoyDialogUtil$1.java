package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.mobileqq.activity.SplashActivity;
import cooperation.readinjoy.ReadInJoyHelper;

final class ReadInJoyDialogUtil$1
  implements DialogInterface.OnClickListener
{
  ReadInJoyDialogUtil$1(Context paramContext) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      ReadInJoyHelper.d(1);
      ReadInJoyHelper.a(true);
      ReadInJoyActivityHelper.a(this.a, 9);
    }
    for (;;)
    {
      if ((this.a instanceof Activity)) {
        ((Activity)this.a).finish();
      }
      return;
      paramDialogInterface = new Intent(this.a, SplashActivity.class);
      paramDialogInterface.putExtra("fragment_id", 1);
      paramDialogInterface.putExtra("open_kandian_tab_fragment", true);
      paramDialogInterface.putExtra("arg_channel_cover_id", 0);
      paramDialogInterface.setFlags(335544320);
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyDialogUtil.1
 * JD-Core Version:    0.7.0.1
 */