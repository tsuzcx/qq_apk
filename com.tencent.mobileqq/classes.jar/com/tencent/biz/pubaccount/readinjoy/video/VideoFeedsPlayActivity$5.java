package com.tencent.biz.pubaccount.readinjoy.video;

import com.tencent.biz.pubaccount.VideoInfo;
import noo;
import qzd;
import qze;

class VideoFeedsPlayActivity$5
  implements Runnable
{
  VideoFeedsPlayActivity$5(VideoFeedsPlayActivity paramVideoFeedsPlayActivity, VideoInfo paramVideoInfo, String paramString) {}
  
  public void run()
  {
    qze localqze = new qze(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
    String str1 = "";
    String str2 = "0";
    if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
    {
      str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.j;
      str2 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g;
      localqze.h(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    }
    String str4 = this.jdField_a_of_type_JavaLangString;
    String str5 = this.jdField_a_of_type_JavaLangString;
    if (VideoFeedsPlayActivity.a(this.this$0)) {}
    for (String str3 = "1";; str3 = "0")
    {
      noo.a(null, str1, str4, str5, 0, 0, str3, "", str2, localqze.a().a(), false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity.5
 * JD-Core Version:    0.7.0.1
 */