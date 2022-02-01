package com.tencent.mobileqq.activity.recent.specialcare;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

class CareNotificationBar$3$2$1
  implements Runnable
{
  CareNotificationBar$3$2$1(CareNotificationBar.3.2 param2) {}
  
  public void run()
  {
    if (this.a.a.a.getParent() != null)
    {
      this.a.a.a.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("CareNotificationBar", 2, "onAnimationEnd-->clearAnimation");
      }
      Object localObject = this.a.a.a.getTag(2131443128);
      if ((localObject instanceof Drawable))
      {
        this.a.a.a.setBackgroundDrawable((Drawable)localObject);
        this.a.a.a.setTag(2131443128, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3.2.1
 * JD-Core Version:    0.7.0.1
 */