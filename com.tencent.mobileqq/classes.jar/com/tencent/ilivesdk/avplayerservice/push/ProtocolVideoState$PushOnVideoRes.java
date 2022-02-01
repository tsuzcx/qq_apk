package com.tencent.ilivesdk.avplayerservice.push;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ProtocolVideoState$PushOnVideoRes
  extends MessageMicro<PushOnVideoRes>
{
  public static final int DSTUIN_FIELD_NUMBER = 4;
  public static final int OPERTYPE_FIELD_NUMBER = 2;
  public static final int RESULT_FIELD_NUMBER = 1;
  public static final int SRCUIN_FIELD_NUMBER = 3;
  public static final int VIDEOCHANEL_FIELD_NUMBER = 5;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field DstUin = PBField.initUInt64(0L);
  public final PBUInt32Field OperType = PBField.initUInt32(0);
  public final PBUInt32Field Result = PBField.initUInt32(0);
  public final PBUInt64Field SrcUin = PBField.initUInt64(0L);
  public final PBUInt32Field VideoChanel = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "Result", "OperType", "SrcUin", "DstUin", "VideoChanel" }, new Object[] { localInteger, localInteger, localLong, localLong, localInteger }, PushOnVideoRes.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.ProtocolVideoState.PushOnVideoRes
 * JD-Core Version:    0.7.0.1
 */