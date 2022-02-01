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
  
  protected void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onGetAppletsDetail:  isSuccess: ");
        ((StringBuilder)localObject).append(paramBoolean);
        ((StringBuilder)localObject).append(", data.size = ");
        ((StringBuilder)localObject).append(paramList.size());
        QLog.i("AppletsObserver", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = (Conversation)this.a.get();
      if (localObject != null)
      {
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          AppletsAccountInfo localAppletsAccountInfo = (AppletsAccountInfo)paramList.next();
          if (localAppletsAccountInfo != null) {
            ((Conversation)localObject).a(9, localAppletsAccountInfo.uin, 1038);
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