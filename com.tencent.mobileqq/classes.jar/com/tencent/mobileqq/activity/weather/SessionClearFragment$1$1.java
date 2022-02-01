package com.tencent.mobileqq.activity.weather;

import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import java.util.List;

class SessionClearFragment$1$1
  implements Runnable
{
  SessionClearFragment$1$1(SessionClearFragment.1 param1, List paramList) {}
  
  public void run()
  {
    this.b.a.a = this.a;
    this.b.a.b();
    SessionClearFragment.a(this.b.a).setVisibility(0);
    List localList = this.a;
    if ((localList != null) && (localList.size() != 0))
    {
      this.b.a.a(this.a);
      return;
    }
    SessionClearFragment.b(this.b.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.1.1
 * JD-Core Version:    0.7.0.1
 */