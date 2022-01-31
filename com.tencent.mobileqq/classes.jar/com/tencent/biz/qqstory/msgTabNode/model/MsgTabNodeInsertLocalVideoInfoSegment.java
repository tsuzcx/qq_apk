package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import nea;

public class MsgTabNodeInsertLocalVideoInfoSegment
  extends JobSegment
{
  MsgTabNodeInfo a;
  
  public MsgTabNodeInsertLocalVideoInfoSegment(MsgTabNodeInfo paramMsgTabNodeInfo)
  {
    this.a = paramMsgTabNodeInfo;
  }
  
  protected void a(JobContext paramJobContext, List paramList)
  {
    Object localObject;
    MsgTabVideoData localMsgTabVideoData;
    if (this.a.jdField_a_of_type_Int == 5)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.msgTab.jobLocalVideo", 2, "self node, check local video");
      }
      paramJobContext = (StoryManager)SuperManager.a(5);
      localObject = ((MsgTabStoryManager)QQStoryContext.a().getManager(250)).a().a(this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (((MsgTabNodeInfo)localObject).b == null) || (((MsgTabNodeInfo)localObject).b.isEmpty())) {
        break label302;
      }
      localObject = ((MsgTabNodeInfo)localObject).b.iterator();
      while (((Iterator)localObject).hasNext())
      {
        localMsgTabVideoData = (MsgTabVideoData)((Iterator)localObject).next();
        StoryVideoItem localStoryVideoItem = paramJobContext.a(localMsgTabVideoData.jdField_b_of_type_JavaLangString);
        if (localStoryVideoItem != null)
        {
          localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = localStoryVideoItem;
          paramList.add(localMsgTabVideoData);
        }
      }
    }
    label302:
    for (int i = 1;; i = 0)
    {
      paramJobContext = paramJobContext.a(false);
      int j = i;
      if (paramJobContext != null)
      {
        j = i;
        if (paramJobContext.size() > 0)
        {
          paramJobContext = paramJobContext.iterator();
          while (paramJobContext.hasNext())
          {
            localObject = (StoryVideoItem)paramJobContext.next();
            localMsgTabVideoData = new MsgTabVideoData();
            localMsgTabVideoData.jdField_a_of_type_Boolean = false;
            localMsgTabVideoData.jdField_a_of_type_JavaLangString = ((StoryVideoItem)localObject).mAttachedFeedId;
            localMsgTabVideoData.jdField_b_of_type_JavaLangString = ((StoryVideoItem)localObject).mVid;
            localMsgTabVideoData.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((StoryVideoItem)localObject);
            localMsgTabVideoData.jdField_b_of_type_Boolean = true;
            paramList.add(localMsgTabVideoData);
          }
          j = 1;
        }
      }
      if (j != 0) {
        Collections.sort(paramList, new nea(this));
      }
      notifyResult(paramList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment
 * JD-Core Version:    0.7.0.1
 */