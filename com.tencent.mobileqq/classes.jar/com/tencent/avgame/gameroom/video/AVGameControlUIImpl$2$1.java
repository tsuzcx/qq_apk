package com.tencent.avgame.gameroom.video;

import com.tencent.av.app.MSFNetInfoMonitor;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameMediaPlayerCtrl;

class AVGameControlUIImpl$2$1
  implements Runnable
{
  AVGameControlUIImpl$2$1(AVGameControlUIImpl.2 param2) {}
  
  public void run()
  {
    if (this.a.a.d()) {
      return;
    }
    IAVGameMediaPlayerCtrl localIAVGameMediaPlayerCtrl = AVGameBusinessCtrl.b().n();
    if (localIAVGameMediaPlayerCtrl != null) {
      localIAVGameMediaPlayerCtrl.a(this.a.a.h);
    }
    if (this.a.a.o != null) {
      this.a.a.o.b();
    }
    AVGameControlUIImpl.a(this.a.a);
    AVGameControlUIImpl.b(this.a.a);
    AVGameControlUIImpl.c(this.a.a);
    boolean bool1;
    if (MSFNetInfoMonitor.b() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2 = GameEngine.a().d();
    int i = AVGameBusinessCtrl.b().i();
    if ((bool2) && (i == 1)) {
      AVGameControlUIImpl.a(this.a.a, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameroom.video.AVGameControlUIImpl.2.1
 * JD-Core Version:    0.7.0.1
 */