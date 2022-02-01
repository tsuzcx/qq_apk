package com.tencent.aladdin.config.network;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xbf8$ReqBody
  extends MessageMicro<ReqBody>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "req_type", "body_type_1", "body_type_2", "uin", "appId" }, new Object[] { Integer.valueOf(0), null, null, "", Integer.valueOf(0) }, ReqBody.class);
  public final PBUInt32Field appId = PBField.initUInt32(0);
  public oidb_cmd0xbf8.ReqBodyType1 body_type_1 = new oidb_cmd0xbf8.ReqBodyType1();
  public oidb_cmd0xbf8.ReqBodyType2 body_type_2 = new oidb_cmd0xbf8.ReqBodyType2();
  public final PBUInt32Field req_type = PBField.initUInt32(0);
  public final PBStringField uin = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.aladdin.config.network.oidb_cmd0xbf8.ReqBody
 * JD-Core Version:    0.7.0.1
 */