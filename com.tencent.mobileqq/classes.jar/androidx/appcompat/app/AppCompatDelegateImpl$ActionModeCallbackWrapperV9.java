package androidx.appcompat.app;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import androidx.appcompat.view.ActionMode;
import androidx.appcompat.view.ActionMode.Callback;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewPropertyAnimatorCompat;

class AppCompatDelegateImpl$ActionModeCallbackWrapperV9
  implements ActionMode.Callback
{
  private ActionMode.Callback mWrapped;
  
  public AppCompatDelegateImpl$ActionModeCallbackWrapperV9(AppCompatDelegateImpl paramAppCompatDelegateImpl, ActionMode.Callback paramCallback)
  {
    this.mWrapped = paramCallback;
  }
  
  public boolean onActionItemClicked(ActionMode paramActionMode, MenuItem paramMenuItem)
  {
    return this.mWrapped.onActionItemClicked(paramActionMode, paramMenuItem);
  }
  
  public boolean onCreateActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onCreateActionMode(paramActionMode, paramMenu);
  }
  
  public void onDestroyActionMode(ActionMode paramActionMode)
  {
    this.mWrapped.onDestroyActionMode(paramActionMode);
    if (this.this$0.mActionModePopup != null) {
      this.this$0.mWindow.getDecorView().removeCallbacks(this.this$0.mShowActionModePopup);
    }
    if (this.this$0.mActionModeView != null)
    {
      this.this$0.endOnGoingFadeAnimation();
      paramActionMode = this.this$0;
      paramActionMode.mFadeAnim = ViewCompat.animate(paramActionMode.mActionModeView).alpha(0.0F);
      this.this$0.mFadeAnim.setListener(new AppCompatDelegateImpl.ActionModeCallbackWrapperV9.1(this));
    }
    if (this.this$0.mAppCompatCallback != null) {
      this.this$0.mAppCompatCallback.onSupportActionModeFinished(this.this$0.mActionMode);
    }
    this.this$0.mActionMode = null;
  }
  
  public boolean onPrepareActionMode(ActionMode paramActionMode, Menu paramMenu)
  {
    return this.mWrapped.onPrepareActionMode(paramActionMode, paramMenu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AppCompatDelegateImpl.ActionModeCallbackWrapperV9
 * JD-Core Version:    0.7.0.1
 */