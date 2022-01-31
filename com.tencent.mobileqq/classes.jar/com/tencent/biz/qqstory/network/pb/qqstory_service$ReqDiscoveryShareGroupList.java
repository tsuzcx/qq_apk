package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqDiscoveryShareGroupList
  extends MessageMicro<ReqDiscoveryShareGroupList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26 }, new String[] { "start_cookie", "coordinate", "gps" }, new Object[] { localByteStringMicro, Integer.valueOf(0), null }, ReqDiscoveryShareGroupList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqDiscoveryShareGroupList
 * JD-Core Version:    0.7.0.1
 */