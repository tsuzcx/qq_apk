package com.tencent.luggage.wxa.lq;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.View.OnLayoutChangeListener;
import androidx.core.view.ViewCompat;

class d$2$a
  implements View.OnAttachStateChangeListener, View.OnLayoutChangeListener
{
  TouchDelegate a;
  View b;
  View c;
  
  d$2$a(d.2 param2, View paramView)
  {
    paramView.addOnAttachStateChangeListener(this);
    paramView.setOnTouchListener(new d.2.a.1(this, param2));
    this.b = paramView;
  }
  
  private void a()
  {
    if ((this.c != null) && (ViewCompat.isAttachedToWindow(this.b)))
    {
      Object localObject = new Rect(0, 0, this.c.getWidth(), this.c.getHeight());
      View localView = this.c;
      localObject = new TouchDelegate((Rect)localObject, this.b);
      this.a = ((TouchDelegate)localObject);
      localView.setTouchDelegate((TouchDelegate)localObject);
    }
  }
  
  private void b()
  {
    View localView = this.c;
    if ((localView != null) && (localView.getTouchDelegate() == this.a)) {
      this.c.setTouchDelegate(null);
    }
    localView = this.c;
    if (localView != null) {
      localView.removeOnLayoutChangeListener(this);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    a();
  }
  
  public void onViewAttachedToWindow(View paramView)
  {
    this.c = ((View)paramView.getParent());
    a();
    this.c.addOnLayoutChangeListener(this);
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.d.2.a
 * JD-Core Version:    0.7.0.1
 */