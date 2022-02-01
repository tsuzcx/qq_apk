package com.tencent.biz.pubaccount.readinjoy.video.player;

import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInjoyPlayer$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ReadInjoyPlayer$1(ReadInjoyPlayer paramReadInjoyPlayer, String paramString, long paramLong, int paramInt) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (paramVideoUrlInfo == null)
    {
      QLog.d(ReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer), 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(ReadInjoyPlayer.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayerReadInjoyPlayer), 2, "UUIDToUrlCallback Callback vid=" + paramVideoUrlInfo.jdField_b_of_type_JavaLangString + ", url=" + paramVideoUrlInfo.jdField_a_of_type_JavaLangString + ", isH265=" + paramVideoUrlInfo.jdField_a_of_type_Boolean + ", isHWCodec=" + paramVideoUrlInfo.jdField_b_of_type_Boolean + ", fileBitRate=" + paramVideoUrlInfo.c + ", hwBackupUrl=" + paramVideoUrlInfo.e);
    }
    LitePlayer.a(new ReadInjoyPlayer.1.1(this, paramVideoUrlInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1
 * JD-Core Version:    0.7.0.1
 */