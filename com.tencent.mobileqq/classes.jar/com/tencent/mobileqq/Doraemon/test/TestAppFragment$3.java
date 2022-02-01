package com.tencent.mobileqq.Doraemon.test;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.DoraemonOpenAPI;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class TestAppFragment$3
  implements DialogInterface.OnClickListener
{
  TestAppFragment$3(TestAppFragment paramTestAppFragment, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    String str = this.b.getText().toString();
    if ((TextUtils.isEmpty(paramDialogInterface)) || (TextUtils.isEmpty(str)))
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getActivity(), HardCodeUtil.a(2131714727), 1).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.c = paramDialogInterface;
    this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_Int = Integer.parseInt(str);
    this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = DoraemonOpenAPI.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_Int, paramDialogInterface);
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getActivity(), "appid切换为:" + paramDialogInterface, 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.3
 * JD-Core Version:    0.7.0.1
 */