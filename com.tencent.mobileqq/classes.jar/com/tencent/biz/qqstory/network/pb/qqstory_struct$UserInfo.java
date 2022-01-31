package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$UserInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField background_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfoExt ext = new qqstory_struct.UserInfoExt();
  public final PBUInt32Field fans_count = PBField.initUInt32(0);
  public final PBUInt32Field fans_incr_count = PBField.initUInt32(0);
  public final PBUInt32Field friend_type = PBField.initUInt32(0);
  public final PBUInt64Field gid_in_group = PBField.initUInt64(0L);
  public final PBBytesField head_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field is_subscribe = PBField.initUInt32(0);
  public final PBUInt32Field is_vip = PBField.initUInt32(0);
  public final PBBytesField nick = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField nick_postfix = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField phone = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField remark = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField signature = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field subscribe_count = PBField.initUInt32(0);
  public final PBBytesField symbol = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt64Field uid = PBField.initUInt64(0L);
  public final PBBytesField union_id = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBRepeatMessageField usr_icon_list = PBField.initRepeatMessage(qqstory_struct.UsrIcon.class);
  public final PBUInt64Field vip_id = PBField.initUInt64(0L);
  public qqstory_struct.WatcherExt watcher = new qqstory_struct.WatcherExt();
  
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
    ByteStringMicro localByteStringMicro9 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 58, 66, 74, 80, 88, 96, 104, 114, 122, 128, 136, 146, 152, 162, 170 }, new String[] { "uid", "nick", "head_url", "remark", "ext", "is_vip", "union_id", "symbol", "watcher", "is_subscribe", "friend_type", "fans_count", "subscribe_count", "signature", "background_url", "fans_incr_count", "gid_in_group", "usr_icon_list", "vip_id", "phone", "nick_postfix" }, new Object[] { Long.valueOf(0L), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, Integer.valueOf(0), localByteStringMicro4, localByteStringMicro5, null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro6, localByteStringMicro7, Integer.valueOf(0), Long.valueOf(0L), null, Long.valueOf(0L), localByteStringMicro8, localByteStringMicro9 }, UserInfo.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.UserInfo
 * JD-Core Version:    0.7.0.1
 */