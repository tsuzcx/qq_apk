package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqAddComment
  extends MessageMicro<ReqAddComment>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field fake_id = PBField.initUInt64(0L);
  public final PBUInt64Field reply_uid = PBField.initUInt64(0L);
  public final PBBytesField story_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32 }, new String[] { "story_id", "reply_uid", "content", "fake_id" }, new Object[] { localByteStringMicro1, localLong, localByteStringMicro2, localLong }, ReqAddComment.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqAddComment
 * JD-Core Version:    0.7.0.1
 */