package androidx.appcompat.app;

import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;
import androidx.core.view.ViewPropertyAnimatorListenerAdapter;

class AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1
  extends ViewPropertyAnimatorListenerAdapter
{
  AppCompatDelegateImpl$ActionModeCallbackWrapperV9$1(AppCompatDelegateImpl.ActionModeCallbackWrapperV9 paramActionModeCallbackWrapperV9) {}
  
  public void onAnimationEnd(View paramView)
  {
    this.this$1.this$0.mActionModeView.setVisibility(8);
    if (this.this$1.this$0.mActionModePopup != null) {
      this.this$1.this$0.mActionModePopup.dismiss();
    } else if ((this.this$1.this$0.mActionModeView.getParent() instanceof View)) {
      ViewCompat.requestApplyInsets((View)this.this$1.this$0.mActionModeView.getParent());
    }
    this.this$1.this$0.mActionModeView.removeAllViews();
    this.this$1.this$0.mFadeAnim.setListener(null);
    this.this$1.this$0.mFadeAnim = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1
 * JD-Core Version:    0.7.0.1
 */