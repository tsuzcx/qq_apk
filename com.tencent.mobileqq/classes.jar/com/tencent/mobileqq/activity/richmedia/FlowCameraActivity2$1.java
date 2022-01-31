package com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.shortvideo.widget.TCProgressBar;

class FlowCameraActivity2$1
  implements Runnable
{
  FlowCameraActivity2$1(FlowCameraActivity2 paramFlowCameraActivity2) {}
  
  public void run()
  {
    if ((this.this$0.b != null) && (!this.this$0.b.isEnabled()))
    {
      this.this$0.b.setEnabled(true);
      this.this$0.b.setText(2131692636);
      this.this$0.b.setTextColor(-15550475);
    }
    int i = 0;
    if (this.this$0.a != null) {
      i = this.this$0.a.c();
    }
    if ((!this.this$0.i.isEnabled()) && (i > 0)) {
      this.this$0.i.setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2.1
 * JD-Core Version:    0.7.0.1
 */