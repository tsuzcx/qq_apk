package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class GAudioMembersCtrlActivity$RefreshFaceRunnable
  implements Runnable
{
  private GAudioMembersCtrlActivity$RefreshFaceRunnable(GAudioMembersCtrlActivity paramGAudioMembersCtrlActivity) {}
  
  public void run()
  {
    if (this.this$0.c != null) {
      this.this$0.c.a();
    }
    this.this$0.a.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.GAudioMembersCtrlActivity.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */