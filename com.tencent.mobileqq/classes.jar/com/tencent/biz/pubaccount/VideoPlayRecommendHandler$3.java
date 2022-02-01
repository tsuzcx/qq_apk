package com.tencent.biz.pubaccount;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.protocol.ReadInJoyOidbHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.ToServiceMsg;
import cooperation.readinjoy.ReadInJoyHelper;
import tencent.im.oidb.cmd0x6cf.oidb_0x6cf.ReqBody;

class VideoPlayRecommendHandler$3
  implements Runnable
{
  VideoPlayRecommendHandler$3(VideoPlayRecommendHandler paramVideoPlayRecommendHandler, long paramLong, int paramInt, String paramString, VideoPlayRecommendObserver paramVideoPlayRecommendObserver, VideoInfo paramVideoInfo) {}
  
  public void run()
  {
    Object localObject = new oidb_0x6cf.ReqBody();
    ((oidb_0x6cf.ReqBody)localObject).uint64_uin.set(this.jdField_a_of_type_Long);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_source.set(this.jdField_a_of_type_Int);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_sub_source.set(6);
    ((oidb_0x6cf.ReqBody)localObject).uint32_req_sim_type.set(ReadInJoyHelper.d());
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      ((oidb_0x6cf.ReqBody)localObject).bytes_req_range_cookie.set(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
    }
    localObject = ReadInJoyOidbHelper.a("OidbSvc.0x6cf", 1743, 3, ((oidb_0x6cf.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("VALUE_OBSERVER_TAG", Integer.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountVideoPlayRecommendObserver.hashCode()));
    ((ToServiceMsg)localObject).addAttribute("VALUE_REQUEST_VIDEO_ARTICLE_ID", this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.g);
    this.this$0.sendPbReq((ToServiceMsg)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.VideoPlayRecommendHandler.3
 * JD-Core Version:    0.7.0.1
 */