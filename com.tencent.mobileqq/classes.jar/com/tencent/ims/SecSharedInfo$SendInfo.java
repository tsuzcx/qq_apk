package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class SecSharedInfo$SendInfo
  extends MessageMicro<SendInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48 }, new String[] { "type", "md5", "url", "src_uin", "des_uin", "des_type" }, new Object[] { Integer.valueOf(1), "", "", "", "", Integer.valueOf(0) }, SendInfo.class);
  public final PBInt32Field des_type = PBField.initInt32(0);
  public final PBStringField des_uin = PBField.initString("");
  public final PBStringField md5 = PBField.initString("");
  public final PBStringField src_uin = PBField.initString("");
  public final PBEnumField type = PBField.initEnum(1);
  public final PBStringField url = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ims.SecSharedInfo.SendInfo
 * JD-Core Version:    0.7.0.1
 */