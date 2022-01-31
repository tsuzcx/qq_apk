package com.tencent.biz.pubaccount.readinjoy.view.headers.question;

import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;

public class ReadInJoyQuestionBannerViewPager$RollerChangeListener
  extends ViewPager.SimpleOnPageChangeListener
{
  int jdField_a_of_type_Int = 0;
  
  protected ReadInJoyQuestionBannerViewPager$RollerChangeListener(ReadInJoyQuestionBannerViewPager paramReadInJoyQuestionBannerViewPager) {}
  
  public void onPageScrollStateChanged(int paramInt)
  {
    int j = 1;
    ReadInJoyQuestionBannerViewPager localReadInJoyQuestionBannerViewPager = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager;
    boolean bool;
    if (paramInt == 0)
    {
      bool = true;
      localReadInJoyQuestionBannerViewPager.jdField_a_of_type_Boolean = bool;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager.jdField_a_of_type_Boolean) {
        break label39;
      }
    }
    label150:
    label163:
    for (;;)
    {
      return;
      bool = false;
      break;
      label39:
      int i = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager.getCurrentItem();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager.jdField_a_of_type_Int = i;
      int k = ReadInJoyQuestionBannerViewPager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager).getCount();
      if (k > 1)
      {
        if (i == 1)
        {
          ReadInJoyQuestionBannerViewPager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager).instantiateItem(null, k - 2);
          if (i != 0) {
            break label150;
          }
          paramInt = k - 2;
        }
        for (;;)
        {
          if (i == paramInt) {
            break label163;
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager.jdField_a_of_type_Int = paramInt;
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager.setCurrentItem(paramInt, false);
          return;
          if (i != k - 2) {
            break;
          }
          ReadInJoyQuestionBannerViewPager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager).instantiateItem(null, 1);
          break;
          paramInt = j;
          if (i != k - 1) {
            paramInt = i;
          }
        }
      }
    }
  }
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2)
  {
    super.onPageScrolled(paramInt1, paramFloat, paramInt2);
  }
  
  public void onPageSelected(int paramInt)
  {
    paramInt = ReadInJoyQuestionBannerViewPager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager).a(paramInt);
    ReadInJoyQuestionBannerViewPager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewHeadersQuestionReadInJoyQuestionBannerViewPager).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.question.ReadInJoyQuestionBannerViewPager.RollerChangeListener
 * JD-Core Version:    0.7.0.1
 */