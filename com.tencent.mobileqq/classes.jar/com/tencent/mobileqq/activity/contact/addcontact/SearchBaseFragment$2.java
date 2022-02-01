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
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i != 4)
            {
              if (i != 5) {
                return;
              }
              this.a.h();
              return;
            }
            this.a.a((List)paramMessage.obj);
            return;
          }
          this.a.c();
          return;
        }
        this.a.g();
        return;
      }
      this.a.a((String)paramMessage.obj);
      return;
    }
    this.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.SearchBaseFragment.2
 * JD-Core Version:    0.7.0.1
 */