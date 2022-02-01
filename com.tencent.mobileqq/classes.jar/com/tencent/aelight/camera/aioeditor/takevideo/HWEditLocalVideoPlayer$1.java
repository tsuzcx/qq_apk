package com.tencent.aelight.camera.aioeditor.takevideo;

import android.os.SystemClock;
import com.tencent.aelight.camera.aioeditor.richmedia.mediacodec.utils.MediaUtil;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.FileUtils;
import com.tencent.biz.qqstory.utils.VideoUtils.VideoKeyFrameFragment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.editor.composite.step.AudioDataUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

class HWEditLocalVideoPlayer$1
  implements Runnable
{
  HWEditLocalVideoPlayer$1(HWEditLocalVideoPlayer paramHWEditLocalVideoPlayer) {}
  
  public void run()
  {
    Object localObject1 = new ArrayList();
    int i = 0;
    long l1;
    for (;;)
    {
      l1 = i;
      if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration / 2147483647L) {
        break;
      }
      ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(l1 * 2147483647L, 2147483647L));
      i += 1;
    }
    if (((ArrayList)localObject1).size() <= 0) {
      ((ArrayList)localObject1).add(new VideoUtils.VideoKeyFrameFragment(0L, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration));
    }
    long l3 = SystemClock.uptimeMillis();
    i = 0;
    Object localObject2;
    while (i < ((ArrayList)localObject1).size())
    {
      VideoUtils.VideoKeyFrameFragment localVideoKeyFrameFragment = (VideoUtils.VideoKeyFrameFragment)((ArrayList)localObject1).get(i);
      long l4 = SystemClock.uptimeMillis();
      long l2 = Math.min(localVideoKeyFrameFragment.a + localVideoKeyFrameFragment.b, this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      localObject2 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;
      l1 = l2;
      if (1000L + l2 > ((LocalMediaInfo)localObject2).mDuration) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      if (i == 5) {
        l1 = this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration;
      }
      try
      {
        localObject2 = new HWEditLocalVideoPlayer.Mp4VideoFragmentInfo(i, MediaUtil.a(HWEditLocalVideoPlayer.a(this.this$0), (int)localVideoKeyFrameFragment.a));
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2, localVideoKeyFrameFragment.a);
        HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject2, l1);
        this.this$0.jdField_a_of_type_JavaUtilList.add(localObject2);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info = %s, cost = %dms", localObject2, Long.valueOf(SystemClock.uptimeMillis() - l4));
      }
      catch (RuntimeException localRuntimeException)
      {
        QLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", 1, localRuntimeException, new Object[0]);
      }
      if (l1 >= this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration) {
        break;
      }
      i += 1;
    }
    SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", "create fragment info count = %d, cost = %dms", Integer.valueOf(this.this$0.jdField_a_of_type_JavaUtilList.size()), Long.valueOf(SystemClock.uptimeMillis() - l3));
    i = 0;
    while (i < this.this$0.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)this.this$0.jdField_a_of_type_JavaUtilList.get(i);
      String str = FileUtils.a(HWEditLocalVideoPlayer.a(this.this$0));
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(AppConstants.SDCARD_AUDIO_CACHE);
      ((StringBuilder)localObject2).append(str);
      ((StringBuilder)localObject2).append("_");
      ((StringBuilder)localObject2).append(i);
      ((StringBuilder)localObject2).append(".IFrames.audio");
      str = ((StringBuilder)localObject2).toString();
      int j = AudioDataUtil.a(HWEditLocalVideoPlayer.b(this.this$0), str, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration, (float)HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1) * 1.0F / (float)this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration);
      if (j == 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("clipAudioFile finished audioFilePath");
        ((StringBuilder)localObject2).append(str);
        SLog.b("Q.qqstory.record.HWEditLocalVideoPlayer", ((StringBuilder)localObject2).toString());
        ((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1).b = str;
      }
      else
      {
        SLog.e("Q.qqstory.record.HWEditLocalVideoPlayer", "clipAudioFile failed. errcode =%s,  audioFilePath=%s, duration=%s, startTime=%s, endTime=%s", new Object[] { Integer.valueOf(j), str, Long.valueOf(this.this$0.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mDuration), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.a((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)), Long.valueOf(HWEditLocalVideoPlayer.Mp4VideoFragmentInfo.b((HWEditLocalVideoPlayer.Mp4VideoFragmentInfo)localObject1)) });
      }
      i += 1;
    }
    this.this$0.a(new HWEditLocalVideoPlayer.1.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.HWEditLocalVideoPlayer.1
 * JD-Core Version:    0.7.0.1
 */