package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.util.Log;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;

class PhotoListLogicAECamera$3$2
  implements Runnable
{
  PhotoListLogicAECamera$3$2(PhotoListLogicAECamera.3 param3) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.a.a.mActivity).isFinishing())
    {
      ((NewPhotoListActivity)this.a.a.mActivity).cancleProgressDailog();
      Log.d("Q.videostory.capture", "failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListLogicAECamera.3.2
 * JD-Core Version:    0.7.0.1
 */