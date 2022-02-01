package com.tencent.aelight.camera.aioeditor;

import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import java.io.Serializable;
import java.util.List;

class PhotoListCustomizationAECamera$3$1
  implements Runnable
{
  PhotoListCustomizationAECamera$3$1(PhotoListCustomizationAECamera.3 param3, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    if (!PhotoListCustomizationAECamera.j(this.d.c).isFinishing())
    {
      PhotoListCustomizationAECamera.k(this.d.c).u.b();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.d.b.path);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.a);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.b);
      PhotoListCustomizationAECamera.a(this.d.c, this.c, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3.1
 * JD-Core Version:    0.7.0.1
 */