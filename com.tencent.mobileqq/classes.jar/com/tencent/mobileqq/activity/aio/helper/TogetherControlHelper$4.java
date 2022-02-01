package com.tencent.mobileqq.activity.aio.helper;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.together.TogetherSession;
import com.tencent.mobileqq.widget.QQToast;

class TogetherControlHelper$4
  implements DialogInterface.OnClickListener
{
  TogetherControlHelper$4(TogetherControlHelper paramTogetherControlHelper, TogetherControlManager paramTogetherControlManager, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherControlManager.a("video_tab", "clk_joinframe_join", 0, TogetherControlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTogetherControlHelper).b());
    paramDialogInterface.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqTogetherTogetherControlManager.a(2, 1, TogetherControlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTogetherControlHelper).b());
    if ((paramDialogInterface == null) || (paramDialogInterface.h == 3))
    {
      QQToast.a(TogetherControlHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTogetherControlHelper), 0, this.jdField_a_of_type_JavaLangString, 0).a();
      return;
    }
    TogetherControlHelper.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioHelperTogetherControlHelper);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TogetherControlHelper.4
 * JD-Core Version:    0.7.0.1
 */