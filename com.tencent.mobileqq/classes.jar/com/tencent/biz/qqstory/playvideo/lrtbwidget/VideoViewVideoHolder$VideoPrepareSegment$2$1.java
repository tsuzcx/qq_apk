package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.io.File;
import mqq.os.MqqHandler;

class VideoViewVideoHolder$VideoPrepareSegment$2$1
  implements Runnable
{
  VideoViewVideoHolder$VideoPrepareSegment$2$1(VideoViewVideoHolder.VideoPrepareSegment.2 param2, String paramString1, String paramString2, File paramFile) {}
  
  public void run()
  {
    SLog.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_JavaLangString, "onSuccess, [vid, url, fileCache] = ");
    DownloadUrlManager localDownloadUrlManager = (DownloadUrlManager)SuperManager.a(28);
    String str = FileCacheUtils.a(new File(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.jdField_a_of_type_JavaLangString));
    if (!TextUtils.isEmpty(str)) {
      FileCacheUtils.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment$2.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem, str, 0, StoryReportor.a(BaseApplicationImpl.getContext()));
    }
    localDownloadUrlManager.b(this.jdField_a_of_type_JavaLangString, 0);
    localDownloadUrlManager.a(this.jdField_a_of_type_JavaLangString, 0);
    ThreadManager.getUIHandler().post(new VideoViewVideoHolder.VideoPrepareSegment.2.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.2.1
 * JD-Core Version:    0.7.0.1
 */