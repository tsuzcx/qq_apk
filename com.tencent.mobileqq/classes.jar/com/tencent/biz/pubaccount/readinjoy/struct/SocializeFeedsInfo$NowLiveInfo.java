package com.tencent.biz.pubaccount.readinjoy.struct;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.NowLiveInfo;
import tencent.im.oidb.nowlive.nowlive.AnchorInfo;
import tencent.im.oidb.nowlive.nowlive.LiveInfo;
import tencent.im.oidb.nowlive.nowlive.MixInfo;
import tencent.im.oidb.nowlive.nowlive.VideoInfo;

public class SocializeFeedsInfo$NowLiveInfo
{
  private int jdField_a_of_type_Int;
  private SocializeFeedsInfo.NowLiveInfo.MixInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo = new SocializeFeedsInfo.NowLiveInfo.MixInfo();
  private int b;
  
  public feeds_info.NowLiveInfo a()
  {
    feeds_info.NowLiveInfo localNowLiveInfo = new feeds_info.NowLiveInfo();
    localNowLiveInfo.msg_type.set(this.jdField_a_of_type_Int);
    localNowLiveInfo.uint32_timestamp.set(this.b);
    nowlive.MixInfo localMixInfo = new nowlive.MixInfo();
    Object localObject = new nowlive.AnchorInfo();
    ((nowlive.AnchorInfo)localObject).fans.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.AnchorInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    ((nowlive.AnchorInfo)localObject).status.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.AnchorInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    ((nowlive.AnchorInfo)localObject).uin.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.AnchorInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    localMixInfo.anchor_info.set((MessageMicro)localObject);
    localObject = new nowlive.LiveInfo();
    if (SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).live_url.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    }
    if (SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).room_name.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    }
    if (SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.c(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null) {
      ((nowlive.LiveInfo)localObject).room_cover.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.c(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    }
    ((nowlive.LiveInfo)localObject).live_statue.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    ((nowlive.LiveInfo)localObject).audience.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
    if (SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.d(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null)
    {
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(SocializeFeedsInfo.NowLiveInfo.MixInfo.LiveInfo.d(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo))));
      localMixInfo.live_info.set((MessageMicro)localObject);
      localObject = new nowlive.VideoInfo();
      if (SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null) {
        ((nowlive.VideoInfo)localObject).video_url.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.a(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
      }
      if (SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) != null) {
        ((nowlive.VideoInfo)localObject).video_cover_url.set(SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.b(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)));
      }
      if (SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.c(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo)) == null) {
        break label410;
      }
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.copyFromUtf8(SocializeFeedsInfo.NowLiveInfo.MixInfo.VideoInfo.c(SocializeFeedsInfo.NowLiveInfo.MixInfo.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo))));
    }
    for (;;)
    {
      localMixInfo.video_info.set((MessageMicro)localObject);
      localNowLiveInfo.mix_info.set(localMixInfo);
      return localNowLiveInfo;
      ((nowlive.LiveInfo)localObject).vid.set(ByteStringMicro.EMPTY);
      break;
      label410:
      ((nowlive.VideoInfo)localObject).vid.set(ByteStringMicro.EMPTY);
    }
  }
  
  public void a(SocializeFeedsInfo.NowLiveInfo.MixInfo paramMixInfo)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$NowLiveInfo$MixInfo = paramMixInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.NowLiveInfo
 * JD-Core Version:    0.7.0.1
 */