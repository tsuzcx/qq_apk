package com.tencent.biz.qqstory.base;

import android.support.annotation.NonNull;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;

public abstract class UIBaseEventReceiver<T extends IEventReceiver, EVENT extends BaseEvent>
  extends QQUIEventReceiver<T, EVENT>
{
  public UIBaseEventReceiver(T paramT)
  {
    super(paramT);
  }
  
  public final void a(@NonNull T paramT, @NonNull EVENT paramEVENT)
  {
    if ((paramEVENT.g != null) && (paramEVENT.g.isFail()))
    {
      c(paramT, paramEVENT);
      return;
    }
    b(paramT, paramEVENT);
  }
  
  public abstract void b(@NonNull T paramT, @NonNull EVENT paramEVENT);
  
  public abstract void c(@NonNull T paramT, @NonNull EVENT paramEVENT);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.UIBaseEventReceiver
 * JD-Core Version:    0.7.0.1
 */