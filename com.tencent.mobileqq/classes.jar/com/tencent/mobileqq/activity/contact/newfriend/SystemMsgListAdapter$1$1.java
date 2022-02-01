package com.tencent.mobileqq.activity.contact.newfriend;

import aidm;
import aidw;
import aiej;
import aifj;
import aifw;
import aigl;
import aigo;
import aigv;
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
    aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (aigo)localIterator.next();
      if ((localObject instanceof aigl))
      {
        localObject = new aidw(aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (aigo)localObject, aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0));
        ((aidw)localObject).a(i);
        i += 1;
      }
      for (;;)
      {
        if (localObject != null) {
          aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(localObject);
        }
        break;
        if ((localObject instanceof aigv))
        {
          localObject = new aifj(aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (aigo)localObject);
          bool = true;
        }
        else
        {
          localObject = aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (aigo)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool + "mCurrentTabLayoutStatus =" + aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
    }
    if (bool)
    {
      aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a();
      aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
      if (aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0))
      {
        if ((aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == 2) && (aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).c() == 0) && (aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).d() > 0) && (aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a() >= 3))
        {
          i = aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.setSelection(i);
        }
        aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, false);
      }
      return;
      aifw.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */