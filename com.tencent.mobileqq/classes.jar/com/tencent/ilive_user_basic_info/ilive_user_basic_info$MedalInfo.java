package com.tencent.ilive_user_basic_info;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class ilive_user_basic_info$MedalInfo
  extends MessageMicro<MedalInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field create_time = PBField.initUInt64(0L);
  public final PBUInt32Field medal_bg = PBField.initUInt32(0);
  public final PBBytesField medal_bg_img = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField medal_desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field medal_end_time = PBField.initUInt64(0L);
  public final PBBytesField medal_face_bigger = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField medal_face_small = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_frame = PBField.initUInt32(0);
  public final PBUInt32Field medal_id = PBField.initUInt32(0);
  public final PBUInt32Field medal_index = PBField.initUInt32(0);
  public final PBUInt32Field medal_level = PBField.initUInt32(0);
  public final PBBytesField medal_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_point = PBField.initUInt32(0);
  public final PBUInt32Field medal_priority_level = PBField.initUInt32(0);
  public final PBUInt64Field medal_start_time = PBField.initUInt64(0L);
  public final PBUInt32Field medal_type = PBField.initUInt32(0);
  public final PBBytesField medal_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field medal_version = PBField.initUInt32(0);
  public final PBUInt64Field update_time = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154 }, new String[] { "medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", "create_time", "update_time", "medal_bg", "medal_frame", "medal_bg_img" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6 }, MedalInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ilive_user_basic_info.ilive_user_basic_info.MedalInfo
 * JD-Core Version:    0.7.0.1
 */