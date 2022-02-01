package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$FilterListPack
  extends MessageMicro<FilterListPack>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField filter_config_file = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField filter_config_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field filter_id = PBField.initUInt64(0L);
  public final PBBytesField filter_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field filter_type = PBField.initUInt32(0);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42 }, new String[] { "filter_id", "filter_name", "filter_type", "filter_config_file", "filter_config_md5" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, Integer.valueOf(0), localByteStringMicro2, localByteStringMicro3 }, FilterListPack.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.FilterListPack
 * JD-Core Version:    0.7.0.1
 */