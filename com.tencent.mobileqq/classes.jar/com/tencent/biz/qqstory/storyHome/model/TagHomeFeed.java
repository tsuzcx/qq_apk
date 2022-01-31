package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.TagVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TagHomeFeed
  extends VideoListHomeFeed
{
  public TagHomeFeed(@NonNull TagFeedItem paramTagFeedItem)
  {
    super(paramTagFeedItem);
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    Object localObject = (qqstory_struct.TagFeed)paramStoryFeed.tag_feed.get();
    ((TagFeedItem)this.a).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), (qqstory_struct.TagFeed)localObject);
    paramStoryFeed = new ArrayList();
    localObject = ((qqstory_struct.TagFeed)localObject).video_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.TagVideoInfo localTagVideoInfo = (qqstory_struct.TagVideoInfo)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.home.data.VideoListHomeFeed", localTagVideoInfo);
      paramStoryFeed.add(localStoryVideoItem);
    }
    c(paramStoryFeed, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.TagHomeFeed
 * JD-Core Version:    0.7.0.1
 */