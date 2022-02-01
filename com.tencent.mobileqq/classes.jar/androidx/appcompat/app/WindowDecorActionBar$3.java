package androidx.appcompat.app;

import android.view.View;
import androidx.appcompat.widget.ActionBarContainer;
import androidx.core.view.ViewPropertyAnimatorUpdateListener;

class WindowDecorActionBar$3
  implements ViewPropertyAnimatorUpdateListener
{
  WindowDecorActionBar$3(WindowDecorActionBar paramWindowDecorActionBar) {}
  
  public void onAnimationUpdate(View paramView)
  {
    ((View)this.this$0.mContainerView.getParent()).invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.WindowDecorActionBar.3
 * JD-Core Version:    0.7.0.1
 */