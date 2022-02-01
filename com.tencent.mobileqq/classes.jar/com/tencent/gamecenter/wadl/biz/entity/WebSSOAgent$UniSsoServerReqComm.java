package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class WebSSOAgent$UniSsoServerReqComm
  extends MessageMicro<UniSsoServerReqComm>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "platform", "osver", "mqqver" }, new Object[] { Long.valueOf(0L), "", "" }, UniSsoServerReqComm.class);
  public final PBStringField mqqver = PBField.initString("");
  public final PBStringField osver = PBField.initString("");
  public final PBInt64Field platform = PBField.initInt64(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.WebSSOAgent.UniSsoServerReqComm
 * JD-Core Version:    0.7.0.1
 */