package com.tencent.mobileqq.activity.phone;

import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;

class PhoneContactStatusCheckView$1
  implements Runnable
{
  PhoneContactStatusCheckView$1(PhoneContactStatusCheckView paramPhoneContactStatusCheckView) {}
  
  public void run()
  {
    Object localObject1 = this.this$0.getResources();
    Object localObject3 = new BitmapFactory.Options();
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
    BitmapFactory.decodeResource(this.this$0.getResources(), 2130845013, (BitmapFactory.Options)localObject3);
    ((BitmapFactory.Options)localObject3).inSampleSize = ImageUtil.a((BitmapFactory.Options)localObject3, ((Resources)localObject1).getDimensionPixelSize(2131297186), ((Resources)localObject1).getDimensionPixelSize(2131297184));
    ((BitmapFactory.Options)localObject3).inJustDecodeBounds = false;
    Object localObject2;
    try
    {
      localObject1 = BitmapFactory.decodeResource((Resources)localObject1, 2130845013, (BitmapFactory.Options)localObject3);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
      QLog.i("PhoneContactStatusCheckView", 1, "");
      localObject2 = null;
    }
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("loadIcon bmg: ");
      ((StringBuilder)localObject3).append(localObject2);
      QLog.i("PhoneContactStatusCheckView", 2, ((StringBuilder)localObject3).toString());
    }
    PhoneContactStatusCheckView.a(this.this$0).post(new PhoneContactStatusCheckView.1.1(this, localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.phone.PhoneContactStatusCheckView.1
 * JD-Core Version:    0.7.0.1
 */