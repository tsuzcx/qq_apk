package com.tencent.mobileqq.activity.aio.doodle;

import android.graphics.drawable.Drawable;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;

class DoodleMsgLayout$3$1
  implements Runnable
{
  DoodleMsgLayout$3$1(DoodleMsgLayout.3 param3, Drawable paramDrawable) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDoodleContent start update drawable:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.a);
    QLog.d("DoodleMsgLayout", 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.a != DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0)) {
      return;
    }
    if (DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0) != null) {
      DoodleMsgLayout.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0) != null) {
      DoodleMsgLayout.c(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0).setImageDrawable(null);
    }
    if (DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0) != null) {
      DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0).setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
    DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0, 0);
    if (DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0) != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0.a(DoodleMsgLayout.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.this$0).a());
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("setDoodleContent finish update drawable:");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleMsgLayout$3.a);
    QLog.d("DoodleMsgLayout", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleMsgLayout.3.1
 * JD-Core Version:    0.7.0.1
 */