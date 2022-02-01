package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class pbenterroom$Resolution
  extends MessageMicro<Resolution>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "height", "width" }, new Object[] { localInteger, localInteger }, Resolution.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.Resolution
 * JD-Core Version:    0.7.0.1
 */