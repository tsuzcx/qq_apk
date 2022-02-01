package com.tencent.mobileqq.activity;

import aeqr;
import aeqx;
import android.view.View;
import com.tencent.widget.Gallery;

public class FriendProfileImageActivity$6$1
  implements Runnable
{
  public FriendProfileImageActivity$6$1(aeqr paramaeqr) {}
  
  public void run()
  {
    if (this.a.a.jdField_a_of_type_Int != this.a.a.jdField_a_of_type_Aeqx.b()) {
      this.a.a.jdField_a_of_type_Int = this.a.a.jdField_a_of_type_Aeqx.b();
    }
    View localView;
    do
    {
      return;
      localView = this.a.a.jdField_a_of_type_ComTencentWidgetGallery.getSelectedView();
    } while (localView == null);
    this.a.a.jdField_a_of_type_AndroidViewView = localView;
    this.a.a.jdField_a_of_type_Aeqx.a(this.a.a.jdField_a_of_type_Aeqx.b());
    this.a.a.a(this.a.a.jdField_a_of_type_ComTencentWidgetGallery, this.a.a.jdField_a_of_type_Aeqx.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.6.1
 * JD-Core Version:    0.7.0.1
 */