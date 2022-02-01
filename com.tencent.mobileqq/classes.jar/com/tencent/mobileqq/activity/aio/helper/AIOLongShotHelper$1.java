package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class AIOLongShotHelper$1
  implements Runnable
{
  AIOLongShotHelper$1(AIOLongShotHelper paramAIOLongShotHelper, boolean paramBoolean1, boolean paramBoolean2, String paramString) {}
  
  public void run()
  {
    BaseActivity localBaseActivity = AIOLongShotHelper.a(this.this$0).jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
    if ((localBaseActivity != null) && (!localBaseActivity.isFinishing()))
    {
      if ((!this.jdField_a_of_type_Boolean) && (!this.b))
      {
        QQToast.a(AIOLongShotHelper.a(this.this$0).jdField_a_of_type_AndroidContentContext, 1, HardCodeUtil.a(2131700327), 0).a();
        AIOLongShotHelper.a("0X800A50D");
      }
      AIOLongShotHelper.a(this.this$0, this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper.1
 * JD-Core Version:    0.7.0.1
 */