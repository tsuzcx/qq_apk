package com.tencent.avgame.gameroom.video;

import leu;
import nfc;
import nmb;
import nnm;
import nnw;

public class AVGameControlUIImpl$2$1
  implements Runnable
{
  public AVGameControlUIImpl$2$1(nmb paramnmb) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    nnw localnnw = nnm.b().a();
    if (localnnw != null) {
      localnnw.a(this.a.a.jdField_a_of_type_Nmq);
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.a.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.a();
    }
    AVGameControlUIImpl.a(this.a.a);
    AVGameControlUIImpl.b(this.a.a);
    AVGameControlUIImpl.c(this.a.a);
    if (leu.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = nfc.a().a();
      int i = nnm.b().a();
      if ((!bool2) || (i != 1)) {
        break;
      }
      AVGameControlUIImpl.a(this.a.a, bool1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.1
 * JD-Core Version:    0.7.0.1
 */