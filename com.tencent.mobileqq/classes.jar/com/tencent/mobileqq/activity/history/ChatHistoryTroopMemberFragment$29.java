package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.api.ISelectMemberApi;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ChatHistoryTroopMemberFragment$29
  implements ActionSheet.OnButtonClickListener
{
  ChatHistoryTroopMemberFragment$29(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i;
    if ((!ChatHistoryTroopMemberFragment.c(this.a)) && (paramInt >= 5)) {
      i = paramInt + 1;
    } else {
      i = paramInt;
    }
    if (this.a.h)
    {
      if (paramInt == 0)
      {
        this.a.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.1(this), 320L);
      }
      else if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mOnActionSheetClickListener.OnClick, error : which = ");
        paramView.append(paramInt);
        paramView.append(", troopUin = ");
        paramView.append(this.a.c);
        QLog.d("Q.history.BaseFragment", 2, paramView.toString());
      }
    }
    else if (this.a.jdField_d_of_type_Int == 9)
    {
      if (i == 0)
      {
        paramView = this.a;
        paramView.f = true;
        paramView.u = "";
        paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
        this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
        this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
          this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
        }
        ReportController.b(this.a.getBaseActivity().app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.c, this.a.o, "", "");
      }
    }
    else if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i == 3)
          {
            paramView = this.a;
            paramView.g = true;
            paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
            ChatHistoryTroopMemberFragment.a(this.a);
            this.a.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
            this.a.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
            this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
            paramView = this.a;
            paramView.jdField_d_of_type_AndroidWidgetTextView = ((TextView)ChatHistoryTroopMemberFragment.a(paramView, 2131369204));
            this.a.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
            this.a.jdField_d_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701827));
            this.a.jdField_d_of_type_AndroidWidgetTextView.setOnClickListener(new ChatHistoryTroopMemberFragment.29.3(this));
            if (this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter != null) {
              this.a.jdField_a_of_type_ComTencentMobileqqActivityHistoryChatHistoryTroopMemberFragment$ListAdapter.a();
            }
            paramView = this.a.o;
            this.a.a("Clk_del", paramView, "");
          }
        }
        else {
          this.a.jdField_b_of_type_AndroidOsHandler.postDelayed(new ChatHistoryTroopMemberFragment.29.2(this), 320L);
        }
      }
      else if (!TextUtils.isEmpty(this.a.jdField_b_of_type_JavaLangString))
      {
        paramView = new Intent();
        paramView.putExtra("param_from", 30);
        paramView.putExtra("group_uin", this.a.c);
        paramView.putExtra("param_groupcode", this.a.jdField_b_of_type_JavaLangString);
        paramView.putExtra("param_from", 30);
        paramView.putExtra("param_subtype", 4);
        paramView.putExtra("param_entrance", 30);
        paramView.putExtra("param_max", 30);
        paramView.putExtra("param_exit_animation", 3);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.a.getBaseActivity(), paramView);
        this.a.getBaseActivity().overridePendingTransition(2130772011, 0);
        ReportController.b(this.a.getBaseActivity().app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.c, "", "", "");
      }
    }
    else {
      this.a.A();
    }
    if ((this.a.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.a.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing())) {
      this.a.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29
 * JD-Core Version:    0.7.0.1
 */