package com.tencent.comic.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.Observable;
import java.util.Observer;
import mqq.os.MqqHandler;

public abstract class QQComicRedTouchServiceImpl$PluginRedTouchObserver
  implements Observer
{
  public abstract void a();
  
  public final void update(Observable paramObservable, Object paramObject)
  {
    ThreadManager.getUIHandler().post(new QQComicRedTouchServiceImpl.PluginRedTouchObserver.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicRedTouchServiceImpl.PluginRedTouchObserver
 * JD-Core Version:    0.7.0.1
 */