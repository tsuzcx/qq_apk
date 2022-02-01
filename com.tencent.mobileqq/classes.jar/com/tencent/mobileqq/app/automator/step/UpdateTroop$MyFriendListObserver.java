package com.tencent.mobileqq.app.automator.step;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

class UpdateTroop$MyFriendListObserver
  extends TroopObserver
{
  private UpdateTroop$MyFriendListObserver(UpdateTroop paramUpdateTroop) {}
  
  protected void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updateTroopList:");
      localStringBuilder.append(paramBoolean);
      QLog.d("QQInitHandler", 2, localStringBuilder.toString());
    }
    if (!paramBoolean)
    {
      this.a.setResult(6);
      return;
    }
    this.a.mAutomator.a.edit().putBoolean("isTrooplistok", true).commit();
    this.a.mAutomator.notifyUI(3, true, Integer.valueOf(2));
    this.a.setResult(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */