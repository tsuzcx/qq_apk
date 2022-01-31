package com.tencent.mobileqq.activity.selectmember;

import ahti;
import ajhh;
import akeu;
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

public class TroopListBaseAdapter$3
  implements Runnable
{
  public TroopListBaseAdapter$3(ahti paramahti, TroopManager paramTroopManager, akeu paramakeu) {}
  
  public void run()
  {
    ArrayList localArrayList1 = this.jdField_a_of_type_ComTencentMobileqqAppTroopManager.a();
    ArrayList localArrayList2 = ((ajhh)this.this$0.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(53)).a();
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
            QLog.d("TroopListBaseAdapter", 2, "load data asyncLoadTroopListAndNotifyUi discussion : " + localDiscussionInfo);
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
        else if (this.this$0.jdField_a_of_type_Ajhh.a(localDiscussionInfo.uin) > 0)
        {
          localArrayList3.add(localDiscussionInfo);
          i += 1;
        }
        else
        {
          j = i + 1;
          QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi discussion skiped : " + localDiscussionInfo);
          i = j;
        }
      }
    }
    QLog.d("TroopListBaseAdapter", 1, "load data asyncLoadTroopListAndNotifyUi count: " + i + "  org_discussions.size:" + localArrayList2.size() + "  discussions.size:" + localArrayList3.size());
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.3.1(this, localArrayList1, localArrayList3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3
 * JD-Core Version:    0.7.0.1
 */