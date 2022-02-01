package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.LikeEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedLike;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedLikeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoLikeInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetFeedLikeRequest$BatchGetFeedLikeResp
  extends BaseResponse
{
  public List<BatchGetFeedLikeRequest.FeedLikeInfo> a = new ArrayList();
  
  public BatchGetFeedLikeRequest$BatchGetFeedLikeResp(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
  }
  
  public BatchGetFeedLikeRequest$BatchGetFeedLikeResp(qqstory_service.RspBatchFeedLike paramRspBatchFeedLike)
  {
    super(paramRspBatchFeedLike.result);
    paramRspBatchFeedLike = paramRspBatchFeedLike.feed_like_info_list.get().iterator();
    while (paramRspBatchFeedLike.hasNext())
    {
      Object localObject = (qqstory_struct.FeedLikeInfo)paramRspBatchFeedLike.next();
      BatchGetFeedLikeRequest.FeedLikeInfo localFeedLikeInfo = new BatchGetFeedLikeRequest.FeedLikeInfo();
      localFeedLikeInfo.a = ((qqstory_struct.FeedLikeInfo)localObject).feed_id.get().toStringUtf8();
      localFeedLikeInfo.c = ((qqstory_struct.FeedLikeInfo)localObject).has_like.get();
      localFeedLikeInfo.b = ((qqstory_struct.FeedLikeInfo)localObject).like_total_count.get();
      localFeedLikeInfo.d = new ArrayList();
      localObject = ((qqstory_struct.FeedLikeInfo)localObject).like_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        LikeEntry localLikeEntry = LikeEntry.convertFrom((qqstory_struct.StoryVideoLikeInfo)((Iterator)localObject).next());
        localLikeEntry.feedId = localFeedLikeInfo.a;
        localFeedLikeInfo.d.add(localLikeEntry);
      }
      this.a.add(localFeedLikeInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp
 * JD-Core Version:    0.7.0.1
 */