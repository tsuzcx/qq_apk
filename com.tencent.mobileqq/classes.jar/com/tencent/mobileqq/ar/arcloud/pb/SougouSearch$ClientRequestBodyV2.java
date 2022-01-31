package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SougouSearch$ClientRequestBodyV2
  extends MessageMicro<ClientRequestBodyV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 34 }, new String[] { "device", "sentences" }, new Object[] { null, "" }, ClientRequestBodyV2.class);
  public SougouSearch.DeviceV2 device = new SougouSearch.DeviceV2();
  public final PBRepeatField<String> sentences = PBField.initRepeat(PBStringField.__repeatHelper__);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch.ClientRequestBodyV2
 * JD-Core Version:    0.7.0.1
 */