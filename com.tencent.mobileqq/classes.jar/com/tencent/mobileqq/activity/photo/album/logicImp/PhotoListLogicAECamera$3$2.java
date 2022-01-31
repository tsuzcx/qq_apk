package com.tencent.mobileqq.activity.photo.album.logicImp;

import agtn;
import agtr;
import android.util.Log;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import mqq.util.WeakReference;

public class PhotoListLogicAECamera$3$2
  implements Runnable
{
  public PhotoListLogicAECamera$3$2(agtr paramagtr) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.a.a.a.get()).isFinishing())
    {
      ((NewPhotoListActivity)this.a.a.a.get()).d();
      Log.d("Q.videostory.capture", "failed");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.2
 * JD-Core Version:    0.7.0.1
 */