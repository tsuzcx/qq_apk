package com.tencent.biz.qqcircle;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

final class QCirclePluginUtil$4
  implements Runnable
{
  QCirclePluginUtil$4(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void run()
  {
    Object localObject = new Rect();
    this.a.setEnabled(true);
    this.a.getHitRect((Rect)localObject);
    ((Rect)localObject).top -= this.b;
    ((Rect)localObject).bottom += this.c;
    ((Rect)localObject).left -= this.d;
    ((Rect)localObject).right += this.e;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" bounds.top=");
      localStringBuilder.append(((Rect)localObject).top);
      localStringBuilder.append("bounds.bottom=");
      localStringBuilder.append(((Rect)localObject).bottom);
      localStringBuilder.append(" bounds.top=");
      localStringBuilder.append(((Rect)localObject).top);
      localStringBuilder.append("bounds.bottom=");
      localStringBuilder.append(((Rect)localObject).bottom);
      QLog.d("TouchDelegate", 2, localStringBuilder.toString());
    }
    localObject = new TouchDelegate((Rect)localObject, this.a);
    if ((this.a.getParent() instanceof View)) {
      ((View)this.a.getParent()).setTouchDelegate((TouchDelegate)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.QCirclePluginUtil.4
 * JD-Core Version:    0.7.0.1
 */