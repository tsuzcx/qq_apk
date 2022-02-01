package com.tencent.mobileqq.ar.codeEngine;

import apnh;
import com.tencent.qphone.base.util.QLog;

public class MiniRecog$2
  implements Runnable
{
  public MiniRecog$2(apnh paramapnh) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QRSession.MiniRecog", 2, "[------ onDetectReady------]");
    }
    this.this$0.a = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniRecog.2
 * JD-Core Version:    0.7.0.1
 */