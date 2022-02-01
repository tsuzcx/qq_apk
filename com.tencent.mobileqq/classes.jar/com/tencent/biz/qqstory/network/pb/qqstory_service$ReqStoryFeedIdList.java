package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_service$ReqStoryFeedIdList
  extends MessageMicro<ReqStoryFeedIdList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field bind_uin = PBField.initUInt64(0L);
  public qqstory_struct.LoginSig bind_uin_login_sig = new qqstory_struct.LoginSig();
  public final PBUInt32Field client_version = PBField.initUInt32(0);
  public final PBUInt32Field coordinate = PBField.initUInt32(0);
  public qqstory_struct.GpsMsg gps = new qqstory_struct.GpsMsg();
  public final PBBytesField start_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 50 }, new String[] { "start_cookie", "coordinate", "gps", "client_version", "bind_uin", "bind_uin_login_sig" }, new Object[] { localByteStringMicro, localInteger, null, localInteger, Long.valueOf(0L), null }, ReqStoryFeedIdList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqStoryFeedIdList
 * JD-Core Version:    0.7.0.1
 */