package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;

class VideoWebPreDownload$3
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoWebPreDownload$3(VideoWebPreDownload paramVideoWebPreDownload, String paramString, int paramInt, long paramLong) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if ((TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramVideoUrlInfo.b)) || (!paramVideoUrlInfo.b.equals(this.jdField_a_of_type_JavaLangString)))
    {
      if ((TextUtils.isEmpty(paramVideoUrlInfo.jdField_a_of_type_JavaLangString)) && (VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoWebPreDownload) != null))
      {
        String str = (String)VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoWebPreDownload).get(paramVideoUrlInfo.b);
        if (!TextUtils.isEmpty(str)) {
          VideoWebPreDownload.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoWebPreDownload).a(paramVideoUrlInfo.b, -1, str);
        }
      }
      return;
    }
    ThreadManager.post(new VideoWebPreDownload.3.1(this, paramVideoUrlInfo), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoWebPreDownload.3
 * JD-Core Version:    0.7.0.1
 */