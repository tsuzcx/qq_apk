package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqCheckActivity
  extends MessageMicro<ReqCheckActivity>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "adcode", "version" }, new Object[] { Long.valueOf(0L), "" }, ReqCheckActivity.class);
  public final PBUInt64Field adcode = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqCheckActivity
 * JD-Core Version:    0.7.0.1
 */