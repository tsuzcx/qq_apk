package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

public final class SerializationPB$StoryAlbum
  extends MessageMicro<StoryAlbum>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "geo_hash_list", "pic_list" }, new Object[] { "", null }, StoryAlbum.class);
  public final PBRepeatField<String> geo_hash_list = PBField.initRepeat(PBStringField.__repeatHelper__);
  public final PBRepeatMessageField<SerializationPB.PicInfo> pic_list = PBField.initRepeatMessage(SerializationPB.PicInfo.class);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.SerializationPB.StoryAlbum
 * JD-Core Version:    0.7.0.1
 */