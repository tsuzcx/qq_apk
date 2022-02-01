package com.tencent.biz.subscribe.part;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;

final class ViewUtils$1
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = ViewUtils.a(this.jdField_a_of_type_AndroidViewView.getResources(), this.jdField_a_of_type_Int, Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getWidth()), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getHeight()));
    QLog.d("ViewUtils", 2, " qrWhiteBitmap = " + localBitmap);
    if (localBitmap != null) {}
    try
    {
      StackBlur.a(localBitmap, this.b);
      this.jdField_a_of_type_AndroidViewView.post(new ViewUtils.1.1(this, localBitmap));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.part.ViewUtils.1
 * JD-Core Version:    0.7.0.1
 */