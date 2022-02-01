package com.tencent.av.ui;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class MultiVideoCtrlLayerUIBase$1$1
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$1$1(MultiVideoCtrlLayerUIBase.1 param1) {}
  
  public void run()
  {
    if ((this.a.a.a() != null) && (this.a.a.a().size() != 0))
    {
      this.a.a.b(-1017L, "InviteMemberObserver");
      return;
    }
    QLog.d(this.a.a.d, 1, "InviteMemberObserver null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.1.1
 * JD-Core Version:    0.7.0.1
 */