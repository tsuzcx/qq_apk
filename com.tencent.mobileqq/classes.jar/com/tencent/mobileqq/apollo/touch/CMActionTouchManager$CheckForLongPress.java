package com.tencent.mobileqq.apollo.touch;

import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.apollo.listener.OnApolloViewListener;
import com.tencent.qphone.base.util.QLog;

class CMActionTouchManager$CheckForLongPress
  implements Runnable
{
  private int a;
  
  CMActionTouchManager$CheckForLongPress(CMActionTouchManager paramCMActionTouchManager) {}
  
  public void a()
  {
    this.a = CMActionTouchManager.a(this.this$0);
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow][CMActionTouchManager]", 2, "CheckForLongPress onLongClick");
    }
    if (this.a == CMActionTouchManager.a(this.this$0))
    {
      CMActionTouchManager.a(this.this$0, true);
      CMActionTouchManager.a(this.this$0).sendAccessibilityEvent(2);
      if ((!TextUtils.isEmpty(CMActionTouchManager.a(this.this$0))) && (CMActionTouchManager.b(this.this$0) >= 0) && (CMActionTouchManager.a(this.this$0) != null)) {
        CMActionTouchManager.a(this.this$0).onNotifyLongTouch(CMActionTouchManager.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.touch.CMActionTouchManager.CheckForLongPress
 * JD-Core Version:    0.7.0.1
 */