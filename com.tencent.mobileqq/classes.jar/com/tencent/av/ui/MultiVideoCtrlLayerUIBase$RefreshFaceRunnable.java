package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.app.VideoAppInterface;

class MultiVideoCtrlLayerUIBase$RefreshFaceRunnable
  implements Runnable
{
  MultiVideoCtrlLayerUIBase$RefreshFaceRunnable(MultiVideoCtrlLayerUIBase paramMultiVideoCtrlLayerUIBase) {}
  
  public void run()
  {
    if (this.this$0.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI != null) {
      this.this$0.jdField_a_of_type_ComTencentAvUiMultiMembersAudioUI.a();
    }
    this.this$0.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 2000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.MultiVideoCtrlLayerUIBase.RefreshFaceRunnable
 * JD-Core Version:    0.7.0.1
 */