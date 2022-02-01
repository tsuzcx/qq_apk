package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class pbenterroom$EnterRoomReq
  extends MessageMicro<EnterRoomReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public pbenterroom.AuthInfo auth = new pbenterroom.AuthInfo();
  public final PBUInt32Field enter_type = PBField.initUInt32(0);
  public final PBUInt64Field flag = PBField.initUInt64(0L);
  public final PBUInt32Field from_id = PBField.initUInt32(0);
  public final PBUInt64Field gid = PBField.initUInt64(0L);
  public final PBDoubleField latitude = PBField.initDouble(0.0D);
  public final PBDoubleField longitude = PBField.initDouble(0.0D);
  public final PBStringField machineCode = PBField.initString("");
  public final PBUInt32Field open_live_type = PBField.initUInt32(0);
  public final PBBytesField private_key = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField refer_source = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field roomId = PBField.initUInt32(0);
  public final PBUInt32Field room_type = PBField.initUInt32(0);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    Long localLong = Long.valueOf(0L);
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58, 64, 73, 81, 88, 98, 104, 272 }, new String[] { "roomId", "machineCode", "enter_type", "private_key", "ts", "flag", "refer_source", "open_live_type", "latitude", "longitude", "room_type", "auth", "from_id", "gid" }, new Object[] { localInteger, "", localInteger, localByteStringMicro1, localLong, localLong, localByteStringMicro2, localInteger, Double.valueOf(0.0D), Double.valueOf(0.0D), localInteger, null, localInteger, localLong }, EnterRoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomReq
 * JD-Core Version:    0.7.0.1
 */