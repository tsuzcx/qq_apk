package com.tencent.mobileqq.activity;

import android.os.Handler;
import com.tencent.mobileqq.managers.TroopAssistantManager;

class TroopAssisSettingActivity$1
  implements Runnable
{
  TroopAssisSettingActivity$1(TroopAssisSettingActivity paramTroopAssisSettingActivity) {}
  
  public void run()
  {
    this.this$0.c = TroopAssistantManager.a().a(this.this$0.app, this.this$0.d);
    this.this$0.h.sendEmptyMessage(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssisSettingActivity.1
 * JD-Core Version:    0.7.0.1
 */