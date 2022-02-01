package com.tencent.av.ui;

import android.app.Activity;
import com.tencent.av.widget.ChildLockCircle;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class DoubleVideoCtrlUI$16
  implements Runnable
{
  DoubleVideoCtrlUI$16(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.this$0.a != null)
    {
      localObject1 = localObject2;
      if (this.this$0.a.get() != null) {
        localObject1 = (ChildLockCircle)((Activity)this.this$0.a.get()).findViewById(2131373264);
      }
    }
    if (localObject1 != null)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.this$0.d, 1, "timtest HideChildLockUIRunnable");
      }
      ((ChildLockCircle)localObject1).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.16
 * JD-Core Version:    0.7.0.1
 */