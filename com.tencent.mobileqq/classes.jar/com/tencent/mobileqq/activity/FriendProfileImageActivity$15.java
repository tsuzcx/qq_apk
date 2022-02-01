package com.tencent.mobileqq.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

class FriendProfileImageActivity$15
  implements View.OnClickListener
{
  FriendProfileImageActivity$15(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131365474)
    {
      FriendProfileImageModel.ProfileImageInfo localProfileImageInfo = this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a();
      if ((!this.a.b) && (this.a.jdField_a_of_type_Boolean) && (localProfileImageInfo != null))
      {
        ActionSheet localActionSheet = (ActionSheet)ActionSheetHelper.a(this.a, null);
        localActionSheet.addButton(2131693253, 3);
        localActionSheet.addCancelButton(2131690728);
        localActionSheet.setOnButtonClickListener(new FriendProfileImageActivity.15.1(this, localProfileImageInfo, localActionSheet));
        localActionSheet.show();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.15
 * JD-Core Version:    0.7.0.1
 */