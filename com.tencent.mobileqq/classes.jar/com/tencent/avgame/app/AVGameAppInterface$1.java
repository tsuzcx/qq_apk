package com.tencent.avgame.app;

import com.tencent.qphone.base.util.QLog;
import ndn;

class AVGameAppInterface$1
  implements Runnable
{
  AVGameAppInterface$1(AVGameAppInterface paramAVGameAppInterface) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "register broadcast for av game.");
    }
    if (AVGameAppInterface.a(this.this$0) != null) {
      AVGameAppInterface.a(this.this$0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface.1
 * JD-Core Version:    0.7.0.1
 */