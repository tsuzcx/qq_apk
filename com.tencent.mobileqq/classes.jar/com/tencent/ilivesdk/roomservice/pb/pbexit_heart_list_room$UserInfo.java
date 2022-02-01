package com.tencent.ilivesdk.roomservice.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pbexit_heart_list_room$UserInfo
  extends MessageMicro<UserInfo>
{
  public static final int CLIENT_TYPE_FIELD_NUMBER = 5;
  public static final int FACE_URL_FIELD_NUMBER = 2;
  public static final int LOGO_FULL_URL_FIELD_NUMBER = 9;
  public static final int NICK_NAME_FIELD_NUMBER = 6;
  public static final int TINYID_FIELD_NUMBER = 4;
  public static final int UIN_FIELD_NUMBER = 1;
  public static final int VERSION_FIELD_NUMBER = 3;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field client_type = PBField.initUInt32(0);
  public final PBStringField face_url = PBField.initString("");
  public final PBBytesField logo_full_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nick_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field tinyid = PBField.initUInt64(0L);
  public final PBUInt64Field uin = PBField.initUInt64(0L);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 50, 74 }, new String[] { "uin", "face_url", "version", "tinyid", "client_type", "nick_name", "logo_full_url" }, new Object[] { localLong, "", localInteger, localLong, localInteger, localByteStringMicro1, localByteStringMicro2 }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.roomservice.pb.pbexit_heart_list_room.UserInfo
 * JD-Core Version:    0.7.0.1
 */