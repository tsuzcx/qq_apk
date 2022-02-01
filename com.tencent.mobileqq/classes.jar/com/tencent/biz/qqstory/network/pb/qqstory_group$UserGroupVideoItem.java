package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$UserGroupVideoItem
  extends MessageMicro<UserGroupVideoItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field publish_time = PBField.initUInt32(0);
  public final PBRepeatField<Long> top_uin_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBUInt32Field total = PBField.initUInt32(0);
  public final PBUInt32Field total_unread = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 40, 48 }, new String[] { "group_id", "total", "total_unread", "cover_url", "publish_time", "top_uin_list" }, new Object[] { localLong, localInteger, localInteger, localByteStringMicro, localInteger, localLong }, UserGroupVideoItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.UserGroupVideoItem
 * JD-Core Version:    0.7.0.1
 */