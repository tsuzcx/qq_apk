package com.tencent.aelight.camera.aioeditor.shortvideo.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.tencent.qphone.base.util.QLog;

class TCProgressBar$ProgressBlock
  extends TCProgressBar.Draw
{
  int jdField_a_of_type_Int;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  boolean g;
  boolean h = false;
  
  TCProgressBar$ProgressBlock(TCProgressBar paramTCProgressBar, boolean paramBoolean)
  {
    super(paramTCProgressBar);
    this.jdField_g_of_type_Boolean = false;
    this.c = paramBoolean;
  }
  
  void a(Canvas paramCanvas)
  {
    if (this.c)
    {
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.jdField_g_of_type_Int);
      paramCanvas.drawRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a);
      this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.h);
    }
    else
    {
      int i;
      if (this.jdField_f_of_type_Boolean)
      {
        i = this.jdField_g_of_type_Int;
      }
      else
      {
        i = this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.l;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.left = (this.jdField_f_of_type_Int + i);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + this.jdField_g_of_type_Int);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.k);
        paramCanvas.drawRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a);
      }
      boolean bool = a(this.jdField_a_of_type_Int - 5);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ProgressBlock:hasMorePart=");
        localStringBuilder.append(this.jdField_a_of_type_Boolean);
        localStringBuilder.append(" bounds=");
        localStringBuilder.append(bool);
        QLog.d("TCProgressBar", 2, localStringBuilder.toString());
      }
      if ((this.jdField_a_of_type_Boolean) && (bool))
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.right = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.i);
        paramCanvas.drawRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.left = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + i);
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.j);
        paramCanvas.drawRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a);
      }
      else
      {
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.left = this.jdField_f_of_type_Int;
        this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b.right = (this.jdField_f_of_type_Int + i);
        if (this.b) {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.j);
        } else {
          this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a.setColor(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.i);
        }
        paramCanvas.drawRect(this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.b, this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.a);
      }
    }
    super.a(paramCanvas);
  }
  
  boolean a(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int) && (paramInt < this.jdField_f_of_type_Int + this.jdField_g_of_type_Int - this.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoWidgetTCProgressBar.l);
  }
  
  boolean b(int paramInt)
  {
    return (paramInt < this.jdField_f_of_type_Int) || (a(paramInt));
  }
  
  boolean c(int paramInt)
  {
    return (paramInt > this.jdField_f_of_type_Int + this.jdField_g_of_type_Int) || (a(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.widget.TCProgressBar.ProgressBlock
 * JD-Core Version:    0.7.0.1
 */