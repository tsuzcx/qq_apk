package com.tencent.av.ui;

import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;

class DoubleVideoCtrlUI$12
  implements Runnable
{
  DoubleVideoCtrlUI$12(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.V()) {
      return;
    }
    String str1 = this.this$0.al.getCurrentAccountUin();
    int i = this.this$0.am.k().bS;
    String str2 = this.this$0.X;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume, setGlass, nCurrentSwitch[");
    localStringBuilder.append(i);
    localStringBuilder.append("]");
    QLog.w(str2, 1, localStringBuilder.toString());
    this.this$0.al.a(new Object[] { Integer.valueOf(42), str1, Integer.valueOf(i) });
    DoubleVideoCtrlUI.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.12
 * JD-Core Version:    0.7.0.1
 */