package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

class TroopAssistantActivity$17
  implements ThreadExcutor.IThreadListener
{
  TroopAssistantActivity$17(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onAdded()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onAdded:" + TroopAssistantActivity.a(this.a));
    TroopAssistantActivity.a(this.a, true);
  }
  
  public void onPostRun()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onPostRun:" + TroopAssistantActivity.a(this.a));
    TroopAssistantActivity.a(this.a, false);
  }
  
  public void onPreRun()
  {
    QLog.e("TroopAssistantActivity", 2, "mRefreshListener onPreRun:" + TroopAssistantActivity.a(this.a));
    TroopAssistantActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.17
 * JD-Core Version:    0.7.0.1
 */