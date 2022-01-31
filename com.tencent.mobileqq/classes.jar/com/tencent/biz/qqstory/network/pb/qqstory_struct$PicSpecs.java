package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$PicSpecs
  extends MessageMicro<PicSpecs>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField pic_bid = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatField<Integer> pic_spec = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "pic_bid", "pic_spec" }, new Object[] { localByteStringMicro, Integer.valueOf(0) }, PicSpecs.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.PicSpecs
 * JD-Core Version:    0.7.0.1
 */