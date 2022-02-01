package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_group.CommentLikeCount;
import com.tencent.biz.qqstory.network.pb.qqstory_group.NewlyLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetCommentLikeCount;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetCommentLikeCountRespone
  extends BaseResponse
{
  public ArrayList<GetCommentLikeCountRespone.CommentLikeCount> a = new ArrayList();
  
  public GetCommentLikeCountRespone(qqstory_group.RspGetCommentLikeCount paramRspGetCommentLikeCount)
  {
    super(paramRspGetCommentLikeCount.result);
    paramRspGetCommentLikeCount = paramRspGetCommentLikeCount.count_list.get().iterator();
    while (paramRspGetCommentLikeCount.hasNext())
    {
      Object localObject = (qqstory_group.CommentLikeCount)paramRspGetCommentLikeCount.next();
      GetCommentLikeCountRespone.CommentLikeCount localCommentLikeCount = new GetCommentLikeCountRespone.CommentLikeCount(this);
      localCommentLikeCount.a = ((qqstory_group.CommentLikeCount)localObject).story_id.get().toStringUtf8();
      localCommentLikeCount.b = ((qqstory_group.CommentLikeCount)localObject).like_count.get();
      localCommentLikeCount.c = ((qqstory_group.CommentLikeCount)localObject).comment_count.get();
      int i = ((qqstory_group.CommentLikeCount)localObject).is_has_like.get();
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      localCommentLikeCount.d = bool;
      localObject = ((qqstory_group.CommentLikeCount)localObject).newly_three_like.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        qqstory_group.NewlyLikeInfo localNewlyLikeInfo = (qqstory_group.NewlyLikeInfo)((Iterator)localObject).next();
        localCommentLikeCount.e.add(Long.valueOf(localNewlyLikeInfo.uin.get()));
      }
      this.a.add(localCommentLikeCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone
 * JD-Core Version:    0.7.0.1
 */