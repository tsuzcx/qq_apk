package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;

class AVActivity$12$1
  implements Runnable
{
  AVActivity$12$1(AVActivity.12 param12) {}
  
  public void run()
  {
    if ((this.a.a.I != null) && (this.a.a.I.k().i != 4) && (this.a.a.b == 1) && (!this.a.a.u))
    {
      this.a.a.b(false);
      this.a.a.f(false);
      if ((this.a.a.K != null) && ((this.a.a.K instanceof DoubleVideoCtrlUI)))
      {
        ((DoubleVideoCtrlUI)this.a.a.K).a();
        ((DoubleVideoCtrlUI)this.a.a.K).b(true);
        this.a.a.K.f(-1028L, 16777215);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.12.1
 * JD-Core Version:    0.7.0.1
 */