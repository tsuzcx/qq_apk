package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.video.videofeeds.BaseVideoItemHolder;
import java.util.ArrayList;
import java.util.List;

class VideoFeedsAdapter$11
  extends DefaultVideoPreDownloadController<VideoInfo>
{
  VideoFeedsAdapter$11(VideoFeedsAdapter paramVideoFeedsAdapter) {}
  
  protected VideoPlayerWrapper a()
  {
    if ((this.a.a != null) && (this.a.a.a != null)) {
      return this.a.a.a.a;
    }
    return null;
  }
  
  protected VideoPreDownloadMgr.VideoPreDownloadParam a(VideoInfo paramVideoInfo)
  {
    return new VideoPreDownloadMgr.VideoPreDownloadParam(paramVideoInfo.jdField_a_of_type_JavaLangString, paramVideoInfo.g, paramVideoInfo.jdField_a_of_type_Int, paramVideoInfo.d);
  }
  
  protected String a()
  {
    return "video_feeds";
  }
  
  protected List<VideoInfo> a()
  {
    return VideoFeedsAdapter.a(this.a);
  }
  
  public List<VideoPreDownloadMgr.VideoPreDownloadParam> a(int paramInt, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramInt >= 0)
    {
      List localList = VideoFeedsAdapter.a(this.a);
      a(paramInt, paramBoolean, localList, localArrayList);
      b(paramInt - 1, paramBoolean, localList, localArrayList);
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsAdapter.11
 * JD-Core Version:    0.7.0.1
 */