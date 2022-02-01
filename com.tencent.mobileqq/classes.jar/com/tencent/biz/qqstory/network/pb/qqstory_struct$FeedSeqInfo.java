package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$FeedSeqInfo
  extends MessageMicro<FeedSeqInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBBytesField feed_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_playable = PBField.initUInt32(0);
  public final PBUInt32Field rcmd_more = PBField.initUInt32(0);
  public final PBBytesField rcmd_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 58 }, new String[] { "feed_id", "seq", "union_id", "date", "is_playable", "rcmd_more", "rcmd_word" }, new Object[] { localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger, localInteger, localByteStringMicro3 }, FeedSeqInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedSeqInfo
 * JD-Core Version:    0.7.0.1
 */