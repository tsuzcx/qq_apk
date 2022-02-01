package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class SougouSearch$CardV2$CarouselUnitV2
  extends MessageMicro<CarouselUnitV2>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "card_properties" }, new Object[] { null }, CarouselUnitV2.class);
  public final PBRepeatMessageField<SougouSearch.MapItem> card_properties = PBField.initRepeatMessage(SougouSearch.MapItem.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.SougouSearch.CardV2.CarouselUnitV2
 * JD-Core Version:    0.7.0.1
 */