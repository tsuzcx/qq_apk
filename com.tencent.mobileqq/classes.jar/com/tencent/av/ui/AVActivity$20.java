package com.tencent.av.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.SeqUtil;

class AVActivity$20
  extends Handler
{
  AVActivity$20(AVActivity paramAVActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 272)
    {
      super.handleMessage(paramMessage);
      return;
    }
    long l = SeqUtil.a(paramMessage.obj);
    this.a.a(l, "handleMessage", true);
    if (this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl != null) {
      this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.n();
    }
    if (this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI != null) {
      this.a.jdField_a_of_type_ComTencentAvUiVideoLayerUI.l(this.a.jdField_a_of_type_ComTencentAvUiQavVideoRecordUICtrl.a);
    }
    this.a.g(-1031L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVActivity.20
 * JD-Core Version:    0.7.0.1
 */