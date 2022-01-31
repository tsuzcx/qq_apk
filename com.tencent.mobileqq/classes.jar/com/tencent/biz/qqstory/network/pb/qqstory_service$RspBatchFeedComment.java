package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class qqstory_service$RspBatchFeedComment
  extends MessageMicro<RspBatchFeedComment>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_comment_info_list" }, new Object[] { null, null }, RspBatchFeedComment.class);
  public final PBRepeatMessageField<qqstory_struct.FeedCommentInfo> feed_comment_info_list = PBField.initRepeatMessage(qqstory_struct.FeedCommentInfo.class);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspBatchFeedComment
 * JD-Core Version:    0.7.0.1
 */