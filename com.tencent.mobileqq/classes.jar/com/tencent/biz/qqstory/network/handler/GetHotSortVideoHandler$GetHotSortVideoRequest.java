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
  boolean a = false;
  
  public GetHotSortVideoHandler$GetHotSortVideoRequest(GetHotSortVideoHandler paramGetHotSortVideoHandler, boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public LegoResponseBase a(byte[] paramArrayOfByte)
  {
    Object localObject = new qqstory_group.RspGetGroupHotRankVideo();
    try
    {
      ((qqstory_group.RspGetGroupHotRankVideo)localObject).mergeFrom(paramArrayOfByte);
      return new GetHotSortVideoHandler.GetHotSortVideoResponse(this.b, (qqstory_group.RspGetGroupHotRankVideo)localObject, this.a);
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
  
  protected byte[] b()
  {
    qqstory_group.ReqGetGroupHotRankVideo localReqGetGroupHotRankVideo = new qqstory_group.ReqGetGroupHotRankVideo();
    localReqGetGroupHotRankVideo.union_id.set(ByteStringMicro.copyFromUtf8(GetHotSortVideoHandler.a(this.b)));
    localReqGetGroupHotRankVideo.size.set(10);
    if (this.a)
    {
      localReqGetGroupHotRankVideo.seq.set(GetHotSortVideoHandler.b(this.b));
      if (!TextUtils.isEmpty(GetHotSortVideoHandler.c(this.b))) {
        localReqGetGroupHotRankVideo.start_cookie.set(ByteStringMicro.copyFromUtf8(GetHotSortVideoHandler.c(this.b)));
      }
    }
    return localReqGetGroupHotRankVideo.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.GetHotSortVideoHandler.GetHotSortVideoRequest
 * JD-Core Version:    0.7.0.1
 */