package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_struct$SquareBannerItem
  extends MessageMicro<SquareBannerItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField image = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField item_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField jump_target_action = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "item_id", "image", "jump_target_action" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3 }, SquareBannerItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.SquareBannerItem
 * JD-Core Version:    0.7.0.1
 */