package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

public final class YTOpenBase$StoreFace
  extends MessageMicro<StoreFace>
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "face_id", "face_item", "tag" }, new Object[] { "", null, "" }, StoreFace.class);
  public final PBStringField face_id = PBField.initString("");
  public YTOpenBase.FaceItem face_item = new YTOpenBase.FaceItem();
  public final PBStringField tag = PBField.initString("");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arcloud.pb.YTOpenBase.StoreFace
 * JD-Core Version:    0.7.0.1
 */