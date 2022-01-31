package com.tencent.mobileqq.activity;

import android.app.Activity;
import bdic;
import com.tencent.mobileqq.widget.FormSimpleItem;
import java.lang.ref.WeakReference;
import mqq.app.MobileQQ;

class LoginInfoActivity$CheckPIMStatus
  implements Runnable
{
  private WeakReference<FormSimpleItem> a;
  private WeakReference<Activity> b;
  
  public LoginInfoActivity$CheckPIMStatus(Activity paramActivity, FormSimpleItem paramFormSimpleItem)
  {
    this.a = new WeakReference(paramFormSimpleItem);
    this.b = new WeakReference(paramActivity);
  }
  
  public void run()
  {
    boolean bool1 = bdic.a(MobileQQ.sMobileQQ);
    boolean bool2 = bdic.b(MobileQQ.sMobileQQ);
    if (!bool1)
    {
      i = LoginInfoActivity.a();
      if (i == LoginInfoActivity.c()) {
        break label85;
      }
    }
    label85:
    for (int i = 2131719662;; i = 2131719665)
    {
      Activity localActivity = (Activity)this.b.get();
      if (localActivity != null) {
        localActivity.runOnUiThread(new LoginInfoActivity.RefreshPIMStatus(i, this.a));
      }
      return;
      if (!bool2)
      {
        i = LoginInfoActivity.b();
        break;
      }
      i = LoginInfoActivity.c();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LoginInfoActivity.CheckPIMStatus
 * JD-Core Version:    0.7.0.1
 */