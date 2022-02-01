package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetUserVideoInfo
  extends MessageMicro<ReqGetUserVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field source = PBField.initUInt32(0);
  public final PBBytesField vid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 34, 40 }, new String[] { "vid", "source" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, ReqGetUserVideoInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetUserVideoInfo
 * JD-Core Version:    0.7.0.1
 */