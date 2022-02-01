package com.tencent.av.smallscreen;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.utils.UITools;

class SmallScreenVideoControlUI$TimmerRunnable
  implements Runnable
{
  SmallScreenVideoControlUI$TimmerRunnable(SmallScreenVideoControlUI paramSmallScreenVideoControlUI) {}
  
  public void run()
  {
    if ((this.this$0.z != null) && (this.this$0.s))
    {
      long l = this.this$0.z.z();
      if ((this.this$0.u == null) || (l != 0L))
      {
        this.this$0.u = UITools.a(l);
        if ((this.this$0.B != null) && (!this.this$0.t))
        {
          this.this$0.B.setContentDescription(UITools.a(this.this$0.u));
          this.this$0.B.setText(this.this$0.u);
        }
      }
      this.this$0.y.a().postDelayed(this, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenVideoControlUI.TimmerRunnable
 * JD-Core Version:    0.7.0.1
 */