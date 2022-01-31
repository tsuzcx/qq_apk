package com.tencent.mobileqq.adapter;

import ahgq;
import ahgs;
import ahgu;
import ahgy;
import ahhb;
import ahhd;
import ahhf;
import ahhh;
import ahhq;
import ahhs;
import ahhu;
import ahhw;
import ahhy;
import ahia;
import ahic;
import ahie;
import ahig;
import ahii;
import ahil;
import ahjo;
import akgy;
import altc;
import android.os.Handler;
import avpx;
import avpy;
import avpz;
import avqa;
import avqb;
import avqc;
import avqd;
import avqe;
import avqf;
import avqg;
import avqh;
import avqi;
import avqj;
import avqk;
import avql;
import avqm;
import avqn;
import avqo;
import avqp;
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
    akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    avqe localavqe;
    Object localObject;
    if (localIterator.hasNext())
    {
      localavqe = (avqe)localIterator.next();
      if ((localavqe instanceof avqb))
      {
        localObject = new ahgu(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe, akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0));
        ((ahgu)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localavqe instanceof avpy))
      {
        localObject = new ahgs(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avpx))
      {
        if (akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new ahgq(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
          akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, (ahgq)localObject);
        }
        else
        {
          localObject = akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0);
          ((ahgy)localObject).a(localavqe);
        }
      }
      else if ((localavqe instanceof avpz))
      {
        localObject = new ahil(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
        if (((ahil)localObject).a != 0L) {
          akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(Long.valueOf(((ahil)localObject).a));
        }
      }
      else if ((localavqe instanceof avqh))
      {
        localObject = new ahhs(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqf))
      {
        localObject = new ahhh(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqc))
      {
        localObject = new ahhb(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqd))
      {
        localObject = new ahhd(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqn))
      {
        localObject = new ahie(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqo))
      {
        localObject = new ahig(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqp))
      {
        localObject = new ahii(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqm))
      {
        localObject = new ahic(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqi))
      {
        localObject = new ahhu(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqj))
      {
        localObject = new ahhw(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
        boolean bool2 = akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        ((ahhw)localObject).a(bool2);
      }
      else if ((localavqe instanceof avqa))
      {
        localObject = new ahhf(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
      }
      else if ((localavqe instanceof avqg))
      {
        localObject = new ahhq(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localavqe));
        }
      }
      else if ((localavqe instanceof avql))
      {
        localObject = new ahia(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
        bool1 = true;
      }
      else if ((localavqe instanceof avqk))
      {
        localObject = new ahhy(akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavqe);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a();
          akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0))
          {
            if ((akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == 2) && (akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).c() == 0) && (akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).d() > 0) && (akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, false);
          }
          return;
          akgy.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
        }
      }
      else
      {
        localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.SystemMsgListAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */