package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqGroupDateVideoList
  extends MessageMicro<ReqGroupDateVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field date_count = PBField.initUInt32(0);
  public final PBUInt32Field from = PBField.initUInt32(0);
  public final PBBytesField group_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field seqno = PBField.initUInt64(0L);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBInt32Field time_zone = PBField.initInt32(0);
  public final PBUInt32Field video_count = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32, 40, 48, 56 }, new String[] { "group_unionid", "start_cookie", "date_count", "video_count", "seqno", "time_zone", "from" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqGroupDateVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGroupDateVideoList
 * JD-Core Version:    0.7.0.1
 */