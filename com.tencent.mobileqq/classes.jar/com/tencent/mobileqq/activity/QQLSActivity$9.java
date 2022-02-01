package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNewFriendMsgData;
import com.tencent.mobileqq.managers.QQLSRecentManager;
import com.tencent.mobileqq.newfriend.interfaces.INewFriendListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class QQLSActivity$9
  implements INewFriendListener
{
  QQLSActivity$9(QQLSActivity paramQQLSActivity) {}
  
  public void b() {}
  
  public void bR_() {}
  
  public void i_(int paramInt)
  {
    if ((paramInt == 0) && (this.a.n.b().size() > 0))
    {
      Iterator localIterator = this.a.n.b().iterator();
      while (localIterator.hasNext())
      {
        RecentBaseData localRecentBaseData = (RecentBaseData)localIterator.next();
        if ((localRecentBaseData instanceof RecentItemNewFriendMsgData))
        {
          if (QLog.isColorLevel()) {
            QLog.d("QQLSActivity", 2, "Need to delete RecentItemNewFriendMsgData");
          }
          this.a.n.b().remove(localRecentBaseData);
          this.a.c();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.QQLSActivity.9
 * JD-Core Version:    0.7.0.1
 */