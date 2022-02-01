package com.tencent.mobileqq.activity;

import android.widget.TextView;
import com.tencent.imcore.message.QQMessageFacade;

class TroopAssistantActivity$17
  implements Runnable
{
  TroopAssistantActivity$17(TroopAssistantActivity paramTroopAssistantActivity, QQMessageFacade paramQQMessageFacade, TextView paramTextView) {}
  
  public void run()
  {
    int i = this.a.w();
    String str;
    if (i > 99) {
      str = "99+";
    } else if (i <= 0) {
      str = "";
    } else {
      str = String.valueOf(i);
    }
    this.this$0.runOnUiThread(new TroopAssistantActivity.17.1(this, i, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.17
 * JD-Core Version:    0.7.0.1
 */