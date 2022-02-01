package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.GeneralRecommendFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GeneralRecommendHomeFeed
  extends VideoListHomeFeed<GeneralRecommendFeedItem>
{
  public GeneralRecommendHomeFeed(@NonNull GeneralRecommendFeedItem paramGeneralRecommendFeedItem)
  {
    super(paramGeneralRecommendFeedItem);
  }
  
  public boolean a(qqstory_struct.StoryFeed paramStoryFeed)
  {
    Object localObject = (qqstory_struct.GeneralFeed)paramStoryFeed.general_recommend_feed.recommend_feed.get();
    ((GeneralRecommendFeedItem)this.f).covertFrom(paramStoryFeed.feed_id.get().toStringUtf8(), (qqstory_struct.GeneralFeed)localObject);
    ((GeneralRecommendFeedItem)this.f).blurb = paramStoryFeed.general_recommend_feed.blurb.get().toStringUtf8();
    ((GeneralRecommendFeedItem)this.f).recommendId = paramStoryFeed.general_recommend_feed.recommend_id.get();
    ((GeneralRecommendFeedItem)this.f).recommendTitle = paramStoryFeed.general_recommend_feed.title_wording.get().toStringUtf8();
    ((GeneralRecommendFeedItem)this.f).feedSourceTagType = paramStoryFeed.feed_source_tag_type.get();
    paramStoryFeed = new ArrayList();
    localObject = ((qqstory_struct.GeneralFeed)localObject).feed_video_info_list.get().iterator();
    while (((Iterator)localObject).hasNext())
    {
      qqstory_struct.FeedVideoInfo localFeedVideoInfo = (qqstory_struct.FeedVideoInfo)((Iterator)localObject).next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.home.data.GeneralRecommendHomeFeed", localFeedVideoInfo);
      paramStoryFeed.add(localStoryVideoItem);
    }
    c(paramStoryFeed, true);
    return true;
  }
  
  public GeneralRecommendFeedItem h()
  {
    return (GeneralRecommendFeedItem)super.i();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.GeneralRecommendHomeFeed
 * JD-Core Version:    0.7.0.1
 */