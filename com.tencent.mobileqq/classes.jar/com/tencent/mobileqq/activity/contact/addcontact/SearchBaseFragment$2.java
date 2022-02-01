package com.tencent.mobileqq.activity.contact.addcontact;

import android.os.Handler;
import android.os.Message;
import java.util.List;

class SearchBaseFragment$2
  extends Handler
{
  SearchBaseFragment$2(SearchBaseFragment paramSearchBaseFragment) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (SearchBaseFragment.a(this.a) != null) {
      SearchBaseFragment.a(this.a).sendMessage(Message.obtain(paramMessage));
    }
    switch (paramMessage.what)
    {
    default: 
      return;
    case 0: 
      this.a.a();
      return;
    case 1: 
      this.a.a((String)paramMessage.obj);
      return;
    case 2: 
      this.a.g();
      return;
    case 3: 
      this.a.c();
      return;
    case 4: 
      this.a.a((List)paramMessage.obj);
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */