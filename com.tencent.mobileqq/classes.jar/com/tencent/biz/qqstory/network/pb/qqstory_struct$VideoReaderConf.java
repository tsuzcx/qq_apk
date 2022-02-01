package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$VideoReaderConf
  extends MessageMicro<VideoReaderConf>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field ban_type = PBField.initUInt32(0);
  public final PBRepeatField<Long> user_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> user_unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26 }, new String[] { "ban_type", "user_list", "user_unionid_list" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro }, VideoReaderConf.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoReaderConf
 * JD-Core Version:    0.7.0.1
 */