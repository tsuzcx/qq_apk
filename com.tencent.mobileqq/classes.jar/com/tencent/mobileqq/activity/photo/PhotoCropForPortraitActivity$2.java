package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PortraitImageview;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class PhotoCropForPortraitActivity$2
  extends Handler
{
  boolean jdField_a_of_type_Boolean;
  
  PhotoCropForPortraitActivity$2(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, ExtensionInfo paramExtensionInfo, String paramString) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (1000 == paramMessage.what) {
      this.jdField_a_of_type_Boolean = true;
    } else if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int j = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.a();
    int i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentMobileqqActivityPortraitImageview.b();
    double d1 = j;
    Double.isNaN(d1);
    j = (int)(d1 * 1.257D);
    d1 = i;
    Double.isNaN(d1);
    paramMessage = new RelativeLayout.LayoutParams(j, (int)(d1 * 1.481D));
    paramMessage.addRule(14);
    d1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.getHeight() * 0.5F;
    double d2 = i * 0.5F;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramMessage.topMargin = ((int)(d1 - d2 * 1.705D));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView == null)
    {
      PhotoCropForPortraitActivity localPhotoCropForPortraitActivity = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity;
      localPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(localPhotoCropForPortraitActivity);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, paramMessage);
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams(paramMessage);
    }
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantId).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView, 6, PendantInfo.e, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.2
 * JD-Core Version:    0.7.0.1
 */