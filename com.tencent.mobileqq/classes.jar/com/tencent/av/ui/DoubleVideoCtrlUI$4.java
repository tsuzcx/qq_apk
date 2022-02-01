package com.tencent.av.ui;

import android.app.Activity;
import com.tencent.av.widget.ChildLockSign;
import java.lang.ref.WeakReference;

class DoubleVideoCtrlUI$4
  implements Runnable
{
  DoubleVideoCtrlUI$4(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    ChildLockSign localChildLockSign;
    if ((this.this$0.a != null) && (this.this$0.a.get() != null)) {
      localChildLockSign = (ChildLockSign)((Activity)this.this$0.a.get()).findViewById(2131373366);
    } else {
      localChildLockSign = null;
    }
    if (localChildLockSign != null) {
      localChildLockSign.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.4
 * JD-Core Version:    0.7.0.1
 */