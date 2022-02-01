package com.tencent.biz.pubaccount.accountdetail.view;

import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class AccountDetailBannerViewPager$1
  implements ViewPager.OnPageChangeListener
{
  AccountDetailBannerViewPager$1(AccountDetailBannerViewPager paramAccountDetailBannerViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageScrollStateChanged->");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AccountDetailBannerViewPager", 2, ((StringBuilder)localObject).toString());
    }
    AccountDetailBannerViewPager.a(this.a, paramInt);
    if (AccountDetailBannerViewPager.a(this.a) != null)
    {
      localObject = AccountDetailBannerViewPager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ViewPager.OnPageChangeListener)((Iterator)localObject).next()).onPageScrollStateChanged(paramInt);
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    if (AccountDetailBannerViewPager.a(this.a) != null)
    {
      Iterator localIterator = AccountDetailBannerViewPager.a(this.a).iterator();
      while (localIterator.hasNext()) {
        ((ViewPager.OnPageChangeListener)localIterator.next()).onPageScrolled(paramInt1, paramFloat, paramInt2);
      }
    }
  }
  
  public void onPageSelected(int paramInt)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageSelected->");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("AccountDetailBannerViewPager", 2, ((StringBuilder)localObject).toString());
    }
    if (AccountDetailBannerViewPager.a(this.a) != null)
    {
      localObject = AccountDetailBannerViewPager.a(this.a).iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ViewPager.OnPageChangeListener)((Iterator)localObject).next()).onPageSelected(paramInt);
      }
    }
    if (AccountDetailBannerViewPager.a(this.a) != null) {
      AccountDetailBannerViewPager.a(this.a).a(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.accountdetail.view.AccountDetailBannerViewPager.1
 * JD-Core Version:    0.7.0.1
 */