package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class VideoInviteActivity$1
  implements DialogInterface.OnClickListener
{
  VideoInviteActivity$1(VideoInviteActivity paramVideoInviteActivity, long paramLong) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b.isFinishing()) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 17) && (this.b.isDestroyed())) {
      return;
    }
    if (paramInt == 1) {
      return;
    }
    ChatActivityUtils.a(this.b, true, new VideoInviteActivity.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.1
 * JD-Core Version:    0.7.0.1
 */