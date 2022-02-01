package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$14
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$14(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt != 1) {
        return;
      }
      this.a.dismiss();
      this.b.getQBaseActivity().finish();
      return;
    }
    TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.b, true);
    this.a.dismiss();
    paramView = this.b;
    paramView.b(paramView.getShareUrl());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.14
 * JD-Core Version:    0.7.0.1
 */