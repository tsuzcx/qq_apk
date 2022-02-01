package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$RspGetWatcher
  extends MessageMicro<RspGetWatcher>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field is_end = PBField.initUInt32(0);
  public final PBUInt32Field like_total_num = PBField.initUInt32(0);
  public final PBBytesField next_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.ErrorInfo result = new qqstory_struct.ErrorInfo();
  public final PBUInt32Field stranger_like_total_num = PBField.initUInt32(0);
  public final PBUInt32Field stranger_view_total_num = PBField.initUInt32(0);
  public final PBRepeatMessageField<qqstory_struct.UserInfo> user_list = PBField.initRepeatMessage(qqstory_struct.UserInfo.class);
  public final PBUInt32Field view_total_num = PBField.initUInt32(0);
  public final PBUInt32Field view_total_time = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 40, 48, 56, 64, 72 }, new String[] { "result", "user_list", "is_end", "next_cookie", "view_total_num", "stranger_view_total_num", "like_total_num", "stranger_like_total_num", "view_total_time" }, new Object[] { null, null, localInteger, localByteStringMicro, localInteger, localInteger, localInteger, localInteger, localInteger }, RspGetWatcher.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetWatcher
 * JD-Core Version:    0.7.0.1
 */