package com.tencent.aelight.camera.aioeditor.takevideo;

import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.SystemClock;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil.FrameWithoutBlackResult;
import com.tencent.aelight.camera.aioeditor.takevideo.localmedia.demos.MediaCodecThumbnailGenerator;
import com.tencent.aelight.camera.util.api.ICaptureUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.BitmapUtils;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.VideoUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.List;

class HWEditImportVideoPlayer$1
  implements Runnable
{
  HWEditImportVideoPlayer$1(HWEditImportVideoPlayer paramHWEditImportVideoPlayer) {}
  
  public void run()
  {
    SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "thumb get start");
    Object localObject1 = VideoUtils.a(HWEditImportVideoPlayer.a(this.this$0), 2147483647L);
    Object localObject2 = localObject1;
    long l1;
    if (localObject1 == null)
    {
      localObject1 = new ArrayList();
      i = 0;
      for (;;)
      {
        l1 = i;
        localObject2 = localObject1;
        if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 2147483647L) {
          break;
        }
        ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(l1 * 2147483647L, 2147483647L));
        i += 1;
      }
    }
    if (((ArrayList)localObject2).size() <= 0) {
      ((ArrayList)localObject2).add(new VideoUtils.VideoKeyFrameFragment(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    int i = 0;
    Object localObject3;
    int j;
    while (i < ((ArrayList)localObject2).size())
    {
      localObject1 = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject2).get(i);
      long l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(HWEditImportVideoPlayer.a(this.this$0) + ((VideoUtils.VideoKeyFrameFragment)localObject1).b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      l1 = l2;
      if (l2 + 1000L > this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      if (i == 5) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      localObject3 = MediaUtil.a(HWEditImportVideoPlayer.a(this.this$0), HWEditImportVideoPlayer.a(this.this$0));
      localObject1 = localObject3;
      if (i == 0)
      {
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          float f = MediaCodecThumbnailGenerator.a((Bitmap)localObject3);
          SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "blackPrecent = %f start fix black frame.", Float.valueOf(f));
          localObject1 = localObject3;
          if (f > 0.9F)
          {
            MediaUtil.FrameWithoutBlackResult localFrameWithoutBlackResult = MediaUtil.a(HWEditImportVideoPlayer.a(this.this$0), HWEditImportVideoPlayer.a(this.this$0));
            localObject1 = localObject3;
            if (localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap != null)
            {
              localObject1 = localObject3;
              if (localFrameWithoutBlackResult.jdField_a_of_type_Long > 0L)
              {
                localObject1 = localObject3;
                if (MediaCodecThumbnailGenerator.a(localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap) <= 0.9F)
                {
                  if (!((Bitmap)localObject3).isRecycled()) {
                    ((Bitmap)localObject3).recycle();
                  }
                  localObject1 = localFrameWithoutBlackResult.jdField_a_of_type_AndroidGraphicsBitmap;
                  HWEditImportVideoPlayer.a(this.this$0, (int)(localFrameWithoutBlackResult.jdField_a_of_type_Long / 1000L));
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("Fix black frame. adjust star time to ");
                  ((StringBuilder)localObject3).append(HWEditImportVideoPlayer.a(this.this$0));
                  SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", ((StringBuilder)localObject3).toString());
                }
              }
            }
          }
        }
      }
      localObject3 = localObject1;
      if (localObject1 != null)
      {
        j = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(((Bitmap)localObject1).getWidth());
        int k = ((ICaptureUtil)QRoute.api(ICaptureUtil.class)).alainSize(((Bitmap)localObject1).getHeight());
        if (j == ((Bitmap)localObject1).getWidth())
        {
          localObject3 = localObject1;
          if (k == ((Bitmap)localObject1).getHeight()) {}
        }
        else
        {
          SLog.d("Q.qqstory.record.HWEditImportVideoPlayer", "origin bitmap width:%d, height:%d, should change size to w:%d, h:%d", new Object[] { Integer.valueOf(((Bitmap)localObject1).getWidth()), Integer.valueOf(((Bitmap)localObject1).getHeight()), Integer.valueOf(j), Integer.valueOf(j) });
          localObject3 = BitmapUtils.a((Bitmap)localObject1, new Rect(0, 0, j, k), true);
        }
      }
      localObject1 = new HWEditImportVideoPlayer.Mp4VideoFragmentInfo(i, (Bitmap)localObject3);
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.a(this.this$0));
      HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1, HWEditImportVideoPlayer.b(this.this$0));
      this.this$0.jdField_a_of_type_JavaUtilList.add(localObject1);
      SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info = %s, cost = %dms", localObject1, Long.valueOf(SystemClock.uptimeMillis() - l4));
      if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        break;
      }
      i += 1;
    }
    SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
    i = 0;
    while (i < this.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (HWEditImportVideoPlayer.Mp4VideoFragmentInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
      localObject2 = FileUtils.a(HWEditImportVideoPlayer.a(this.this$0));
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append(AppConstants.SDCARD_AUDIO_CACHE);
      ((StringBuilder)localObject3).append((String)localObject2);
      ((StringBuilder)localObject3).append("_");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(".IFrames.audio");
      localObject2 = ((StringBuilder)localObject3).toString();
      j = AudioDataUtil.a(HWEditImportVideoPlayer.b(this.this$0), (String)localObject2, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      if (j == 0)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("clipAudioFile finished audioFilePath");
        ((StringBuilder)localObject3).append((String)localObject2);
        SLog.b("Q.qqstory.record.HWEditImportVideoPlayer", ((StringBuilder)localObject3).toString());
        ((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = ((String)localObject2);
      }
      else
      {
        SLog.e("Q.qqstory.record.HWEditImportVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), localObject2, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.a((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditImportVideoPlayer.Mp4VideoFragmentInfo.b((HWEditImportVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
      }
      i += 1;
    }
    this.this$0.a(new HWEditImportVideoPlayer.1.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditImportVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */