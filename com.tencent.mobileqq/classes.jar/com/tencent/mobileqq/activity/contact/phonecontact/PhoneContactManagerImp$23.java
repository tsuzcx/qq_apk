package com.tencent.mobileqq.activity.contact.phonecontact;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

final class PhoneContactManagerImp$23
  implements Runnable
{
  PhoneContactManagerImp$23(Resources paramResources, QQAppInterface paramQQAppInterface, ImageView paramImageView) {}
  
  public void run()
  {
    Object localObject = null;
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentResResources, 2130844976);
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new PhoneContactManagerImp.23.1(this, localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.23
 * JD-Core Version:    0.7.0.1
 */