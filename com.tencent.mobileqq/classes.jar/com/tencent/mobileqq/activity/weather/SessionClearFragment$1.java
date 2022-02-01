package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.mobileqq.app.message.messageclean.IMessageLoadListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class SessionClearFragment$1
  implements IMessageLoadListener
{
  SessionClearFragment$1(SessionClearFragment paramSessionClearFragment) {}
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      QLog.d("SessionClearFragment", 2, "onLoadStart");
      this.a.a();
    }
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onLoadFinish");
    }
    SessionClearFragment.c(this.a).runOnUiThread(new SessionClearFragment.1.1(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment.1
 * JD-Core Version:    0.7.0.1
 */