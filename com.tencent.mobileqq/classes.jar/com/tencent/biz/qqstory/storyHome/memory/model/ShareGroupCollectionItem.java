package com.tencent.biz.qqstory.storyHome.memory.model;

import com.tencent.biz.qqstory.database.VideoCollectionEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupVideoInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShareGroupCollectionItem
  extends VideoCollectionItem
{
  public ShareGroupItem shareGroupItem = new ShareGroupItem();
  
  public ShareGroupCollectionItem()
  {
    this.collectionType = 4;
  }
  
  public ShareGroupCollectionItem(VideoCollectionEntry paramVideoCollectionEntry)
  {
    super(paramVideoCollectionEntry);
  }
  
  public void convertFrom(String paramString, qqstory_struct.ShareGroupFeed paramShareGroupFeed)
  {
    this.shareGroupItem.convertFrom((qqstory_struct.ShareGroupInfo)paramShareGroupFeed.info.get());
    this.collectionType = 4;
    this.groupId = this.shareGroupItem.shareGroupId;
    this.collectionId = this.shareGroupItem.shareGroupId;
    this.uin = paramString;
    this.key = VideoCollectionEntry.getCollectionKey(this.collectionType, this.collectionId, this.uin);
    if (paramShareGroupFeed.video_list.has())
    {
      paramString = paramShareGroupFeed.video_list.get();
      if (paramString.size() > 0)
      {
        this.videoVidList.clear();
        this.videoItemList.clear();
      }
      paramString = paramString.iterator();
      while (paramString.hasNext())
      {
        paramShareGroupFeed = (qqstory_struct.ShareGroupVideoInfo)paramString.next();
        StoryVideoItem localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom(paramShareGroupFeed);
        this.videoItemList.add(localStoryVideoItem);
        this.videoVidList.add(localStoryVideoItem.mVid);
      }
    }
  }
  
  public void copy(Object paramObject)
  {
    super.copy(paramObject);
    paramObject = (ShareGroupCollectionItem)paramObject;
    this.shareGroupItem.copy(paramObject.shareGroupItem);
  }
  
  public String toString()
  {
    return "ShareGroupFeed{, shareGroupItem=" + this.shareGroupItem + ", videoList=" + this.videoItemList.size() + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.model.ShareGroupCollectionItem
 * JD-Core Version:    0.7.0.1
 */