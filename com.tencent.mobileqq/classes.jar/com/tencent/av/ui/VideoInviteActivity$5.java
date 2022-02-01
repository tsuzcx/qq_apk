package com.tencent.av.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Build.VERSION;
import com.tencent.mobileqq.activity.ChatActivityUtils;

class VideoInviteActivity$5
  implements DialogInterface.OnClickListener
{
  VideoInviteActivity$5(VideoInviteActivity paramVideoInviteActivity, long paramLong, boolean paramBoolean) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.c.isFinishing()) {
      return;
    }
    if ((Build.VERSION.SDK_INT >= 17) && (this.c.isDestroyed())) {
      return;
    }
    if (paramInt == 1)
    {
      this.c.c(this.a);
      return;
    }
    ChatActivityUtils.a(this.c, this.b, new VideoInviteActivity.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoInviteActivity.5
 * JD-Core Version:    0.7.0.1
 */