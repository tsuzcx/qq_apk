package com.tencent.mobileqq.activity.recent.guidebanner;

import alkp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

public class NewerGuideBannerViewModel$5
  implements Runnable
{
  public NewerGuideBannerViewModel$5(alkp paramalkp, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    localPhoneContactManagerImp.j();
    localPhoneContactManagerImp.e = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerViewModel.5
 * JD-Core Version:    0.7.0.1
 */