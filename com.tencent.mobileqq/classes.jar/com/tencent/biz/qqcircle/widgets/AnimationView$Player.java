package com.tencent.biz.qqcircle.widgets;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.SparseArray;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class AnimationView$Player
  implements Handler.Callback
{
  int a = 0;
  int b = 0;
  int c = 0;
  boolean d = false;
  protected WeakReference<AnimationView> e;
  protected Handler f;
  
  public AnimationView$Player(AnimationView paramAnimationView)
  {
    this.e = new WeakReference(paramAnimationView);
    this.f = new Handler(this);
  }
  
  protected Drawable a(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.a != null))
    {
      paramAnimationView = paramAnimationView.a;
      if (this.a == 2) {
        return null;
      }
      if (paramAnimationView.f.size() <= 0)
      {
        this.a = 2;
        return null;
      }
      int i = this.b;
      if ((i >= 0) && (i <= paramAnimationView.f.size()))
      {
        int k = this.b + 1;
        int m = 0;
        i = k;
        int j = m;
        if (paramAnimationView.g > 0)
        {
          i = k;
          j = m;
          if (paramAnimationView.h > 0)
          {
            i = k;
            j = m;
            if (paramAnimationView.h > paramAnimationView.g)
            {
              i = k;
              if (this.b == paramAnimationView.h) {
                i = paramAnimationView.g;
              }
              j = 1;
            }
          }
        }
        if (i > paramAnimationView.f.size())
        {
          if (paramAnimationView.a < 0) {
            this.a = 2;
          } else if ((paramAnimationView.a != 0) && (this.c >= paramAnimationView.a)) {
            this.a = 2;
          }
          if (this.a == 2) {
            return null;
          }
          k = 1;
        }
        else
        {
          k = i;
          if (i == paramAnimationView.f.size())
          {
            k = i;
            if (j == 0)
            {
              this.c += 1;
              k = i;
            }
          }
        }
        this.b = k;
        i = ((Integer)paramAnimationView.f.get(k - 1)).intValue();
        return (Drawable)paramAnimationView.e.get(i);
      }
      this.a = 2;
      return null;
    }
    this.a = 2;
    return null;
  }
  
  public void a()
  {
    this.b = 0;
    this.c = 0;
    this.a = 0;
    this.d = false;
  }
  
  public int b(AnimationView paramAnimationView)
  {
    if ((paramAnimationView != null) && (paramAnimationView.a != null))
    {
      if (this.b >= paramAnimationView.a.f.size()) {
        return paramAnimationView.a.c;
      }
      return paramAnimationView.a.b;
    }
    return 100;
  }
  
  public void b()
  {
    a();
    this.a = 1;
    e();
  }
  
  public void c()
  {
    this.a = 2;
    this.f.removeCallbacksAndMessages(null);
  }
  
  public void d()
  {
    c();
  }
  
  protected void e()
  {
    Object localObject = (AnimationView)this.e.get();
    if (localObject != null)
    {
      if (this.a == 2) {
        return;
      }
      Drawable localDrawable = a((AnimationView)localObject);
      if (localDrawable != null) {
        ((AnimationView)localObject).setImageDrawable(localDrawable);
      }
      if (((AnimationView)localObject).c != null) {
        if ((this.b == 1) && (this.c > 0)) {
          ((AnimationView)localObject).c.c((AnimationView)localObject);
        } else if ((this.b == 1) && (this.c == 0))
        {
          if (!this.d)
          {
            this.d = true;
            ((AnimationView)localObject).c.a((AnimationView)localObject);
          }
        }
        else if (this.a == 2) {
          ((AnimationView)localObject).c.b((AnimationView)localObject);
        }
      }
      int i = b((AnimationView)localObject);
      localObject = this.f.obtainMessage(1);
      this.f.sendMessageDelayed((Message)localObject, i);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1) {
      e();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.AnimationView.Player
 * JD-Core Version:    0.7.0.1
 */