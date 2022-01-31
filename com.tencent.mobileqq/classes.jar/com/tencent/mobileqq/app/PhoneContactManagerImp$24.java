package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

final class PhoneContactManagerImp$24
  implements Runnable
{
  PhoneContactManagerImp$24(Resources paramResources, QQAppInterface paramQQAppInterface, ImageView paramImageView) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130844197);
      localObject = localBitmap;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.i("PhoneContact.Manager", 1, "OutOfMemoryError", localOutOfMemoryError);
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        QLog.i("PhoneContact.Manager", 1, "Throwable", localThrowable);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "loadIconAsync bmp: " + localObject);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.24.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.24
 * JD-Core Version:    0.7.0.1
 */