package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_group$ReqGetGroupVideoList
  extends MessageMicro<ReqGetGroupVideoList>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt64Field group_id = PBField.initUInt64(0L);
  public final PBUInt32Field seq = PBField.initUInt32(0);
  public final PBUInt32Field size = PBField.initUInt32(0);
  public final PBUInt32Field start = PBField.initUInt32(0);
  public final PBInt32Field time_zone = PBField.initInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "group_id", "start", "size", "time_zone", "seq" }, new Object[] { Long.valueOf(0L), localInteger, localInteger, localInteger, localInteger }, ReqGetGroupVideoList.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_group.ReqGetGroupVideoList
 * JD-Core Version:    0.7.0.1
 */