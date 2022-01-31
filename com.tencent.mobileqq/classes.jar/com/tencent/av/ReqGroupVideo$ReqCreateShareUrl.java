package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$ReqCreateShareUrl
  extends MessageMicro<ReqCreateShareUrl>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field role = PBField.initUInt32(0);
  public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_is_need_verify = PBField.initUInt32(0);
  public final PBUInt32Field uint32_room_create_time = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_room_id = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42, 50, 56, 64 }, new String[] { "uint64_uin", "uint64_group_code", "uint64_room_id", "uint32_room_create_time", "group_name", "share_name", "role", "uint32_is_need_verify" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0) }, ReqCreateShareUrl.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.ReqCreateShareUrl
 * JD-Core Version:    0.7.0.1
 */