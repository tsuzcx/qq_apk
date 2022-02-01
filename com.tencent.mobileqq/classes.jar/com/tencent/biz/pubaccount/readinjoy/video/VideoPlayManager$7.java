package com.tencent.biz.pubaccount.readinjoy.video;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class VideoPlayManager$7
  implements Runnable
{
  VideoPlayManager$7(VideoPlayManager paramVideoPlayManager, VideoPlayManager.VideoPlayParam paramVideoPlayParam, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    if (VideoPlayManager.a(this.this$0) != null)
    {
      Iterator localIterator = VideoPlayManager.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        VideoPlayManager.OnPlayStateListener localOnPlayStateListener = (VideoPlayManager.OnPlayStateListener)localIterator.next();
        if (localOnPlayStateListener != null) {
          localOnPlayStateListener.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager$VideoPlayParam, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
        }
      }
    }
    VideoPlayManager.a(this.this$0, this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager.7
 * JD-Core Version:    0.7.0.1
 */