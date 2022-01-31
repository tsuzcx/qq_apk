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
  public ShareGroupItem a;
  public String a;
  public List a;
  public List b = new ArrayList();
  
  public SquareFeed()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public SquareFeed(qqstory_struct.DiscoveryShareGroupInfo paramDiscoveryShareGroupInfo)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem = new ShareGroupItem();
    this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.convertFrom(paramDiscoveryShareGroupInfo.group);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqstoryShareGroupModelShareGroupItem.shareGroupId;
    paramDiscoveryShareGroupInfo = paramDiscoveryShareGroupInfo.video_info.get().iterator();
    while (paramDiscoveryShareGroupInfo.hasNext())
    {
      qqstory_struct.DiscoveryShareGroupVideoInfo localDiscoveryShareGroupVideoInfo = (qqstory_struct.DiscoveryShareGroupVideoInfo)paramDiscoveryShareGroupInfo.next();
      StoryVideoItem localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("square feed", localDiscoveryShareGroupVideoInfo);
      this.jdField_a_of_type_JavaUtilList.add(localStoryVideoItem);
      this.b.add(new SquareFeed.FeedIdVid(localDiscoveryShareGroupVideoInfo.feed_id.get().toStringUtf8(), localDiscoveryShareGroupVideoInfo.vid.get().toStringUtf8()));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeed
 * JD-Core Version:    0.7.0.1
 */