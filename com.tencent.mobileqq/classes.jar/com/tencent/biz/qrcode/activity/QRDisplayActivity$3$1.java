package com.tencent.biz.qrcode.activity;

import alri;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import bdhj;
import com.tencent.mobileqq.app.QQAppInterface;

class QRDisplayActivity$3$1
  implements Runnable
{
  QRDisplayActivity$3$1(QRDisplayActivity.3 param3) {}
  
  public void run()
  {
    if (this.a.this$0.jdField_c_of_type_Int == 1) {
      this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.a(this.a.this$0.jdField_c_of_type_JavaLangString, false);
    }
    for (;;)
    {
      if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.a();
      }
      return;
      if (this.a.this$0.jdField_c_of_type_Int == 2)
      {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.a(this.a.this$0.jdField_c_of_type_JavaLangString, (byte)3, false, false);
        if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bdhj.f();
        }
      }
      else
      {
        Drawable localDrawable = this.a.this$0.jdField_a_of_type_Alri.a(this.a.this$0.jdField_c_of_type_JavaLangString, true);
        if ((localDrawable instanceof BitmapDrawable)) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localDrawable).getBitmap();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.3.1
 * JD-Core Version:    0.7.0.1
 */