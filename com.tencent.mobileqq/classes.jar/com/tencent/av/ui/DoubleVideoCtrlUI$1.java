package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.TipsUtil;
import com.tencent.av.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$1
  implements Runnable
{
  DoubleVideoCtrlUI$1(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.V()) {
      return;
    }
    long l = AudioHelper.c();
    if ((!this.this$0.am.n()) && (this.this$0.am.k().h == 1) && (this.this$0.am.k().H))
    {
      if (QLog.isColorLevel())
      {
        String str = this.this$0.X;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("FixTerSwitchStatus ,switch to pc ,local close camera, seq[");
        localStringBuilder.append(l);
        localStringBuilder.append("]");
        QLog.w(str, 1, localStringBuilder.toString());
      }
      this.this$0.m(l);
      this.this$0.al.a(new Object[] { Integer.valueOf(106), Long.valueOf(l) });
      TipsUtil.a(this.this$0.al, 1021);
    }
    this.this$0.f(l, 16777215);
    if (this.this$0.am.k().E) {
      this.this$0.am.a(true, this.this$0.am.k().s);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.1
 * JD-Core Version:    0.7.0.1
 */