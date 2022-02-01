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
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 40, 48, 58, 64, 73, 81, 88, 98, 104, 272 }, new String[] { "roomId", "machineCode", "enter_type", "private_key", "ts", "flag", "refer_source", "open_live_type", "latitude", "longitude", "room_type", "auth", "from_id", "gid" }, new Object[] { Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro1, Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Double.valueOf(0.0D), Double.valueOf(0.0D), Integer.valueOf(0), null, Integer.valueOf(0), Long.valueOf(0L) }, EnterRoomReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.EnterRoomReq
 * JD-Core Version:    0.7.0.1
 */