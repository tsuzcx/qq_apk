package com.tencent.av;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qav_gvideo_sdk_transfer$gVideoAcceptType
  extends MessageMicro<gVideoAcceptType>
{
  public static final int BIG = 2;
  public static final int SMALL = 1;
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_account", "video_type" }, new Object[] { Long.valueOf(0L), Integer.valueOf(1) }, gVideoAcceptType.class);
  public final PBUInt64Field uint64_account = PBField.initUInt64(0L);
  public final PBEnumField video_type = PBField.initEnum(1);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.qav_gvideo_sdk_transfer.gVideoAcceptType
 * JD-Core Version:    0.7.0.1
 */