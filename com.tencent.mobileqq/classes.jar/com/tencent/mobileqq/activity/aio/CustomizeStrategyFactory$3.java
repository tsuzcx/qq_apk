package com.tencent.mobileqq.activity.aio;

import afxn;
import akww;
import com.tencent.qphone.base.util.QLog;

class CustomizeStrategyFactory$3
  implements Runnable
{
  CustomizeStrategyFactory$3(CustomizeStrategyFactory paramCustomizeStrategyFactory, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo) {}
  
  public void run()
  {
    try
    {
      this.a.jdField_a_of_type_ArrayOfAndroidGraphicsDrawableDrawable = akww.a(this.a.jdField_a_of_type_Afxn.a);
      this.a.c = true;
      if (QLog.isColorLevel()) {
        QLog.d("CustomizeStrategyFactory", 2, "preProcessAnim-preProcess finished");
      }
      CustomizeStrategyFactory.a().a(this.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CustomizeStrategyFactory", 2, "preProcessAnim-throw:" + localThrowable);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.3
 * JD-Core Version:    0.7.0.1
 */