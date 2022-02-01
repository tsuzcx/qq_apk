package com.tencent.aelight.camera.ae.protobuf;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

public final class AEPbData$DebugBrowItem
  extends MessageMicro<DebugBrowItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBInt32Field brow_arc_left = PBField.initInt32(0);
  public final PBInt32Field brow_arcr_right = PBField.initInt32(0);
  public final PBInt32Field brow_curvature = PBField.initInt32(0);
  public final PBInt32Field brow_intensity = PBField.initInt32(0);
  public final PBInt32Field brow_length = PBField.initInt32(0);
  public final PBInt32Field brow_shape = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48 }, new String[] { "brow_intensity", "brow_length", "brow_curvature", "brow_shape", "brow_arc_left", "brow_arcr_right" }, new Object[] { localInteger, localInteger, localInteger, localInteger, localInteger, localInteger }, DebugBrowItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.protobuf.AEPbData.DebugBrowItem
 * JD-Core Version:    0.7.0.1
 */