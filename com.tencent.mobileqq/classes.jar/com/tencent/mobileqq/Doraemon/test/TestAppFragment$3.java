package com.tencent.mobileqq.Doraemon.test;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.Doraemon.IDoraemonService;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;

class TestAppFragment$3
  implements DialogInterface.OnClickListener
{
  TestAppFragment$3(TestAppFragment paramTestAppFragment, EditText paramEditText1, EditText paramEditText2) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_AndroidWidgetEditText.getText().toString();
    Object localObject1 = this.b.getText().toString();
    if ((!TextUtils.isEmpty(paramDialogInterface)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment;
      ((TestAppFragment)localObject2).c = paramDialogInterface;
      ((TestAppFragment)localObject2).jdField_a_of_type_Int = Integer.parseInt((String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_ComTencentMobileqqDoraemonDoraemonAPIManager = ((IDoraemonService)QRoute.api(IDoraemonService.class)).createAPIManager(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getQBaseActivity(), this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.jdField_a_of_type_Int, paramDialogInterface);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getActivity();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("appid切换为:");
      ((StringBuilder)localObject2).append(paramDialogInterface);
      QQToast.a((Context)localObject1, ((StringBuilder)localObject2).toString(), 1).a();
      return;
    }
    QQToast.a(this.jdField_a_of_type_ComTencentMobileqqDoraemonTestTestAppFragment.getQBaseActivity(), HardCodeUtil.a(2131714658), 1).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.test.TestAppFragment.3
 * JD-Core Version:    0.7.0.1
 */