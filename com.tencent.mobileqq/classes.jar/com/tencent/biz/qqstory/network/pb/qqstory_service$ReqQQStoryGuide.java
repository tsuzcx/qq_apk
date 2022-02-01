package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqQQStoryGuide
  extends MessageMicro<ReqQQStoryGuide>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "to_uid", "version", "platform" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0) }, ReqQQStoryGuide.class);
  public final PBInt32Field platform = PBField.initInt32(0);
  public final PBUInt64Field to_uid = PBField.initUInt64(0L);
  public final PBStringField version = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqQQStoryGuide
 * JD-Core Version:    0.7.0.1
 */