package com.tencent.imcore.message;

import com.tencent.qphone.base.util.QLog;
import java.util.Observable;
import java.util.Observer;

class BaseQQMessageFacade$ObserverWrapper
  implements Observer
{
  private Observer a;
  
  public BaseQQMessageFacade$ObserverWrapper(Observer paramObserver)
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localObserver);
    localStringBuilder.append(" update with: o = [");
    localStringBuilder.append(paramObservable);
    localStringBuilder.append("], arg = [");
    localStringBuilder.append(paramObject);
    localStringBuilder.append("], costTime=[");
    localStringBuilder.append(l2 - l1);
    localStringBuilder.append("]ms");
    QLog.d("Q.msg.QQMessageFacade", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.BaseQQMessageFacade.ObserverWrapper
 * JD-Core Version:    0.7.0.1
 */