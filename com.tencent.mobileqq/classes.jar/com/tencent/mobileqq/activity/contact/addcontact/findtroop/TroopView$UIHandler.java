package com.tencent.mobileqq.activity.contact.addcontact.findtroop;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.activity.contacts.pullrefresh.CommonRefreshLayout;
import com.tencent.mobileqq.activity.contacts.pullrefresh.ContactRefreshHeader;
import java.lang.ref.WeakReference;

class TroopView$UIHandler
  extends Handler
{
  public WeakReference<TroopView> a;
  
  public TroopView$UIHandler(TroopView paramTroopView)
  {
    this.a = new WeakReference(paramTroopView);
  }
  
  public void a()
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {
      return;
    }
    if (TroopView.i(localTroopView) != null) {
      TroopView.i(localTroopView).setRefreshing(false);
    }
    if (TroopView.m(localTroopView) != null) {
      TroopView.m(localTroopView).setRefresh(false);
    }
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {
      return;
    }
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 4)
      {
        if (i != 5) {
          switch (i)
          {
          default: 
            return;
          case 15: 
            a();
            return;
          case 14: 
            i = paramMessage.arg1;
            if (paramMessage.arg2 == 1) {
              i = 1;
            } else {
              i = 0;
            }
            if (i != 0)
            {
              TroopView.l(localTroopView);
              if (TroopView.m(localTroopView) == null) {
                break;
              }
              TroopView.m(localTroopView).a(0);
              TroopView.c(localTroopView).sendEmptyMessageDelayed(15, 800L);
              return;
            }
            a();
            TroopView.a(localTroopView, 1, 2131916799);
            return;
          case 13: 
            TroopView.a(localTroopView, 1, 2131892104);
            a();
            return;
          }
        } else {
          TroopView.b(localTroopView, false);
        }
      }
      else {
        TroopView.b(localTroopView, true);
      }
    }
    else
    {
      TroopView.k(localTroopView);
      TroopView.a(localTroopView, 1, 2131892104);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.UIHandler
 * JD-Core Version:    0.7.0.1
 */