package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_pgc$UserInfo
  extends MessageMicro<UserInfo>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField auth_type_icon = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField auth_type_name = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField desc = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field fans_group_uin = PBField.initUInt64(0L);
  public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBoolField is_subscribe = PBField.initBool(false);
  public final PBBytesField logo_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field subscribe_count = PBField.initUInt64(0L);
  public final PBUInt32Field theme_color = PBField.initUInt32(0);
  public final PBUInt64Field tribe_id = PBField.initUInt64(0L);
  public final PBUInt32Field type = PBField.initUInt32(0);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field view_count = PBField.initUInt64(0L);
  
  static
  {
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro6 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro7 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro8 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 42, 48, 58, 66, 72, 80, 88, 96, 104, 114, 122, 130 }, new String[] { "type", "uid", "nick", "head_url", "remark", "is_subscribe", "desc", "logo_url", "view_count", "fans_group_uin", "tribe_id", "theme_color", "subscribe_count", "union_id", "auth_type_name", "auth_type_icon" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Boolean.valueOf(false), localByteStringMicro4, localByteStringMicro5, Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro6, localByteStringMicro7, localByteStringMicro8 }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_pgc.UserInfo
 * JD-Core Version:    0.7.0.1
 */