package com.tencent.mobileqq.activity.aio.avatardoubletap;

import android.animation.ObjectAnimator;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.multiaio.MultiAIOStarter;
import com.tencent.mobileqq.vas.avatar.VasAvatar;
import com.tencent.qphone.base.util.QLog;

public class DoubleTapEffect
{
  private VasAvatar a;
  
  public DoubleTapEffect(VasAvatar paramVasAvatar)
  {
    this.a = paramVasAvatar;
  }
  
  private void a(View paramView)
  {
    paramView.setPivotX(paramView.getWidth() * 0.5F);
    paramView.setPivotY(paramView.getHeight() * 1.0F);
    Property localProperty = View.ROTATION;
    float f1 = -10;
    float f2 = 10;
    paramView = ObjectAnimator.ofFloat(paramView, localProperty, new float[] { 0.0F, f1, 0.0F, f2, 0.0F, f1, 0.0F, f2, 0.0F });
    paramView.setDuration(300L);
    paramView.addListener(new DoubleTapEffect.1(this));
    paramView.start();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("DoubleTapEffect", 2, "start() called");
    }
    a(this.a);
    View localView = ((ViewGroup)this.a.getParent()).findViewById(2131364541);
    if ((localView != null) && (localView.isShown())) {
      a(localView);
    }
    MultiAIOStarter.a(20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.avatardoubletap.DoubleTapEffect
 * JD-Core Version:    0.7.0.1
 */