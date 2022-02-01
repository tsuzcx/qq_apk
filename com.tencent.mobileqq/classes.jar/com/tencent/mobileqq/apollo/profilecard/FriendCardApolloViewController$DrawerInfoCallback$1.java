package com.tencent.mobileqq.apollo.profilecard;

import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.view.FrameGifView;
import com.tencent.mobileqq.apollo.view.QQFrameZipDecoder;
import com.tencent.mobileqq.app.QBaseActivity;

class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  FriendCardApolloViewController$DrawerInfoCallback$1(FriendCardApolloViewController.DrawerInfoCallback paramDrawerInfoCallback, QBaseActivity paramQBaseActivity, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a = new FrameGifView(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(AIOUtils.b(45.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()), AIOUtils.b(45.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources()));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = AIOUtils.b(45.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
      localLayoutParams.rightMargin = AIOUtils.b(75.0F, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources());
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.getParent()).addView(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a, localLayoutParams);
    }
    this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a.a.setGifData(30, null, FriendCardApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a), QQFrameZipDecoder.a(FriendCardApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a)), true);
    FriendCardApolloViewController.a(this.jdField_a_of_type_ComTencentMobileqqApolloProfilecardFriendCardApolloViewController$DrawerInfoCallback.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.profilecard.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */