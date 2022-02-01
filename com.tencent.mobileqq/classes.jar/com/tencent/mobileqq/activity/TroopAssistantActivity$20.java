package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class TroopAssistantActivity$20
  implements Runnable
{
  TroopAssistantActivity$20(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void run()
  {
    try
    {
      List localList = this.this$0.e();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("refreshTroopList -- data.size():");
      int j = 0;
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localList.size();
      }
      localStringBuilder1.append(i);
      QLog.e("TroopAssistantActivity", 2, localStringBuilder1.toString());
      if (QLog.isColorLevel())
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("data|size");
        if (localList == null) {
          i = j;
        } else {
          i = localList.size();
        }
        localStringBuilder1.append(i);
        QLog.i("TroopAssistantActivity", 2, localStringBuilder1.toString());
      }
      try
      {
        Collections.sort(localList, this.this$0.L);
      }
      catch (Exception localException2)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder3 = new StringBuilder();
          localStringBuilder3.append("Collections.sort error ..., msg: ");
          localStringBuilder3.append(localException2.getMessage());
          QLog.e("TroopAssistantActivity", 2, localStringBuilder3.toString());
        }
      }
      this.this$0.runOnUiThread(new TroopAssistantActivity.20.1(this, localList));
      return;
    }
    catch (Exception localException1)
    {
      ReportController.b(this.this$0.app, "P_CliOper", "BizTechReport", "", "troop_assistant", "load_data_failed", 0, 0, localException1.toString(), "", "", "");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("refreshTroopList exception:");
        localStringBuilder2.append(localException1.toString());
        QLog.i("TroopAssistantActivity", 2, localStringBuilder2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.20
 * JD-Core Version:    0.7.0.1
 */