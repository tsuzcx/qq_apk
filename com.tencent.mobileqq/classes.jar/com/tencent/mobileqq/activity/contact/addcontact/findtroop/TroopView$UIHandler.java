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
    if (localTroopView == null) {}
    do
    {
      return;
      if (TroopView.a(localTroopView) != null) {
        TroopView.a(localTroopView).setRefreshing(false);
      }
    } while (TroopView.a(localTroopView) == null);
    TroopView.a(localTroopView).setRefresh(false);
  }
  
  public void handleMessage(Message paramMessage)
  {
    TroopView localTroopView = (TroopView)this.a.get();
    if (localTroopView == null) {
      return;
    }
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      TroopView.c(localTroopView);
      TroopView.a(localTroopView, 1, 2131694459);
      return;
    case 4: 
      TroopView.a(localTroopView, true);
      return;
    case 5: 
      TroopView.a(localTroopView, false);
      return;
    case 13: 
      TroopView.a(localTroopView, 1, 2131694459);
      a();
      return;
    case 14: 
      int i = paramMessage.arg1;
      if (paramMessage.arg2 == 1) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label178;
        }
        TroopView.d(localTroopView);
        if (TroopView.a(localTroopView) == null) {
          break;
        }
        TroopView.a(localTroopView).a(0);
        TroopView.a(localTroopView).sendEmptyMessageDelayed(15, 800L);
        return;
      }
      label178:
      a();
      TroopView.a(localTroopView, 1, 2131719529);
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.findtroop.TroopView.UIHandler
 * JD-Core Version:    0.7.0.1
 */