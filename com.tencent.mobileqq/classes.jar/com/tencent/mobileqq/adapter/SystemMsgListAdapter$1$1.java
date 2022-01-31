package com.tencent.mobileqq.adapter;

import aexx;
import aexz;
import aeyb;
import aeyf;
import aeyi;
import aeyk;
import aeym;
import aeyo;
import aeyx;
import aeyz;
import aezb;
import aezd;
import aezf;
import aezh;
import aezj;
import aezl;
import aezn;
import aezp;
import aezs;
import afav;
import aicw;
import ajnf;
import android.os.Handler;
import atcn;
import atco;
import atcp;
import atcq;
import atcr;
import atcs;
import atct;
import atcu;
import atcv;
import atcw;
import atcx;
import atcy;
import atcz;
import atda;
import atdb;
import atdc;
import atdd;
import atde;
import atdf;
import com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView;
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
    aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    atcu localatcu;
    Object localObject;
    if (localIterator.hasNext())
    {
      localatcu = (atcu)localIterator.next();
      if ((localatcu instanceof atcr))
      {
        localObject = new aeyb(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu, aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0));
        ((aeyb)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localatcu instanceof atco))
      {
        localObject = new aexz(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcn))
      {
        if (aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new aexx(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
          aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, (aexx)localObject);
        }
        else
        {
          localObject = aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0);
          ((aeyf)localObject).a(localatcu);
        }
      }
      else if ((localatcu instanceof atcp))
      {
        localObject = new aezs(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
        if (((aezs)localObject).a != 0L) {
          aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(Long.valueOf(((aezs)localObject).a));
        }
      }
      else if ((localatcu instanceof atcx))
      {
        localObject = new aeyz(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcv))
      {
        localObject = new aeyo(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcs))
      {
        localObject = new aeyi(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atct))
      {
        localObject = new aeyk(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atdd))
      {
        localObject = new aezl(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atde))
      {
        localObject = new aezn(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atdf))
      {
        localObject = new aezp(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atdc))
      {
        localObject = new aezj(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcy))
      {
        localObject = new aezb(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcz))
      {
        localObject = new aezd(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
        boolean bool2 = aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        ((aezd)localObject).a(bool2);
      }
      else if ((localatcu instanceof atcq))
      {
        localObject = new aeym(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
      }
      else if ((localatcu instanceof atcw))
      {
        localObject = new aeyx(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localatcu));
        }
      }
      else if ((localatcu instanceof atdb))
      {
        localObject = new aezh(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
        bool1 = true;
      }
      else if ((localatcu instanceof atda))
      {
        localObject = new aezf(aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatcu);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a();
          aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0))
          {
            if ((aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == 2) && (aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).c() == 0) && (aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).d() > 0) && (aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, false);
          }
          return;
          aicw.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */