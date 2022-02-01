package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqMsgTabNodeList
  extends MessageMicro<ReqMsgTabNodeList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBBytesField client_version = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField current_seq = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField device = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField force_refresh = PBField.initBool(false);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 50, 56, 66 }, new String[] { "current_seq", "start_cookie", "source", "version", "adcode", "device", "force_refresh", "client_version" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localInteger, localInteger, Long.valueOf(0L), localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4 }, ReqMsgTabNodeList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeList
 * JD-Core Version:    0.7.0.1
 */