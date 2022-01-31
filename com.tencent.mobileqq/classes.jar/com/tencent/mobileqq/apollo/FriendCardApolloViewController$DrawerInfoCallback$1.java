package com.tencent.mobileqq.apollo;

import actj;
import aiuk;
import ajrs;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;

public class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  public FriendCardApolloViewController$DrawerInfoCallback$1(aiuk paramaiuk, FriendProfileCardActivity paramFriendProfileCardActivity, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aiuk.a.a == null)
    {
      this.jdField_a_of_type_Aiuk.a.a = new FrameGifView(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      this.jdField_a_of_type_Aiuk.a.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(actj.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()), actj.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = actj.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      localLayoutParams.rightMargin = actj.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.getParent()).addView(this.jdField_a_of_type_Aiuk.a.a, localLayoutParams);
    }
    this.jdField_a_of_type_Aiuk.a.a.setVisibility(0);
    this.jdField_a_of_type_Aiuk.a.a.setGifData(30, null, FriendCardApolloViewController.a(this.jdField_a_of_type_Aiuk.a), ajrs.a(FriendCardApolloViewController.a(this.jdField_a_of_type_Aiuk.a)), true);
    FriendCardApolloViewController.a(this.jdField_a_of_type_Aiuk.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */