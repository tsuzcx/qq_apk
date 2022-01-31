package com.tencent.av.service;

import com.tencent.qphone.base.util.QLog;
import lyt;

public class AVServiceForQQ$AVServiceForQQStub$1
  implements Runnable
{
  public AVServiceForQQ$AVServiceForQQStub$1(lyt paramlyt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.service.AVServiceForQQ.AVServiceForQQStub.1
 * JD-Core Version:    0.7.0.1
 */