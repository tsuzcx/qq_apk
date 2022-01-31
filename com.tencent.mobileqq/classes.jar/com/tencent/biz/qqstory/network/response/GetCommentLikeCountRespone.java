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
  public ArrayList a = new ArrayList();
  
  public GetCommentLikeCountRespone(qqstory_group.RspGetCommentLikeCount paramRspGetCommentLikeCount)
  {
    super(paramRspGetCommentLikeCount.result);
    paramRspGetCommentLikeCount = paramRspGetCommentLikeCount.count_list.get().iterator();
    while (paramRspGetCommentLikeCount.hasNext())
    {
      Object localObject = (qqstory_group.CommentLikeCount)paramRspGetCommentLikeCount.next();
      GetCommentLikeCountRespone.CommentLikeCount localCommentLikeCount = new GetCommentLikeCountRespone.CommentLikeCount(this);
      localCommentLikeCount.jdField_a_of_type_JavaLangString = ((qqstory_group.CommentLikeCount)localObject).story_id.get().toStringUtf8();
      localCommentLikeCount.jdField_a_of_type_Int = ((qqstory_group.CommentLikeCount)localObject).like_count.get();
      localCommentLikeCount.b = ((qqstory_group.CommentLikeCount)localObject).comment_count.get();
      if (((qqstory_group.CommentLikeCount)localObject).is_has_like.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localCommentLikeCount.jdField_a_of_type_Boolean = bool;
        localObject = ((qqstory_group.CommentLikeCount)localObject).newly_three_like.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          qqstory_group.NewlyLikeInfo localNewlyLikeInfo = (qqstory_group.NewlyLikeInfo)((Iterator)localObject).next();
          localCommentLikeCount.jdField_a_of_type_JavaUtilList.add(Long.valueOf(localNewlyLikeInfo.uin.get()));
        }
      }
      this.a.add(localCommentLikeCount);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetCommentLikeCountRespone
 * JD-Core Version:    0.7.0.1
 */