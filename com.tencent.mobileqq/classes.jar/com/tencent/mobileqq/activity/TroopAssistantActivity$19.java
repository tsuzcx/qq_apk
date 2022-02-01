package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;

class TroopAssistantActivity$19
  implements ThreadExcutor.IThreadListener
{
  TroopAssistantActivity$19(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void onAdded()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRefreshListener onAdded:");
    localStringBuilder.append(TroopAssistantActivity.c(this.a));
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    TroopAssistantActivity.a(this.a, true);
  }
  
  public void onPostRun()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRefreshListener onPostRun:");
    localStringBuilder.append(TroopAssistantActivity.c(this.a));
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    TroopAssistantActivity.a(this.a, false);
  }
  
  public void onPreRun()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mRefreshListener onPreRun:");
    localStringBuilder.append(TroopAssistantActivity.c(this.a));
    QLog.e("TroopAssistantActivity", 2, localStringBuilder.toString());
    TroopAssistantActivity.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.19
 * JD-Core Version:    0.7.0.1
 */