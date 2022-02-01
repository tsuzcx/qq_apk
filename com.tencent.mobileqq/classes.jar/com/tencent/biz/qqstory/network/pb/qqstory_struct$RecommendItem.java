package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class qqstory_struct$RecommendItem
  extends MessageMicro<RecommendItem>
{
  static final MessageMicro.FieldMap __fieldMap__;
  public qqstory_struct.BigVColleciton bigv_info = new qqstory_struct.BigVColleciton();
  public final PBUInt32Field item_id = PBField.initUInt32(0);
  public qqstory_struct.HotTopicPack topic_info = new qqstory_struct.HotTopicPack();
  public final PBUInt32Field type = PBField.initUInt32(0);
  public qqstory_struct.ClickUrlInfo url_info = new qqstory_struct.ClickUrlInfo();
  
  static
  {
    Integer localInteger = Integer.valueOf(0);
    __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 40 }, new String[] { "type", "topic_info", "bigv_info", "url_info", "item_id" }, new Object[] { localInteger, null, null, null, localInteger }, RecommendItem.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.pb.qqstory_struct.RecommendItem
 * JD-Core Version:    0.7.0.1
 */