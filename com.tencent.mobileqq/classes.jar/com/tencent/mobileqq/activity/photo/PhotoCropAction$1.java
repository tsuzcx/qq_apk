package com.tencent.mobileqq.activity.photo;

import android.view.View;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class PhotoCropAction$1
  implements ActionSheet.OnButtonClickListener
{
  PhotoCropAction$1(PhotoCropAction paramPhotoCropAction, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt != this.b.a.length)
    {
      this.b.a(paramInt);
      this.b.b.b();
    }
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropAction.1
 * JD-Core Version:    0.7.0.1
 */