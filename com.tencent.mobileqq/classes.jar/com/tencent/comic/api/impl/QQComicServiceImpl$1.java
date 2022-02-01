package com.tencent.comic.api.impl;

import com.tencent.mobileqq.app.ThreadManager;
import mqq.app.AppRuntime;

class QQComicServiceImpl$1
  implements Runnable
{
  QQComicServiceImpl$1(QQComicServiceImpl paramQQComicServiceImpl, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    ThreadManager.executeOnNetWorkThread(new QQComicServiceImpl.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.api.impl.QQComicServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */