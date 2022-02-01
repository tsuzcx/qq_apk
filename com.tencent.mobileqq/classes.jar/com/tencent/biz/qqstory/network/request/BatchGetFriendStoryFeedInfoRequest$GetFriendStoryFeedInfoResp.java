package com.tencent.biz.qqstory.network.request;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspStoryFeed;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.StoryFeed;
import com.tencent.biz.qqstory.shareGroup.ShareGroupUtil;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class BatchGetFriendStoryFeedInfoRequest$GetFriendStoryFeedInfoResp
  extends BaseResponse
{
  public List<StoryHomeFeed> a = new ArrayList();
  public HashSet<String> b = new HashSet();
  
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
      Object localObject = (qqstory_struct.StoryFeed)paramRspStoryFeed.next();
      int i = ((qqstory_struct.StoryFeed)localObject).type.get();
      StoryHomeFeed localStoryHomeFeed = StoryHomeFeed.a(i);
      if (localStoryHomeFeed == null)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("目前没有这个类型的Feed=");
        ((StringBuilder)localObject).append(i);
        SLog.e("Q.qqstory.net:BatchGetFriendStoryFeedInfoRequest", ((StringBuilder)localObject).toString());
      }
      else if (localStoryHomeFeed.a((qqstory_struct.StoryFeed)localObject))
      {
        if (localStoryHomeFeed.g() != null) {
          this.b.add(localStoryHomeFeed.g().feedId);
        }
        if ((!(localStoryHomeFeed instanceof ShareGroupHomeFeed)) || (!ShareGroupUtil.a((ShareGroupFeedItem)((ShareGroupHomeFeed)localStoryHomeFeed).i()))) {
          this.a.add(localStoryHomeFeed);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp
 * JD-Core Version:    0.7.0.1
 */