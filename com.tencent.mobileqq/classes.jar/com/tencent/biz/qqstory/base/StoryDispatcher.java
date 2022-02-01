package com.tencent.biz.qqstory.base;

import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatchers;

public class StoryDispatcher
{
  public static Dispatcher a()
  {
    return Dispatchers.get(ThreadManager.getSubThreadLooper());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.StoryDispatcher
 * JD-Core Version:    0.7.0.1
 */