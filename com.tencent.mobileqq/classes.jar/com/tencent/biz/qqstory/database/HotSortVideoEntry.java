package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoCard;
import com.tencent.biz.qqstory.network.pb.qqstory_group.HotVideoItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.Entity;
import java.util.List;

public class HotSortVideoEntry
  extends Entity
{
  public String coverURL;
  public String feedId;
  public String groupId;
  public int hotVal;
  public int likeCount;
  public int publishTime;
  public String storyId;
  public String unionId;
  public int viewCount;
  
  public static HotSortVideoEntry convertFrom(qqstory_group.HotVideoCard paramHotVideoCard)
  {
    if (paramHotVideoCard == null) {
      return null;
    }
    paramHotVideoCard = (qqstory_group.HotVideoItem)paramHotVideoCard.video_item_list.get().get(0);
    HotSortVideoEntry localHotSortVideoEntry = new HotSortVideoEntry();
    localHotSortVideoEntry.storyId = paramHotVideoCard.story_id.get().toStringUtf8();
    localHotSortVideoEntry.feedId = paramHotVideoCard.feed_id.get().toStringUtf8();
    localHotSortVideoEntry.unionId = paramHotVideoCard.union_id.get().toStringUtf8();
    localHotSortVideoEntry.coverURL = paramHotVideoCard.cover_url.get().toStringUtf8();
    localHotSortVideoEntry.publishTime = paramHotVideoCard.publish_time.get();
    localHotSortVideoEntry.likeCount = paramHotVideoCard.like_count.get();
    localHotSortVideoEntry.viewCount = paramHotVideoCard.view_count.get();
    localHotSortVideoEntry.hotVal = paramHotVideoCard.hot_val.get();
    return localHotSortVideoEntry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.HotSortVideoEntry
 * JD-Core Version:    0.7.0.1
 */