package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class SerializationPB$PicInfo
  extends MessageMicro<PicInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt64Field db_create_time = PBField.initUInt64(0L);
  public final PBStringField geo_hash = PBField.initString("");
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt64Field id = PBField.initUInt64(0L);
  public final PBDoubleField lat = PBField.initDouble(0.0D);
  public final PBDoubleField lng = PBField.initDouble(0.0D);
  public final PBStringField mime = PBField.initString("");
  public final PBUInt32Field orientation = PBField.initUInt32(0);
  public final PBStringField path = PBField.initString("");
  public final PBUInt64Field size = PBField.initUInt64(0L);
  public final PBUInt32Field state = PBField.initUInt32(0);
  public final PBStringField thumb = PBField.initString("");
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 65, 73, 82, 88, 98, 104, 112 }, new String[] { "id", "path", "thumb", "width", "height", "orientation", "create_time", "lat", "lng", "geo_hash", "state", "mime", "size", "db_create_time" }, new Object[] { localLong, "", "", localInteger, localInteger, localInteger, localLong, Double.valueOf(0.0D), Double.valueOf(0.0D), "", localInteger, "", localLong, localLong }, PicInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.PicInfo
 * JD-Core Version:    0.7.0.1
 */