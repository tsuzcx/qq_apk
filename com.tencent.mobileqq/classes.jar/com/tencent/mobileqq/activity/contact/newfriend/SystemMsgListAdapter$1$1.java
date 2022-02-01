package com.tencent.mobileqq.activity.contact.newfriend;

import com.tencent.mobileqq.activity.contact.connections.TabLayoutStatus;
import com.tencent.mobileqq.activity.contact.newfriend.msg.MayKnowMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendMessage;
import com.tencent.mobileqq.activity.contact.newfriend.msg.NewFriendTabInfoMessage;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

class SystemMsgListAdapter$1$1
  implements Runnable
{
  SystemMsgListAdapter$1$1(SystemMsgListAdapter.1 param1, ArrayList paramArrayList) {}
  
  public void run()
  {
    SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (NewFriendMessage)localIterator.next();
      if ((localObject instanceof MayKnowMessage))
      {
        localObject = new MayKnowRecommendBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (NewFriendMessage)localObject, SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0));
        ((MayKnowRecommendBuilder)localObject).a(i);
        i += 1;
      }
      for (;;)
      {
        if (localObject != null) {
          SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(localObject);
        }
        break;
        if ((localObject instanceof NewFriendTabInfoMessage))
        {
          localObject = new NewFriendTabInfoBuilder(SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (NewFriendMessage)localObject);
          bool = true;
        }
        else
        {
          localObject = SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (NewFriendMessage)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool + "mCurrentTabLayoutStatus =" + SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
    }
    if (bool)
    {
      SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a();
      SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
      if (SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0))
      {
        if ((SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == 2) && (SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).c() == 0) && (SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).d() > 0) && (SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a() >= 3))
        {
          i = SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.setSelection(i);
        }
        SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, false);
      }
      return;
      SystemMsgListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */