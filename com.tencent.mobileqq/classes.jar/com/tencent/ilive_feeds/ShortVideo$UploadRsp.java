package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ShortVideo$UploadRsp
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField authkey = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBStringField err_msg = PBField.initString("");
  public final PBUInt32Field expiretime = PBField.initUInt32(0);
  public final PBUInt32Field frontid = PBField.initUInt32(0);
  public final PBRepeatField frontip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  public final PBUInt32Field prov = PBField.initUInt32(0);
  public final PBInt32Field retcode = PBField.initInt32(0);
  public final PBUInt32Field userflag = PBField.initUInt32(0);
  public final PBUInt32Field userip = PBField.initUInt32(0);
  public final PBInt32Field ver = PBField.initInt32(0);
  public final PBStringField zonedomain = PBField.initString("");
  public final PBUInt32Field zoneid = PBField.initUInt32(0);
  public final PBRepeatField zoneip = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
  
  static
  {
    ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40, 48, 56, 64, 72, 82, 88, 98, 106 }, new String[] { "retcode", "ver", "userip", "prov", "frontid", "frontip", "zoneid", "zoneip", "expiretime", "zonedomain", "userflag", "authkey", "err_msg" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), "", Integer.valueOf(0), localByteStringMicro, "" }, UploadRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.ilive_feeds.ShortVideo.UploadRsp
 * JD-Core Version:    0.7.0.1
 */