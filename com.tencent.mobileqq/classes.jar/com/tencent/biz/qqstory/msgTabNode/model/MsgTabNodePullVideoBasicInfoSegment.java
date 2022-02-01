package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodePullVideoBasicInfoSegment
  extends JobSegment<List<MsgTabVideoData>, List<MsgTabVideoData>>
{
  private final BatchGetVideoInfo.VideoLocalCacheFilter a;
  
  public MsgTabNodePullVideoBasicInfoSegment()
  {
    this(new MsgTabNodePullVideoBasicInfoSegment.1());
  }
  
  public MsgTabNodePullVideoBasicInfoSegment(BatchGetVideoInfo.VideoLocalCacheFilter paramVideoLocalCacheFilter)
  {
    this.a = paramVideoLocalCacheFilter;
  }
  
  protected void a(JobContext paramJobContext, List<MsgTabVideoData> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "list empty");
      }
      notifyResult(paramList);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqstory.msgTab.jobPullBasicInfo", 2, "pull video info start");
    }
    paramJobContext = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext()) {
      paramJobContext.add(((MsgTabVideoData)localIterator.next()).b);
    }
    paramJobContext = new BatchGetVideoInfo(paramJobContext);
    if (this.a != null) {
      paramJobContext.a = this.a;
    }
    paramJobContext.a(new MsgTabNodePullVideoBasicInfoSegment.2(this, paramList));
    paramJobContext.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodePullVideoBasicInfoSegment
 * JD-Core Version:    0.7.0.1
 */