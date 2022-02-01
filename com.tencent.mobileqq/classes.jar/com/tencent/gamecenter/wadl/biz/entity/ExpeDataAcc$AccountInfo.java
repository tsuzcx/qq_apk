package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$AccountInfo
  extends MessageMicro<AccountInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34 }, new String[] { "uid", "open_id", "account_type", "to_uid" }, new Object[] { "", "", Long.valueOf(0L), "" }, AccountInfo.class);
  public final PBInt64Field account_type = PBField.initInt64(0L);
  public final PBStringField open_id = PBField.initString("");
  public final PBStringField to_uid = PBField.initString("");
  public final PBStringField uid = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.AccountInfo
 * JD-Core Version:    0.7.0.1
 */