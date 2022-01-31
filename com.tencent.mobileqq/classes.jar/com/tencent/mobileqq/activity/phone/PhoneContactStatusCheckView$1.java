package com.tencent.mobileqq.activity.phone;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import bbdr;
import com.tencent.qphone.base.util.QLog;

class PhoneContactStatusCheckView$1
  implements Runnable
{
  PhoneContactStatusCheckView$1(PhoneContactStatusCheckView paramPhoneContactStatusCheckView) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.getResources();
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.this$0.getResources(), 2130844196, localOptions);
    localOptions.inSampleSize = bbdr.a(localOptions, ((Resources)localObject2).getDimensionPixelSize(2131297045), ((Resources)localObject2).getDimensionPixelSize(2131297043));
    localOptions.inJustDecodeBounds = false;
    Object localObject1 = null;
    try
    {
      localObject2 = BitmapFactory.decodeResource((Resources)localObject2, 2130844196, localOptions);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        localOutOfMemoryError.printStackTrace();
        QLog.i("PhoneContactStatusCheckView", 1, "");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("PhoneContactStatusCheckView", 2, "loadIcon bmg: " + localObject1);
    }
    PhoneContactStatusCheckView.a(this.this$0).post(new PhoneContactStatusCheckView.1.1(this, localObject1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView.1
 * JD-Core Version:    0.7.0.1
 */