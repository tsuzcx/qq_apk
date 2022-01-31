package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_710_message$ShareGroupInfo
  extends MessageMicro<ShareGroupInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_bigv = PBField.initUInt32(0);
  public final PBUInt32Field oper_type = PBField.initUInt32(0);
  public final PBUInt64Field oper_uin = PBField.initUInt64(0L);
  public final PBUInt32Field push_time = PBField.initUInt32(0);
  public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField share_new_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field share_type = PBField.initUInt32(0);
  public final PBBytesField share_union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58, 66, 72 }, new String[] { "oper_uin", "oper_type", "share_name", "share_new_name", "push_time", "is_bigv", "union_id", "share_union_id", "share_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, Integer.valueOf(0) }, ShareGroupInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_710_message.ShareGroupInfo
 * JD-Core Version:    0.7.0.1
 */