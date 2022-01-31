package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;
import nvm;

public class MemoriesProfilePresenter$GetYearNodeListReceiver
  extends QQUIEventReceiver
{
  public MemoriesProfilePresenter$GetYearNodeListReceiver(MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull ProfileFeedPresenter.GetYearNodeListEvent paramGetYearNodeListEvent)
  {
    if (paramGetYearNodeListEvent.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage.isSuccess())
    {
      paramGetYearNodeListEvent = paramGetYearNodeListEvent.jdField_a_of_type_JavaUtilList.iterator();
      for (int i = 0; paramGetYearNodeListEvent.hasNext(); i = ((MomeriesYearNode)paramGetYearNodeListEvent.next()).videoCount + i) {}
      if (i >= 0)
      {
        SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        MemoriesProfilePresenter.a(paramMemoriesProfilePresenter, i);
        if (paramMemoriesProfilePresenter.a != null)
        {
          paramMemoriesProfilePresenter.a.videoCount = MemoriesProfilePresenter.a(paramMemoriesProfilePresenter);
          ThreadManager.post(new nvm(this, paramMemoriesProfilePresenter), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ProfileFeedPresenter.GetYearNodeListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver
 * JD-Core Version:    0.7.0.1
 */