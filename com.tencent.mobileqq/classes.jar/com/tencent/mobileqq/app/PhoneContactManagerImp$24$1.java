package com.tencent.mobileqq.app;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$24$1
  implements Runnable
{
  PhoneContactManagerImp$24$1(PhoneContactManagerImp.24 param24, Bitmap paramBitmap) {}
  
  public void run()
  {
    if (this.a != null) {
      this.this$0.a.setImageBitmap(this.a);
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContact.Manager", 2, "loadIconAsync end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.PhoneContactManagerImp.24.1
 * JD-Core Version:    0.7.0.1
 */