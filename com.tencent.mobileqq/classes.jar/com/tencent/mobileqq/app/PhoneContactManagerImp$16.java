package com.tencent.mobileqq.app;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$16
  implements Runnable
{
  PhoneContactManagerImp$16(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean) {}
  
  public void run()
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          i = this.this$0.d();
          if (QLog.isColorLevel())
          {
            RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.this$0.a();
            QLog.d("PhoneContact.Manager", 2, String.format("checkUpdateLocalContact [%s, %s, %s]", new Object[] { Boolean.valueOf(this.this$0.g), Boolean.valueOf(this.a), localRespondQueryQQBindingStat }));
          }
          if ((i != 8) && (this.this$0.e()))
          {
            this.this$0.g();
            return;
          }
          if (!this.this$0.c()) {
            break;
          }
        } while ((!this.a) && (!this.this$0.g));
        PhoneContactManagerImp.d(this.this$0);
        return;
        if ((i != 4) && (this.this$0.d()))
        {
          this.this$0.h();
          return;
        }
        if (i != 1) {
          break;
        }
      } while ((!this.a) || (!this.this$0.a().noBindUploadContacts));
      PhoneContactManagerImp.a(this.this$0, true, true, 15L);
      return;
    } while ((i != 2) || ((!this.a) && (!this.this$0.g)));
    PhoneContactManagerImp.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.16
 * JD-Core Version:    0.7.0.1
 */