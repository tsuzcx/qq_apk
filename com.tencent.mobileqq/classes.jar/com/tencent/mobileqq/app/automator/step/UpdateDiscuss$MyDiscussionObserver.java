package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.discussion.observer.DiscussionObserver;
import com.tencent.qphone.base.util.QLog;

class UpdateDiscuss$MyDiscussionObserver
  extends DiscussionObserver
{
  private UpdateDiscuss$MyDiscussionObserver(UpdateDiscuss paramUpdateDiscuss) {}
  
  protected void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateDiscussionList: ");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      this.a.setResult(6);
      return;
    }
    this.a.mAutomator.d.edit().putBoolean("isDiscussionlistok", true).commit();
    this.a.mAutomator.notifyUI(3, true, Integer.valueOf(3));
    this.a.setResult(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateDiscuss.MyDiscussionObserver
 * JD-Core Version:    0.7.0.1
 */