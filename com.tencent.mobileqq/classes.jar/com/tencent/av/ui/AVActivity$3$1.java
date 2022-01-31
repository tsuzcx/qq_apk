package com.tencent.av.ui;

import android.view.View;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3$1
  implements Runnable
{
  AVActivity$3$1(AVActivity.3 param3, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.isDestroyed()) {}
    View localView;
    do
    {
      return;
      QLog.w(this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.b, 1, "qav_UserGuide_for_more, 开始显示, seq[" + this.jdField_a_of_type_Long + "]");
      localView = this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.findViewById(2131306684);
    } while ((localView == null) || (this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a == null) || (!this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a.h()));
    this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a.y(this.jdField_a_of_type_Long);
    localView.setVisibility(0);
    localView.setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3.1
 * JD-Core Version:    0.7.0.1
 */