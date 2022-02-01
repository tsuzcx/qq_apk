package com.tencent.aelight.camera.aioeditor;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.media.MediaMetadataRetriever;
import android.util.Log;
import com.tencent.biz.videostory.config.VSConfigManager;
import com.tencent.biz.videostory.support.FileUtils;
import com.tencent.biz.videostory.video.FrameVideoHelper.FrameBuffer;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.ConvertListener;
import com.tencent.mobileqq.editor.composite.step.VideoStoryPicToVideo.RetCode;
import com.tencent.mobileqq.util.BitmapManager;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.os.MqqHandler;

class PhotoListCustomizationAECamera$3
  implements VideoStoryPicToVideo.ConvertListener
{
  PhotoListCustomizationAECamera$3(PhotoListCustomizationAECamera paramPhotoListCustomizationAECamera, String paramString, LocalMediaInfo paramLocalMediaInfo) {}
  
  public void a(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    Log.d("Q.videostory.capture", "success");
    paramRetCode = new MediaMetadataRetriever();
    try
    {
      paramRetCode.setDataSource(this.jdField_a_of_type_JavaLangString);
      localLocalMediaInfo = new LocalMediaInfo();
      localLocalMediaInfo.path = this.jdField_a_of_type_JavaLangString;
      localLocalMediaInfo.mDuration = Integer.parseInt(paramRetCode.extractMetadata(9));
      localLocalMediaInfo.mediaWidth = Integer.parseInt(paramRetCode.extractMetadata(18));
      localLocalMediaInfo.mediaHeight = Integer.parseInt(paramRetCode.extractMetadata(19));
      localLocalMediaInfo.rotation = Integer.parseInt(paramRetCode.extractMetadata(24));
      localLocalMediaInfo.mMediaType = 1;
      localLocalMediaInfo.mMimeType = "video/mp4";
      localLocalMediaInfo.latitude = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.latitude;
      localLocalMediaInfo.longitude = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.longitude;
      localLocalMediaInfo.addedDate = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.addedDate;
      paramRetCode.release();
      Bitmap localBitmap = BitmapManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.path);
      localCopyOnWriteArrayList = new CopyOnWriteArrayList();
      if ((localBitmap == null) || (localBitmap.isRecycled())) {
        break label309;
      }
      Object localObject = FileUtils.a(localBitmap);
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      l = ((Long)VSConfigManager.a().a("SmartCutPicQuality_And", Long.valueOf(80L))).longValue();
      ((Bitmap)localObject).compress(Bitmap.CompressFormat.JPEG, (int)l, localByteArrayOutputStream);
      localObject = localByteArrayOutputStream.toByteArray();
      l = localObject.length;
      localCopyOnWriteArrayList.add(new FrameVideoHelper.FrameBuffer((byte[])localObject));
      localByteArrayOutputStream.close();
      localBitmap.recycle();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        LocalMediaInfo localLocalMediaInfo;
        CopyOnWriteArrayList localCopyOnWriteArrayList;
        continue;
        long l = 0L;
      }
    }
    ThreadManager.getUIHandler().post(new PhotoListCustomizationAECamera.3.1(this, localCopyOnWriteArrayList, l, localLocalMediaInfo));
    return;
    paramRetCode.release();
  }
  
  public void b(VideoStoryPicToVideo.RetCode paramRetCode)
  {
    ThreadManager.getUIHandler().post(new PhotoListCustomizationAECamera.3.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.PhotoListCustomizationAECamera.3
 * JD-Core Version:    0.7.0.1
 */