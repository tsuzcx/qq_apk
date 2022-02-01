package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;

class DrawRedpacketPannelPreviewFragment$2
  implements DrawClassifier.OnClassifierInitListener
{
  DrawRedpacketPannelPreviewFragment$2(DrawRedpacketPannelPreviewFragment paramDrawRedpacketPannelPreviewFragment, String paramString) {}
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedpacketPannelPreviewFragment.getActivity() == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedpacketPannelPreviewFragment.getActivity().isFinishing())) {
      return;
    }
    DrawRedpacketPannelPreviewFragment.a(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawDrawRedpacketPannelPreviewFragment).post(new DrawRedpacketPannelPreviewFragment.2.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DrawRedpacketPannelPreviewFragment.2
 * JD-Core Version:    0.7.0.1
 */