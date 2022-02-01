package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class MonitReport$PublicAccountReq
  extends MessageMicro<PublicAccountReq>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field action = PBField.initUInt32(0);
  public final PBUInt64Field msgid = PBField.initUInt64(0L);
  public final PBUInt64Field taskid = PBField.initUInt64(0L);
  public final PBUInt64Field ts = PBField.initUInt64(0L);
  public final PBStringField url = PBField.initString("");
  
  static
  {
    Long localLong = Long.valueOf(0L);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 40 }, new String[] { "msgid", "action", "url", "ts", "taskid" }, new Object[] { localLong, Integer.valueOf(0), "", localLong, localLong }, PublicAccountReq.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.MonitReport.PublicAccountReq
 * JD-Core Version:    0.7.0.1
 */