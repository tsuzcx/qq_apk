package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetPublicCommentList
  extends MessageMicro<RspGetPublicCommentList>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "result", "comment_list", "is_end", "total_comment_num" }, new Object[] { null, null, Integer.valueOf(0), Integer.valueOf(0) }, RspGetPublicCommentList.class);
  public final PBRepeatMessageField<qqstory_struct.StoryVideoCommentInfo> comment_list = PBField.initRepeatMessage(qqstory_struct.StoryVideoCommentInfo.class);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetPublicCommentList
 * JD-Core Version:    0.7.0.1
 */