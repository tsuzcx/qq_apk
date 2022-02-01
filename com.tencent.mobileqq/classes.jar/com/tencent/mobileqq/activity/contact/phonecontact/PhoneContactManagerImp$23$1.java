package com.tencent.mobileqq.activity.contact.phonecontact;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$23$1
  implements Runnable
{
  PhoneContactManagerImp$23$1(PhoneContactManagerImp.23 param23, Bitmap paramBitmap) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.23.1
 * JD-Core Version:    0.7.0.1
 */