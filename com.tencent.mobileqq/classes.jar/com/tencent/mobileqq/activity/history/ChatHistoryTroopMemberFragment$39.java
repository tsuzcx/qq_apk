package com.tencent.mobileqq.activity.history;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberMngHandler;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

class ChatHistoryTroopMemberFragment$39
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$39(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, List paramList, CheckBox paramCheckBox, boolean paramBoolean, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (ITroopMemberMngHandler)this.e.bc.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_MNG_HANDLER);
    if (localObject != null)
    {
      ((ITroopMemberMngHandler)localObject).a(Long.parseLong(this.e.w), this.a, this.b.isChecked(), this.c);
      String str = this.e.aK;
      if (this.b.isChecked()) {
        localObject = "0";
      } else {
        localObject = "1";
      }
      ReportController.b(this.e.bc, "P_CliOper", "Grp_manage", "", "del_mber", "Clk_del", 1, 0, this.e.w, str, (String)localObject, "");
    }
    localObject = this.d;
    if ((localObject != null) && (((Dialog)localObject).isShowing())) {
      this.d.dismiss();
    }
    this.e.B();
    this.e.L.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.39
 * JD-Core Version:    0.7.0.1
 */