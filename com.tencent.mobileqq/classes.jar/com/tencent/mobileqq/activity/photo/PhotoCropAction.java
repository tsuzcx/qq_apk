package com.tencent.mobileqq.activity.photo;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class PhotoCropAction
{
  PhotoCropActivity jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity;
  String[] jdField_a_of_type_ArrayOfJavaLangString;
  
  public PhotoCropAction(PhotoCropActivity paramPhotoCropActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity = paramPhotoCropActivity;
  }
  
  public void a()
  {
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = (ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropActivity, null);
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
        if (i >= arrayOfString.length) {
          break;
        }
        ((ActionSheet)localObject).addButton(arrayOfString[i], 1);
        i += 1;
      }
      ((ActionSheet)localObject).addCancelButton(2131690728);
      ((ActionSheet)localObject).setOnButtonClickListener(new PhotoCropAction.1(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropAction
 * JD-Core Version:    0.7.0.1
 */