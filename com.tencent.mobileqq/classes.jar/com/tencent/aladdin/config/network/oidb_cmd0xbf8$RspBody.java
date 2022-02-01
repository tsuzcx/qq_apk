package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$RspBody
  extends MessageMicro<RspBody>
{
  public static final int INTERNAL_ERROR = 2;
  public static final int INVALID_PACKAGE = 3;
  public static final int INVALID_REQ1 = 1;
  public static final int SUCCESS = 0;
  static final MessageMicro.FieldMap __fieldMap__;
  public oidb_cmd0xbf8.RspBodyType1 body_type_1 = new oidb_cmd0xbf8.RspBodyType1();
  public oidb_cmd0xbf8.RspBodyType2 body_type_2 = new oidb_cmd0xbf8.RspBodyType2();
  public final PBEnumField ret_code = PBField.initEnum(0);
  public final PBUInt32Field rsp_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34 }, new String[] { "ret_code", "rsp_type", "body_type_1", "body_type_2" }, new Object[] { localInteger, localInteger, null, null }, RspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.RspBody
 * JD-Core Version:    0.7.0.1
 */