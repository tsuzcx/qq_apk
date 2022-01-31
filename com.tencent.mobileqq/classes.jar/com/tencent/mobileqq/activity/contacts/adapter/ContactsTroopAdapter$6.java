package com.tencent.mobileqq.activity.contacts.adapter;

import ahrs;
import alrk;
import amnz;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class ContactsTroopAdapter$6
  implements Runnable
{
  public ContactsTroopAdapter$6(ahrs paramahrs, TroopManager paramTroopManager, amnz paramamnz) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    ArrayList localArrayList2 = ((alrk)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
    ArrayList localArrayList3 = new ArrayList();
    Iterator localIterator = localArrayList2.iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)localIterator.next();
      int j = i;
      if (localDiscussionInfo != null)
      {
        j = i;
        if (!TextUtils.isEmpty(localDiscussionInfo.uin))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ContactsTroopAdapter", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + localDiscussionInfo);
          }
          if (!TextUtils.isEmpty(localDiscussionInfo.discussionName)) {
            localArrayList3.add(localDiscussionInfo);
          }
        }
      }
      for (;;)
      {
        break;
        if (i >= 40)
        {
          localArrayList3.add(localDiscussionInfo);
        }
        else if (this.this$0.jdField_a_of_type_Alrk.a(localDiscussionInfo.uin) > 0)
        {
          localArrayList3.add(localDiscussionInfo);
          i += 1;
        }
        else
        {
          j = i + 1;
          QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + localDiscussionInfo);
          i = j;
        }
      }
    }
    QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i + "  org_discussions.size:" + localArrayList2.size() + "  discussions.size:" + localArrayList3.size());
    ThreadManager.getUIHandler().post(new ContactsTroopAdapter.6.1(this, localArrayList1, localArrayList3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.adapter.ContactsTroopAdapter.6
 * JD-Core Version:    0.7.0.1
 */