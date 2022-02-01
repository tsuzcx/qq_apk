package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.DownloadUrlQueryResult;
import com.tencent.biz.qqstory.base.download.DownloadUrlManager.QueryUrlResultUICallBack;
import com.tencent.biz.qqstory.base.preload.FileCacheUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tencent.biz.qqstory.playvideo.TVKPreloader.PreloadItem;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.HardCodeUtil;
import java.io.File;

class VideoViewVideoHolder$VideoPrepareSegment$6
  implements DownloadUrlManager.QueryUrlResultUICallBack
{
  VideoViewVideoHolder$VideoPrepareSegment$6(VideoViewVideoHolder.VideoPrepareSegment paramVideoPrepareSegment, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void a(DownloadUrlManager.DownloadUrlQueryResult paramDownloadUrlQueryResult)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.isCanceled())
    {
      SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_JavaLangString, "queryAndUpdateUrl onResult. stream canceled");
      return;
    }
    if (!TextUtils.equals(paramDownloadUrlQueryResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid))
    {
      SLog.e(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_JavaLangString, "ignore queryAndUpdateUrl onResult. oldVid=%s. newVid=%s", new Object[] { paramDownloadUrlQueryResult.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid });
      return;
    }
    if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.d())
    {
      VideoViewVideoHolder.VideoPrepareSegment.c(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment, new ErrorMessage(-1, "queryAndUpdateUrl onResult already unBind"));
      return;
    }
    Object localObject;
    if (paramDownloadUrlQueryResult.jdField_a_of_type_Boolean)
    {
      localObject = new File(this.jdField_a_of_type_JavaLangString);
      if ((((File)localObject).exists()) && (!FileCacheUtils.a((File)localObject)))
      {
        boolean bool = ((File)localObject).delete();
        SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_JavaLangString, "%s - %d found orphan tmp , delete it. %s", new Object[] { paramDownloadUrlQueryResult.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadUrlQueryResult.jdField_a_of_type_Int), Boolean.valueOf(bool) });
      }
    }
    if (TextUtils.isEmpty(paramDownloadUrlQueryResult.b))
    {
      VideoViewVideoHolder.VideoPrepareSegment.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment, new ErrorMessage(13, "queryAndUpdateUrl onResult url empty"));
      return;
    }
    int i = TVKPreloader.a(new TVKPreloader.PreloadItem(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramDownloadUrlQueryResult.b, this.jdField_a_of_type_JavaLangString, "TVKsetVideoPath"));
    SLog.d(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_JavaLangString, "setVideoPath, vid=%s, cache=%d, fileName = %s, url=%s", new Object[] { this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, Integer.valueOf(i), this.jdField_a_of_type_JavaLangString.substring(this.jdField_a_of_type_JavaLangString.length() - 15), paramDownloadUrlQueryResult.b });
    switch (i)
    {
    }
    for (;;)
    {
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, DownloadUrlManager.a(paramDownloadUrlQueryResult.b));
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.c = paramDownloadUrlQueryResult.b;
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, "SP", SystemClock.uptimeMillis());
      VideoViewVideoHolder.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, SystemClock.uptimeMillis());
      this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.jdField_a_of_type_ComTencentBizQqstoryPlayvideoPlayerIVideoView.a(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.jdField_a_of_type_JavaLangString, paramDownloadUrlQueryResult.b, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoBytes, (int)this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVideoDuration, 0);
      return;
      VideoViewVideoHolder localVideoViewVideoHolder = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a;
      StringBuilder localStringBuilder = new StringBuilder().append(HardCodeUtil.a(2131716278));
      if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a.b()) {}
      for (localObject = "TVK";; localObject = "TexView")
      {
        VideoViewVideoHolder.a(localVideoViewVideoHolder, (String)localObject);
        VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, paramDownloadUrlQueryResult.b, null, false);
        break;
      }
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, HardCodeUtil.a(2131716276));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, HardCodeUtil.a(2131716270));
      continue;
      VideoViewVideoHolder.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoLrtbwidgetVideoViewVideoHolder$VideoPrepareSegment.a, HardCodeUtil.a(2131716272));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.VideoViewVideoHolder.VideoPrepareSegment.6
 * JD-Core Version:    0.7.0.1
 */