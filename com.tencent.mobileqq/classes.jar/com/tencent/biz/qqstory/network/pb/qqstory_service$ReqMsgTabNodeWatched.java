package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqMsgTabNodeWatched
  extends MessageMicro<ReqMsgTabNodeWatched>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field node_type = PBField.initUInt32(0);
  public final PBUInt32Field operation = PBField.initUInt32(0);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField unionID = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32 }, new String[] { "unionID", "node_type", "operation", "recommend_id" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L) }, ReqMsgTabNodeWatched.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqMsgTabNodeWatched
 * JD-Core Version:    0.7.0.1
 */