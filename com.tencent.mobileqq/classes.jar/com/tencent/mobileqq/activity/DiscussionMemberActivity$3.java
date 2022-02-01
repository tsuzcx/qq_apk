package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Handler;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;

class DiscussionMemberActivity$3
  implements DialogInterface.OnDismissListener
{
  DiscussionMemberActivity$3(DiscussionMemberActivity paramDiscussionMemberActivity, int paramInt, TranslateAnimation paramTranslateAnimation, InputMethodManager paramInputMethodManager, AvatarObserver paramAvatarObserver) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityDiscussionMemberActivity.a.getHandler().postDelayed(new DiscussionMemberActivity.3.1(this), 150L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.DiscussionMemberActivity.3
 * JD-Core Version:    0.7.0.1
 */