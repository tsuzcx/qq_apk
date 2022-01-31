package com.tencent.biz.qqstory.base;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public abstract class UIBaseEventReceiver
  extends QQUIEventReceiver
{
  public UIBaseEventReceiver(IEventReceiver paramIEventReceiver)
  {
    super(paramIEventReceiver);
  }
  
  public final void a(@NonNull IEventReceiver paramIEventReceiver, @NonNull BaseEvent paramBaseEvent)
  {
    if ((paramBaseEvent.a != null) && (paramBaseEvent.a.isFail()))
    {
      c(paramIEventReceiver, paramBaseEvent);
      return;
    }
    b(paramIEventReceiver, paramBaseEvent);
  }
  
  public abstract void b(@NonNull IEventReceiver paramIEventReceiver, @NonNull BaseEvent paramBaseEvent);
  
  public abstract void c(@NonNull IEventReceiver paramIEventReceiver, @NonNull BaseEvent paramBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.UIBaseEventReceiver
 * JD-Core Version:    0.7.0.1
 */