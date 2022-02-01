package com.tencent.avgame.gameroom.video;

import leo;
import mxl;
import ncp;
import ndt;
import ned;

public class AVGameControlUIImpl$2$1
  implements Runnable
{
  public AVGameControlUIImpl$2$1(ncp paramncp) {}
  
  public void run()
  {
    if (this.a.a.a()) {
      return;
    }
    ned localned = ndt.b().a();
    if (localned != null) {
      localned.a(this.a.a.a);
    }
    AVGameControlUIImpl.a(this.a.a);
    AVGameControlUIImpl.b(this.a.a);
    AVGameControlUIImpl.c(this.a.a);
    if (leo.b() == 1) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      boolean bool2 = mxl.a().a();
      int i = ndt.b().a();
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