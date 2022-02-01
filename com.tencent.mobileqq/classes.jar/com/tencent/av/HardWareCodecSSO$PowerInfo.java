package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class HardWareCodecSSO$PowerInfo
  extends MessageMicro<PowerInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "mark", "support", "max_width", "max_height" }, new Object[] { Long.valueOf(0L), Boolean.valueOf(false), Long.valueOf(0L), Long.valueOf(0L) }, PowerInfo.class);
  public final PBUInt64Field mark = PBField.initUInt64(0L);
  public final PBUInt64Field max_height = PBField.initUInt64(0L);
  public final PBUInt64Field max_width = PBField.initUInt64(0L);
  public final PBBoolField support = PBField.initBool(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.HardWareCodecSSO.PowerInfo
 * JD-Core Version:    0.7.0.1
 */