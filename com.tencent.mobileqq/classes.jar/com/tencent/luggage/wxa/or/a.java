package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.hg.c;
import com.tencent.luggage.wxa.oq.d.b;
import com.tencent.luggage.wxa.oq.d.c;
import com.tencent.luggage.wxa.oq.e.b;
import com.tencent.luggage.wxa.qz.o;

final class a
  extends com.tencent.luggage.wxa.oq.a
{
  private final d.c d;
  private int e;
  private int f = -1;
  private WindowManager.LayoutParams g;
  
  a(@NonNull n paramn, @Nullable d.b paramb)
  {
    super(paramn, paramb);
    this.d = new a.1(this, paramn);
  }
  
  private Activity a()
  {
    return ((n)this.a).u();
  }
  
  public void a(int paramInt)
  {
    this.c = true;
    if (paramInt != -90)
    {
      if (paramInt != 0)
      {
        if (paramInt != 90)
        {
          this.d.a(e.b.a(9));
          return;
        }
        this.d.a(e.b.a(0));
        return;
      }
      this.d.a(e.b.a(1));
      return;
    }
    this.d.a(e.b.a(8));
  }
  
  public final void a(@NonNull View paramView, int paramInt)
  {
    super.a(paramView, paramInt);
    paramView = a();
    if (paramView != null)
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getWindow().getDecorView();
      if (this.b == null) {
        this.e = localViewGroup.getSystemUiVisibility();
      }
      if (c.b(19)) {
        localViewGroup.setSystemUiVisibility(2);
      } else {
        localViewGroup.setSystemUiVisibility(4102);
      }
      if (this.b == null)
      {
        this.g = new WindowManager.LayoutParams();
        this.g.copyFrom(paramView.getWindow().getAttributes());
      }
      paramView.getWindow().addFlags(1024);
      if (Build.VERSION.SDK_INT >= 28) {
        paramView.getWindow().getAttributes().layoutInDisplayCutoutMode = 2;
      }
      if (this.b == null) {
        this.f = paramView.getRequestedOrientation();
      }
      a(paramInt);
    }
    else
    {
      o.b("Luggage.ActivityWindowFullscreenImpl", "enterFullscreen, get NULL activity");
      if (this.b == null)
      {
        this.f = -1;
        this.g = null;
        this.e = 0;
      }
    }
    e();
    this.b = null;
  }
  
  public boolean c()
  {
    boolean bool = this.c;
    if (super.c())
    {
      Activity localActivity = a();
      if ((localActivity != null) && (!localActivity.isFinishing()) && (!localActivity.isDestroyed()))
      {
        ((ViewGroup)localActivity.getWindow().getDecorView()).setSystemUiVisibility(this.e);
        localActivity.getWindow().clearFlags(1024);
        if (this.g != null) {
          localActivity.getWindow().setAttributes(this.g);
        }
        this.d.a(e.b.a(this.f));
        this.f = -1;
      }
      else
      {
        o.b("Luggage.ActivityWindowFullscreenImpl", "exitFullscreen activity(%s) destroyed", new Object[] { localActivity });
      }
      f();
      return true;
    }
    if (bool)
    {
      this.c = false;
      f();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.a
 * JD-Core Version:    0.7.0.1
 */