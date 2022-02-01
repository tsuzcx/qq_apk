package com.tencent.mobileqq.activity.miniaio;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;

class MiniMsgTabFragment$2
  implements MiniMsgTabFragment.OnItemClickListener
{
  MiniMsgTabFragment$2(MiniMsgTabFragment paramMiniMsgTabFragment) {}
  
  public void a(RecentBaseData paramRecentBaseData)
  {
    BaseActivity localBaseActivity = this.a.getBaseActivity();
    if (paramRecentBaseData.getRecentUserUin().equals("0"))
    {
      MiniMsgTabFragment.f(this.a).findViewById(2131447655).performClick();
      return;
    }
    MiniChatActivity.a(localBaseActivity, paramRecentBaseData.getRecentUserType(), paramRecentBaseData.getRecentUserUin(), paramRecentBaseData.getTitleName(), false, MiniMsgTabFragment.g(this.a));
    MiniChatReportHelper.a("0X8009C2D");
    if (MiniMsgTabFragment.h(this.a) == null)
    {
      MiniMsgTabFragment localMiniMsgTabFragment = this.a;
      MiniMsgTabFragment.a(localMiniMsgTabFragment, AnimationUtils.loadAnimation(localMiniMsgTabFragment.getBaseActivity(), 2130772012));
    }
    MiniMsgTabFragment.i(this.a).startAnimation(MiniMsgTabFragment.h(this.a));
    MiniMsgTabFragment.h(this.a).setAnimationListener(new MiniMsgTabFragment.2.1(this, localBaseActivity));
    MiniMsgTabFragment.i(this.a).setVisibility(8);
    int j = paramRecentBaseData.getRecentUserType();
    int i = 5;
    if (UinTypeUtil.b(j)) {
      i = 1;
    } else if (j == 1) {
      i = 2;
    } else if (j == 3000) {
      i = 4;
    }
    j = MiniMsgTabFragment.g(this.a);
    paramRecentBaseData = new StringBuilder();
    paramRecentBaseData.append("");
    paramRecentBaseData.append(i);
    ReportController.b(null, "dc00898", "", "", "0X800A0F7", "0X800A0F7", j, 1, paramRecentBaseData.toString(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgTabFragment.2
 * JD-Core Version:    0.7.0.1
 */