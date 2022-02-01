package com.tencent.aelight.camera.aioeditor;

import android.util.Log;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;

class PhotoListCustomizationAECamera$3$2
  implements Runnable
{
  PhotoListCustomizationAECamera$3$2(PhotoListCustomizationAECamera.3 param3) {}
  
  public void run()
  {
    if (!PhotoListCustomizationAECamera.l(this.a.c).isFinishing())
    {
      PhotoListCustomizationAECamera.m(this.a.c).u.b();
      Log.d("Q.videostory.capture", "failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3.2
 * JD-Core Version:    0.7.0.1
 */