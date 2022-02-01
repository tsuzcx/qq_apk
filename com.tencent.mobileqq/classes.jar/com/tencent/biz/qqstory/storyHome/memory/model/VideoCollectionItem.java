package com.tencent.biz.qqstory.storyHome.memory.model;

import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.HotSortVideoEntry;
import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.BaseUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DateVideoCollection;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupNodeInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GroupStoryInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryVideoSimpleInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import vzk;
import wjp;
import wjs;
import yap;
import yau;
import zdu;

public class VideoCollectionItem
  extends BaseUIItem
  implements vzk
{
  public static final String LOCAL_DESC_ITEM_KEY = "local_desc_item";
  public static final String LOCAL_EMPTY_ITEM_KEY = "local_empty_item";
  public static final int TYPE_DAY_COLLECTION_ITEM = 1;
  public static final int TYPE_DOUBLE_TAB_ITEM = 3;
  public static final int[] TYPE_ORDER = { 2, 3, 0, 1, 5, 6, 7, 4, 8 };
  public static final int TYPE_SHARE_GROUP_EMPTY_ITEM = 5;
  public static final int TYPE_SHARE_GROUP_HOTSORT_ITEM = 7;
  public static final int TYPE_SHARE_GROUP_ITEM = 4;
  public static final int TYPE_STRANGER_LIMIT_COLLECTION_ITEM = 8;
  public static final int TYPE_USER_PROFILE_ITEM = 2;
  public static final int TYPE_VIDEO_COLLECTION_EMPTY_ITEM = 6;
  public static final int TYPE_YEAR_COLLECTION_ITEM = 0;
  public String address = "";
  public int collectionCount = -1;
  public String collectionId = "";
  public long collectionTime = -1L;
  public int collectionType = 1;
  public int collectionTypeOrder = -1;
  public List<yap> collectionVideoUIItemList = new ArrayList();
  public long dbIndex = -1L;
  public String feedId;
  public String groupId = "";
  public int hasShareToDiscover = -1;
  public List<HotSortVideoEntry> hotSortVideoLIst = new ArrayList();
  public boolean isEmptyFakeItem;
  public String key;
  public String label = "";
  public String nextCookie = "";
  public String uin = "";
  public List<StoryVideoItem> videoItemList = new ArrayList();
  public ArrayList<String> videoVidList = new ArrayList();
  public int viewCount = -1;
  public int viewTimes = -1;
  
  public VideoCollectionItem() {}
  
  public VideoCollectionItem(VideoCollectionEntry paramVideoCollectionEntry)
  {
    this.key = paramVideoCollectionEntry.key;
    this.feedId = paramVideoCollectionEntry.feedId;
    this.collectionId = paramVideoCollectionEntry.collectionId;
    this.collectionType = paramVideoCollectionEntry.collectionType;
    this.collectionCount = paramVideoCollectionEntry.collectionCount;
    this.collectionTime = paramVideoCollectionEntry.collectionTime;
    this.address = paramVideoCollectionEntry.address;
    this.label = paramVideoCollectionEntry.label;
    this.dbIndex = paramVideoCollectionEntry.dbIndex;
    this.uin = paramVideoCollectionEntry.unionId;
    this.viewCount = paramVideoCollectionEntry.viewCount;
    this.viewTimes = paramVideoCollectionEntry.viewTimes;
    this.hasShareToDiscover = paramVideoCollectionEntry.hasShareToDiscover;
    this.groupId = paramVideoCollectionEntry.groupId;
    this.nextCookie = paramVideoCollectionEntry.nextCookie;
  }
  
  public static VideoCollectionItem getCurrentYearFakeItem(String paramString)
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionType = 0;
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.collectionTime = zdu.a();
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, String.valueOf(localVideoCollectionItem.collectionTime), paramString);
    return localVideoCollectionItem;
  }
  
  public static VideoCollectionItem getDoubleTabItem()
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionType = 3;
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, localVideoCollectionItem.collectionId, QQStoryContext.a().b());
    localVideoCollectionItem.collectionTime = zdu.a();
    return localVideoCollectionItem;
  }
  
  public static VideoCollectionItem getEmptyShareGroupItem()
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionType = 5;
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, localVideoCollectionItem.collectionId, QQStoryContext.a().b());
    localVideoCollectionItem.collectionTime = zdu.a();
    return localVideoCollectionItem;
  }
  
  public static VideoCollectionItem getEmptyVideoListItem()
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionType = 6;
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, localVideoCollectionItem.collectionId, QQStoryContext.a().b());
    localVideoCollectionItem.collectionTime = zdu.a();
    return localVideoCollectionItem;
  }
  
  public static VideoCollectionItem getProfilePlaceholderItem(String paramString)
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionType = 2;
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, localVideoCollectionItem.collectionId, paramString);
    localVideoCollectionItem.collectionTime = zdu.a();
    return localVideoCollectionItem;
  }
  
  public static VideoCollectionItem getTodayFakeItem(String paramString)
  {
    VideoCollectionItem localVideoCollectionItem = new VideoCollectionItem();
    localVideoCollectionItem.collectionId = "";
    localVideoCollectionItem.collectionTime = zdu.b();
    localVideoCollectionItem.key = VideoCollectionEntry.getCollectionKey(localVideoCollectionItem.collectionType, localVideoCollectionItem.collectionId, paramString);
    localVideoCollectionItem.collectionVideoUIItemList.add(new yau());
    return localVideoCollectionItem;
  }
  
  public void convertFrom(String paramString1, String paramString2, qqstory_struct.DateVideoCollection paramDateVideoCollection)
  {
    this.feedId = paramDateVideoCollection.feed_id.get().toStringUtf8();
    this.collectionId = String.valueOf(paramDateVideoCollection.collection_id.get());
    this.collectionType = paramDateVideoCollection.collection_type.get();
    this.uin = paramString2;
    this.key = VideoCollectionEntry.getCollectionKey(this.collectionType, this.collectionId, paramString2);
    if (paramDateVideoCollection.collection_video_count.has()) {
      this.collectionCount = paramDateVideoCollection.collection_video_count.get();
    }
    if (paramDateVideoCollection.collection_time.has()) {
      this.collectionTime = (paramDateVideoCollection.collection_time.get() * 1000L);
    }
    if (paramDateVideoCollection.share_to_discover.has()) {
      this.hasShareToDiscover = paramDateVideoCollection.share_to_discover.get();
    }
    if (this.collectionType == 1)
    {
      wjp localwjp = (wjp)wjs.a(5);
      HashMap localHashMap = new HashMap();
      Object localObject1;
      Object localObject2;
      if (paramDateVideoCollection.video_list.has())
      {
        paramString2 = paramDateVideoCollection.video_list.get().iterator();
        while (paramString2.hasNext())
        {
          localObject1 = (qqstory_struct.StoryVideoSimpleInfo)paramString2.next();
          localObject2 = new StoryVideoItem();
          ((StoryVideoItem)localObject2).convertFrom(paramString1, (qqstory_struct.StoryVideoSimpleInfo)localObject1);
          localObject1 = localwjp.a(((StoryVideoItem)localObject2).mVid, (StoryVideoItem)localObject2);
          localHashMap.put(((StoryVideoItem)localObject1).mVid, localObject1);
          this.videoItemList.add(localObject1);
        }
      }
      if (paramDateVideoCollection.vid_list.has())
      {
        paramString1 = paramDateVideoCollection.vid_list.get();
        if (paramString1.size() > 0) {
          this.videoVidList.clear();
        }
        paramString1 = paramString1.iterator();
        while (paramString1.hasNext())
        {
          paramString2 = (ByteStringMicro)paramString1.next();
          this.videoVidList.add(paramString2.toStringUtf8());
        }
        localObject1 = this.videoVidList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          paramString2 = (StoryVideoItem)localHashMap.get(localObject2);
          paramString1 = paramString2;
          if (paramString2 == null) {
            paramString1 = localwjp.a((String)localObject2);
          }
          paramString1 = new yap((String)localObject2, paramString1);
          this.collectionVideoUIItemList.add(paramString1);
        }
      }
      if (paramDateVideoCollection.address.has()) {
        this.address = paramDateVideoCollection.address.get().toStringUtf8();
      }
      if (paramDateVideoCollection.label.has()) {
        this.label = paramDateVideoCollection.label.get().toStringUtf8();
      }
      if (paramDateVideoCollection.total_view_count.has()) {
        this.viewCount = paramDateVideoCollection.total_view_count.get();
      }
      if (paramDateVideoCollection.total_view_times.has()) {
        this.viewTimes = paramDateVideoCollection.total_view_times.get();
      }
    }
  }
  
  public void convertFrom(String paramString1, String paramString2, qqstory_struct.GroupNodeInfo paramGroupNodeInfo)
  {
    this.feedId = paramGroupNodeInfo.feed_id.get().toStringUtf8();
    this.collectionId = this.feedId;
    this.collectionType = paramGroupNodeInfo.feed_type.get();
    this.uin = paramString2;
    this.collectionCount = paramGroupNodeInfo.feed_video_total.get();
    this.collectionTime = (paramGroupNodeInfo.feed_time.get() * 1000L);
    if ((this.collectionType == 0) && (TextUtils.isEmpty(this.feedId)))
    {
      this.key = VideoCollectionEntry.getCollectionKey(this.collectionType, String.valueOf(this.collectionTime), this.uin);
      if (!paramGroupNodeInfo.more_start_cookie.has()) {
        break label294;
      }
    }
    label294:
    for (paramString2 = paramGroupNodeInfo.more_start_cookie.get().toStringUtf8();; paramString2 = "")
    {
      this.nextCookie = paramString2;
      if ((this.collectionType != 1) && (this.collectionType != 7)) {
        return;
      }
      paramString2 = (wjp)wjs.a(5);
      if (!paramGroupNodeInfo.video_list.has()) {
        return;
      }
      paramGroupNodeInfo = paramGroupNodeInfo.video_list.get().iterator();
      while (paramGroupNodeInfo.hasNext())
      {
        Object localObject1 = (qqstory_struct.GroupStoryInfo)paramGroupNodeInfo.next();
        Object localObject2 = new StoryVideoItem();
        ((StoryVideoItem)localObject2).convertFrom(paramString1, (qqstory_struct.GroupStoryInfo)localObject1);
        localObject1 = paramString2.a(((StoryVideoItem)localObject2).mVid, (StoryVideoItem)localObject2);
        this.videoItemList.add(localObject1);
        localObject2 = new yap(((StoryVideoItem)localObject1).mVid, (StoryVideoItem)localObject1);
        this.collectionVideoUIItemList.add(localObject2);
        this.videoVidList.add(((StoryVideoItem)localObject1).mVid);
      }
      this.key = this.feedId;
      break;
    }
  }
  
  public VideoCollectionEntry convertTo()
  {
    VideoCollectionEntry localVideoCollectionEntry = new VideoCollectionEntry();
    localVideoCollectionEntry.key = this.key;
    localVideoCollectionEntry.feedId = this.feedId;
    localVideoCollectionEntry.collectionId = this.collectionId;
    localVideoCollectionEntry.collectionType = this.collectionType;
    localVideoCollectionEntry.collectionCount = this.collectionCount;
    localVideoCollectionEntry.collectionTime = this.collectionTime;
    localVideoCollectionEntry.address = this.address;
    localVideoCollectionEntry.label = this.label;
    localVideoCollectionEntry.dbIndex = this.dbIndex;
    localVideoCollectionEntry.unionId = this.uin;
    localVideoCollectionEntry.viewCount = this.viewCount;
    localVideoCollectionEntry.viewTimes = this.viewTimes;
    localVideoCollectionEntry.hasShareToDiscover = this.hasShareToDiscover;
    localVideoCollectionEntry.groupId = this.groupId;
    localVideoCollectionEntry.nextCookie = this.nextCookie;
    return localVideoCollectionEntry;
  }
  
  public void copy(Object paramObject)
  {
    if (this == paramObject) {
      break label5;
    }
    label5:
    while (!(paramObject instanceof VideoCollectionItem)) {
      return;
    }
    paramObject = (VideoCollectionItem)paramObject;
    this.collectionType = paramObject.collectionType;
    if (!TextUtils.isEmpty(paramObject.feedId)) {
      this.feedId = paramObject.feedId;
    }
    if (!TextUtils.isEmpty(paramObject.collectionId)) {
      this.collectionId = paramObject.collectionId;
    }
    if (!TextUtils.isEmpty(paramObject.key)) {
      this.key = paramObject.key;
    }
    if (paramObject.collectionTime != -1L) {
      this.collectionTime = paramObject.collectionTime;
    }
    if (paramObject.collectionCount != -1) {
      this.collectionCount = paramObject.collectionCount;
    }
    if (!TextUtils.isEmpty(paramObject.address)) {
      this.address = paramObject.address;
    }
    if (!TextUtils.isEmpty(paramObject.label)) {
      this.label = paramObject.label;
    }
    if (paramObject.dbIndex != -1L) {
      this.dbIndex = paramObject.dbIndex;
    }
    if (!TextUtils.isEmpty(paramObject.uin)) {
      this.uin = paramObject.uin;
    }
    if (paramObject.viewCount != -1) {
      this.viewCount = paramObject.viewCount;
    }
    if (paramObject.viewTimes != -1) {
      this.viewTimes = paramObject.viewTimes;
    }
    if (paramObject.videoVidList.size() > 0) {
      this.videoVidList = paramObject.videoVidList;
    }
    if (paramObject.videoItemList.size() > 0) {
      this.videoItemList = paramObject.videoItemList;
    }
    if (paramObject.collectionVideoUIItemList.size() > 0)
    {
      if (this.collectionVideoUIItemList.size() <= 0) {
        break label435;
      }
      yap localyap = (yap)this.collectionVideoUIItemList.get(0);
      if ((!(localyap instanceof yau)) || ((paramObject.collectionVideoUIItemList.get(0) instanceof yau))) {
        break label435;
      }
      this.collectionVideoUIItemList.clear();
      this.collectionVideoUIItemList.add(localyap);
      this.collectionVideoUIItemList.addAll(paramObject.collectionVideoUIItemList);
    }
    label435:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        this.collectionVideoUIItemList.clear();
        this.collectionVideoUIItemList.addAll(paramObject.collectionVideoUIItemList);
      }
      if (!TextUtils.isEmpty(paramObject.feedId)) {
        this.feedId = paramObject.feedId;
      }
      if (paramObject.hasShareToDiscover != -1) {
        this.hasShareToDiscover = paramObject.hasShareToDiscover;
      }
      if (TextUtils.isEmpty(paramObject.groupId)) {
        break;
      }
      this.groupId = paramObject.groupId;
      return;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject == null) || (!(paramObject instanceof VideoCollectionItem))) {
      return false;
    }
    return TextUtils.equals(((VideoCollectionItem)paramObject).key, this.key);
  }
  
  public String toString()
  {
    return "VideoCollectionItem{key='" + this.key + '\'' + ", uin='" + this.uin + '\'' + ", feedId='" + this.feedId + '\'' + ", collectionId='" + this.collectionId + '\'' + ", collectionType=" + this.collectionType + ", collectionTypeOrder=" + this.collectionTypeOrder + ", collectionCount=" + this.collectionCount + ", collectionTime=" + this.collectionTime + ", videoVidList=" + this.videoVidList + ", collectionVideoUIItemList=" + this.collectionVideoUIItemList + ", videoItemList=" + this.videoItemList + ", hotSortVideoLIst=" + this.hotSortVideoLIst + ", isEmptyFakeItem=" + this.isEmptyFakeItem + ", address='" + this.address + '\'' + ", label='" + this.label + '\'' + ", viewCount=" + this.viewCount + ", viewTimes=" + this.viewTimes + ", dbIndex=" + this.dbIndex + ", hasShareToDiscover=" + this.hasShareToDiscover + ", groupId='" + this.groupId + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem
 * JD-Core Version:    0.7.0.1
 */