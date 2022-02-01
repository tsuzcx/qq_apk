package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.biz.qqstory.database.HotTopicEntry;
import com.tencent.biz.qqstory.database.OfficialRecommendEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.HotTopicPack;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public class HotTopicItem
  extends BaseUIItem
  implements Copyable
{
  public boolean topicCanJoin;
  public int topicColor;
  public String topicCover;
  public String topicDesc;
  public long topicId;
  public String topicLogo;
  public String topicName;
  
  public HotTopicItem() {}
  
  public HotTopicItem(HotTopicEntry paramHotTopicEntry)
  {
    this.topicId = paramHotTopicEntry.topicId;
    this.topicName = paramHotTopicEntry.topicName;
    this.topicCover = paramHotTopicEntry.topicCover;
    this.topicLogo = paramHotTopicEntry.topicLogo;
    this.topicColor = paramHotTopicEntry.topicColor;
    this.topicDesc = paramHotTopicEntry.topicDesc;
    this.topicCanJoin = paramHotTopicEntry.topicCanJoin;
  }
  
  public HotTopicItem(OfficialRecommendEntry paramOfficialRecommendEntry)
  {
    if (paramOfficialRecommendEntry == null) {
      return;
    }
    this.topicId = paramOfficialRecommendEntry.topicId;
    this.topicName = paramOfficialRecommendEntry.topicName;
    this.topicCover = paramOfficialRecommendEntry.topicCover;
    this.topicLogo = paramOfficialRecommendEntry.topicLogo;
    this.topicColor = paramOfficialRecommendEntry.topicColor;
    this.topicDesc = paramOfficialRecommendEntry.topicDesc;
    this.topicCanJoin = paramOfficialRecommendEntry.topicCanJoin;
  }
  
  public HotTopicItem(qqstory_struct.HotTopicPack paramHotTopicPack)
  {
    this.topicId = paramHotTopicPack.topic_id.get();
    this.topicName = paramHotTopicPack.topic_name.get().toStringUtf8();
    this.topicCover = paramHotTopicPack.topic_cover.get().toStringUtf8();
    this.topicLogo = paramHotTopicPack.topic_logo.get().toStringUtf8();
    this.topicColor = paramHotTopicPack.topic_color.get();
    this.topicDesc = paramHotTopicPack.topic_desc.get().toStringUtf8();
    int i = paramHotTopicPack.is_join.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.topicCanJoin = bool;
  }
  
  public void copy(Object paramObject) {}
  
  public HotTopicEntry cover2StoryEntry()
  {
    HotTopicEntry localHotTopicEntry = new HotTopicEntry();
    localHotTopicEntry.topicId = this.topicId;
    localHotTopicEntry.topicName = this.topicName;
    localHotTopicEntry.topicCover = this.topicCover;
    localHotTopicEntry.topicLogo = this.topicLogo;
    localHotTopicEntry.topicColor = this.topicColor;
    localHotTopicEntry.topicDesc = this.topicDesc;
    localHotTopicEntry.topicCanJoin = this.topicCanJoin;
    return localHotTopicEntry;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HotTopicItem{topicId=");
    localStringBuilder.append(this.topicId);
    localStringBuilder.append(", topicName='");
    localStringBuilder.append(this.topicName);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicCanJoin=");
    localStringBuilder.append(this.topicCanJoin);
    localStringBuilder.append("} ");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.HotTopicItem
 * JD-Core Version:    0.7.0.1
 */