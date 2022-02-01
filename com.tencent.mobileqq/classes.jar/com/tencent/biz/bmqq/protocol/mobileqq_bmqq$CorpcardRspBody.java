package com.tencent.biz.bmqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class mobileqq_bmqq$CorpcardRspBody
  extends MessageMicro<CorpcardRspBody>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBStringField corpname = PBField.initString("");
  public final PBStringField email = PBField.initString("");
  public final PBUInt32Field flag = PBField.initUInt32(0);
  public final PBStringField jobs = PBField.initString("");
  public final PBStringField mobile = PBField.initString("");
  public final PBStringField nickname = PBField.initString("");
  public final PBStringField phone = PBField.initString("");
  public final PBStringField remarkname = PBField.initString("");
  public mobileqq_bmqq.RetInfo retInfo = new mobileqq_bmqq.RetInfo();
  public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0L);
  public final PBUInt64Field uint64_qquin = PBField.initUInt64(0L);
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 34, 42, 50, 58, 66, 74, 82, 88 }, new String[] { "retInfo", "uint64_qquin", "uint64_kfuin", "nickname", "remarkname", "jobs", "mobile", "phone", "email", "corpname", "flag" }, new Object[] { null, localLong, localLong, "", "", "", "", "", "", "", Integer.valueOf(0) }, CorpcardRspBody.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.bmqq.protocol.mobileqq_bmqq.CorpcardRspBody
 * JD-Core Version:    0.7.0.1
 */