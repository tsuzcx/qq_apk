package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import nrt;
import rom;
import ron;

class VideoFeedsPlayActivity$8
  implements Runnable
{
  VideoFeedsPlayActivity$8(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, VideoInfo paramVideoInfo, String paramString) {}
  
  public void run()
  {
    ron localron = new ron(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    String str1 = "";
    String str2 = "0";
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
      localron.h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
    String str4 = this.jdField_a_of_type_JavaLangString;
    String str5 = this.jdField_a_of_type_JavaLangString;
    if (VideoFeedsPlayActivity.c(this.this$0)) {}
    for (String str3 = "1";; str3 = "0")
    {
      nrt.a(null, str1, str4, str5, 0, 0, str3, "", str2, localron.a().a(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.8
 * JD-Core Version:    0.7.0.1
 */