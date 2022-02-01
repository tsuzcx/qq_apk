package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;

class TroopAssistantActivity$16
  implements Runnable
{
  TroopAssistantActivity$16(TroopAssistantActivity paramTroopAssistantActivity, QQMessageFacade paramQQMessageFacade, TextView paramTextView) {}
  
  public void run()
  {
    int i = this.jdField_a_of_type_ComTencentImcoreMessageQQMessageFacade.getUnreadMsgsNum();
    String str;
    if (i > 99) {
      str = "99+";
    }
    for (;;)
    {
      this.this$0.runOnUiThread(new TroopAssistantActivity.16.1(this, i, str));
      return;
      if (i <= 0) {
        str = "";
      } else {
        str = String.valueOf(i);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.16
 * JD-Core Version:    0.7.0.1
 */