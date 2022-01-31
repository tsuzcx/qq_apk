package com.tencent.av;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class hd_video_2$InviteTempSessionData
  extends MessageMicro<InviteTempSessionData>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField bytes_relationship = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField bytes_relationship_ext = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field uint32_relationship_type = PBField.initUInt32(0);
  public final PBUInt64Field uint64_group_uin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42 }, new String[] { "uint64_uin", "uint64_group_uin", "bytes_relationship", "uint32_relationship_type", "bytes_relationship_ext" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2 }, InviteTempSessionData.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.hd_video_2.InviteTempSessionData
 * JD-Core Version:    0.7.0.1
 */