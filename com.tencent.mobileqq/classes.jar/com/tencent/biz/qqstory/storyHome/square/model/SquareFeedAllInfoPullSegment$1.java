package com.tencent.biz.qqstory.storyHome.square.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupManager;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class SquareFeedAllInfoPullSegment$1
  implements CmdTaskManger.CommandCallback<BatchGetSquareFeedInfoRequest, BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp>
{
  SquareFeedAllInfoPullSegment$1(SquareFeedAllInfoPullSegment paramSquareFeedAllInfoPullSegment, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult, ArrayList paramArrayList) {}
  
  public void a(@NonNull BatchGetSquareFeedInfoRequest paramBatchGetSquareFeedInfoRequest, @Nullable BatchGetSquareFeedInfoRequest.GetSquareFeedInfoResp paramGetSquareFeedInfoResp, @NonNull ErrorMessage paramErrorMessage)
  {
    if ((paramGetSquareFeedInfoResp != null) && (paramErrorMessage.isSuccess()))
    {
      paramBatchGetSquareFeedInfoRequest = new SquareFeedData(new ErrorMessage());
      paramBatchGetSquareFeedInfoRequest.c = this.a.b;
      paramBatchGetSquareFeedInfoRequest.a = this.a.c;
      paramBatchGetSquareFeedInfoRequest.e = this.b;
      paramBatchGetSquareFeedInfoRequest.f = paramGetSquareFeedInfoResp.a;
      paramGetSquareFeedInfoResp = (ShareGroupManager)SuperManager.a(7);
      paramErrorMessage = (StoryManager)SuperManager.a(5);
      Iterator localIterator1 = paramBatchGetSquareFeedInfoRequest.f.iterator();
      while (localIterator1.hasNext())
      {
        SquareFeed localSquareFeed = (SquareFeed)localIterator1.next();
        localSquareFeed.b = paramGetSquareFeedInfoResp.a(localSquareFeed.b);
        ArrayList localArrayList = new ArrayList(localSquareFeed.c.size());
        Iterator localIterator2 = localSquareFeed.c.iterator();
        while (localIterator2.hasNext()) {
          localArrayList.add(paramErrorMessage.a((StoryVideoItem)localIterator2.next()));
        }
        localSquareFeed.c = localArrayList;
        paramErrorMessage.a(localSquareFeed.a, localSquareFeed.d, true);
      }
      SquareFeedAllInfoPullSegment.a(this.c, paramBatchGetSquareFeedInfoRequest);
      return;
    }
    SquareFeedAllInfoPullSegment.a(this.c, paramErrorMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeedAllInfoPullSegment.1
 * JD-Core Version:    0.7.0.1
 */