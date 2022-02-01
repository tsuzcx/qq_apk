package com.tencent.biz.qrcode.activity;

import amqx;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import bfvo;
import com.tencent.mobileqq.app.QQAppInterface;

class QRDisplayActivity$4$1
  implements Runnable
{
  QRDisplayActivity$4$1(QRDisplayActivity.4 param4) {}
  
  public void run()
  {
    Object localObject;
    if (this.a.this$0.jdField_c_of_type_Int == 1)
    {
      this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.getFaceBitmap(this.a.this$0.jdField_c_of_type_JavaLangString, false);
      QRDisplayActivity localQRDisplayActivity = this.a.this$0;
      if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localObject = bfvo.a(true);
        localQRDisplayActivity.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
    }
    for (;;)
    {
      if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a();
      }
      return;
      localObject = bfvo.a(this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
      break;
      if (this.a.this$0.jdField_c_of_type_Int == 2)
      {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.getTroopFaceBitmap(this.a.this$0.jdField_c_of_type_JavaLangString, (byte)3, false, false);
        if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.f();
        }
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bfvo.a(this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
      }
      else
      {
        localObject = this.a.this$0.jdField_a_of_type_Amqx.a(this.a.this$0.jdField_c_of_type_JavaLangString, true);
        if ((localObject instanceof BitmapDrawable)) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject).getBitmap();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.4.1
 * JD-Core Version:    0.7.0.1
 */