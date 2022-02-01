package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GroupSearchRecommendView$UIHandler
  extends Handler
{
  public WeakReference<GroupSearchRecommendView> a;
  
  GroupSearchRecommendView$UIHandler(GroupSearchRecommendView paramGroupSearchRecommendView)
  {
    this.a = new WeakReference(paramGroupSearchRecommendView);
  }
  
  public void handleMessage(Message paramMessage)
  {
    GroupSearchRecommendView localGroupSearchRecommendView = (GroupSearchRecommendView)this.a.get();
    if (localGroupSearchRecommendView == null) {
      return;
    }
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3) {
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("GroupSearchRecommendView", 2, "fetch data failed");
        }
        GroupSearchRecommendView.a(localGroupSearchRecommendView, true);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("GroupSearchRecommendView", 2, "fetch data successfully");
      }
      GroupSearchRecommendView.a(localGroupSearchRecommendView, false);
      return;
    }
    GroupSearchRecommendView.a(localGroupSearchRecommendView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchRecommendView.UIHandler
 * JD-Core Version:    0.7.0.1
 */