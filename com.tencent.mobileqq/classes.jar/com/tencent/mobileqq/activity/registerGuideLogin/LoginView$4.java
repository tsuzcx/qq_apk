package com.tencent.mobileqq.activity.registerGuideLogin;

import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

class LoginView$4
  implements Runnable
{
  LoginView$4(LoginView paramLoginView, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      String str = ((SimpleAccount)localIterator.next()).getUin();
      LoginView.a(this.this$0).put(str, this.this$0.a(str, true));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.registerGuideLogin.LoginView.4
 * JD-Core Version:    0.7.0.1
 */