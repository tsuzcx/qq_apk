package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YoutuOcr$OcrItem
  extends MessageMicro<OcrItem>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "itemstring", "itemcoord" }, new Object[] { "", null }, OcrItem.class);
  public YoutuOcr.ItemCoord itemcoord = new YoutuOcr.ItemCoord();
  public final PBStringField itemstring = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.OcrItem
 * JD-Core Version:    0.7.0.1
 */