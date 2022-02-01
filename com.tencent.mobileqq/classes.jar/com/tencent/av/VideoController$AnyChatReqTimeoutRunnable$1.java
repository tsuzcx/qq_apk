package com.tencent.av;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.SessionInfo.Anychat_Info;
import com.tencent.av.app.VideoAppInterface;

class VideoController$AnyChatReqTimeoutRunnable$1
  implements DialogInterface.OnClickListener
{
  VideoController$AnyChatReqTimeoutRunnable$1(VideoController.AnyChatReqTimeoutRunnable paramAnyChatReqTimeoutRunnable) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.this$0.a().d == null) {
      this.a.this$0.a().d = this.a.this$0.a().a.c;
    }
    this.a.this$0.a().a("AnyChatReqTimeoutRunnable", 6);
    this.a.this$0.a(this.a.a, 2131230741, 1, VideoController.a(this.a.this$0, this.a.a));
    this.a.this$0.a.a(new Object[] { Integer.valueOf(14), Integer.valueOf(9), this.a.this$0.a().d, Long.valueOf(this.a.a) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.VideoController.AnyChatReqTimeoutRunnable.1
 * JD-Core Version:    0.7.0.1
 */