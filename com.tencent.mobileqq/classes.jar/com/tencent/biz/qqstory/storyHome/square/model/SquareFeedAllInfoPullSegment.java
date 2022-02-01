package com.tencent.biz.qqstory.storyHome.square.model;

import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.square.BatchGetSquareFeedInfoRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedIdListSeqInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SquareFeedAllInfoPullSegment
  extends JobSegment<FeedListPageLoaderBase.GetFeedIdListResult, SquareFeedData>
{
  private void b(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    paramJobContext = paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList;
    SLog.a("Q.qqstory.discover:SquareFeedAllInfoPullSegment", "start pull feed info count:%d", Integer.valueOf(paramJobContext.size()));
    if (SLog.a()) {
      SLog.a("Q.qqstory.discover:SquareFeedAllInfoPullSegment", "start pull feed info %s", paramJobContext);
    }
    ArrayList localArrayList = new ArrayList(paramJobContext.size());
    Object localObject = paramJobContext.iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add(((FeedIdListSeqInfo)((Iterator)localObject).next()).a);
    }
    localObject = new BatchGetSquareFeedInfoRequest();
    ((BatchGetSquareFeedInfoRequest)localObject).jdField_a_of_type_JavaUtilList = paramJobContext;
    CmdTaskManger.a().a((NetworkRequest)localObject, new SquareFeedAllInfoPullSegment.1(this, paramGetFeedIdListResult, localArrayList));
  }
  
  protected void a(JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult)
  {
    Iterator localIterator = paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      if (localIterator.next() == null) {
        localIterator.remove();
      }
    }
    if (paramGetFeedIdListResult.jdField_a_of_type_JavaUtilList.isEmpty())
    {
      if (paramGetFeedIdListResult.b)
      {
        paramJobContext = new SquareFeedData(new ErrorMessage());
        paramJobContext.c = paramGetFeedIdListResult.jdField_a_of_type_Boolean;
        paramJobContext.jdField_a_of_type_Boolean = paramGetFeedIdListResult.b;
        notifyResult(paramJobContext);
        return;
      }
      paramJobContext = new ErrorMessage(940001, "");
      paramJobContext.extraMsg = "data error no data";
      notifyError(paramJobContext);
      SLog.a("Q.qqstory.discover:SquareFeedAllInfoPullSegment", "feed id arg %s", paramJobContext);
      return;
    }
    b(paramJobContext, paramGetFeedIdListResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.square.model.SquareFeedAllInfoPullSegment
 * JD-Core Version:    0.7.0.1
 */