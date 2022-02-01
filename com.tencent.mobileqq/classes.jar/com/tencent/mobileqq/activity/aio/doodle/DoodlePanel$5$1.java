package com.tencent.mobileqq.activity.aio.doodle;

import com.tencent.mobileqq.activity.aio.core.BaseAIOContext;
import com.tencent.mobileqq.scribble.ScribbleMsgConstants;
import com.tencent.mobileqq.widget.QQToast;

class DoodlePanel$5$1
  implements Runnable
{
  DoodlePanel$5$1(DoodlePanel.5 param5, int paramInt) {}
  
  public void run()
  {
    this.b.b.e();
    if (this.a == ScribbleMsgConstants.d)
    {
      this.b.b.d();
      return;
    }
    QQToast.makeText(this.b.b.getContext(), 2131886489, 0).show(DoodlePanel.c(this.b.b).v());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodlePanel.5.1
 * JD-Core Version:    0.7.0.1
 */