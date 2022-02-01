package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$ShareGroupExtInfo
  extends MessageMicro<ShareGroupExtInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBUInt32Field has_join = PBField.initUInt32(0);
  public final PBUInt32Field owner_type = PBField.initUInt32(0);
  public final PBUInt32Field total_members = PBField.initUInt32(0);
  public final PBUInt32Field total_videos = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "has_join", "total_members", "total_videos", "owner_type" }, new Object[] { localInteger, localInteger, localInteger, localInteger }, ShareGroupExtInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupExtInfo
 * JD-Core Version:    0.7.0.1
 */