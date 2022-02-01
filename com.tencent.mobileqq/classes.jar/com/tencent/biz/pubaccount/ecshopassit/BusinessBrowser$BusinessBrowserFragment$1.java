package com.tencent.biz.pubaccount.ecshopassit;

import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.mobileqq.app.HardCodeUtil;

class BusinessBrowser$BusinessBrowserFragment$1
  extends IPublicAccountObserver.OnCallback
{
  BusinessBrowser$BusinessBrowserFragment$1(BusinessBrowser.BusinessBrowserFragment paramBusinessBrowserFragment) {}
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    if (this.a.jdField_a_of_type_AndroidWidgetTextView != null)
    {
      if ((paramBoolean) && (this.a.jdField_a_of_type_JavaLangString != null) && (this.a.jdField_a_of_type_JavaLangString.equals(paramString)))
      {
        this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701486));
        this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(false);
        this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(0);
        return;
      }
      this.a.jdField_a_of_type_AndroidWidgetTextView.setText(HardCodeUtil.a(2131701465));
      this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
      this.a.jdField_a_of_type_AndroidWidgetTextView.setBackgroundResource(2130847326);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.BusinessBrowser.BusinessBrowserFragment.1
 * JD-Core Version:    0.7.0.1
 */