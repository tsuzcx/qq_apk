package com.tencent.mobileqq.activity.contact.newfriend;

import aiyl;
import aiyv;
import aizi;
import ajai;
import ajav;
import ajbk;
import ajbn;
import ajbu;
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
    ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (ajbn)localIterator.next();
      if ((localObject instanceof ajbk))
      {
        localObject = new aiyv(ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajbn)localObject, ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0));
        ((aiyv)localObject).a(i);
        i += 1;
      }
      for (;;)
      {
        if (localObject != null) {
          ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(localObject);
        }
        break;
        if ((localObject instanceof ajbu))
        {
          localObject = new ajai(ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajbn)localObject);
          bool = true;
        }
        else
        {
          localObject = ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajbn)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool + "mCurrentTabLayoutStatus =" + ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
    }
    if (bool)
    {
      ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a();
      ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
      if (ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0))
      {
        if ((ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == 2) && (ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).c() == 0) && (ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).d() > 0) && (ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a() >= 3))
        {
          i = ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.setSelection(i);
        }
        ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, false);
      }
      return;
      ajav.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */