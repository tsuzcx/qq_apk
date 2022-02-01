package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;

class TroopMemberListActivity$SearchDialogDismissRunnable
  implements Runnable
{
  private WeakReference<TroopMemberListActivity> a;
  
  public TroopMemberListActivity$SearchDialogDismissRunnable(TroopMemberListActivity paramTroopMemberListActivity)
  {
    this.a = new WeakReference(paramTroopMemberListActivity);
  }
  
  public void run()
  {
    TroopMemberListActivity localTroopMemberListActivity = (TroopMemberListActivity)this.a.get();
    if (localTroopMemberListActivity != null)
    {
      localTroopMemberListActivity.isSearchMode = false;
      int i = localTroopMemberListActivity.mTitleBar.getHeight();
      Object localObject = localTroopMemberListActivity.mRootView;
      i = -i;
      ((LinearLayout)localObject).offsetTopAndBottom(i);
      localTroopMemberListActivity.mTitleBar.setVisibility(0);
      localObject = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      localTroopMemberListActivity.mRootView.startAnimation((Animation)localObject);
      ((InputMethodManager)localTroopMemberListActivity.getSystemService("input_method")).hideSoftInputFromWindow(localTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchDialogDismissRunnable
 * JD-Core Version:    0.7.0.1
 */