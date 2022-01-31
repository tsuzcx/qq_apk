package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;

class AVActivity$9$1
  implements Runnable
{
  AVActivity$9$1(AVActivity.9 param9, boolean paramBoolean) {}
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface == null) {}
    for (;;)
    {
      return;
      if (!this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.isDestroyed())
      {
        if (this.jdField_a_of_type_Boolean) {}
        for (this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = localVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiAVActivity$9.a, "105000.105100"); (this.jdField_a_of_type_ComTencentAvUiAVActivity$9.a.getVisibility() == 8) && (this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null); this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = localVideoAppInterface.a(this.jdField_a_of_type_ComTencentAvUiAVActivity$9.a, 1))
        {
          this.jdField_a_of_type_ComTencentAvUiAVActivity$9.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.9.1
 * JD-Core Version:    0.7.0.1
 */