package com.tencent.av.ui;

import com.tencent.mobileqq.vipav.VipFullScreenVideoView;

class AVActivity$5
  implements Runnable
{
  AVActivity$5(AVActivity paramAVActivity) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView != null)
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.isPlaying()) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.stopPlayback();
      }
      if ((this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI != null) && ((this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI instanceof DoubleVideoCtrlUI))) {
        ((DoubleVideoCtrlUI)this.this$0.jdField_a_of_type_ComTencentAvUiVideoControlUI).b(false);
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqVipavVipFullScreenVideoView.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.5
 * JD-Core Version:    0.7.0.1
 */