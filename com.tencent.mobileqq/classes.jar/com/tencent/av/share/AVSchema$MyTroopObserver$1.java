package com.tencent.av.share;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class AVSchema$MyTroopObserver$1
  implements DialogInterface.OnClickListener
{
  AVSchema$MyTroopObserver$1(AVSchema.MyTroopObserver paramMyTroopObserver, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.b.a("checkQAVPermission.callback", this.a)) {
      return;
    }
    if (paramInt == 1)
    {
      this.b.b.b(this.a, this.b.a);
      return;
    }
    ChatActivityUtils.a(this.b.b.getBaseActivity(), true, new AVSchema.MyTroopObserver.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.AVSchema.MyTroopObserver.1
 * JD-Core Version:    0.7.0.1
 */