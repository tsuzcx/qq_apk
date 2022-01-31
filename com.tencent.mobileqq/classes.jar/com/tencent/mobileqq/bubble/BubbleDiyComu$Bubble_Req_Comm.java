package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class BubbleDiyComu$Bubble_Req_Comm
  extends MessageMicro<Bubble_Req_Comm>
{
  public static final int MQQVER_FIELD_NUMBER = 3;
  public static final int OSVER_FIELD_NUMBER = 2;
  public static final int PLATFORM_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, Bubble_Req_Comm.class);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
  public final PBInt64Field platform = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyComu.Bubble_Req_Comm
 * JD-Core Version:    0.7.0.1
 */