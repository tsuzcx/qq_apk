package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class qqstory_struct$GpsMsg
  extends MessageMicro<GpsMsg>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field lat = PBField.initInt32(0);
  public final PBInt32Field lng = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "lat", "lng" }, new Object[] { localInteger, localInteger }, GpsMsg.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.GpsMsg
 * JD-Core Version:    0.7.0.1
 */