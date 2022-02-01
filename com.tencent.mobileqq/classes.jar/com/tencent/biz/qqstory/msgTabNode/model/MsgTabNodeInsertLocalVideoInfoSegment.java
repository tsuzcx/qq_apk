package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MsgTabNodeInsertLocalVideoInfoSegment
  extends JobSegment<List<MsgTabVideoData>, List<MsgTabVideoData>>
{
  MsgTabNodeInfo a;
  
  public MsgTabNodeInsertLocalVideoInfoSegment(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a = paramMsgTabNodeInfo;
  }
  
  protected void a(JobContext paramJobContext, List<MsgTabVideoData> paramList)
  {
    if (this.a.b == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (StoryManager)SuperManager.a(5);
      Object localObject1 = ((MsgTabStoryManager)QQStoryContext.j().getManager(QQManagerFactory.MSG_TAB_STORY_MANAGER)).a().a(this.a.b, this.a.d);
      Object localObject2;
      Object localObject3;
      int i;
      if ((localObject1 != null) && (((MsgTabNodeInfo)localObject1).u != null) && (!((MsgTabNodeInfo)localObject1).u.isEmpty()))
      {
        localObject1 = ((MsgTabNodeInfo)localObject1).u.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MsgTabVideoData)((Iterator)localObject1).next();
          localObject3 = paramJobContext.a(((MsgTabVideoData)localObject2).c);
          if (localObject3 != null)
          {
            ((MsgTabVideoData)localObject2).e = ((StoryVideoItem)localObject3);
            paramList.add(localObject2);
          }
        }
        i = 1;
      }
      else
      {
        i = 0;
      }
      localObject1 = paramJobContext.a(false);
      int j = i;
      if (localObject1 != null)
      {
        j = i;
        if (((List)localObject1).size() > 0)
        {
          localObject1 = ((List)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (StoryVideoItem)((Iterator)localObject1).next();
            localObject3 = new MsgTabVideoData();
            ((MsgTabVideoData)localObject3).a = false;
            ((MsgTabVideoData)localObject3).b = ((StoryVideoItem)localObject2).mAttachedFeedId;
            ((MsgTabVideoData)localObject3).c = ((StoryVideoItem)localObject2).mVid;
            ((MsgTabVideoData)localObject3).e = ((StoryVideoItem)localObject2);
            ((MsgTabVideoData)localObject3).f = true;
            paramList.add(localObject3);
          }
          j = 1;
        }
      }
      if (j != 0)
      {
        localObject1 = paramList.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (MsgTabVideoData)((Iterator)localObject1).next();
          if (((MsgTabVideoData)localObject2).e == null) {
            ((MsgTabVideoData)localObject2).e = paramJobContext.a(((MsgTabVideoData)localObject2).c);
          }
          if (((MsgTabVideoData)localObject2).e == null)
          {
            notifyError(new ErrorMessage(940001, "should not be null"));
            return;
          }
        }
        Collections.sort(paramList, new MsgTabNodeInsertLocalVideoInfoSegment.1(this));
      }
    }
    if (paramList.isEmpty())
    {
      notifyError(new ErrorMessage(103, "nodeInfo not valid"));
      return;
    }
    notifyResult(paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment
 * JD-Core Version:    0.7.0.1
 */