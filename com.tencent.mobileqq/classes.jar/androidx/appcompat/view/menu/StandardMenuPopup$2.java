package androidx.appcompat.view.menu;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.ViewTreeObserver;

class StandardMenuPopup$2
  implements View.OnAttachStateChangeListener
{
  StandardMenuPopup$2(StandardMenuPopup paramStandardMenuPopup) {}
  
  public void onViewAttachedToWindow(View paramView) {}
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this.this$0.mTreeObserver != null)
    {
      if (!this.this$0.mTreeObserver.isAlive()) {
        this.this$0.mTreeObserver = paramView.getViewTreeObserver();
      }
      this.this$0.mTreeObserver.removeGlobalOnLayoutListener(this.this$0.mGlobalLayoutListener);
    }
    paramView.removeOnAttachStateChangeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.view.menu.StandardMenuPopup.2
 * JD-Core Version:    0.7.0.1
 */