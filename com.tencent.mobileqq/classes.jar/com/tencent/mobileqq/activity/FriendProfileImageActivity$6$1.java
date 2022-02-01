package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.widget.Gallery;

class FriendProfileImageActivity$6$1
  implements Runnable
{
  FriendProfileImageActivity$6$1(FriendProfileImageActivity.6 param6) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Int != this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b())
    {
      this.a.a.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b();
      return;
    }
    View localView = this.a.a.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    if (localView == null) {
      return;
    }
    this.a.a.jdField_a_of_type_AndroidViewView = localView;
    this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.a(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentWidgetGallery, this.a.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
 * JD-Core Version:    0.7.0.1
 */