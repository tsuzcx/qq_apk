package com.tencent.image_picker.imagepicker.features;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TencentImagePickerActivity$4
  implements View.OnClickListener
{
  TencentImagePickerActivity$4(TencentImagePickerActivity paramTencentImagePickerActivity) {}
  
  public void onClick(View paramView)
  {
    TencentImagePickerActivity.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.image_picker.imagepicker.features.TencentImagePickerActivity.4
 * JD-Core Version:    0.7.0.1
 */