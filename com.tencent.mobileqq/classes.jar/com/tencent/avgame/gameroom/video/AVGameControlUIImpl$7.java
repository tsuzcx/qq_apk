package com.tencent.avgame.gameroom.video;

import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.mobileqq.statistics.ReportController;

class AVGameControlUIImpl$7
  implements Runnable
{
  AVGameControlUIImpl$7(AVGameControlUIImpl paramAVGameControlUIImpl, AVGameBusinessCtrl paramAVGameBusinessCtrl, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentAvgameQavAVGameBusinessCtrl.a(this.jdField_a_of_type_Int);
    int i;
    if (this.jdField_a_of_type_Int == 1) {
      i = 1;
    } else {
      i = 2;
    }
    ReportController.b(null, "dc00898", "", "", "0X800B03B", "0X800B03B", i, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.7
 * JD-Core Version:    0.7.0.1
 */