package com.tencent.imcore.message.facade.add;

import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import java.util.HashMap;

class OnMessageAddCompleteObserverProvider$1
  extends HashMap<Integer, IOnMessageAddCompleteObserver<QQMessageFacade>>
{
  OnMessageAddCompleteObserverProvider$1(OnMessageAddCompleteObserverProvider paramOnMessageAddCompleteObserverProvider)
  {
    put(Integer.valueOf(0), new OnMessageAddCompleteObserverConsiderNotify());
    put(Integer.valueOf(1), new OnMessageAddCompleteObserverDirect());
    put(Integer.valueOf(2), new OnMessageAddCompleteObserverNotifyDirectWithQAV());
    put(Integer.valueOf(3), new OnMessageAddCompleteObserverConsiderUnread());
    put(Integer.valueOf(4), new OnMessageAddCompleteObserverConsiderUnreadAndNotifyUI());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserverProvider.1
 * JD-Core Version:    0.7.0.1
 */