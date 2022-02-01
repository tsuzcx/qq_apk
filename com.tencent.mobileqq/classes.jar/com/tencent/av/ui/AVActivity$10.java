package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redtouch.AVRedTouchUtil;
import com.tencent.mobileqq.tianshu.ui.RedTouch;

class AVActivity$10
  implements Runnable
{
  AVActivity$10(AVActivity paramAVActivity, View paramView) {}
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface == null) {
      return;
    }
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch == null) && (!this.this$0.isDestroyed()))
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch = AVRedTouchUtil.a(localVideoAppInterface, this.a, 1);
      if ((this.a.getVisibility() == 8) && (this.this$0.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch != null)) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqTianshuUiRedTouch.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.10
 * JD-Core Version:    0.7.0.1
 */