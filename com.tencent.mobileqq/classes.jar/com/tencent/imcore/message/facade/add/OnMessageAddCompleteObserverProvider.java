package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import com.tencent.mobileqq.data.entitymanager.Provider;
import java.util.Map;

public class OnMessageAddCompleteObserverProvider
  implements Provider<Map<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>>>
{
  private final Map<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>> a = new OnMessageAddCompleteObserverProvider.1(this);
  
  public Map<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>> a()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverProvider
 * JD-Core Version:    0.7.0.1
 */