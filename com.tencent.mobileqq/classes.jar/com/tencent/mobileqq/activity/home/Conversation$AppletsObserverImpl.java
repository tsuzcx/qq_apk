package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;

class Conversation$AppletsObserverImpl
  extends AppletsObserver
{
  private WeakReference<Conversation> a;
  
  public Conversation$AppletsObserverImpl(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
      }
      Conversation localConversation = (Conversation)this.a.get();
      if (localConversation != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)paramList.next();
          if (localAppletsAccountInfo != null) {
            localConversation.a(9, localAppletsAccountInfo.uin, 1038);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.AppletsObserverImpl
 * JD-Core Version:    0.7.0.1
 */