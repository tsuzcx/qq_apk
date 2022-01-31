package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.concurrent.atomic.AtomicLong;

public abstract class PageLoaderStep
  extends QQUIEventReceiver
  implements Step
{
  protected static AtomicLong a = new AtomicLong(0L);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep
 * JD-Core Version:    0.7.0.1
 */