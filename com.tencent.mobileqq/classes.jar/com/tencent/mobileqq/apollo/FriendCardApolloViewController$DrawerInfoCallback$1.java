package com.tencent.mobileqq.apollo;

import aekt;
import aklw;
import aljf;
import android.view.View;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.view.FrameGifView;

public class FriendCardApolloViewController$DrawerInfoCallback$1
  implements Runnable
{
  public FriendCardApolloViewController$DrawerInfoCallback$1(aklw paramaklw, FriendProfileCardActivity paramFriendProfileCardActivity, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Aklw.a.a == null)
    {
      this.jdField_a_of_type_Aklw.a.a = new FrameGifView(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      this.jdField_a_of_type_Aklw.a.a.setScaleType(ImageView.ScaleType.CENTER_CROP);
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(aekt.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()), aekt.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources()));
      localLayoutParams.addRule(12, -1);
      localLayoutParams.addRule(11, -1);
      localLayoutParams.bottomMargin = aekt.a(45.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      localLayoutParams.rightMargin = aekt.a(75.0F, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getResources());
      ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.getParent()).addView(this.jdField_a_of_type_Aklw.a.a, localLayoutParams);
    }
    this.jdField_a_of_type_Aklw.a.a.setVisibility(0);
    this.jdField_a_of_type_Aklw.a.a.setGifData(30, null, FriendCardApolloViewController.a(this.jdField_a_of_type_Aklw.a), aljf.a(FriendCardApolloViewController.a(this.jdField_a_of_type_Aklw.a)), true);
    FriendCardApolloViewController.a(this.jdField_a_of_type_Aklw.a, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.FriendCardApolloViewController.DrawerInfoCallback.1
 * JD-Core Version:    0.7.0.1
 */