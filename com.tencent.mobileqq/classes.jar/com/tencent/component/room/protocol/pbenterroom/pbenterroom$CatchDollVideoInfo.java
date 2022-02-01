package com.tencent.component.room.protocol.pbenterroom;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

public final class pbenterroom$CatchDollVideoInfo
  extends MessageMicro<CatchDollVideoInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "camera_info" }, new Object[] { null }, CatchDollVideoInfo.class);
  public final PBRepeatMessageField<pbenterroom.CameraInfo> camera_info = PBField.initRepeatMessage(pbenterroom.CameraInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.component.room.protocol.pbenterroom.pbenterroom.CatchDollVideoInfo
 * JD-Core Version:    0.7.0.1
 */