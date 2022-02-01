package com.tencent.biz.qqstory.network.handler;

import android.text.TextUtils;
import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.comment.lego.LegoRequestBase;
import com.tencent.biz.qqstory.comment.lego.LegoResponseBase;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupHotRankVideo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupHotRankVideo;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class GetHotSortVideoHandler$GetHotSortVideoRequest
  extends LegoRequestBase
{
  boolean jdField_a_of_type_Boolean = false;
  
  public GetHotSortVideoHandler$GetHotSortVideoRequest(GetHotSortVideoHandler paramGetHotSortVideoHandler, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_group.RspGetGroupHotRankVideo();
    try
    {
      ((qqstory_group.RspGetGroupHotRankVideo)localObject).mergeFrom(paramArrayOfByte);
      return new GetHotSortVideoHandler.GetHotSortVideoResponse(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler, (qqstory_group.RspGetGroupHotRankVideo)localObject, this.jdField_a_of_type_Boolean);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      SLog.d("GetHotSortVideoHandler", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.get_hot_rank_video_list");
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
    localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(GetHotSortVideoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler)));
    localReqGetGroupHotRankVideo.size.set(10);
    if (this.jdField_a_of_type_Boolean)
    {
      localReqGetGroupHotRankVideo.seq.set(GetHotSortVideoHandler.a(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler));
      if (!TextUtils.isEmpty(GetHotSortVideoHandler.b(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler))) {
        localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(GetHotSortVideoHandler.b(this.jdField_a_of_type_ComTencentBizQqstoryNetworkHandlerGetHotSortVideoHandler)));
      }
    }
    return localReqGetGroupHotRankVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoRequest
 * JD-Core Version:    0.7.0.1
 */