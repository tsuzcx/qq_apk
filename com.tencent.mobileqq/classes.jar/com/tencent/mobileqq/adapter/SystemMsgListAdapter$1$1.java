package com.tencent.mobileqq.adapter;

import afjl;
import afjn;
import afjp;
import afjt;
import afjw;
import afjy;
import afka;
import afkc;
import afkl;
import afkn;
import afkp;
import afkr;
import afkt;
import afkv;
import afkx;
import afkz;
import aflb;
import afld;
import aflg;
import afmj;
import aipn;
import akbn;
import android.os.Handler;
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
import atzk;
import atzl;
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
    aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    atza localatza;
    Object localObject;
    if (localIterator.hasNext())
    {
      localatza = (atza)localIterator.next();
      if ((localatza instanceof atyx))
      {
        localObject = new afjp(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza, aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0));
        ((afjp)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localatza instanceof atyu))
      {
        localObject = new afjn(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atyt))
      {
        if (aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new afjl(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
          aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, (afjl)localObject);
        }
        else
        {
          localObject = aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0);
          ((afjt)localObject).a(localatza);
        }
      }
      else if ((localatza instanceof atyv))
      {
        localObject = new aflg(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
        if (((aflg)localObject).a != 0L) {
          aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(Long.valueOf(((aflg)localObject).a));
        }
      }
      else if ((localatza instanceof atzd))
      {
        localObject = new afkn(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzb))
      {
        localObject = new afkc(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atyy))
      {
        localObject = new afjw(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atyz))
      {
        localObject = new afjy(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzj))
      {
        localObject = new afkz(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzk))
      {
        localObject = new aflb(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzl))
      {
        localObject = new afld(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzi))
      {
        localObject = new afkx(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atze))
      {
        localObject = new afkp(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzf))
      {
        localObject = new afkr(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
        boolean bool2 = aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        ((afkr)localObject).a(bool2);
      }
      else if ((localatza instanceof atyw))
      {
        localObject = new afka(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
      }
      else if ((localatza instanceof atzc))
      {
        localObject = new afkl(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localatza));
        }
      }
      else if ((localatza instanceof atzh))
      {
        localObject = new afkv(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
        bool1 = true;
      }
      else if ((localatza instanceof atzg))
      {
        localObject = new afkt(aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localatza);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a();
          aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0))
          {
            if ((aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == 2) && (aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).c() == 0) && (aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).d() > 0) && (aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, false);
          }
          return;
          aipn.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
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