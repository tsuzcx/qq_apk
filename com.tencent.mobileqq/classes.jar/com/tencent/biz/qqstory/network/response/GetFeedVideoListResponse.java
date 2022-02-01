package com.tencent.biz.qqstory.network.response;

import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.UserManager;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspFriendStoryFeedVideoList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedVideoInfo;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MultiRecommendItem;
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
  public boolean b;
  public ArrayList<StoryVideoItem> e = new ArrayList();
  public String f;
  
  public GetFeedVideoListResponse(qqstory_service.RspFriendStoryFeedVideoList paramRspFriendStoryFeedVideoList)
  {
    super(paramRspFriendStoryFeedVideoList.result);
    this.a = paramRspFriendStoryFeedVideoList.next_cookie.get().toStringUtf8();
    this.f = paramRspFriendStoryFeedVideoList.union_id.get().toStringUtf8();
    int i = paramRspFriendStoryFeedVideoList.is_end.get();
    boolean bool = true;
    if (i != 1) {
      bool = false;
    }
    this.b = bool;
    Object localObject1;
    Object localObject2;
    if (paramRspFriendStoryFeedVideoList.share_group_video_info_list.has())
    {
      paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.share_group_video_info_list.get().iterator();
      while (paramRspFriendStoryFeedVideoList.hasNext())
      {
        localObject1 = (qqstory_struct.ShareGroupVideoInfo)paramRspFriendStoryFeedVideoList.next();
        localObject2 = new StoryVideoItem();
        ((StoryVideoItem)localObject2).convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.ShareGroupVideoInfo)localObject1);
        this.e.add(localObject2);
      }
    }
    if (paramRspFriendStoryFeedVideoList.multi_rcmd_feed_info_list.has())
    {
      localObject1 = (UserManager)SuperManager.a(2);
      paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.multi_rcmd_feed_info_list.get().iterator();
      while (paramRspFriendStoryFeedVideoList.hasNext())
      {
        localObject2 = (qqstory_struct.MultiRecommendItem)paramRspFriendStoryFeedVideoList.next();
        if (((qqstory_struct.MultiRecommendItem)localObject2).feed_video_info_list.has())
        {
          String str = ((qqstory_struct.MultiRecommendItem)localObject2).feed_id.get().toStringUtf8();
          Iterator localIterator = ((qqstory_struct.MultiRecommendItem)localObject2).feed_video_info_list.get().iterator();
          while (localIterator.hasNext())
          {
            Object localObject3 = (qqstory_struct.FeedVideoInfo)localIterator.next();
            StoryVideoItem localStoryVideoItem = new StoryVideoItem();
            localStoryVideoItem.convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.FeedVideoInfo)localObject3);
            localStoryVideoItem.mAttachedFeedId = str;
            this.e.add(localStoryVideoItem);
            localObject3 = new QQUserUIItem();
            ((QQUserUIItem)localObject3).convertFrom(((qqstory_struct.MultiRecommendItem)localObject2).user);
            localObject3 = ((UserManager)localObject1).a((QQUserUIItem)localObject3);
            localStoryVideoItem.mOwnerUid = ((QQUserUIItem)localObject3).uid;
            localStoryVideoItem.mOwnerName = ((QQUserUIItem)localObject3).getDisplayName();
          }
        }
      }
    }
    paramRspFriendStoryFeedVideoList = paramRspFriendStoryFeedVideoList.feed_video_info_list.get().iterator();
    while (paramRspFriendStoryFeedVideoList.hasNext())
    {
      localObject1 = (qqstory_struct.FeedVideoInfo)paramRspFriendStoryFeedVideoList.next();
      localObject2 = new StoryVideoItem();
      ((StoryVideoItem)localObject2).convertFrom("Q.qqstory.net:GetFeedVideoListResponse", (qqstory_struct.FeedVideoInfo)localObject1);
      this.e.add(localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.response.GetFeedVideoListResponse
 * JD-Core Version:    0.7.0.1
 */