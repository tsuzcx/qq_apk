package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FriendProfileMoreInfoActivity$9
  implements ActionSheet.OnButtonClickListener
{
  FriendProfileMoreInfoActivity$9(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    paramView = this.jdField_a_of_type_ComTencentWidgetActionSheet;
    if (paramView != null) {
      paramView.dismiss();
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 3);
        FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(1) }));
        return;
      }
      FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 2);
      FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(2) }));
      return;
    }
    FriendProfileMoreInfoActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, 1);
    FriendProfileMoreInfoActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity, String.format("https://ti.qq.com/hybrid-h5/school_relation/eduexperience?category=%d&_wv=67108994", new Object[] { Integer.valueOf(3) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.9
 * JD-Core Version:    0.7.0.1
 */