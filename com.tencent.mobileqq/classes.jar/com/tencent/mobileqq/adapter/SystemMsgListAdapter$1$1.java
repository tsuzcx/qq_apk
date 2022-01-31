package com.tencent.mobileqq.adapter;

import afjn;
import afjp;
import afjr;
import afjv;
import afjy;
import afka;
import afkc;
import afke;
import afkn;
import afkp;
import afkr;
import afkt;
import afkv;
import afkx;
import afkz;
import aflb;
import afld;
import aflf;
import afli;
import afml;
import aipp;
import akbo;
import android.os.Handler;
import atyr;
import atys;
import atyt;
import atyu;
import atyv;
import atyw;
import atyx;
import atyy;
import atyz;
import atza;
import atzb;
import atzc;
import atzd;
import atze;
import atzf;
import atzg;
import atzh;
import atzi;
import atzj;
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
    aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    atyy localatyy;
    Object localObject;
    if (localIterator.hasNext())
    {
      localatyy = (atyy)localIterator.next();
      if ((localatyy instanceof atyv))
      {
        localObject = new afjr(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy, aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0));
        ((afjr)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localatyy instanceof atys))
      {
        localObject = new afjp(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atyr))
      {
        if (aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new afjn(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
          aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, (afjn)localObject);
        }
        else
        {
          localObject = aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0);
          ((afjv)localObject).a(localatyy);
        }
      }
      else if ((localatyy instanceof atyt))
      {
        localObject = new afli(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
        if (((afli)localObject).a != 0L) {
          aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(Long.valueOf(((afli)localObject).a));
        }
      }
      else if ((localatyy instanceof atzb))
      {
        localObject = new afkp(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atyz))
      {
        localObject = new afke(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atyw))
      {
        localObject = new afjy(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atyx))
      {
        localObject = new afka(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzh))
      {
        localObject = new aflb(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzi))
      {
        localObject = new afld(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzj))
      {
        localObject = new aflf(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzg))
      {
        localObject = new afkz(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzc))
      {
        localObject = new afkr(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atzd))
      {
        localObject = new afkt(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
        boolean bool2 = aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        ((afkt)localObject).a(bool2);
      }
      else if ((localatyy instanceof atyu))
      {
        localObject = new afkc(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
      }
      else if ((localatyy instanceof atza))
      {
        localObject = new afkn(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localatyy));
        }
      }
      else if ((localatyy instanceof atzf))
      {
        localObject = new afkx(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
        bool1 = true;
      }
      else if ((localatyy instanceof atze))
      {
        localObject = new afkv(aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatyy);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a();
          aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0))
          {
            if ((aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == 2) && (aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).c() == 0) && (aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).d() > 0) && (aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, false);
          }
          return;
          aipp.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
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