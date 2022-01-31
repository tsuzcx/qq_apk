package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import qqi;
import qql;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$1(qqi paramqqi, TVK_NetVideoInfo paramTVK_NetVideoInfo) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.jdField_a_of_type_Qqi.a) != null) && (VideoFeedsPlayManager.b(this.jdField_a_of_type_Qqi.a).a != null)) {
      qqi.a(this.jdField_a_of_type_Qqi, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, VideoFeedsPlayManager.b(this.jdField_a_of_type_Qqi.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */