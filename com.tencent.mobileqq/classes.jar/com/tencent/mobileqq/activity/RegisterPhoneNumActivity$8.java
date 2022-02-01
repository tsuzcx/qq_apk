package com.tencent.mobileqq.activity;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class RegisterPhoneNumActivity$8
  implements Runnable
{
  RegisterPhoneNumActivity$8(View paramView, int paramInt) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.a.setEnabled(true);
    this.a.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.b;
    ((Rect)localObject).bottom += this.b;
    ((Rect)localObject).left -= this.b;
    ((Rect)localObject).right += this.b;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" bounds.top=");
      localStringBuilder.append(((Rect)localObject).top);
      localStringBuilder.append("bounds.bottom=");
      localStringBuilder.append(((Rect)localObject).bottom);
      QLog.d("TouchDelegate", 2, localStringBuilder.toString());
    }
    localObject = new TouchDelegate((Rect)localObject, this.a);
    if (View.class.isInstance(this.a.getParent())) {
      ((View)this.a.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.RegisterPhoneNumActivity.8
 * JD-Core Version:    0.7.0.1
 */