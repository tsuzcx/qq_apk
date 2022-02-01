package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopFile;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AIORevokeMsgHelper$5
  implements ActionSheet.OnButtonClickListener
{
  AIORevokeMsgHelper$5(AIORevokeMsgHelper paramAIORevokeMsgHelper, ChatMessage paramChatMessage, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ReportController.b(AIORevokeMsgHelper.b(this.c), "dc00899", "Grp_chatRecord", "", "remove_file", "Clk_cel", 0, 0, AIORevokeMsgHelper.c(this.c).b, "", "", "");
      }
    }
    else
    {
      AIORevokeMsgHelper.a(this.c, (MessageForTroopFile)this.a);
      ReportController.b(AIORevokeMsgHelper.b(this.c), "dc00899", "Grp_chatRecord", "", "remove_file", "tips_det", 0, 0, AIORevokeMsgHelper.c(this.c).b, "", "", "");
    }
    this.b.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIORevokeMsgHelper.5
 * JD-Core Version:    0.7.0.1
 */