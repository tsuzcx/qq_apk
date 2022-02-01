package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

public final class ExpeDataAcc$NetworkInfo
  extends MessageMicro<NetworkInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26 }, new String[] { "network_type", "user_client_ip", "gateway_ip" }, new Object[] { Long.valueOf(0L), "", "" }, NetworkInfo.class);
  public final PBStringField gateway_ip = PBField.initString("");
  public final PBInt64Field network_type = PBField.initInt64(0L);
  public final PBStringField user_client_ip = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc.NetworkInfo
 * JD-Core Version:    0.7.0.1
 */