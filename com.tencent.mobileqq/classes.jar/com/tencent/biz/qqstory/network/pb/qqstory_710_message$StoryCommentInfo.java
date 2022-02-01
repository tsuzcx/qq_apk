package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$StoryCommentInfo
  extends MessageMicro<StoryCommentInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field comment_del = PBField.initUInt32(0);
  public final PBUInt32Field comment_id = PBField.initUInt32(0);
  public final PBUInt32Field comment_time = PBField.initUInt32(0);
  public final PBUInt64Field comment_uid = PBField.initUInt64(0L);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field reply_is_bigv = PBField.initUInt32(0);
  public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  public final PBBytesField reply_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field share_type = PBField.initUInt32(0);
  public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48, 58, 64, 72, 82, 88, 98, 106, 112 }, new String[] { "comment_id", "comment_uid", "comment_time", "content", "comment_del", "is_bigv", "union_id", "reply_uid", "reply_is_bigv", "reply_union_id", "type", "share_name", "share_union_id", "share_type" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0) }, StoryCommentInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.StoryCommentInfo
 * JD-Core Version:    0.7.0.1
 */