package com.tencent.ilivesdk.service.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class SwitchAndEnterRoom$RoomInfo
  extends MessageMicro<RoomInfo>
{
  public static final int LOGO_FIELD_NUMBER = 3;
  public static final int ROOMID_FIELD_NUMBER = 1;
  public static final int URL_FIELD_NUMBER = 2;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field logo = PBField.initUInt32(0);
  public final PBUInt32Field roomid = PBField.initUInt32(0);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "roomid", "url", "logo" }, new Object[] { localInteger, "", localInteger }, RoomInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.service.pb.SwitchAndEnterRoom.RoomInfo
 * JD-Core Version:    0.7.0.1
 */