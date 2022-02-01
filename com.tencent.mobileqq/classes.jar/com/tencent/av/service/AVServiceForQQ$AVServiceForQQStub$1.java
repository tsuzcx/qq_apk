package com.tencent.av.service;

import com.tencent.qphone.base.util.QLog;
import lvr;

public class AVServiceForQQ$AVServiceForQQStub$1
  implements Runnable
{
  public AVServiceForQQ$AVServiceForQQStub$1(lvr paramlvr) {}
  
  public void run()
  {
    try
    {
      this.a.a.startForeground(235, this.a.a.jdField_a_of_type_AndroidAppNotification);
      QLog.d(this.a.a.jdField_a_of_type_JavaLangString, 1, "setAvServiceForegroud start foreground.");
      return;
    }
    catch (Exception localException)
    {
      QLog.d(this.a.a.jdField_a_of_type_JavaLangString, 1, "setAVServiceForegroud, e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
 * JD-Core Version:    0.7.0.1
 */