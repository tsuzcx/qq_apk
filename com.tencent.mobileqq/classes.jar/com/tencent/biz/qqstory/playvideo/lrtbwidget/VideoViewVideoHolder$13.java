package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.graphics.Bitmap;
import android.os.Handler;
import android.view.View;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.StoryNewGuideDialog;

class VideoViewVideoHolder$13
  extends SimpleActivityLifeCycle
{
  VideoViewVideoHolder$13(VideoViewVideoHolder paramVideoViewVideoHolder) {}
  
  public void d()
  {
    super.d();
    String str1 = this.a.jdField_a_of_type_JavaLangString;
    String str2 = VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)];
    boolean bool = false;
    if (this.a.a().getVisibility() == 0) {
      bool = true;
    }
    SLog.d(str1, "onResume, current state = %s, startBtn show = %s", new Object[] { str2, Boolean.valueOf(bool) });
    if (this.a.c()) {
      this.a.a(10, "onResume");
    }
  }
  
  public void e()
  {
    super.e();
    VideoViewVideoHolder.a(this.a, false);
    SLog.d(this.a.jdField_a_of_type_JavaLangString, "onPause, current state = %s", new Object[] { VideoViewVideoHolder.jdField_a_of_type_ArrayOfJavaLangString[VideoViewVideoHolder.f(this.a)] });
    this.a.a(0, true, "onPause");
  }
  
  public void g()
  {
    super.g();
    VideoViewVideoHolder.a(this.a).removeCallbacksAndMessages(null);
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$SingleFileDownloaderHolder.a();
    this.a.a(0, true, "onDestroy");
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a();
    this.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.e();
    BatchGetVideoInfo localBatchGetVideoInfo = VideoViewVideoHolder.a(this.a);
    VideoViewVideoHolder.a(this.a, null);
    if (localBatchGetVideoInfo != null) {
      localBatchGetVideoInfo.a();
    }
    if (VideoViewVideoHolder.a(this.a) != null)
    {
      VideoViewVideoHolder.a(this.a).recycle();
      VideoViewVideoHolder.a(this.a, null);
    }
    if ((this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog != null) && (this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.isShowing())) {
      this.a.jdField_a_of_type_ComTencentBizQqstoryViewStoryNewGuideDialog.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.13
 * JD-Core Version:    0.7.0.1
 */