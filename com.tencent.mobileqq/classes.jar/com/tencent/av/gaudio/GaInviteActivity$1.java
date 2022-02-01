package com.tencent.av.gaudio;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class GaInviteActivity$1
  implements DialogInterface.OnClickListener
{
  GaInviteActivity$1(GaInviteActivity paramGaInviteActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.isFinishing()) {}
    while (((Build.VERSION.SDK_INT >= 17) && (this.a.isDestroyed())) || (paramInt == 1)) {
      return;
    }
    ChatActivityUtils.a(this.a, true, new GaInviteActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.gaudio.GaInviteActivity.1
 * JD-Core Version:    0.7.0.1
 */