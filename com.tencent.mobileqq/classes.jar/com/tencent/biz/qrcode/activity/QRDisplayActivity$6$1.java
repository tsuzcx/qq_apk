package com.tencent.biz.qrcode.activity;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import antl;
import bheg;
import com.tencent.mobileqq.app.QQAppInterface;

class QRDisplayActivity$6$1
  implements Runnable
{
  QRDisplayActivity$6$1(QRDisplayActivity.6 param6) {}
  
  public void run()
  {
    Object localObject;
    if (this.a.this$0.jdField_c_of_type_Int == 1)
    {
      this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.getFaceBitmap(this.a.this$0.jdField_c_of_type_JavaLangString, false);
      QRDisplayActivity localQRDisplayActivity = this.a.this$0;
      if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localObject = bheg.a(true);
        localQRDisplayActivity.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
    }
    for (;;)
    {
      if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a();
      }
      return;
      localObject = bheg.a(this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
      break;
      if (this.a.this$0.jdField_c_of_type_Int == 2)
      {
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = this.a.this$0.app.getTroopFaceBitmap(this.a.this$0.jdField_c_of_type_JavaLangString, (byte)3, false, false);
        if (this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap == null) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bheg.f();
        }
        this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = bheg.a(this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap, 50, 50);
      }
      else
      {
        localObject = this.a.this$0.jdField_a_of_type_Antl.a(this.a.this$0.jdField_c_of_type_JavaLangString, true);
        if ((localObject instanceof BitmapDrawable)) {
          this.a.this$0.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject).getBitmap();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.6.1
 * JD-Core Version:    0.7.0.1
 */