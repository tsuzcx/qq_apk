package com.tencent.mobileqq.activity.contact.newfriend;

import aixu;
import aiya;
import aiyc;
import aiye;
import aiyi;
import aiyl;
import aiyn;
import aiyp;
import aiyr;
import aiyy;
import aizh;
import aizj;
import aizl;
import aizn;
import aizp;
import aizr;
import aizt;
import aizv;
import aizx;
import aizz;
import ajac;
import ajae;
import ajaq;
import ajar;
import ajas;
import ajat;
import ajau;
import ajav;
import ajaw;
import ajax;
import ajay;
import ajaz;
import ajba;
import ajbb;
import ajbc;
import ajbd;
import ajbe;
import ajbf;
import ajbg;
import ajbh;
import ajbi;
import android.os.Handler;
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
    ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    ajax localajax;
    Object localObject;
    if (localIterator.hasNext())
    {
      localajax = (ajax)localIterator.next();
      if ((localajax instanceof ajau))
      {
        localObject = new aiye(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax, ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0));
        ((aiye)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localajax instanceof ajar))
      {
        localObject = new aiyc(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajaq))
      {
        if (ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new aiya(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
          ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, (aiya)localObject);
        }
        else
        {
          localObject = ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0);
          ((aiyi)localObject).a(localajax);
        }
      }
      else if ((localajax instanceof ajas))
      {
        localObject = new ajac(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
        if (((ajac)localObject).a != 0L) {
          ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).add(Long.valueOf(((ajac)localObject).a));
        }
      }
      else if ((localajax instanceof ajba))
      {
        localObject = new aizj(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajay))
      {
        localObject = new aiyy(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajav))
      {
        localObject = new aiyl(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajaw))
      {
        localObject = new aiyn(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbg))
      {
        localObject = new aizv(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbh))
      {
        localObject = new aizx(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbi))
      {
        localObject = new aizz(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbf))
      {
        localObject = new aizt(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbb))
      {
        localObject = new aizl(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajbc))
      {
        localObject = new aizn(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
        boolean bool2 = ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        ((aizn)localObject).a(bool2);
      }
      else if ((localajax instanceof ajat))
      {
        localObject = new aiyp(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
      }
      else if ((localajax instanceof ajaz))
      {
        localObject = new aizh(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localajax));
        }
      }
      else if ((localajax instanceof ajbe))
      {
        localObject = new aizr(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
        bool1 = true;
      }
      else if ((localajax instanceof ajbd))
      {
        localObject = new aizp(ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, localajax);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a();
          ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0))
          {
            if ((ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0) == 2) && (ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).c() == 0) && (ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).d() > 0) && (ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0, false);
          }
          return;
          ajae.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListAdapter$1.this$0).b();
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */