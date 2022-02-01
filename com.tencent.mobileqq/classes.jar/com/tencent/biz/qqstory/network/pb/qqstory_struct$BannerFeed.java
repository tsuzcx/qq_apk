package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class qqstory_struct$BannerFeed
  extends MessageMicro<BannerFeed>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public final PBBytesField blurb = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField content = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBBytesField cover_url = PBField.initBytes(ByteStringMicro.EMPTY);
  public final PBUInt32Field date = PBField.initUInt32(0);
  public final PBUInt32Field height = PBField.initUInt32(0);
  public final PBUInt64Field recommend_id = PBField.initUInt64(0L);
  public final PBBytesField schema = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.BannerShareInfo share_info = new qqstory_struct.BannerShareInfo();
  public final PBBytesField title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
  public qqstory_struct.UserInfo user = new qqstory_struct.UserInfo();
  public final PBUInt32Field width = PBField.initUInt32(0);
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
    ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 26, 42, 48, 56, 66, 74, 82, 88, 96, 106 }, new String[] { "schema", "content", "cover_url", "width", "height", "user", "blurb", "share_info", "date", "recommend_id", "title_wording" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localInteger, localInteger, null, localByteStringMicro4, null, localInteger, Long.valueOf(0L), localByteStringMicro5 }, BannerFeed.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.BannerFeed
 * JD-Core Version:    0.7.0.1
 */