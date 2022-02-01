package com.tencent.avgame.gameroom.video;

import lev;
import myk;
import nec;
import nfm;
import nfw;

public class AVGameControlUIImpl$2$1
  implements Runnable
{
  public AVGameControlUIImpl$2$1(nec paramnec) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    nfw localnfw = nfm.b().a();
    if (localnfw != null) {
      localnfw.a(this.a.a.jdField_a_of_type_Ner);
    }
    if (this.a.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager != null) {
      this.a.a.jdField_a_of_type_ComTencentAvgameGameroomVideoAVGameNetWorkQualityManager.a();
    }
    AVGameControlUIImpl.a(this.a.a);
    AVGameControlUIImpl.b(this.a.a);
    AVGameControlUIImpl.c(this.a.a);
    if (lev.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = myk.a().a();
      int i = nfm.b().a();
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