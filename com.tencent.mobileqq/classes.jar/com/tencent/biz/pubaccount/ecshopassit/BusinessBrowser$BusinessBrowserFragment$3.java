package com.tencent.biz.pubaccount.ecshopassit;

import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PublicAccountObserver;

class BusinessBrowser$BusinessBrowserFragment$3
  extends PublicAccountObserver
{
  BusinessBrowser$BusinessBrowserFragment$3(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701346));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
      }
    }
    else {
      return;
    }
    this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701325));
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847457);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.3
 * JD-Core Version:    0.7.0.1
 */