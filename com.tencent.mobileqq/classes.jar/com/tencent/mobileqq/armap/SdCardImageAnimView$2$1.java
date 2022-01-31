package com.tencent.mobileqq.armap;

import android.graphics.Bitmap;
import com.tencent.qphone.base.util.QLog;

class SdCardImageAnimView$2$1
  implements Runnable
{
  SdCardImageAnimView$2$1(SdCardImageAnimView.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("SdCardImageAnimView", 2, "defaultImgRunnable set image bitmap");
    }
    this.jdField_a_of_type_ComTencentMobileqqArmapSdCardImageAnimView$2.this$0.setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SdCardImageAnimView.2.1
 * JD-Core Version:    0.7.0.1
 */