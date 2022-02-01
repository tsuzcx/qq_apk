package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.boundaries.StoryApi;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetCommentLikeCount;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetCommentLikeCount;
import com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import java.util.Iterator;
import java.util.List;

public class GetCommentLikeCountRequest
  extends NetworkRequest
{
  public List<String> a;
  
  public BaseResponse a(byte[] paramArrayOfByte)
  {
    qqstory_group.RspGetCommentLikeCount localRspGetCommentLikeCount = new qqstory_group.RspGetCommentLikeCount();
    try
    {
      localRspGetCommentLikeCount.mergeFrom(paramArrayOfByte);
      return new GetCommentLikeCountRespone(localRspGetCommentLikeCount);
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      label23:
      break label23;
    }
    return null;
  }
  
  public String a()
  {
    return StoryApi.a("StoryGroupSvc.get_comment_like_count");
  }
  
  protected byte[] a()
  {
    qqstory_group.ReqGetCommentLikeCount localReqGetCommentLikeCount = new qqstory_group.ReqGetCommentLikeCount();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      localReqGetCommentLikeCount.story_id_list.add(ByteStringMicro.copyFromUtf8(str));
    }
    return localReqGetCommentLikeCount.toByteArray();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.GetCommentLikeCountRequest
 * JD-Core Version:    0.7.0.1
 */