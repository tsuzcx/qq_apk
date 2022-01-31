package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ARCloudRecogCustomPb$CNBSInfo
  extends MessageMicro<CNBSInfo>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 808, 816 }, new String[] { "uint32_game_id", "uint32_confirmed", "uint32_confirm_time", "uint32_be_killed", "uint32_killed_time", "uint32_key_time", "uint32_sum_num", "uint32_dead_num" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, CNBSInfo.class);
  public final PBUInt32Field uint32_be_killed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_confirm_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_confirmed = PBField.initUInt32(0);
  public final PBUInt32Field uint32_dead_num = PBField.initUInt32(0);
  public final PBUInt32Field uint32_game_id = PBField.initUInt32(0);
  public final PBUInt32Field uint32_key_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_killed_time = PBField.initUInt32(0);
  public final PBUInt32Field uint32_sum_num = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.ARCloudRecogCustomPb.CNBSInfo
 * JD-Core Version:    0.7.0.1
 */