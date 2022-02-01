package com.tencent.mobileqq.apollo;

import agej;
import amvl;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import ansz;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;

public class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  public FriendCardApolloViewController$DrawerInfoCallback$1(amvl paramamvl, FriendProfileCardActivity paramFriendProfileCardActivity, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Amvl.a.a == null)
    {
      this.jdField_a_of_type_Amvl.a.a = new FrameGifView(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      this.jdField_a_of_type_Amvl.a.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(agej.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()), agej.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = agej.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      localLayoutParams.rightMargin = agej.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.getParent()).addView(this.jdField_a_of_type_Amvl.a.a, localLayoutParams);
    }
    this.jdField_a_of_type_Amvl.a.a.setVisibility(0);
    this.jdField_a_of_type_Amvl.a.a.setGifData(30, null, FriendCardApolloViewController.a(this.jdField_a_of_type_Amvl.a), ansz.a(FriendCardApolloViewController.a(this.jdField_a_of_type_Amvl.a)), true);
    FriendCardApolloViewController.a(this.jdField_a_of_type_Amvl.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */