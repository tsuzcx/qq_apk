package com.tencent.mobileqq.activity.photo;

import android.os.Handler;
import android.view.View;
import android.view.View.OnLayoutChangeListener;

class PhotoCropActivity$2
  implements View.OnLayoutChangeListener
{
  PhotoCropActivity$2(PhotoCropActivity paramPhotoCropActivity) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if (((paramInt1 != paramInt5) || (paramInt2 != paramInt6) || (paramInt3 != paramInt7) || (paramInt4 != paramInt8)) && (this.a.D != null)) {
      this.a.D.sendEmptyMessage(1001);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.2
 * JD-Core Version:    0.7.0.1
 */