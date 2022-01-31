package com.tencent.mobileqq.activity.photo;

import agbu;
import android.os.Bundle;
import java.io.Serializable;
import java.util.List;

public class PhotoListActivity$8$1
  implements Runnable
{
  public PhotoListActivity$8$1(agbu paramagbu, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Agbu.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.isFinishing())
    {
      this.jdField_a_of_type_Agbu.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.f();
      Bundle localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_Agbu.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      PhotoListActivity.a(this.jdField_a_of_type_Agbu.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoListActivity.8.1
 * JD-Core Version:    0.7.0.1
 */