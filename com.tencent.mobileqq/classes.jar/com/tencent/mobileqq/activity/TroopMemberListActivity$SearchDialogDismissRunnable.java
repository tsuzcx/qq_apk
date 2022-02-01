package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;

public class TroopMemberListActivity$SearchDialogDismissRunnable
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
      localTroopMemberListActivity.h = false;
      int i = localTroopMemberListActivity.a.getHeight();
      localTroopMemberListActivity.b.offsetTopAndBottom(-i);
      localTroopMemberListActivity.a.setVisibility(0);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localTroopMemberListActivity.b.startAnimation(localTranslateAnimation);
      ((InputMethodManager)localTroopMemberListActivity.getSystemService("input_method")).hideSoftInputFromWindow(localTroopMemberListActivity.getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopMemberListActivity.SearchDialogDismissRunnable
 * JD-Core Version:    0.7.0.1
 */