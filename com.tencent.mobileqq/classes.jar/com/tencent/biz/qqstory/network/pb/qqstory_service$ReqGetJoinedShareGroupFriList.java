package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

public final class qqstory_service$ReqGetJoinedShareGroupFriList
  extends MessageMicro<ReqGetJoinedShareGroupFriList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField share_group_unionid = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "share_group_unionid" }, new Object[] { localByteStringMicro }, ReqGetJoinedShareGroupFriList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetJoinedShareGroupFriList
 * JD-Core Version:    0.7.0.1
 */