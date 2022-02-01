package com.tencent.biz.qrcode.util;

import android.graphics.Bitmap;
import android.view.View;
import bgsn;
import com.tencent.qphone.base.util.QLog;
import zvc;

public final class QRUtils$3
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = zvc.a(this.jdField_a_of_type_AndroidContentResResources, this.jdField_a_of_type_Int, Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getWidth()), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getHeight()));
    QLog.d("QRUtils", 2, " qrWhiteBitmap = " + localBitmap);
    if (localBitmap != null) {}
    try
    {
      bgsn.a(localBitmap, this.b);
      if (this.jdField_a_of_type_AndroidViewView != null) {
        this.jdField_a_of_type_AndroidViewView.post(new QRUtils.3.1(this, localBitmap));
      }
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.biz.qrcode.util.QRUtils.3
 * JD-Core Version:    0.7.0.1
 */