package androidx.appcompat.widget;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import androidx.core.view.ActionProvider;

class ActivityChooserView$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  ActivityChooserView$2(ActivityChooserView paramActivityChooserView) {}
  
  public void onGlobalLayout()
  {
    if (this.this$0.isShowingPopup())
    {
      if (!this.this$0.isShown())
      {
        this.this$0.getListPopupWindow().dismiss();
        return;
      }
      this.this$0.getListPopupWindow().show();
      if (this.this$0.mProvider != null) {
        this.this$0.mProvider.subUiVisibilityChanged(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActivityChooserView.2
 * JD-Core Version:    0.7.0.1
 */