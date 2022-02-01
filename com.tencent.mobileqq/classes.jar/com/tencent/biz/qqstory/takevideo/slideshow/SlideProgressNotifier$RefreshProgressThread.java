package com.tencent.biz.qqstory.takevideo.slideshow;

import bkym;
import com.tencent.qphone.base.util.QLog;
import yzn;

public class SlideProgressNotifier$RefreshProgressThread
  extends Thread
{
  int jdField_a_of_type_Int;
  yzn jdField_a_of_type_Yzn;
  boolean jdField_a_of_type_Boolean = false;
  int b;
  int c;
  int d;
  
  public SlideProgressNotifier$RefreshProgressThread(int paramInt1, int paramInt2, int paramInt3, yzn paramyzn)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (paramInt2 - paramInt3 > 0) {}
    for (this.c = (paramInt1 / (paramInt2 - paramInt3));; this.c = 100)
    {
      this.d = paramInt3;
      this.jdField_a_of_type_Yzn = paramyzn;
      return;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQProgressNotifier", 2, "cancel progress update thread, stack trace : " + bkym.a(new RuntimeException()));
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void run()
  {
    while (!this.jdField_a_of_type_Boolean) {
      if (this.d < this.b)
      {
        if (this.jdField_a_of_type_Yzn != null)
        {
          this.jdField_a_of_type_Yzn.a(this.d);
          this.d += 1;
          try
          {
            Thread.sleep(this.c);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
        }
      }
      else
      {
        this.d = this.b;
        if (this.jdField_a_of_type_Yzn != null) {
          this.jdField_a_of_type_Yzn.a(this.d);
        }
        this.jdField_a_of_type_Boolean = true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.SlideProgressNotifier.RefreshProgressThread
 * JD-Core Version:    0.7.0.1
 */