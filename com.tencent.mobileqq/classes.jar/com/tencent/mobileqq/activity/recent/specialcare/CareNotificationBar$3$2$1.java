package com.tencent.mobileqq.activity.recent.specialcare;

import almt;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class CareNotificationBar$3$2$1
  implements Runnable
{
  public CareNotificationBar$3$2$1(almt paramalmt) {}
  
  public void run()
  {
    if (this.a.a.a.getParent() != null)
    {
      this.a.a.a.clearAnimation();
      if (QLog.isColorLevel()) {
        QLog.i("CareNotificationBar", 2, "onAnimationEnd-->clearAnimation");
      }
      Object localObject = this.a.a.a.getTag(2131375047);
      if ((localObject instanceof Drawable))
      {
        this.a.a.a.setBackgroundDrawable((Drawable)localObject);
        this.a.a.a.setTag(2131375047, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.specialcare.CareNotificationBar.3.2.1
 * JD-Core Version:    0.7.0.1
 */