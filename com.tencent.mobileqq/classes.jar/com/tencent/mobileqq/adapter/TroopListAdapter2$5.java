package com.tencent.mobileqq.adapter;

import aklr;
import akly;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class TroopListAdapter2$5
  implements Runnable
{
  public TroopListAdapter2$5(aklr paramaklr, TroopManager paramTroopManager, String paramString, akly paramakly, boolean paramBoolean) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.d(this.jdField_a_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("TroopListAdapter2", 2, "itemTag.troopInfo.troopcode == null, queryDB");
    }
    ThreadManager.getUIHandler().post(new TroopListAdapter2.5.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.TroopListAdapter2.5
 * JD-Core Version:    0.7.0.1
 */