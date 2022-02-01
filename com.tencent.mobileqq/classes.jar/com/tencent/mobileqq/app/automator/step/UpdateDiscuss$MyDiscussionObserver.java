package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.qphone.base.util.QLog;

class UpdateDiscuss$MyDiscussionObserver
  extends DiscussionObserver
{
  private UpdateDiscuss$MyDiscussionObserver(UpdateDiscuss paramUpdateDiscuss) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateDiscussionList: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    this.a.a.a.edit().putBoolean("isDiscussionlistok", true).commit();
    this.a.a.notifyUI(3, true, Integer.valueOf(3));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */