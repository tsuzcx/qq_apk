package com.tencent.mobileqq.bubble;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class BubbleDiyComu$UserTextInfo
  extends MessageMicro<UserTextInfo>
{
  public static final int CREATE_TS_FIELD_NUMBER = 4;
  public static final int TEXT_FIELD_NUMBER = 3;
  public static final int TEXT_ID_FIELD_NUMBER = 2;
  public static final int TEXT_UIN_FIELD_NUMBER = 1;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt64Field create_ts = PBField.initInt64(0L);
  public final PBStringField text = PBField.initString("");
  public final PBUInt32Field text_id = PBField.initUInt32(0);
  public final PBUInt64Field text_uin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "text_uin", "text_id", "text", "create_ts" }, new Object[] { localLong, Integer.valueOf(0), "", localLong }, UserTextInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleDiyComu.UserTextInfo
 * JD-Core Version:    0.7.0.1
 */