package com.tencent.mobileqq.ac;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class ArticleComment$ReadPhotoItemInfo
  extends MessageMicro
{
  static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "index", "item_remain_time", "item_type" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, ReadPhotoItemInfo.class);
  public final PBUInt32Field index = PBField.initUInt32(0);
  public final PBUInt32Field item_remain_time = PBField.initUInt32(0);
  public final PBUInt32Field item_type = PBField.initUInt32(0);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.ac.ArticleComment.ReadPhotoItemInfo
 * JD-Core Version:    0.7.0.1
 */