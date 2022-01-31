package com.tencent.mobileqq.adapter;

import ahlf;
import ahlh;
import ahlj;
import ahln;
import ahlq;
import ahls;
import ahlu;
import ahlw;
import ahmf;
import ahmh;
import ahmj;
import ahml;
import ahmn;
import ahmp;
import ahmr;
import ahmt;
import ahmv;
import ahmx;
import ahna;
import ahod;
import akln;
import alxr;
import android.os.Handler;
import avug;
import avuh;
import avui;
import avuj;
import avuk;
import avul;
import avum;
import avun;
import avuo;
import avup;
import avuq;
import avur;
import avus;
import avut;
import avuu;
import avuv;
import avuw;
import avux;
import avuy;
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
    akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).clear();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    boolean bool1 = false;
    int i = 0;
    avun localavun;
    Object localObject;
    if (localIterator.hasNext())
    {
      localavun = (avun)localIterator.next();
      if ((localavun instanceof avuk))
      {
        localObject = new ahlj(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun, akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0));
        ((ahlj)localObject).a(i);
        i += 1;
      }
    }
    for (;;)
    {
      if (localObject != null) {
        akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(localObject);
      }
      break;
      if ((localavun instanceof avuh))
      {
        localObject = new ahlh(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avug))
      {
        if (akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == null)
        {
          localObject = new ahlf(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
          akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, (ahlf)localObject);
        }
        else
        {
          localObject = akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0);
          ((ahln)localObject).a(localavun);
        }
      }
      else if ((localavun instanceof avui))
      {
        localObject = new ahna(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
        if (((ahna)localObject).a != 0L) {
          akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).add(Long.valueOf(((ahna)localObject).a));
        }
      }
      else if ((localavun instanceof avuq))
      {
        localObject = new ahmh(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avuo))
      {
        localObject = new ahlw(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avul))
      {
        localObject = new ahlq(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avum))
      {
        localObject = new ahls(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avuw))
      {
        localObject = new ahmt(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avux))
      {
        localObject = new ahmv(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avuy))
      {
        localObject = new ahmx(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avuv))
      {
        localObject = new ahmr(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avur))
      {
        localObject = new ahmj(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avus))
      {
        localObject = new ahml(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
        boolean bool2 = akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        ((ahml)localObject).a(bool2);
      }
      else if ((localavun instanceof avuj))
      {
        localObject = new ahlu(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
      }
      else if ((localavun instanceof avup))
      {
        localObject = new ahmf(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
        Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_AndroidOsHandler;
        if (localHandler != null)
        {
          localHandler.removeMessages(3);
          localHandler.sendMessage(localHandler.obtainMessage(3, localavun));
        }
      }
      else if ((localavun instanceof avuu))
      {
        localObject = new ahmp(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
        bool1 = true;
      }
      else if ((localavun instanceof avut))
      {
        localObject = new ahmn(akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0), this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, localavun);
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("SystemMsgListAdapter", 2, "hasMayKnowData = " + bool1 + "mCurrentTabLayoutStatus =" + akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) + "， recommendPos =" + i);
        }
        if (bool1)
        {
          akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a();
          akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, i, this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.a);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.i();
          this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.notifyDataSetChanged();
          if (akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0))
          {
            if ((akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0) == 2) && (akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).c() == 0) && (akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).d() > 0) && (akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).a() >= 3))
            {
              i = akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
              this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendSystemMsgListView.setSelection(i);
            }
            akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0, false);
          }
          return;
          akln.a(this.jdField_a_of_type_ComTencentMobileqqAdapterSystemMsgListAdapter$1.this$0).b();
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