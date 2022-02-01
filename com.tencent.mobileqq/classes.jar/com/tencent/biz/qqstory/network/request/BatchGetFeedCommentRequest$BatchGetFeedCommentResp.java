package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.database.CommentEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedCommentInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoCommentInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetFeedCommentRequest$BatchGetFeedCommentResp
  extends BaseResponse
{
  public List<BatchGetFeedCommentRequest.FeedCommentInfo> a = new ArrayList();
  public List<FeedCommentSync> b = new ArrayList(0);
  
  public BatchGetFeedCommentRequest$BatchGetFeedCommentResp(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
  }
  
  public BatchGetFeedCommentRequest$BatchGetFeedCommentResp(qqstory_service.RspBatchFeedComment paramRspBatchFeedComment)
  {
    super(paramRspBatchFeedComment.result);
    paramRspBatchFeedComment = paramRspBatchFeedComment.feed_comment_info_list.get().iterator();
    while (paramRspBatchFeedComment.hasNext())
    {
      Object localObject = (qqstory_struct.FeedCommentInfo)paramRspBatchFeedComment.next();
      BatchGetFeedCommentRequest.FeedCommentInfo localFeedCommentInfo = new BatchGetFeedCommentRequest.FeedCommentInfo();
      localFeedCommentInfo.a = ((qqstory_struct.FeedCommentInfo)localObject).feed_id.get().toStringUtf8();
      localFeedCommentInfo.b = ((qqstory_struct.FeedCommentInfo)localObject).comment_total_num.get();
      localFeedCommentInfo.d = ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8();
      localFeedCommentInfo.c = ((qqstory_struct.FeedCommentInfo)localObject).is_end.get();
      if (localFeedCommentInfo.c != 1) {
        this.b.add(new FeedCommentSync(localFeedCommentInfo.a, 1, ((qqstory_struct.FeedCommentInfo)localObject).next_cookie.get().toStringUtf8()));
      }
      localObject = ((qqstory_struct.FeedCommentInfo)localObject).comment_list.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        CommentEntry localCommentEntry = CommentEntry.convertFrom((qqstory_struct.StoryVideoCommentInfo)((Iterator)localObject).next());
        localCommentEntry.feedId = localFeedCommentInfo.a;
        localFeedCommentInfo.e.add(localCommentEntry);
      }
      this.a.add(localFeedCommentInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFeedCommentRequest.BatchGetFeedCommentResp
 * JD-Core Version:    0.7.0.1
 */