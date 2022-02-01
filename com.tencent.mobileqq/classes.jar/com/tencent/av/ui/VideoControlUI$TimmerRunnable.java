package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class VideoControlUI$TimmerRunnable
  implements Runnable
{
  VideoControlUI$TimmerRunnable(VideoControlUI paramVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.am != null) && (this.this$0.ae))
    {
      String str = UITools.a(this.this$0.am.z());
      VideoControlUI localVideoControlUI = this.this$0;
      localVideoControlUI.Z += 1;
      str = this.this$0.g(str);
      this.this$0.i(str);
      this.this$0.al.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.VideoControlUI.TimmerRunnable
 * JD-Core Version:    0.7.0.1
 */