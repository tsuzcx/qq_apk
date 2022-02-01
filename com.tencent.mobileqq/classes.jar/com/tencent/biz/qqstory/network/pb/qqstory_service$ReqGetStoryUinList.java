package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetStoryUinList
  extends MessageMicro<ReqGetStoryUinList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field count = PBField.initUInt32(0);
  public final PBUInt32Field ret_user_info = PBField.initUInt32(0);
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "start_cookie", "count", "ret_user_info" }, new Object[] { localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqGetStoryUinList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetStoryUinList
 * JD-Core Version:    0.7.0.1
 */