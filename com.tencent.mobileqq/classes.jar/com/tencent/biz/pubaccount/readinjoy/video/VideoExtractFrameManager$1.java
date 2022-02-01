package com.tencent.biz.pubaccount.readinjoy.video;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.ThirdVideoManager.UUIDToUrlCallback;
import com.tencent.biz.pubaccount.readinjoy.video.videourl.VideoUrlInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

final class VideoExtractFrameManager$1
  implements ThirdVideoManager.UUIDToUrlCallback
{
  VideoExtractFrameManager$1(VideoExtractFrameManager.VideoInfo paramVideoInfo, HashMap paramHashMap) {}
  
  public void a(VideoUrlInfo paramVideoUrlInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoExtractFrame", 2, "换链回包 mHasDestory = " + VideoExtractFrameManager.a().get() + ", vid = " + paramVideoUrlInfo.jdField_b_of_type_JavaLangString);
    }
    if ((VideoExtractFrameManager.a().get()) || (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_a_of_type_JavaLangString.equals(paramVideoUrlInfo.jdField_b_of_type_JavaLangString))) {}
    for (;;)
    {
      return;
      paramVideoUrlInfo = paramVideoUrlInfo.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (paramVideoUrlInfo.hasNext())
      {
        VideoUrlInfo localVideoUrlInfo = (VideoUrlInfo)paramVideoUrlInfo.next();
        if ((localVideoUrlInfo.jdField_a_of_type_Boolean) && (!TextUtils.isEmpty(localVideoUrlInfo.jdField_c_of_type_JavaLangString)) && (localVideoUrlInfo.jdField_c_of_type_JavaLangString.equals(String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_a_of_type_Long))))
        {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_Int = localVideoUrlInfo.jdField_b_of_type_Int;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_c_of_type_Int = localVideoUrlInfo.jdField_c_of_type_Int;
          VideoExtractFrameManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo, localVideoUrlInfo.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilHashMap, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_Long);
        }
      }
      for (int i = 1; (i == 0) && (QLog.isColorLevel()); i = 0)
      {
        QLog.d("VideoExtractFrame", 2, "no found videoInfo.tag = " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoExtractFrameManager$VideoInfo.jdField_b_of_type_JavaLangString);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoExtractFrameManager.1
 * JD-Core Version:    0.7.0.1
 */