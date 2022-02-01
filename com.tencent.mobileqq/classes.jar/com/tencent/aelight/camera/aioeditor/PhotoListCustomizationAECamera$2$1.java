package com.tencent.aelight.camera.aioeditor;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.videostory.video.FrameVideoHelper;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.biz.videostory.video.FrameVideoHelper.GetFrameByteArrayListener;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivityHandler;
import com.tencent.mobileqq.activity.photo.album.PhotoListData;
import java.util.ArrayList;

class PhotoListCustomizationAECamera$2$1
  implements FrameVideoHelper.GetFrameByteArrayListener
{
  PhotoListCustomizationAECamera$2$1(PhotoListCustomizationAECamera.2 param2, LocalMediaInfo paramLocalMediaInfo, FrameVideoHelper paramFrameVideoHelper) {}
  
  public void a(boolean paramBoolean, ArrayList<FrameVideoHelper.FrameBuffer> paramArrayList, long paramLong)
  {
    PhotoListCustomizationAECamera.g(this.c.c).u.b();
    Bundle localBundle = new Bundle();
    localBundle.putLong("KEY_VIDEO_STORY_CAPTYRE_FRAMES_SIZE", paramLong);
    localBundle.putBoolean("VIDEO_STORY_PHOTO_LIST_TO_EDIT", true);
    localBundle.putSerializable("KEY_VIDEO_STORY_CAPTYRE_FRAMES", paramArrayList);
    PhotoListCustomizationAECamera.h(this.c.c).getIntent().putExtra("VIDEO_STORY_MEDIA_TYPE", 100);
    PhotoListCustomizationAECamera.a(this.c.c, this.a, localBundle);
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.2.1
 * JD-Core Version:    0.7.0.1
 */