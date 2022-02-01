package com.tencent.biz.qqstory.storyHome.square.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DiscoveryShareGroupInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.DiscoveryShareGroupVideoInfo;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareFeed
{
  public String a;
  public ShareGroupItem b;
  public List<StoryVideoItem> c = new ArrayList();
  public List<SquareFeed.FeedIdVid> d = new ArrayList();
  
  public SquareFeed() {}
  
  public SquareFeed(qqstory_struct.DiscoveryShareGroupInfo paramDiscoveryShareGroupInfo)
  {
    this.b = new ShareGroupItem();
    this.b.convertFrom(paramDiscoveryShareGroupInfo.group);
    this.a = this.b.shareGroupId;
    paramDiscoveryShareGroupInfo = paramDiscoveryShareGroupInfo.video_info.get().iterator();
    while (paramDiscoveryShareGroupInfo.hasNext())
    {
      qqstory_struct.DiscoveryShareGroupVideoInfo localDiscoveryShareGroupVideoInfo = (qqstory_struct.DiscoveryShareGroupVideoInfo)paramDiscoveryShareGroupInfo.next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("square feed", localDiscoveryShareGroupVideoInfo);
      this.c.add(localStoryVideoItem);
      this.d.add(new SquareFeed.FeedIdVid(localDiscoveryShareGroupVideoInfo.feed_id.get().toStringUtf8(), localDiscoveryShareGroupVideoInfo.vid.get().toStringUtf8()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeed
 * JD-Core Version:    0.7.0.1
 */