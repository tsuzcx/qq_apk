package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralHomeFeed
  extends VideoListHomeFeed
{
  public boolean a;
  
  public GeneralHomeFeed(@NonNull GeneralFeedItem paramGeneralFeedItem)
  {
    super(paramGeneralFeedItem);
  }
  
  public GeneralFeedItem a()
  {
    return (GeneralFeedItem)super.a();
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    Object localObject = (qqstory_struct.GeneralFeed)paramStoryFeed.general_feed.get();
    ((GeneralFeedItem)this.a).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), (qqstory_struct.GeneralFeed)localObject);
    paramStoryFeed = new ArrayList();
    localObject = ((qqstory_struct.GeneralFeed)localObject).feed_video_info_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.FeedVideoInfo localFeedVideoInfo = (qqstory_struct.FeedVideoInfo)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.home.data.GeneralHomeFeed", localFeedVideoInfo);
      paramStoryFeed.add(localStoryVideoItem);
    }
    c(paramStoryFeed, true);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralHomeFeed
 * JD-Core Version:    0.7.0.1
 */