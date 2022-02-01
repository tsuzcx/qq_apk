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
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = this.a.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isCheatDialogShow:");
      localStringBuilder.append(this.a.e);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    if ((paramBoolean) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity != null))
    {
      if (this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView == null) {
        return;
      }
      if ((this.a.f >= 1) && (this.a.f <= 2))
      {
        if (this.a.jdField_a_of_type_Boolean) {
          return;
        }
        if (this.a.e == UrlCheckPlugin.c)
        {
          if (this.a.f == 2)
          {
            this.a.jdField_a_of_type_ComTencentBizPubaccountCustomWebView.removeCallbacks(this.a.jdField_a_of_type_JavaLangRunnable);
            this.a.a();
            localObject = this.a;
            ((UrlCheckPlugin)localObject).jdField_a_of_type_Boolean = true;
            ((UrlCheckPlugin)localObject).a(2131691458);
          }
        }
        else
        {
          localObject = this.a;
          ((UrlCheckPlugin)localObject).jdField_a_of_type_Boolean = true;
          ((UrlCheckPlugin)localObject).a(2131691458);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.UrlCheckPlugin.2
 * JD-Core Version:    0.7.0.1
 */