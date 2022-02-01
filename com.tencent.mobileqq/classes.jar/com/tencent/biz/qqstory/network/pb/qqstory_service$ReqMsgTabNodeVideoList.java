package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqMsgTabNodeVideoList
  extends MessageMicro<ReqMsgTabNodeVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBStringField cookie = PBField.initString("");
  public final PBBytesField device = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field node_type = PBField.initUInt32(0);
  public final PBUInt32Field page_size = PBField.initUInt32(0);
  public final PBBytesField passthrough = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBUInt64Field req_time_stamp = PBField.initUInt64(0L);
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBStringField start_vid = PBField.initString("");
  public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 40, 50, 58, 64, 72, 82, 90 }, new String[] { "unionID", "req_time_stamp", "node_type", "recommend_id", "source", "cookie", "start_vid", "page_size", "adcode", "device", "passthrough" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), "", "", Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2, localByteStringMicro3 }, ReqMsgTabNodeVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeVideoList
 * JD-Core Version:    0.7.0.1
 */