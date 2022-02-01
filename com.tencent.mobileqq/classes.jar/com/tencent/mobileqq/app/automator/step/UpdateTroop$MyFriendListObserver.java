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
  
  public void onUpdateTroopList(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "updateTroopList:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(6);
      return;
    }
    this.a.a.a.edit().putBoolean("isTrooplistok", true).commit();
    this.a.a.notifyUI(3, true, Integer.valueOf(2));
    this.a.a(7);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.UpdateTroop.MyFriendListObserver
 * JD-Core Version:    0.7.0.1
 */