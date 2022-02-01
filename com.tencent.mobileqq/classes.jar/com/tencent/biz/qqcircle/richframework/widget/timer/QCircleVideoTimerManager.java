package com.tencent.biz.qqcircle.richframework.widget.timer;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class QCircleVideoTimerManager
{
  private static volatile QCircleVideoTimerManager a;
  private final Handler b;
  private final HandlerThread c = new HandlerThread("QCircleVideoTimerManager");
  private final List<IVideoTimerListener> d;
  
  private QCircleVideoTimerManager()
  {
    this.c.start();
    this.b = new QCircleVideoTimerManager.1(this, this.c.getLooper());
    this.d = new ArrayList();
  }
  
  public static QCircleVideoTimerManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new QCircleVideoTimerManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void b()
  {
    if (this.d.size() <= 0) {
      return;
    }
    Iterator localIterator = this.d.iterator();
    while (localIterator.hasNext()) {
      ((IVideoTimerListener)localIterator.next()).x();
    }
    c();
  }
  
  private void c()
  {
    Message localMessage = Message.obtain();
    localMessage.what = 3;
    this.b.sendMessageDelayed(localMessage, 33L);
  }
  
  private void c(IVideoTimerListener paramIVideoTimerListener)
  {
    if (paramIVideoTimerListener == null) {
      return;
    }
    this.d.add(paramIVideoTimerListener);
    paramIVideoTimerListener = new StringBuilder();
    paramIVideoTimerListener.append("handlerRegister, listener size:");
    paramIVideoTimerListener.append(this.d.size());
    QLog.i("QCircleVideoTimerManager", 4, paramIVideoTimerListener.toString());
    if (this.d.size() == 1) {
      b();
    }
  }
  
  private void d(IVideoTimerListener paramIVideoTimerListener)
  {
    if (paramIVideoTimerListener == null) {
      return;
    }
    this.d.remove(paramIVideoTimerListener);
    paramIVideoTimerListener = new StringBuilder();
    paramIVideoTimerListener.append("handlerUnRegister, listener size:");
    paramIVideoTimerListener.append(this.d.size());
    QLog.i("QCircleVideoTimerManager", 4, paramIVideoTimerListener.toString());
    if (this.d.size() == 0) {
      this.b.removeMessages(3);
    }
  }
  
  public void a(IVideoTimerListener paramIVideoTimerListener)
  {
    if (paramIVideoTimerListener == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.obj = paramIVideoTimerListener;
    this.b.sendMessage(localMessage);
    QLog.i("QCircleVideoTimerManager", 4, "registerTimerListener");
  }
  
  public void b(IVideoTimerListener paramIVideoTimerListener)
  {
    if (paramIVideoTimerListener == null) {
      return;
    }
    Message localMessage = Message.obtain();
    localMessage.what = 2;
    localMessage.obj = paramIVideoTimerListener;
    this.b.sendMessage(localMessage);
    QLog.i("QCircleVideoTimerManager", 4, "unRegisterTimerListener");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.richframework.widget.timer.QCircleVideoTimerManager
 * JD-Core Version:    0.7.0.1
 */