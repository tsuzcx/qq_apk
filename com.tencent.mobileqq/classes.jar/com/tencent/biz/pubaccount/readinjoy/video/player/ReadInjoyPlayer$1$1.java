package com.tencent.biz.pubaccount.readinjoy.video.player;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyPlayer$1$1
  implements Runnable
{
  ReadInjoyPlayer$1$1(ReadInjoyPlayer.1 param1, VideoUrlInfo paramVideoUrlInfo) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_b_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_JavaLangString)) && (ReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_JavaLangString, ""))) {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.d == 2) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(202, 108, 0, "vid2url failed, video deleted");
      }
    }
    label223:
    while (!QLog.isColorLevel())
    {
      return;
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(202, 107, 0, "vid2url failed, get null");
        return;
      }
      VideoPlayerWrapper localVideoPlayerWrapper;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_a_of_type_Int == 1)
      {
        i = 102;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.e, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_b_of_type_Boolean, i, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_Int);
        localVideoPlayerWrapper = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayerWrapper;
        if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_a_of_type_Boolean) {
          break label223;
        }
      }
      for (int i = 1;; i = 0)
      {
        localVideoPlayerWrapper.b = i;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadinjoyPlayerReporter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo);
        return;
        i = 101;
        break;
      }
    }
    QLog.d(ReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer$1.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer), 2, "vid2url换回来后，当前视频已经不再播放，vid:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_b_of_type_JavaLangString + " url:" + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideourlVideoUrlInfo.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1
 * JD-Core Version:    0.7.0.1
 */