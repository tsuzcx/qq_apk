package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$VideoSpreadGroupList
  extends MessageMicro<VideoSpreadGroupList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBRepeatField<Long> group_list = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  public final PBRepeatField<ByteStringMicro> share_group_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  public final PBUInt32Field visibility_sharegroup_type = PBField.initUInt32(0);
  public final PBUInt32Field visibility_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "visibility_type", "group_list", "visibility_sharegroup_type", "share_group_list" }, new Object[] { localInteger, Long.valueOf(0L), localInteger, localByteStringMicro }, VideoSpreadGroupList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList
 * JD-Core Version:    0.7.0.1
 */