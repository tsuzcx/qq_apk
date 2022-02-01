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
  
  public void onClick(View paramView, int paramInt)
  {
    int i;
    if ((!ChatHistoryTroopMemberFragment.l(this.a)) && (paramInt >= 5)) {
      i = paramInt + 1;
    } else {
      i = paramInt;
    }
    if (this.a.B)
    {
      if (paramInt == 0)
      {
        this.a.bn.postDelayed(new ChatHistoryTroopMemberFragment.29.1(this), 320L);
      }
      else if (QLog.isColorLevel())
      {
        paramView = new StringBuilder();
        paramView.append("mOnActionSheetClickListener.OnClick, error : which = ");
        paramView.append(paramInt);
        paramView.append(", troopUin = ");
        paramView.append(this.a.w);
        QLog.d("Q.history.BaseFragment", 2, paramView.toString());
      }
    }
    else if (this.a.az == 9)
    {
      if (i == 0)
      {
        paramView = this.a;
        paramView.z = true;
        paramView.br = "";
        paramView.N.setVisibility(0);
        this.a.O.setVisibility(8);
        this.a.P.setVisibility(8);
        if (this.a.K != null) {
          this.a.K.c();
        }
        ReportController.b(this.a.getBaseActivity().app, "P_CliOper", "Grp_pay", "", "un_pay_list", "Clk_del", 0, 0, this.a.w, this.a.aK, "", "");
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
            paramView.A = true;
            paramView.N.setVisibility(0);
            ChatHistoryTroopMemberFragment.c(this.a);
            this.a.O.setVisibility(8);
            this.a.P.setVisibility(8);
            this.a.T.setVisibility(8);
            paramView = this.a;
            paramView.T = ((TextView)ChatHistoryTroopMemberFragment.b(paramView, 2131436182));
            this.a.T.setVisibility(0);
            this.a.T.setText(HardCodeUtil.a(2131898212));
            this.a.T.setOnClickListener(new ChatHistoryTroopMemberFragment.29.3(this));
            if (this.a.K != null) {
              this.a.K.c();
            }
            paramView = this.a.aK;
            this.a.a("Clk_del", paramView, "");
          }
        }
        else {
          this.a.bn.postDelayed(new ChatHistoryTroopMemberFragment.29.2(this), 320L);
        }
      }
      else if (!TextUtils.isEmpty(this.a.v))
      {
        paramView = new Intent();
        paramView.putExtra("param_from", 30);
        paramView.putExtra("group_uin", this.a.w);
        paramView.putExtra("param_groupcode", this.a.v);
        paramView.putExtra("param_from", 30);
        paramView.putExtra("param_subtype", 4);
        paramView.putExtra("param_entrance", 30);
        paramView.putExtra("param_max", 30);
        paramView.putExtra("param_exit_animation", 3);
        ((ISelectMemberApi)QRoute.api(ISelectMemberApi.class)).startSelectMemberActivity(this.a.getBaseActivity(), paramView);
        this.a.getBaseActivity().overridePendingTransition(2130772014, 0);
        ReportController.b(this.a.getBaseActivity().app, "dc00899", "Grp_mber", "", "mber_list", "clk_Add", 0, 0, this.a.w, "", "", "");
      }
    }
    else {
      this.a.E();
    }
    if ((this.a.am != null) && (this.a.am.isShowing())) {
      this.a.am.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.29
 * JD-Core Version:    0.7.0.1
 */