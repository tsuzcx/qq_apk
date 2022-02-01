package com.tencent.biz.richframework.part;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.mobileqq.utils.StackBlur;
import com.tencent.qphone.base.util.QLog;
import yzh;

public final class ViewUtils$1
  implements Runnable
{
  public void run()
  {
    Bitmap localBitmap = yzh.a(this.jdField_a_of_type_AndroidViewView.getResources(), this.jdField_a_of_type_Int, Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getWidth()), Integer.valueOf(this.jdField_a_of_type_AndroidViewView.getHeight()));
    QLog.d("ViewUtils", 2, " qrWhiteBitmap = " + localBitmap);
    if (localBitmap != null) {}
    try
    {
      StackBlur.fastblur(localBitmap, this.b);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.part.ViewUtils.1
 * JD-Core Version:    0.7.0.1
 */