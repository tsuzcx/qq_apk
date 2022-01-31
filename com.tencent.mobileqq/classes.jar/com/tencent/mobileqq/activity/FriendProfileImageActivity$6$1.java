package com.tencent.mobileqq.activity;

import abge;
import abgk;
import android.view.View;
import com.tencent.widget.Gallery;

public class FriendProfileImageActivity$6$1
  implements Runnable
{
  public FriendProfileImageActivity$6$1(abge paramabge) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Int != this.a.a.jdField_a_of_type_Abgk.b()) {
      this.a.a.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Abgk.b();
    }
    View localView;
    do
    {
      return;
      localView = this.a.a.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    } while (localView == null);
    this.a.a.jdField_a_of_type_AndroidViewView = localView;
    this.a.a.jdField_a_of_type_Abgk.a(this.a.a.jdField_a_of_type_Abgk.b());
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentWidgetGallery, this.a.a.jdField_a_of_type_Abgk.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
 * JD-Core Version:    0.7.0.1
 */