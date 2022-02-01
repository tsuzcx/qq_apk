package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$ConfigResult
  extends MessageMicro<ConfigResult>
{
  public static final int FAIL = 1;
  public static final int SUCCESS = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field id = PBField.initUInt32(0);
  public final PBEnumField ret_code = PBField.initEnum(0);
  public final PBUInt32Field version = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "id", "version", "ret_code" }, new Object[] { localInteger, localInteger, localInteger }, ConfigResult.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.ConfigResult
 * JD-Core Version:    0.7.0.1
 */