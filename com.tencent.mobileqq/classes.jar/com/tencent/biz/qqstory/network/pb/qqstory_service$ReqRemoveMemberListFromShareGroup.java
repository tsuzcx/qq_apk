package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqRemoveMemberListFromShareGroup
  extends MessageMicro<ReqRemoveMemberListFromShareGroup>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField group_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field remove_story = PBField.initUInt32(0);
  public final PBRepeatField<ByteStringMicro> unionid_list = PBField.initRepeat(PBBytesField.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "group_id", "unionid_list", "remove_story" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0) }, ReqRemoveMemberListFromShareGroup.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqRemoveMemberListFromShareGroup
 * JD-Core Version:    0.7.0.1
 */