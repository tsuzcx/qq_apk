package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp
  extends BaseResponse
{
  public List a = new ArrayList();
  
  public BatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp(ErrorMessage paramErrorMessage)
  {
    super(paramErrorMessage.errorCode, paramErrorMessage.errorMsg);
  }
  
  public BatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp(qqstory_service.RspStoryFeed paramRspStoryFeed)
  {
    super(paramRspStoryFeed.result);
    paramRspStoryFeed = paramRspStoryFeed.feed_list.get().iterator();
    while (paramRspStoryFeed.hasNext())
    {
      qqstory_struct.StoryFeed localStoryFeed = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = localStoryFeed.type.get();
      StoryHomeFeed localStoryHomeFeed = StoryHomeFeed.a(i);
      if (localStoryHomeFeed == null) {
        SLog.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", "目前没有这个类型的Feed=" + i);
      } else if ((localStoryHomeFeed.a(localStoryFeed)) && ((!(localStoryHomeFeed instanceof ShareGroupHomeFeed)) || (!ShareGroupUtil.a((ShareGroupFeedItem)((ShareGroupHomeFeed)localStoryHomeFeed).a())))) {
        this.a.add(localStoryHomeFeed);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp
 * JD-Core Version:    0.7.0.1
 */