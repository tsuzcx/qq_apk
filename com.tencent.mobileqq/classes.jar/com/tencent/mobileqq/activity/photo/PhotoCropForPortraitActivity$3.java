package com.tencent.mobileqq.activity.photo;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoCropForPortraitActivity$3
  implements View.OnClickListener
{
  PhotoCropForPortraitActivity$3(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    Object localObject = this.a.a;
    boolean bool;
    String str;
    if (!this.a.a.isChecked())
    {
      bool = true;
      ((CheckBox)localObject).setChecked(bool);
      this.a.d = this.a.a.isChecked();
      this.a.i = 2;
      localObject = this.a;
      str = this.a.getCurrentAccountUin();
      if (!this.a.d) {
        break label103;
      }
    }
    for (;;)
    {
      SharedPreUtils.E((Context)localObject, str, i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label103:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.3
 * JD-Core Version:    0.7.0.1
 */