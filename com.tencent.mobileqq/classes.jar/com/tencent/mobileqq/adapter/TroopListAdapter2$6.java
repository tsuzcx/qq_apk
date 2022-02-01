package com.tencent.mobileqq.adapter;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItem;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class TroopListAdapter2$6
  implements Runnable
{
  TroopListAdapter2$6(TroopListAdapter2 paramTroopListAdapter2, TroopManager paramTroopManager, String paramString, TroopListItem paramTroopListItem, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.a.v(this.b);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListAdapter2", 2, "itemTag.troopInfo.troopcode == null, queryDB");
    }
    ThreadManager.getUIHandler().post(new TroopListAdapter2.6.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.6
 * JD-Core Version:    0.7.0.1
 */