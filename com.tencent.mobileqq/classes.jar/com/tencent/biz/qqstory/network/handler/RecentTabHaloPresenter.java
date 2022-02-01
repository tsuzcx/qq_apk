package com.tencent.biz.qqstory.network.handler;

import com.tencent.biz.qqstory.base.Destroyable;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.concurrent.atomic.AtomicBoolean;

public class RecentTabHaloPresenter
  implements Destroyable, IEventReceiver
{
  private final QQAppInterface a;
  private AtomicBoolean b = new AtomicBoolean(false);
  private RecentTabHaloPresenter.HaloResponseReceiver c;
  private RecentTabHaloPresenter.ReadStoryVideoEventReceiver d;
  private RecentTabHaloPresenter.Callback e;
  
  public RecentTabHaloPresenter(QQAppInterface paramQQAppInterface)
  {
    this.a = paramQQAppInterface;
    c();
  }
  
  private void c()
  {
    this.c = new RecentTabHaloPresenter.HaloResponseReceiver(this);
    this.d = new RecentTabHaloPresenter.ReadStoryVideoEventReceiver(this);
    StoryDispatcher.a().registerSubscriber(this.c);
    StoryDispatcher.a().registerSubscriber(this.d);
  }
  
  private void d()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalidateHalo: invoked.  mCallback: ");
      ((StringBuilder)localObject).append(this.e);
      QLog.i("RecentTabHaloPresenter", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((RecentTabHaloPresenter.Callback)localObject).a();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentTabHaloPresenter", 2, "destroy: invoked. ");
    }
    StoryDispatcher.a().unRegisterSubscriber(this.c);
    StoryDispatcher.a().unRegisterSubscriber(this.d);
    this.e = null;
    this.b.set(true);
  }
  
  public void a(RecentTabHaloPresenter.Callback paramCallback)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setCallback: invoked. Message: callback: ");
      localStringBuilder.append(paramCallback);
      QLog.i("RecentTabHaloPresenter", 2, localStringBuilder.toString());
    }
    this.e = paramCallback;
  }
  
  public boolean b()
  {
    return this.b.get();
  }
  
  public boolean isValidate()
  {
    return this.b.get() ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.network.handler.RecentTabHaloPresenter
 * JD-Core Version:    0.7.0.1
 */