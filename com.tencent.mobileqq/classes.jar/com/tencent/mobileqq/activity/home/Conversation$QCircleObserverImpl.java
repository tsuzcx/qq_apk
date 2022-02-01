package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.qcircle.handler.QCircleObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Conversation$QCircleObserverImpl
  extends QCircleObserver
{
  private WeakReference<Conversation> a;
  
  public Conversation$QCircleObserverImpl(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a(int paramInt)
  {
    Conversation localConversation = (Conversation)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder().append("QCircleObserver onUpdateRedPoint: ");
    if (localConversation != null) {}
    for (boolean bool = true;; bool = false)
    {
      QLog.d("Q.recent", 2, bool);
      if (localConversation != null) {
        localConversation.s();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.QCircleObserverImpl
 * JD-Core Version:    0.7.0.1
 */