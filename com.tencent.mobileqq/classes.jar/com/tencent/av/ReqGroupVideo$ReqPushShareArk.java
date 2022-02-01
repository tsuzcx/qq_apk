package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ReqGroupVideo$ReqPushShareArk
  extends MessageMicro<ReqPushShareArk>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_code = PBField.initUInt64(0L);
  public final PBBytesField group_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field recv_uin = PBField.initUInt64(0L);
  public final PBUInt32Field role = PBField.initUInt32(0);
  public final PBUInt32Field room_create_time = PBField.initUInt32(0);
  public final PBUInt64Field room_id = PBField.initUInt64(0L);
  public final PBUInt64Field send_type = PBField.initUInt64(0L);
  public final PBBytesField share_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 50, 58, 64, 72 }, new String[] { "uin", "room_id", "room_create_time", "send_type", "recv_uin", "group_name", "share_name", "role", "group_code" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L) }, ReqPushShareArk.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ReqGroupVideo.ReqPushShareArk
 * JD-Core Version:    0.7.0.1
 */