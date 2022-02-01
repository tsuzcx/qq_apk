package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PhotoCropForPortraitActivity$1
  implements View.OnClickListener
{
  PhotoCropForPortraitActivity$1(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    int i = localIntent.getIntExtra("PhotoConst.CLIP_WIDTH", 0);
    PhotoUtils.startPhotoListEdit(localIntent, this.a, str, i, i, 1080, 1080, FaceUtil.a());
    ReportController.b(this.a.app, "dc00898", "", "", "0X800723F", "0X800723F", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity.1
 * JD-Core Version:    0.7.0.1
 */