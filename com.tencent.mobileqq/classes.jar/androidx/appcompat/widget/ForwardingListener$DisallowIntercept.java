package androidx.appcompat.widget;

import android.view.View;
import android.view.ViewParent;

class ForwardingListener$DisallowIntercept
  implements Runnable
{
  ForwardingListener$DisallowIntercept(ForwardingListener paramForwardingListener) {}
  
  public void run()
  {
    ViewParent localViewParent = this.this$0.mSrc.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ForwardingListener.DisallowIntercept
 * JD-Core Version:    0.7.0.1
 */