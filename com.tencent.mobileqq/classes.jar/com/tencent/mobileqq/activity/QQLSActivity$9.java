package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager.INewFriendListener;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class QQLSActivity$9
  implements NewFriendManager.INewFriendListener
{
  QQLSActivity$9(QQLSActivity paramQQLSActivity) {}
  
  public void ae_() {}
  
  public void b() {}
  
  public void k_(int paramInt)
  {
    if ((paramInt == 0) && (this.a.a.a().size() > 0))
    {
      Iterator localIterator = this.a.a.a().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.a.a.a().remove(localRecentBaseData);
          this.a.b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.9
 * JD-Core Version:    0.7.0.1
 */