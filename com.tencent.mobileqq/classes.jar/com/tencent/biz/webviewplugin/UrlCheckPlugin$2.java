package com.tencent.biz.webviewplugin;

import com.tencent.biz.SoftKeyboardObserver.OnSoftKeyboardToggledListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.qphone.base.util.QLog;

class UrlCheckPlugin$2
  implements SoftKeyboardObserver.OnSoftKeyboardToggledListener
{
  UrlCheckPlugin$2(UrlCheckPlugin paramUrlCheckPlugin) {}
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "onSoftKeyboardToggled");
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.TAG, 2, "isCheatDialogShow:" + this.a.e);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity == null) || (this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null)) {}
    do
    {
      do
      {
        return;
      } while ((this.a.f < 1) || (this.a.f > 2) || (this.a.jdField_a_of_type_Boolean));
      if (this.a.e != UrlCheckPlugin.c) {
        break;
      }
    } while (this.a.f != 2);
    this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
    this.a.a();
    this.a.jdField_a_of_type_Boolean = true;
    this.a.a(2131691537);
    return;
    this.a.jdField_a_of_type_Boolean = true;
    this.a.a(2131691537);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin.2
 * JD-Core Version:    0.7.0.1
 */