package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$RspFeedLikeList
  extends MessageMicro<RspFeedLikeList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "result", "feed_like_info" }, new Object[] { null, null }, RspFeedLikeList.class);
  public qqstory_struct.FeedLikeInfo feed_like_info = new qqstory_struct.FeedLikeInfo();
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspFeedLikeList
 * JD-Core Version:    0.7.0.1
 */