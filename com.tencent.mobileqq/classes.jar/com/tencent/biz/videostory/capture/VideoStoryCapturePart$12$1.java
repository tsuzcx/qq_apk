package com.tencent.biz.videostory.capture;

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.text.TextUtils;
import auuy;
import bgxx;
import bgya;
import biys;
import com.tencent.biz.videostory.support.VideoStoryDataBean;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import dov.com.qq.im.capture.data.QIMFilterCategoryItem;
import java.io.Serializable;
import java.util.List;
import wuh;
import wul;
import wvh;

public class VideoStoryCapturePart$12$1
  implements Runnable
{
  public VideoStoryCapturePart$12$1(wul paramwul, List paramList, long paramLong, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void run()
  {
    Bundle localBundle;
    Object localObject2;
    if ((this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh.a != null) && (!this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh.a.isFinishing()))
    {
      localBundle = new Bundle();
      localBundle.putString("KEY_PIC_TO_VIDEO_LOCAL_PIC_PATH", this.jdField_a_of_type_Wul.jdField_a_of_type_Auuy.jdField_a_of_type_JavaLangString);
      localBundle.putBoolean("KEY_FROM_PIC_TO_VIDEO", true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", (Serializable)this.jdField_a_of_type_JavaUtilList);
      localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", this.jdField_a_of_type_Long);
      localObject2 = wvh.a().a();
      localObject1 = "";
      if (localObject2 != null) {
        localObject1 = ((bgya)localObject2).e;
      }
      localObject2 = wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label379;
      }
      ((VideoStoryDataBean)localObject2).setWatermarkId((String)localObject1);
      localObject2 = wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh);
      if (this.jdField_a_of_type_Wul.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem == null) {
        break label385;
      }
      localObject1 = this.jdField_a_of_type_Wul.jdField_a_of_type_DovComQqImCaptureDataQIMFilterCategoryItem.b;
      label157:
      ((VideoStoryDataBean)localObject2).setFilterId((String)localObject1);
      localObject2 = wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh);
      if (bgxx.a() != null) {
        break label391;
      }
      localObject1 = "empty";
      label182:
      ((VideoStoryDataBean)localObject2).setLensId((String)localObject1);
      localObject2 = wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh);
      if (bgxx.a() != null) {
        break label401;
      }
    }
    label385:
    label391:
    label401:
    for (Object localObject1 = "empty";; localObject1 = Integer.valueOf(bgxx.a().jdField_a_of_type_Int))
    {
      ((VideoStoryDataBean)localObject2).setLensTabId(String.valueOf(localObject1));
      if (this.jdField_a_of_type_Wul.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outWidth > this.jdField_a_of_type_Wul.jdField_a_of_type_AndroidGraphicsBitmapFactory$Options.outHeight) {
        wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh).setLandTakePicToVideo(true);
      }
      wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh).setTakePicToVideo(true);
      localBundle.putSerializable("KEY_VIDEO_STORY_CAMERA_TYPE", wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh));
      this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh.a.getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 101);
      biys.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo, 0, (int)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, -1, 10023, 0, null, null, false, 11, wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh, this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh.a), localBundle);
      wuh.a(this.jdField_a_of_type_Wul.jdField_a_of_type_Wuh, false);
      return;
      label379:
      localObject1 = "empty";
      break;
      localObject1 = "empty";
      break label157;
      localObject1 = bgxx.a().jdField_a_of_type_JavaLangString;
      break label182;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.videostory.capture.VideoStoryCapturePart.12.1
 * JD-Core Version:    0.7.0.1
 */