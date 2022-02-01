package com.tencent.mobileqq.activity.miniaio;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.statistics.ReportController;

class MiniMsgTabFragment$2
  implements MiniMsgTabFragment.OnItemClickListener
{
  MiniMsgTabFragment$2(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    FragmentActivity localFragmentActivity = this.a.getActivity();
    if (paramRecentBaseData.getRecentUserUin().equals("0"))
    {
      MiniMsgTabFragment.a(this.a).findViewById(2131379606).performClick();
      return;
    }
    MiniChatActivity.a(localFragmentActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName(), false, MiniMsgTabFragment.b(this.a));
    MiniChatReportHelper.a("0X8009C2D");
    if (MiniMsgTabFragment.a(this.a) == null) {
      MiniMsgTabFragment.a(this.a, AnimationUtils.loadAnimation(this.a.getActivity(), 2130771997));
    }
    MiniMsgTabFragment.b(this.a).startAnimation(MiniMsgTabFragment.a(this.a));
    MiniMsgTabFragment.a(this.a).setAnimationListener(new MiniMsgTabFragment.2.1(this, localFragmentActivity));
    MiniMsgTabFragment.b(this.a).setVisibility(8);
    int i = paramRecentBaseData.getRecentUserType();
    if (UinTypeUtil.b(i)) {
      i = 1;
    }
    for (;;)
    {
      ReportController.b(null, "dc00898", "", "", "0X800A0F7", "0X800A0F7", MiniMsgTabFragment.b(this.a), 1, "" + i, "", "", "");
      return;
      if (i == 1) {
        i = 2;
      } else if (i == 3000) {
        i = 4;
      } else {
        i = 5;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.2
 * JD-Core Version:    0.7.0.1
 */