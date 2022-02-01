package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.tianshu.observer.RedpointObserver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class Conversation$RedpointObserverImpl
  extends RedpointObserver
{
  private WeakReference<Conversation> a;
  
  public Conversation$RedpointObserverImpl(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent", 2, "cameraRedTouchObserver notify dataChanged");
    }
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation != null)
    {
      localConversation.f(false);
      Conversation.h(localConversation);
      localConversation.s();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.RedpointObserverImpl
 * JD-Core Version:    0.7.0.1
 */