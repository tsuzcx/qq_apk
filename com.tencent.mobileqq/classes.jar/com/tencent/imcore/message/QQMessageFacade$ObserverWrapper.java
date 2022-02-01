package com.tencent.imcore.message;

import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class QQMessageFacade$ObserverWrapper
  implements Observer
{
  private Observer a;
  
  public QQMessageFacade$ObserverWrapper(Observer paramObserver)
  {
    this.a = paramObserver;
  }
  
  public void update(Observable paramObservable, Object paramObject)
  {
    Observer localObserver = this.a;
    if (localObserver == null) {
      return;
    }
    long l1 = System.currentTimeMillis();
    localObserver.update(paramObservable, paramObject);
    long l2 = System.currentTimeMillis();
    QLog.d("Q.msg.QQMessageFacade", 1, localObserver + " update with: o = [" + paramObservable + "], arg = [" + paramObject + "], costTime=[" + (l2 - l1) + "]ms");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.imcore.message.QQMessageFacade.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */