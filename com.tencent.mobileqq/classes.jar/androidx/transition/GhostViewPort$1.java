package androidx.transition;

import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnPreDrawListener;
import androidx.core.view.ViewCompat;

class GhostViewPort$1
  implements ViewTreeObserver.OnPreDrawListener
{
  GhostViewPort$1(GhostViewPort paramGhostViewPort) {}
  
  public boolean onPreDraw()
  {
    ViewCompat.postInvalidateOnAnimation(this.this$0);
    if ((this.this$0.mStartParent != null) && (this.this$0.mStartView != null))
    {
      this.this$0.mStartParent.endViewTransition(this.this$0.mStartView);
      ViewCompat.postInvalidateOnAnimation(this.this$0.mStartParent);
      GhostViewPort localGhostViewPort = this.this$0;
      localGhostViewPort.mStartParent = null;
      localGhostViewPort.mStartView = null;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.GhostViewPort.1
 * JD-Core Version:    0.7.0.1
 */