package com.tencent.mobileqq.app;

import android.content.SharedPreferences;
import aumi;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

class PhoneContactManagerImp$4
  implements Runnable
{
  PhoneContactManagerImp$4(PhoneContactManagerImp paramPhoneContactManagerImp) {}
  
  public void run()
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    long l2;
    do
    {
      return;
      l1 = this.this$0.a.getLong("key_req_last_login_time", 0L);
      l2 = this.this$0.a.getLong("key_req_login_interval", 86400000L);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(100);
        ((StringBuilder)localObject).append("checkLastLogin, lastReqTime = ").append(l1);
        ((StringBuilder)localObject).append(", current = ").append(System.currentTimeMillis());
        ((StringBuilder)localObject).append(", interval = ").append(l2);
        ((StringBuilder)localObject).append(", isRequesting = ").append(PhoneContactManagerImp.f(this.this$0));
        QLog.d("PhoneContact.Manager", 2, ((StringBuilder)localObject).toString());
      }
    } while ((PhoneContactManagerImp.f(this.this$0)) || (!this.this$0.c()) || (Math.abs(System.currentTimeMillis() - l1) < l2));
    PhoneContactManagerImp.a(this.this$0, true);
    Object localObject = new NewIntent(PhoneContactManagerImp.a(this.this$0).getApplication(), aumi.class);
    ((NewIntent)localObject).putExtra("req_type", 32);
    long l1 = this.this$0.a.getLong("key_login_info_timestamp", 0L);
    ((NewIntent)localObject).putExtra("next_flag", 0);
    ((NewIntent)localObject).putExtra("time_stamp", l1);
    ((NewIntent)localObject).putExtra("unique_phone_no", this.this$0.a());
    PhoneContactManagerImp.a(this.this$0).startServlet((NewIntent)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.4
 * JD-Core Version:    0.7.0.1
 */