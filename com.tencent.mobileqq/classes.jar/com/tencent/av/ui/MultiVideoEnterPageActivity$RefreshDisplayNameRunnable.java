package com.tencent.av.ui;

import android.os.Handler;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import mhc;

class MultiVideoEnterPageActivity$RefreshDisplayNameRunnable
  implements Runnable
{
  MultiVideoEnterPageActivity$RefreshDisplayNameRunnable(MultiVideoEnterPageActivity paramMultiVideoEnterPageActivity) {}
  
  public void run()
  {
    Object localObject = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getApp().getString(2131694762);
    if (this.this$0.jdField_c_of_type_Int == 2) {
      localObject = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(3000, String.valueOf(this.this$0.jdField_a_of_type_Long), null);
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_Mhc.a.setText((CharSequence)localObject);
      localObject = this.this$0;
      ((MultiVideoEnterPageActivity)localObject).g += 1;
      if (this.this$0.jdField_c_of_type_JavaLangRunnable != null)
      {
        if (this.this$0.g >= 3) {
          break;
        }
        this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this.this$0.jdField_c_of_type_JavaLangRunnable, 1000L);
      }
      return;
      if (this.this$0.jdField_c_of_type_Int == 1) {
        localObject = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getDisplayName(1, String.valueOf(this.this$0.jdField_a_of_type_Long), null);
      }
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this.this$0.jdField_c_of_type_JavaLangRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoEnterPageActivity.RefreshDisplayNameRunnable
 * JD-Core Version:    0.7.0.1
 */