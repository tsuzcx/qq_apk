package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$35
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$35(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof Integer)))
    {
      int i = ((Integer)localObject).intValue();
      if (i >= 0)
      {
        localObject = paramView.findViewById(2131448581);
        boolean bool2 = false;
        boolean bool1 = bool2;
        if (((View)localObject).getTag() != null)
        {
          bool1 = bool2;
          if ((((View)localObject).getTag() instanceof Boolean)) {
            bool1 = ((Boolean)((View)localObject).getTag()).booleanValue();
          }
        }
        if (bool1)
        {
          localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.ad.getItem(i);
          this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
          if ((this.a.bm != null) && (this.a.bm.isShowing())) {
            this.a.bm.dismiss();
          }
          if (this.a.az == 11) {
            ReportController.b(this.a.bc, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
          }
        }
        else
        {
          localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.K.getItem(i);
          this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
          if (this.a.az == 11) {
            ReportController.b(this.a.bc, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
          }
          if (this.a.az == 18) {
            ReportController.b(this.a.bc, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.w, "", "", "");
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.35
 * JD-Core Version:    0.7.0.1
 */