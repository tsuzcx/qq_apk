package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.BaseResponse;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class FeedManager$4
  implements CmdTaskManger.CommandCallback<BatchGetFriendStoryFeedInfoRequest, BaseResponse>
{
  FeedManager$4(FeedManager paramFeedManager) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BaseResponse paramBaseResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    paramBaseResponse = (BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp)paramBaseResponse;
    int j = paramErrorMessage.errorCode;
    int k = paramBatchGetFriendStoryFeedInfoRequest.b.size();
    if (paramBaseResponse == null) {}
    for (int i = 0;; i = paramBaseResponse.jdField_a_of_type_JavaUtilList.size())
    {
      SLog.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec , error :%d , req size :%d , resp size :%d , list :%s", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i), paramBatchGetFriendStoryFeedInfoRequest.b });
      if ((!paramErrorMessage.isFail()) && (paramBaseResponse != null)) {
        break;
      }
      paramBatchGetFriendStoryFeedInfoRequest = paramBatchGetFriendStoryFeedInfoRequest.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBatchGetFriendStoryFeedInfoRequest.hasNext())
      {
        paramBaseResponse = (FeedIdListSeqInfo)paramBatchGetFriendStoryFeedInfoRequest.next();
        FeedManager.a().remove(paramBaseResponse.a);
      }
    }
    if (paramBatchGetFriendStoryFeedInfoRequest.jdField_a_of_type_JavaUtilList.size() != paramBaseResponse.jdField_a_of_type_JavaUtilList.size())
    {
      paramErrorMessage = new ArrayList();
      paramBatchGetFriendStoryFeedInfoRequest = paramBatchGetFriendStoryFeedInfoRequest.jdField_a_of_type_JavaUtilList.iterator();
      while (paramBatchGetFriendStoryFeedInfoRequest.hasNext())
      {
        FeedIdListSeqInfo localFeedIdListSeqInfo = (FeedIdListSeqInfo)paramBatchGetFriendStoryFeedInfoRequest.next();
        if (!paramBaseResponse.jdField_a_of_type_JavaUtilHashSet.contains(localFeedIdListSeqInfo.a))
        {
          paramErrorMessage.add(localFeedIdListSeqInfo.a);
          FeedManager.a().remove(localFeedIdListSeqInfo.a);
        }
      }
      SLog.d("Q.qqstory.home.data.FeedManager", "request feed item list from net rec warning , some feed not return ! %s", new Object[] { paramErrorMessage });
    }
    paramBatchGetFriendStoryFeedInfoRequest = paramBaseResponse.jdField_a_of_type_JavaUtilList.iterator();
    while (paramBatchGetFriendStoryFeedInfoRequest.hasNext())
    {
      paramBaseResponse = (StoryHomeFeed)paramBatchGetFriendStoryFeedInfoRequest.next();
      this.a.a(paramBaseResponse.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedManager.4
 * JD-Core Version:    0.7.0.1
 */