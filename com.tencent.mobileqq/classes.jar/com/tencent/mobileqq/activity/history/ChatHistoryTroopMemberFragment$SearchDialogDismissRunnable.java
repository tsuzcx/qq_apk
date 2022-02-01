package com.tencent.mobileqq.activity.history;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import java.lang.ref.WeakReference;

public class ChatHistoryTroopMemberFragment$SearchDialogDismissRunnable
  implements Runnable
{
  private WeakReference<ChatHistoryTroopMemberFragment> a;
  
  public ChatHistoryTroopMemberFragment$SearchDialogDismissRunnable(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment)
  {
    this.a = new WeakReference(paramChatHistoryTroopMemberFragment);
  }
  
  public void run()
  {
    ChatHistoryTroopMemberFragment localChatHistoryTroopMemberFragment = (ChatHistoryTroopMemberFragment)this.a.get();
    if (localChatHistoryTroopMemberFragment != null)
    {
      localChatHistoryTroopMemberFragment.k = false;
      int i = localChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidViewView.getHeight();
      localChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.offsetTopAndBottom(-i);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, -i, 0.0F);
      localTranslateAnimation.setDuration(300L);
      localChatHistoryTroopMemberFragment.jdField_b_of_type_AndroidWidgetLinearLayout.startAnimation(localTranslateAnimation);
      ((InputMethodManager)localChatHistoryTroopMemberFragment.getActivity().getSystemService("input_method")).hideSoftInputFromWindow(localChatHistoryTroopMemberFragment.getActivity().getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable
 * JD-Core Version:    0.7.0.1
 */