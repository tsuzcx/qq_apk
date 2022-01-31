package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$MultiRecommend
  extends MessageMicro<MultiRecommend>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField rcmd_word = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField<qqstory_struct.MultiRecommendItem> recommend_feed = PBField.initRepeatMessage(qqstory_struct.MultiRecommendItem.class);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field top_location = PBField.initUInt32(0);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 40, 48, 56, 66, 74 }, new String[] { "recommend_feed", "recommend_id", "top_location", "next_cookie", "is_end", "seq", "date", "user", "rcmd_word" }, new Object[] { null, Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, localByteStringMicro2 }, MultiRecommend.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommend
 * JD-Core Version:    0.7.0.1
 */