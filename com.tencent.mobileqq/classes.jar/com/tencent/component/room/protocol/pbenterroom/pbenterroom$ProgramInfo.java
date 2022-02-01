package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$ProgramInfo
  extends MessageMicro<ProgramInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field cancel_ts = PBField.initUInt32(0);
  public final PBRepeatField<String> cover = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBStringField desc = PBField.initString("");
  public final PBUInt32Field end_ts = PBField.initUInt32(0);
  public final PBStringField id = PBField.initString("");
  public final PBUInt32Field start_ts = PBField.initUInt32(0);
  public final PBStringField title = PBField.initString("");
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 40, 48, 58 }, new String[] { "title", "start_ts", "desc", "cover", "end_ts", "cancel_ts", "id" }, new Object[] { "", localInteger, "", "", localInteger, localInteger, "" }, ProgramInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.ProgramInfo
 * JD-Core Version:    0.7.0.1
 */