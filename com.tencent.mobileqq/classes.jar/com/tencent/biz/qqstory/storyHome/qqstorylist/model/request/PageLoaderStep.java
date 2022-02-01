package com.tencent.biz.qqstory.storyHome.qqstorylist.model.request;

import com.tencent.biz.qqstory.network.INetPageLoader;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.Repository;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.concurrent.atomic.AtomicLong;

public abstract class PageLoaderStep<T extends Dispatcher.Dispatchable>
  extends QQUIEventReceiver<Repository, T>
  implements Step
{
  protected static AtomicLong a = new AtomicLong(0L);
  protected int a;
  protected long a;
  protected INetPageLoader a;
  protected Step.FinishCallBack a;
  protected int b;
  
  public abstract int a(T paramT);
  
  public abstract void a(T paramT);
  
  protected boolean b()
  {
    return this.b > 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.PageLoaderStep
 * JD-Core Version:    0.7.0.1
 */