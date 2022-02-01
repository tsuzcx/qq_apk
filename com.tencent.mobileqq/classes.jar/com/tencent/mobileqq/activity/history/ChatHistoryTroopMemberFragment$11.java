package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import mqq.app.AppRuntime;

class ChatHistoryTroopMemberFragment$11
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$11(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.d == 15) && (ChatHistoryTroopMemberFragment.a(this.a).size() > 0))
    {
      Object localObject = new Intent();
      ((Intent)localObject).putExtra("param_deleted_uins", ChatHistoryTroopMemberFragment.a(this.a));
      this.a.getBaseActivity().setResult(-1, (Intent)localObject);
      int i;
      if ((this.a.f != null) && (this.a.f.equals(this.a.getBaseActivity().app.getCurrentAccountUin()))) {
        i = 0;
      } else {
        i = 1;
      }
      localObject = this.a.getBaseActivity().app;
      String str = this.a.c;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b((AppRuntime)localObject, "dc00899", "Grp_mber", "", "mber_list", "del_inacmem", 0, 0, str, localStringBuilder.toString(), "1", ChatHistoryTroopMemberFragment.a(this.a).toString());
    }
    this.a.getBaseActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.11
 * JD-Core Version:    0.7.0.1
 */