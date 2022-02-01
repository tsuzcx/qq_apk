package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$Extinfo
  extends MessageMicro<Extinfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 40 }, new String[] { "net_type", "phone_type", "client_version", "resolution", "content_type" }, new Object[] { "", "", "", null, Integer.valueOf(0) }, Extinfo.class);
  public final PBStringField client_version = PBField.initString("");
  public final PBUInt32Field content_type = PBField.initUInt32(0);
  public final PBStringField net_type = PBField.initString("");
  public final PBStringField phone_type = PBField.initString("");
  public pbenterroom.Resolution resolution = new pbenterroom.Resolution();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.Extinfo
 * JD-Core Version:    0.7.0.1
 */