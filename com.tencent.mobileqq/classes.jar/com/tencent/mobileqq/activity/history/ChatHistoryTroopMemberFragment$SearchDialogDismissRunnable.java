package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.BaseActivity;
import java.lang.ref.WeakReference;

class ChatHistoryTroopMemberFragment$SearchDialogDismissRunnable
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
      localChatHistoryTroopMemberFragment.ap = false;
      int i = localChatHistoryTroopMemberFragment.M.getHeight();
      Object localObject = localChatHistoryTroopMemberFragment.U;
      i = -i;
      ((LinearLayout)localObject).offsetTopAndBottom(i);
      localObject = new TranslateAnimation(0.0F, 0.0F, i, 0.0F);
      ((TranslateAnimation)localObject).setDuration(300L);
      localChatHistoryTroopMemberFragment.U.startAnimation((Animation)localObject);
      ((InputMethodManager)localChatHistoryTroopMemberFragment.getBaseActivity().getSystemService("input_method")).hideSoftInputFromWindow(localChatHistoryTroopMemberFragment.getBaseActivity().getWindow().peekDecorView().getWindowToken(), 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.SearchDialogDismissRunnable
 * JD-Core Version:    0.7.0.1
 */