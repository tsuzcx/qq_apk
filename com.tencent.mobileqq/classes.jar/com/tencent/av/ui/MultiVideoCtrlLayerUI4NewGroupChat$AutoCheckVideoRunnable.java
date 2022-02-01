package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class MultiVideoCtrlLayerUI4NewGroupChat$AutoCheckVideoRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUI4NewGroupChat$AutoCheckVideoRunnable(MultiVideoCtrlLayerUI4NewGroupChat paramMultiVideoCtrlLayerUI4NewGroupChat) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.X, 2, "AutoCheckVideoRunnable");
    }
    if (this.this$0.am != null) {
      this.this$0.am.k().bv = true;
    }
    MultiVideoCtrlLayerUI4NewGroupChat.f(this.this$0);
    if (this.this$0.al != null) {
      this.this$0.al.a(this.this$0.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUI4NewGroupChat.AutoCheckVideoRunnable
 * JD-Core Version:    0.7.0.1
 */