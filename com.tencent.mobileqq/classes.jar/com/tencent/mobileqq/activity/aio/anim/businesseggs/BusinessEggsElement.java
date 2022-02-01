package com.tencent.mobileqq.activity.aio.anim.businesseggs;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;

public class BusinessEggsElement
{
  public long a;
  private boolean b;
  private View c;
  private Drawable d;
  private AIOAnimationConatiner e;
  private ListView f;
  private Point g;
  private Point h;
  private Point i;
  private BusinessEggsElement.IPathStrategy j;
  private ValueAnimator k;
  private ValueAnimator.AnimatorUpdateListener l;
  
  public BusinessEggsElement(AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    this.e = paramAIOAnimationConatiner;
    this.f = paramListView;
    this.i = new Point(ViewUtils.getScreenWidth(), ViewUtils.getScreenHeight());
  }
  
  private void a(float paramFloat)
  {
    BusinessEggsElement.IPathStrategy localIPathStrategy = this.j;
    if (localIPathStrategy != null)
    {
      this.h = localIPathStrategy.a(this.g, this.i, paramFloat);
      a(this.h);
    }
  }
  
  private void a(Point paramPoint)
  {
    View localView = this.c;
    if (localView != null)
    {
      if (paramPoint == null) {
        return;
      }
      int m = localView.getLeft();
      int n = this.c.getWidth() / 2;
      int i1 = this.c.getBottom();
      this.c.offsetTopAndBottom(paramPoint.y - i1);
      this.c.offsetLeftAndRight(paramPoint.x - (m + n));
    }
  }
  
  private View b(Drawable paramDrawable)
  {
    View localView = new View(this.f.getContext());
    localView.setBackgroundDrawable(paramDrawable);
    Rect localRect = paramDrawable.getBounds();
    if (localRect.isEmpty()) {
      localView.layout(0, 0, paramDrawable.getIntrinsicWidth() / 2, paramDrawable.getIntrinsicHeight() / 2);
    } else {
      localView.layout(0, 0, localRect.width() / 2, localRect.height() / 2);
    }
    localView.setScaleX(1.0F);
    localView.setScaleY(1.0F);
    localView.setLayerType(2, null);
    return localView;
  }
  
  private View d()
  {
    if (this.c == null)
    {
      Drawable localDrawable = this.d;
      if (localDrawable == null)
      {
        QLog.e("BusinessEggsElement", 1, "[createEggsView] drawable is null, cannot create view");
        return null;
      }
      this.c = b(localDrawable);
    }
    return this.c;
  }
  
  private void e()
  {
    if (this.k == null)
    {
      this.k = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
      f();
      this.k.addUpdateListener(this.l);
    }
  }
  
  private void f()
  {
    this.l = new BusinessEggsElement.1(this);
  }
  
  public void a(Drawable paramDrawable)
  {
    this.d = paramDrawable;
    e();
    this.c = d();
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    View localView = this.c;
    if (localView != null) {
      localView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public void a(BusinessEggsElement.IPathStrategy paramIPathStrategy)
  {
    this.j = paramIPathStrategy;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (this.b)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessEggsElement", 2, "[start] eggs animating, return");
      }
      return;
    }
    Object localObject = this.j;
    localObject = this.c;
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("BusinessEggsElement", 2, "[start] mEggsView is null");
      }
      return;
    }
    this.e.addViewInLayout((View)localObject, -1, AIOAnimationConatiner.a, false);
    this.j.a(this.k);
    this.g = this.j.a(this.i);
    this.k.start();
    this.b = true;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[start] start eggs: ");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("BusinessEggsElement", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    this.b = false;
    this.e.removeViewInLayout(this.c);
    this.k.removeAllListeners();
    this.k.removeAllUpdateListeners();
    this.c = null;
    this.d = null;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[stop] stop eggs: ");
      localStringBuilder.append(this.a);
      QLog.d("BusinessEggsElement", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.businesseggs.BusinessEggsElement
 * JD-Core Version:    0.7.0.1
 */