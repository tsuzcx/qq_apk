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
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.this$0.a != null)
    {
      localObject1 = localObject2;
      if (this.this$0.a.get() != null) {
        localObject1 = (ChildLockSign)((Activity)this.this$0.a.get()).findViewById(2131373480);
      }
    }
    if (localObject1 != null) {
      ((ChildLockSign)localObject1).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.4
 * JD-Core Version:    0.7.0.1
 */