package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.managers.TroopAssistantManager;

class TroopAssisSettingActivity$1
  implements Runnable
{
  TroopAssisSettingActivity$1(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void run()
  {
    this.this$0.jdField_a_of_type_JavaUtilMap = TroopAssistantManager.a().a(this.this$0.app, this.this$0.jdField_a_of_type_JavaUtilList);
    this.this$0.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */