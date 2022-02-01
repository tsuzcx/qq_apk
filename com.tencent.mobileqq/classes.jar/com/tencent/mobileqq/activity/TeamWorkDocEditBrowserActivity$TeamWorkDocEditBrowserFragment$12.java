package com.tencent.mobileqq.activity;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$12
  implements ActionSheet.OnButtonClickListener
{
  TeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment$12(TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment paramTeamWorkDocEditBrowserFragment, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.c(this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment, true);
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.b(this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.getShareUrl());
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    this.jdField_a_of_type_ComTencentMobileqqActivityTeamWorkDocEditBrowserActivity$TeamWorkDocEditBrowserFragment.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity.TeamWorkDocEditBrowserFragment.12
 * JD-Core Version:    0.7.0.1
 */