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
    if ((localObject == null) || (!(localObject instanceof Integer))) {}
    int i;
    do
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = ((Integer)localObject).intValue();
    } while (i < 0);
    localObject = paramView.findViewById(2131380459);
    if ((((View)localObject).getTag() != null) && ((((View)localObject).getTag() instanceof Boolean))) {}
    for (boolean bool = ((Boolean)((View)localObject).getTag()).booleanValue();; bool = false)
    {
      if (bool)
      {
        localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$SearchResultAdapter.getItem(i);
        this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
        if ((this.a.jdField_d_of_type_AndroidAppDialog != null) && (this.a.jdField_d_of_type_AndroidAppDialog.isShowing())) {
          this.a.jdField_d_of_type_AndroidAppDialog.dismiss();
        }
        if (this.a.jdField_d_of_type_Int != 11) {
          break;
        }
        ReportController.b(this.a.b, "CliOper", "", "", "0X8006218", "0X8006218", 0, 0, "", "", "", "");
        break;
      }
      localObject = (ChatHistoryTroopMemberFragment.ATroopMember)this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.getItem(i);
      this.a.a((ChatHistoryTroopMemberFragment.ATroopMember)localObject);
      if (this.a.jdField_d_of_type_Int == 11) {
        ReportController.b(this.a.b, "CliOper", "", "", "0X8006219", "0X8006219", 0, 0, "", "", "", "");
      }
      if (this.a.jdField_d_of_type_Int != 18) {
        break;
      }
      ReportController.b(this.a.b, "dc00899", "Grp_chatRecord", "", "chatRecor_mber", "mber_clk", 0, 0, this.a.c, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.35
 * JD-Core Version:    0.7.0.1
 */