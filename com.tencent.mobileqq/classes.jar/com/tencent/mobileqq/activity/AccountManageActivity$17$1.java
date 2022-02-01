package com.tencent.mobileqq.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.app.face.FaceDrawable;
import java.util.HashMap;

class AccountManageActivity$17$1
  implements Runnable
{
  AccountManageActivity$17$1(AccountManageActivity.17 param17, boolean paramBoolean, String paramString, Bitmap paramBitmap, Drawable paramDrawable) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.this$0.app) || (this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {
      return;
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_JavaLangString);
      AccountManageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.this$0).put(this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetImageView.getDrawable() != null) && ((this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetImageView.getDrawable() instanceof FaceDrawable))) {
      ((FaceDrawable)this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetImageView.getDrawable()).cancel();
    }
    if (this.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAccountManageActivity$17.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AccountManageActivity.17.1
 * JD-Core Version:    0.7.0.1
 */