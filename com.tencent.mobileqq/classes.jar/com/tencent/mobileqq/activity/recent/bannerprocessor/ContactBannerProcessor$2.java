package com.tencent.mobileqq.activity.recent.bannerprocessor;

import com.tencent.mobileqq.phonecontact.listener.IPhoneContactListener;
import mqq.os.MqqHandler;

class ContactBannerProcessor$2
  implements IPhoneContactListener
{
  ContactBannerProcessor$2(ContactBannerProcessor paramContactBannerProcessor) {}
  
  public void a(int paramInt)
  {
    ContactBannerProcessor.j(this.a).removeMessages(1000);
    ContactBannerProcessor.k(this.a).sendEmptyMessageDelayed(1000, 1000L);
  }
  
  public void a(long paramLong) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(int paramInt) {}
  
  public void c(int paramInt)
  {
    if ((paramInt & 0x1) != 0)
    {
      ContactBannerProcessor.h(this.a).removeMessages(1000);
      ContactBannerProcessor.i(this.a).sendEmptyMessageDelayed(1000, 1000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ContactBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */