package com.tencent.mobileqq.activity.history;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ChatHistoryTroopMemberFragment$18
  implements View.OnClickListener
{
  ChatHistoryTroopMemberFragment$18(ChatHistoryTroopMemberFragment paramChatHistoryTroopMemberFragment, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.F) && (!ChatHistoryTroopMemberFragment.f(this.b)))
    {
      if (((this.b.az == 11) && (this.b.G > 0)) || (this.b.az == 3))
      {
        Intent localIntent = this.b.getActivity().getIntent();
        localIntent.putExtra("member_uin", "0");
        localIntent.putExtra("member_display_name", this.a);
        this.b.getActivity().setResult(-1, localIntent);
        this.b.getActivity().finish();
        if (this.b.az == 11) {
          ReportController.b(this.b.bc, "CliOper", "", "", "0X800621D", "0X800621D", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.makeText(this.b.getBaseActivity(), HardCodeUtil.a(2131899896), 0).show(this.b.M.getHeight());
      }
    }
    else if (!TextUtils.isEmpty(this.b.E)) {
      QQToast.makeText(this.b.getBaseActivity(), this.b.E, 0).show(this.b.M.getHeight());
    } else {
      QQToast.makeText(this.b.getBaseActivity(), HardCodeUtil.a(2131899861), 0).show(this.b.M.getHeight());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryTroopMemberFragment.18
 * JD-Core Version:    0.7.0.1
 */