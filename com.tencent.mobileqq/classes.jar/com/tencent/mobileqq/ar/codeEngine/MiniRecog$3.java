package com.tencent.mobileqq.ar.codeEngine;

import akvc;
import com.tencent.qphone.base.util.QLog;

public class MiniRecog$3
  implements Runnable
{
  public MiniRecog$3(akvc paramakvc) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QRSession.MiniRecog", 2, "[------ onDetectReady------]");
    }
    this.this$0.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniRecog.3
 * JD-Core Version:    0.7.0.1
 */