package androidx.appcompat.widget;

import android.os.Build.VERSION;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class AppCompatSpinner$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  AppCompatSpinner$2(AppCompatSpinner paramAppCompatSpinner) {}
  
  public void onGlobalLayout()
  {
    if (!this.this$0.getInternalPopup().isShowing()) {
      this.this$0.showPopup();
    }
    ViewTreeObserver localViewTreeObserver = this.this$0.getViewTreeObserver();
    if (localViewTreeObserver != null)
    {
      if (Build.VERSION.SDK_INT >= 16)
      {
        localViewTreeObserver.removeOnGlobalLayoutListener(this);
        return;
      }
      localViewTreeObserver.removeGlobalOnLayoutListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.AppCompatSpinner.2
 * JD-Core Version:    0.7.0.1
 */