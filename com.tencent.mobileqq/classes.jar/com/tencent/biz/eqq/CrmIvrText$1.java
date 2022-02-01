package com.tencent.biz.eqq;

import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;

final class CrmIvrText$1
  implements Runnable
{
  CrmIvrText$1(QQAppInterface paramQQAppInterface, View paramView, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    String str = this.jdField_a_of_type_JavaLangString;
    CrmUtils.a(localQQAppInterface, localContext, str, CrmUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.eqq.CrmIvrText.1
 * JD-Core Version:    0.7.0.1
 */