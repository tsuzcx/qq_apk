package com.tencent.mobileqq.activity.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;

class Conversation$11
  implements DialogInterface.OnClickListener
{
  Conversation$11(Conversation paramConversation) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramDialogInterface == Conversation.a(this.a)) {
      Conversation.a(this.a, null);
    }
    ReportController.b(this.a.a, "CliOper", "", "", "0X800815E", "0X800815E", 0, 0, "", "", "", "");
    ReportController.b(this.a.a, "CliOper", "", "", "0X8008656", "0X8008656", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.11
 * JD-Core Version:    0.7.0.1
 */