package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SougouSearch$CardV2
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34, 42 }, new String[] { "template_name", "is_recommended", "card_properties", "carousel", "subcards" }, new Object[] { "", Boolean.valueOf(false), null, null, null }, CardV2.class);
  public final PBRepeatMessageField card_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
  public final PBRepeatMessageField carousel = PBField.initRepeatMessage(SougouSearch.CardV2.CarouselUnitV2.class);
  public final PBBoolField is_recommended = PBField.initBool(false);
  public final PBRepeatMessageField subcards = PBField.initRepeatMessage(CardV2.class);
  public final PBStringField template_name = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch.CardV2
 * JD-Core Version:    0.7.0.1
 */