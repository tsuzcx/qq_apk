package com.tencent.av.utils;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class QQFrameByFrameAnimation
{
  View a = null;
  QQAnimationListener b = null;
  int[] c;
  int d = 300;
  int e = 0;
  int f = 0;
  int g = 0;
  Handler h = new Handler();
  Runnable i = new QQFrameByFrameAnimation.1(this);
  
  void a()
  {
    this.f += 1;
    Object localObject = this.a;
    if (localObject != null)
    {
      int[] arrayOfInt = this.c;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        int j = arrayOfInt[(this.f % arrayOfInt.length)];
        if ((localObject instanceof ImageButton))
        {
          ((View)localObject).setBackgroundResource(j);
          return;
        }
        if ((localObject instanceof Button))
        {
          localObject = ((View)localObject).getResources().getDrawable(j);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          ((Button)this.a).setCompoundDrawables(null, (Drawable)localObject, null, null);
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void a(View paramView)
  {
    this.a = paramView;
  }
  
  public void a(QQAnimationListener paramQQAnimationListener)
  {
    this.b = paramQQAnimationListener;
  }
  
  public void a(int[] paramArrayOfInt)
  {
    this.c = paramArrayOfInt;
  }
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      int[] arrayOfInt = this.c;
      if ((arrayOfInt != null) && (arrayOfInt.length > 0))
      {
        this.f = 0;
        if ((localObject instanceof ImageButton)) {
          ((View)localObject).setBackgroundResource(arrayOfInt[0]);
        }
        localObject = this.a;
        if ((localObject instanceof Button))
        {
          localObject = ((View)localObject).getResources().getDrawable(this.c[0]);
          ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
          ((Button)this.a).setCompoundDrawables(null, (Drawable)localObject, null, null);
        }
        this.h.postDelayed(this.i, this.d);
        localObject = this.b;
        if (localObject != null) {
          ((QQAnimationListener)localObject).d();
        }
      }
    }
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void c()
  {
    this.h.removeCallbacks(this.i);
    QQAnimationListener localQQAnimationListener = this.b;
    if (localQQAnimationListener != null) {
      localQQAnimationListener.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.utils.QQFrameByFrameAnimation
 * JD-Core Version:    0.7.0.1
 */