package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_service$ReqGetConfigFile
  extends MessageMicro<ReqGetConfigFile>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field config_file_type = PBField.initUInt32(0);
  public final PBUInt32Field mobile_type = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "config_file_type", "mobile_type" }, new Object[] { localInteger, localInteger }, ReqGetConfigFile.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_service.ReqGetConfigFile
 * JD-Core Version:    0.7.0.1
 */