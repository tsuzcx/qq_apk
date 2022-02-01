package com.tencent.mobileqq.activity.aio.core;

import android.content.Context;
import android.os.Build;
import com.tencent.mobileqq.widget.ToastStyleDialog;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$35
  implements Runnable
{
  BaseChatPie$35(BaseChatPie paramBaseChatPie, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.this$0.b, 2, "recorderVolumeChange " + this.a);
    }
    if (this.a == 1) {
      if (!this.this$0.l()) {
        QLog.i(this.this$0.b, 1, "volueme state err" + Build.MANUFACTURER + Build.MODEL);
      }
    }
    while (((this.a != 2) && (this.a != 0)) || (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog == null) || (!this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()) || (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.getWindow() == null))
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog != null) && (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.isShowing()));
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = new ToastStyleDialog(this.this$0.jdField_a_of_type_AndroidContentContext);
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.a(this.this$0.jdField_a_of_type_AndroidContentContext.getString(2131698523));
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.show();
      return;
    }
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog.dismiss();
    this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetToastStyleDialog = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.core.BaseChatPie.35
 * JD-Core Version:    0.7.0.1
 */