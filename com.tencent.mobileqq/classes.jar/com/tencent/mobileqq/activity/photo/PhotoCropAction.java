package com.tencent.mobileqq.activity.photo;

import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheetHelper;

public class PhotoCropAction
{
  String[] a;
  PhotoCropActivity b;
  
  public PhotoCropAction(PhotoCropActivity paramPhotoCropActivity)
  {
    this.b = paramPhotoCropActivity;
  }
  
  public void a()
  {
    Object localObject = this.a;
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = (ActionSheet)ActionSheetHelper.b(this.b, null);
      int i = 0;
      for (;;)
      {
        String[] arrayOfString = this.a;
        if (i >= arrayOfString.length) {
          break;
        }
        ((ActionSheet)localObject).addButton(arrayOfString[i], 1);
        i += 1;
      }
      ((ActionSheet)localObject).addCancelButton(2131887648);
      ((ActionSheet)localObject).setOnButtonClickListener(new PhotoCropAction.1(this, (ActionSheet)localObject));
      ((ActionSheet)localObject).show();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String[] paramArrayOfString)
  {
    this.a = paramArrayOfString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropAction
 * JD-Core Version:    0.7.0.1
 */