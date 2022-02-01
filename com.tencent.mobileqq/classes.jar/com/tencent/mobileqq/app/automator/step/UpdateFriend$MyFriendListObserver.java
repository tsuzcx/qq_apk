package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

class UpdateFriend$MyFriendListObserver
  extends FriendListObserver
{
  private UpdateFriend$MyFriendListObserver(UpdateFriend paramUpdateFriend) {}
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.a.mStepId == 7) || (this.a.mStepId == 3))
    {
      if (!paramBoolean1)
      {
        this.a.setResult(6);
        return;
      }
      if ((paramBoolean1) && (paramBoolean2))
      {
        this.a.mAutomator.a.edit().putBoolean("isFriendlistok", true).commit();
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onUpdateFriendList put PREF_ISFRIENDLIST_OK true");
        }
        this.a.mAutomator.notifyUI(3, true, Integer.valueOf(1));
        this.a.setResult(7);
      }
    }
  }
  
  protected void onUpdateGatherFriendList(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.a.mStepId == 8)
    {
      if (!paramBoolean1)
      {
        this.a.setResult(6);
        return;
      }
      if (paramBoolean2) {
        this.a.setResult(7);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateFriend.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */