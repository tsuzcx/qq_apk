package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.widget.QQToast;

class FriendProfileCardActivity$11$5
  implements Runnable
{
  FriendProfileCardActivity$11$5(FriendProfileCardActivity.11 param11) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (!localPhoneContactManagerImp.a(this.a.a.a.a.k, this.a.a.a.a.a))
    {
      this.a.a.g = true;
      if (localPhoneContactManagerImp.b(this.a.a.a.a.k, this.a.a.a.a.a))
      {
        QQToast.a(this.a.a.getApplicationContext(), 2, HardCodeUtil.a(2131704920), 0).a();
        return;
      }
      QQToast.a(this.a.a.getApplicationContext(), 1, HardCodeUtil.a(2131704949), 0).a();
      return;
    }
    QQToast.a(this.a.a.getApplicationContext(), HardCodeUtil.a(2131704910), 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.11.5
 * JD-Core Version:    0.7.0.1
 */