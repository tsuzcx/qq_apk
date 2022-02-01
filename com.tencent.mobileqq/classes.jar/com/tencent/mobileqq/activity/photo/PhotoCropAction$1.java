package com.tencent.mobileqq.activity.photo;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhotoCropAction$1
  implements ActionSheet.OnButtonClickListener
{
  PhotoCropAction$1(PhotoCropAction paramPhotoCropAction, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ArrayOfJavaLangString.length)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropAction.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity.a();
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropAction.1
 * JD-Core Version:    0.7.0.1
 */