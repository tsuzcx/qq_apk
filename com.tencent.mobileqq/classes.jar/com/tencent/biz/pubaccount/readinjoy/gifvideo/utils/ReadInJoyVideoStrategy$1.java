package com.tencent.biz.pubaccount.readinjoy.gifvideo.utils;

import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;

class ReadInJoyVideoStrategy$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  ReadInJoyVideoStrategy$1(ReadInJoyVideoStrategy paramReadInJoyVideoStrategy, IStrategy.URLCallback paramURLCallback) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    QLog.d("ReadInJoyVideoStrategy", 1, "convertVidToUrl: " + paramVideoUrlInfo);
    if ((paramVideoUrlInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsIStrategy$URLCallback != null))
    {
      IStrategy.URLCallback localURLCallback = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyGifvideoUtilsIStrategy$URLCallback;
      String str1 = paramVideoUrlInfo.b;
      String str2 = paramVideoUrlInfo.a;
      localURLCallback.a(new String[] { str1 }, new String[] { str2 }, paramVideoUrlInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.gifvideo.utils.ReadInJoyVideoStrategy.1
 * JD-Core Version:    0.7.0.1
 */