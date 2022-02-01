package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_group$RspGetGroupVideoCommentList
  extends MessageMicro<RspGetGroupVideoCommentList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatMessageField<qqstory_group.CommentInfo> comment_list = PBField.initRepeatMessage(qqstory_group.CommentInfo.class);
  public final PBBytesField cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field total_comment_num = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 42 }, new String[] { "result", "comment_list", "is_end", "total_comment_num", "cookie" }, new Object[] { null, null, localInteger, localInteger, localByteStringMicro }, RspGetGroupVideoCommentList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.RspGetGroupVideoCommentList
 * JD-Core Version:    0.7.0.1
 */