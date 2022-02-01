package com.google.android.material.snackbar;

import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.behavior.SwipeDismissBehavior.OnDismissListener;

class BaseTransientBottomBar$9
  implements SwipeDismissBehavior.OnDismissListener
{
  BaseTransientBottomBar$9(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      SnackbarManager.a().c(this.a.c);
      return;
    }
    SnackbarManager.a().d(this.a.c);
  }
  
  public void a(@NonNull View paramView)
  {
    if (paramView.getParent() != null) {
      paramView.setVisibility(8);
    }
    this.a.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.9
 * JD-Core Version:    0.7.0.1
 */