package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqMonitorValue
  extends MessageMicro<ReqMonitorValue>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ID = PBField.initUInt32(0);
  public final PBUInt32Field Value = PBField.initUInt32(0);
  public final PBBytesField errmsg = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ID", "Value", "errmsg" }, new Object[] { localInteger, localInteger, localByteStringMicro }, ReqMonitorValue.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMonitorValue
 * JD-Core Version:    0.7.0.1
 */