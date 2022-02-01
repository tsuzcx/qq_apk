package com.tencent.mobileqq.activity.aio.core;

import android.text.Editable;
import android.text.SpannableString;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.text.AtTroopMemberSpan;
import com.tencent.widget.XEditTextEx;
import com.tencent.widget.XPanelContainer;

class BaseTroopChatPie$5
  implements Runnable
{
  BaseTroopChatPie$5(BaseTroopChatPie paramBaseTroopChatPie, boolean paramBoolean, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    int i;
    if (this.a)
    {
      i = this.this$0.Y.getSelectionStart();
      this.this$0.Y.getEditableText().delete(i - 1, i);
    }
    Object localObject = AtTroopMemberSpan.a(this.this$0.d, this.this$0.f, this.this$0.ah.b, this.b, this.c, this.this$0.bF(), this.this$0.Y, true);
    if (localObject != null)
    {
      if (((SpannableString)localObject).length() == 0) {
        return;
      }
      int j = this.this$0.Y.getSelectionStart();
      i = j;
      if (j < 0) {
        i = 0;
      }
      this.this$0.Y.getEditableText().insert(i, (CharSequence)localObject);
      this.this$0.n.a(1);
      i = this.d;
      if (i == 1)
      {
        ReportController.b(this.this$0.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Press_AIOhead_sendatmsg", 0, 0, this.this$0.ah.b, "", "", "");
        return;
      }
      if (i == 4)
      {
        localObject = this.b;
        if ((localObject != null) && (((String)localObject).equalsIgnoreCase("0")))
        {
          ReportController.b(this.this$0.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Clk_atallmber_sendatallmsg", 0, 0, this.this$0.ah.b, "", "", "");
          return;
        }
        ReportController.b(this.this$0.d, "P_CliOper", "Grp_AIO", "", "AIOchat", "Input_atmber_sendatmsg", 0, 0, this.this$0.ah.b, "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseTroopChatPie.5
 * JD-Core Version:    0.7.0.1
 */