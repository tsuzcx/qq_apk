package com.tencent.mobileqq.app;

import amcf;
import android.graphics.Rect;

class ScreenShot$1
  implements Runnable
{
  ScreenShot$1(ScreenShot paramScreenShot, amcf paramamcf) {}
  
  public void run()
  {
    if (!this.a.jdField_a_of_type_Boolean) {
      this.a.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
    }
    this.a.invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.1
 * JD-Core Version:    0.7.0.1
 */