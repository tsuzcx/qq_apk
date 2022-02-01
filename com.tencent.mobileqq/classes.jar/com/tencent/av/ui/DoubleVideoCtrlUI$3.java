package com.tencent.av.ui;

import android.app.Activity;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class DoubleVideoCtrlUI$3
  implements Runnable
{
  DoubleVideoCtrlUI$3(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    ChildLockCircle localChildLockCircle;
    if ((this.this$0.a != null) && (this.this$0.a.get() != null)) {
      localChildLockCircle = (ChildLockCircle)((Activity)this.this$0.a.get()).findViewById(2131373363);
    } else {
      localChildLockCircle = null;
    }
    if (localChildLockCircle != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.d, 1, "timtest HideChildLockUIRunnable");
      }
      localChildLockCircle.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.3
 * JD-Core Version:    0.7.0.1
 */