package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.qcircle.api.helper.QCircleObserver;
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
  
  protected void onUpdateRedPoint(int paramInt)
  {
    Conversation localConversation = (Conversation)this.a.get();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QCircleObserver onUpdateRedPoint: ");
    boolean bool;
    if (localConversation != null) {
      bool = true;
    } else {
      bool = false;
    }
    localStringBuilder.append(bool);
    QLog.d("Q.recent", 2, localStringBuilder.toString());
    if (localConversation != null) {
      localConversation.r();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.QCircleObserverImpl
 * JD-Core Version:    0.7.0.1
 */