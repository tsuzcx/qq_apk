package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$16
  implements Runnable
{
  DoubleVideoCtrlUI$16(DoubleVideoCtrlUI paramDoubleVideoCtrlUI, long paramLong) {}
  
  public void run()
  {
    if ((this.this$0.am != null) && (this.this$0.al != null))
    {
      this.this$0.am.a(this.this$0.am.k().s, 233);
      this.this$0.am.b(233);
      this.this$0.am.b(this.this$0.am.k().s, 9);
      QLog.d(this.this$0.X, 1, "exit when onBackPressed");
      this.this$0.al.a(this.a, 1008);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.16
 * JD-Core Version:    0.7.0.1
 */