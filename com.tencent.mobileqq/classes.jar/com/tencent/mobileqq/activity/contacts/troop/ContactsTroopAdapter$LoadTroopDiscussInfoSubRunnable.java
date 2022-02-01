package com.tencent.mobileqq.activity.contacts.troop;

import android.text.TextUtils;
import antp;
import aoxz;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

class ContactsTroopAdapter$LoadTroopDiscussInfoSubRunnable
  implements Runnable
{
  aoxz jdField_a_of_type_Aoxz;
  TroopManager jdField_a_of_type_ComTencentMobileqqAppTroopManager;
  
  private ContactsTroopAdapter$LoadTroopDiscussInfoSubRunnable(ContactsTroopAdapter paramContactsTroopAdapter) {}
  
  public void run()
  {
    TroopManager localTroopManager = (TroopManager)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    aoxz localaoxz = this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    ArrayList localArrayList1 = localTroopManager.b();
    Object localObject = ((antp)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = ((List)localObject).iterator();
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
            localArrayList2.add(localDiscussionInfo);
          }
        }
      }
      for (;;)
      {
        break;
        if (i >= 40)
        {
          localArrayList2.add(localDiscussionInfo);
        }
        else if (this.this$0.jdField_a_of_type_Antp.a(localDiscussionInfo.uin) > 0)
        {
          localArrayList2.add(localDiscussionInfo);
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
    QLog.d("ContactsTroopAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i + "  org_discussions.size:" + ((List)localObject).size() + "  discussions.size:" + localArrayList2.size());
    localObject = new ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable(this.this$0, null);
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_ComTencentMobileqqAppTroopManager = localTroopManager;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_Aoxz = localaoxz;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_JavaUtilArrayList = localArrayList1;
    ((ContactsTroopAdapter.UpdateAfterLoadDataUIRunnable)localObject).jdField_a_of_type_JavaUtilList = localArrayList2;
    ThreadManager.getUIHandler().post((Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.troop.ContactsTroopAdapter.LoadTroopDiscussInfoSubRunnable
 * JD-Core Version:    0.7.0.1
 */