package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.ShareGroupVideoInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GetFeedVideoListResponse
  extends BaseResponse
{
  public String a;
  public ArrayList a;
  public boolean a;
  public String c;
  
  public GetFeedVideoListResponse(qqstory_service.RspFriendStoryFeedVideoList paramRspFriendStoryFeedVideoList)
  {
    super(paramRspFriendStoryFeedVideoList.result);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_JavaLangString = paramRspFriendStoryFeedVideoList.next_cookie.get().toStringUtf8();
    this.c = paramRspFriendStoryFeedVideoList.union_id.get().toStringUtf8();
    if (paramRspFriendStoryFeedVideoList.is_end.get() == 1) {}
    Object localObject;
    StoryVideoItem localStoryVideoItem;
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      if (!paramRspFriendStoryFeedVideoList.share_group_video_info_list.has()) {
        break;
      }
      paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.share_group_video_info_list.get().iterator();
      while (paramRspFriendStoryFeedVideoList.hasNext())
      {
        localObject = (qqstory_struct.ShareGroupVideoInfo)paramRspFriendStoryFeedVideoList.next();
        localStoryVideoItem = new StoryVideoItem();
        localStoryVideoItem.convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.ShareGroupVideoInfo)localObject);
        this.jdField_a_of_type_JavaUtilArrayList.add(localStoryVideoItem);
      }
      bool = false;
    }
    paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.feed_video_info_list.get().iterator();
    while (paramRspFriendStoryFeedVideoList.hasNext())
    {
      localObject = (qqstory_struct.FeedVideoInfo)paramRspFriendStoryFeedVideoList.next();
      localStoryVideoItem = new StoryVideoItem();
      localStoryVideoItem.convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.FeedVideoInfo)localObject);
      this.jdField_a_of_type_JavaUtilArrayList.add(localStoryVideoItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse
 * JD-Core Version:    0.7.0.1
 */