package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.qqlive.mediaplayer.api.TVK_NetVideoInfo;
import rfp;
import rfs;

public class VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$1
  implements Runnable
{
  public VideoFeedsPlayManager$MediaPlayListenerAdapterImpl$1(rfp paramrfp, TVK_NetVideoInfo paramTVK_NetVideoInfo) {}
  
  public void run()
  {
    if ((VideoFeedsPlayManager.b(this.jdField_a_of_type_Rfp.a) != null) && (VideoFeedsPlayManager.b(this.jdField_a_of_type_Rfp.a).a != null)) {
      rfp.a(this.jdField_a_of_type_Rfp, this.jdField_a_of_type_ComTencentQqliveMediaplayerApiTVK_NetVideoInfo, VideoFeedsPlayManager.b(this.jdField_a_of_type_Rfp.a).a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayManager.MediaPlayListenerAdapterImpl.1
 * JD-Core Version:    0.7.0.1
 */