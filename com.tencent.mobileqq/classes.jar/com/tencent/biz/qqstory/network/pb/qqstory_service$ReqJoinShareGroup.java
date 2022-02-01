package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqJoinShareGroup
  extends MessageMicro<ReqJoinShareGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field exit_src = PBField.initUInt32(0);
  public final PBBytesField group_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<ByteStringMicro> member_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field oper_type = PBField.initUInt32(0);
  public final PBUInt32Field source = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "group_id", "oper_type", "member_list", "source", "exit_src" }, new Object[] { localByteStringMicro1, localInteger, localByteStringMicro2, localInteger, localInteger }, ReqJoinShareGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqJoinShareGroup
 * JD-Core Version:    0.7.0.1
 */