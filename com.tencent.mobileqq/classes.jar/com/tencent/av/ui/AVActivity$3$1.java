package com.tencent.av.ui;

import android.view.View;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

class AVActivity$3$1
  implements Runnable
{
  AVActivity$3$1(AVActivity.3 param3, long paramLong) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.isDestroyed()) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("qav_UserGuide_for_more, 开始显示, seq[");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString());
    localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.findViewById(2131373524);
    if (localObject == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a == null) {
      return;
    }
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a.i()) {
      return;
    }
    if (((RelativeLayout)this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.findViewById(2131373442)).getVisibility() == 0) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiAVActivity$3.this$0.a.C(this.jdField_a_of_type_Long);
    ((View)localObject).setVisibility(0);
    ((View)localObject).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.3.1
 * JD-Core Version:    0.7.0.1
 */