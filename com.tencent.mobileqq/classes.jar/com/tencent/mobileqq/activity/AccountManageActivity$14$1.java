package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import bdbk;
import java.util.HashMap;

class AccountManageActivity$14$1
  implements Runnable
{
  AccountManageActivity$14$1(AccountManageActivity.14 param14, boolean paramBoolean, String paramString, Bitmap paramBitmap, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.this$0.app) || (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      AccountManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.this$0).put(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof bdbk))) {
      ((bdbk)this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).a();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$14.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.14.1
 * JD-Core Version:    0.7.0.1
 */