package com.tencent.av.ui;

import android.view.View;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.redtouch.RedTouch;
import lvi;

class AVActivity$9
  implements Runnable
{
  AVActivity$9(AVActivity paramAVActivity, View paramView) {}
  
  public void run()
  {
    VideoAppInterface localVideoAppInterface = this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface == null) {}
    do
    {
      do
      {
        return;
      } while ((this.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch != null) || (this.this$0.isDestroyed()));
      this.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch = lvi.a(localVideoAppInterface, this.a, 1);
    } while ((this.a.getVisibility() != 8) || (this.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch == null));
    this.this$0.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.9
 * JD-Core Version:    0.7.0.1
 */