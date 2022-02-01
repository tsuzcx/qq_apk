package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.graphics.Canvas;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$Draw
{
  boolean d = true;
  boolean e = true;
  int jdField_f_of_type_Int;
  boolean jdField_f_of_type_Boolean = false;
  int g;
  
  TCProgressBar$Draw(TCProgressBar paramTCProgressBar) {}
  
  void a(Canvas paramCanvas)
  {
    this.jdField_f_of_type_Boolean = false;
  }
  
  boolean a(float paramFloat)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkBounds,x = ");
      localStringBuilder.append(paramFloat);
      localStringBuilder.append(",x_coord = ");
      localStringBuilder.append(this.jdField_f_of_type_Int);
      localStringBuilder.append(",x_coord + length = ");
      localStringBuilder.append(this.jdField_f_of_type_Int + this.g);
      QLog.d("TCProgressBar", 2, localStringBuilder.toString());
    }
    int i = this.jdField_f_of_type_Int;
    return (paramFloat > i) && (paramFloat < i + this.g);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.Draw
 * JD-Core Version:    0.7.0.1
 */