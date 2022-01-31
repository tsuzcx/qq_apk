package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class ImageRetrievalComm$OD_BBox
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 45, 48 }, new String[] { "xmin", "ymin", "xmax", "ymax", "fScore", "iLabelID" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Float.valueOf(0.0F), Integer.valueOf(0) }, OD_BBox.class);
  public final PBFloatField fScore = PBField.initFloat(0.0F);
  public final PBInt32Field iLabelID = PBField.initInt32(0);
  public final PBInt32Field xmax = PBField.initInt32(0);
  public final PBInt32Field xmin = PBField.initInt32(0);
  public final PBInt32Field ymax = PBField.initInt32(0);
  public final PBInt32Field ymin = PBField.initInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ImageRetrievalComm.OD_BBox
 * JD-Core Version:    0.7.0.1
 */