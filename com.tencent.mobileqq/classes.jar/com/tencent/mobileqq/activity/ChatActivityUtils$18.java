package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;

final class ChatActivityUtils$18
  implements DialogInterface.OnClickListener
{
  ChatActivityUtils$18(Activity paramActivity, DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 1)
    {
      localObject = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
      ((Intent)localObject).setData(Uri.fromParts("package", this.a.getPackageName(), null));
      this.a.startActivity((Intent)localObject);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((DialogInterface.OnClickListener)localObject).onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityUtils.18
 * JD-Core Version:    0.7.0.1
 */