package com.tencent.mobileqq.activity.photo;

import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.statistics.ReportController;

class PhotoCropActivity$3
  extends CardObserver
{
  PhotoCropActivity$3(PhotoCropActivity paramPhotoCropActivity) {}
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString, int paramInt)
  {
    if ("FROM_SDK_AVATAR_SET_IMAGE".equals(this.a.b))
    {
      this.a.a.removeMessages(1003);
      this.a.c();
      if (!paramBoolean)
      {
        paramString = this.a.getIntent();
        paramString.putExtra("key_from_sdk_set_avatar_result", false);
        this.a.setResult(-1, paramString);
        this.a.finish();
        return;
      }
      ReportController.b(this.a.app, "dc00898", "", "", "0X8009B6B", "0X8009B6B", 0, 0, "", "", "", "");
      paramString = this.a.getIntent();
      paramString.putExtra("key_from_sdk_set_avatar_result", true);
      this.a.setResult(-1, paramString);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoCropActivity.3
 * JD-Core Version:    0.7.0.1
 */