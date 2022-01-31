package com.tencent.mobileqq.activity.photo.album.logicImp;

import agtn;
import agtr;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import java.io.Serializable;
import java.util.List;
import mqq.util.WeakReference;

public class PhotoListLogicAECamera$3$1
  implements Runnable
{
  public PhotoListLogicAECamera$3$1(agtr paramagtr, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    if (!((NewPhotoListActivity)this.jdField_a_of_type_Agtr.jdField_a_of_type_Agtn.a.get()).isFinishing())
    {
      ((NewPhotoListActivity)this.jdField_a_of_type_Agtr.jdField_a_of_type_Agtn.a.get()).d();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_Agtr.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      agtn.a(this.jdField_a_of_type_Agtr.jdField_a_of_type_Agtn, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.logicImp.PhotoListLogicAECamera.3.1
 * JD-Core Version:    0.7.0.1
 */