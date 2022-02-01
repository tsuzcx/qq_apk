package com.tencent.mobileqq.activity.contact.newfriend;

import ajjd;
import ajjn;
import ajka;
import ajla;
import ajln;
import ajmc;
import ajmf;
import ajmm;
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
    ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool = false;
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (ajmf)localIterator.next();
      if ((localObject instanceof ajmc))
      {
        localObject = new ajjn(ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajmf)localObject, ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0));
        ((ajjn)localObject).a(i);
        i += 1;
      }
      for (;;)
      {
        if (localObject != null) {
          ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(localObject);
        }
        break;
        if ((localObject instanceof ajmm))
        {
          localObject = new ajla(ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajmf)localObject);
          bool = true;
        }
        else
        {
          localObject = ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (ajmf)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool + "mCurrentTabLayoutStatus =" + ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
    }
    if (bool)
    {
      ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a();
      ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.i();
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
      if (ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0))
      {
        if ((ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == 2) && (ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).c() == 0) && (ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).d() > 0) && (ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a() >= 3))
        {
          i = ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.a.setSelection(i);
        }
        ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, false);
      }
      return;
      ajln.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */