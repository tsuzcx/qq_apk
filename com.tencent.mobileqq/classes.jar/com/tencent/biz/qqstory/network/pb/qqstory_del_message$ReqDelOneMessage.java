package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_del_message$ReqDelOneMessage
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_del_message.StoryCommentSimpleInfo comment_info = new qqstory_del_message.StoryCommentSimpleInfo();
  public final PBUInt32Field comment_type = PBField.initUInt32(0);
  public final PBUInt64Field comment_uid = PBField.initUInt64(0L);
  public final PBUInt64Field remind_uid = PBField.initUInt64(0L);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40 }, new String[] { "vid", "comment_uid", "comment_type", "comment_info", "remind_uid" }, new Object[] { localByteStringMicro, Long.valueOf(0L), Integer.valueOf(0), null, Long.valueOf(0L) }, ReqDelOneMessage.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_del_message.ReqDelOneMessage
 * JD-Core Version:    0.7.0.1
 */