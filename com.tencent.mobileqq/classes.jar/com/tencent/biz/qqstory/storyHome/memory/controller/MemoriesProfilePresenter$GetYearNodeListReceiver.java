package com.tencent.biz.qqstory.storyHome.memory.controller;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.memory.model.MomeriesYearNode;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class MemoriesProfilePresenter$GetYearNodeListReceiver
  extends QQUIEventReceiver<MemoriesProfilePresenter, ProfileFeedPresenter.GetYearNodeListEvent>
{
  public MemoriesProfilePresenter$GetYearNodeListReceiver(MemoriesProfilePresenter paramMemoriesProfilePresenter)
  {
    super(paramMemoriesProfilePresenter);
  }
  
  public void a(@NonNull MemoriesProfilePresenter paramMemoriesProfilePresenter, @NonNull ProfileFeedPresenter.GetYearNodeListEvent paramGetYearNodeListEvent)
  {
    if (paramGetYearNodeListEvent.g.isSuccess())
    {
      paramGetYearNodeListEvent = paramGetYearNodeListEvent.b.iterator();
      int i = 0;
      while (paramGetYearNodeListEvent.hasNext()) {
        i += ((MomeriesYearNode)paramGetYearNodeListEvent.next()).videoCount;
      }
      if (i >= 0)
      {
        SLog.b("Q.qqstory.memories.MemoriesProfilePresenter", "update video total count. %d.", Integer.valueOf(i));
        MemoriesProfilePresenter.a(paramMemoriesProfilePresenter, i);
        if (paramMemoriesProfilePresenter.b != null)
        {
          paramMemoriesProfilePresenter.b.videoCount = MemoriesProfilePresenter.b(paramMemoriesProfilePresenter);
          ThreadManager.post(new MemoriesProfilePresenter.GetYearNodeListReceiver.1(this, paramMemoriesProfilePresenter), 5, null, false);
        }
      }
    }
  }
  
  public Class acceptEventClass()
  {
    return ProfileFeedPresenter.GetYearNodeListEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.controller.MemoriesProfilePresenter.GetYearNodeListReceiver
 * JD-Core Version:    0.7.0.1
 */