package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;

public final class qqstory_service$ReqGetPOIMarkPack
  extends MessageMicro<ReqGetPOIMarkPack>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "gps" }, new Object[] { null }, ReqGetPOIMarkPack.class);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetPOIMarkPack
 * JD-Core Version:    0.7.0.1
 */