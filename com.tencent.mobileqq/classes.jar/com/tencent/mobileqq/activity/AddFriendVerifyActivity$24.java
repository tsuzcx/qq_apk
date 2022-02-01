package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.profilecard.base.utils.ProfileCardUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AddFriendVerifyActivity$24
  implements ActionSheet.OnButtonClickListener
{
  AddFriendVerifyActivity$24(AddFriendVerifyActivity paramAddFriendVerifyActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        ((ITroopPhotoUtilsApi)QRoute.api(ITroopPhotoUtilsApi.class)).startPhotoList(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity, 1);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity;
      AddFriendVerifyActivity.a(paramView, ProfileCardUtils.enterSnapshot(paramView, 1001));
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddFriendVerifyActivity.24
 * JD-Core Version:    0.7.0.1
 */