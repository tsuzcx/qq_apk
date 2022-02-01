package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetPOIPosters
  extends MessageMicro<ReqGetPOIPosters>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "coordinate", "gps", "version" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0) }, ReqGetPOIPosters.class);
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  public final PBUInt32Field version = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIPosters
 * JD-Core Version:    0.7.0.1
 */