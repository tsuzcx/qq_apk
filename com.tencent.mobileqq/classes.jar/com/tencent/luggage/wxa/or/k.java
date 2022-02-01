package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Looper;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.RequiresApi;
import com.tencent.luggage.wxa.qz.ac;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.mm.ui.c;
import java.util.List;

@RequiresApi(28)
class k
  implements j
{
  private final Activity a;
  private final Object b = this;
  private Configuration c;
  private boolean d = false;
  private final SparseArray<WindowInsets> e = new SparseArray(4);
  
  k(Activity paramActivity)
  {
    this.a = paramActivity;
    this.c = new Configuration(paramActivity.getResources().getConfiguration());
    o.d("Luggage.WXA.WindowAndroidActivityCutoutHandlerApi28", "<init> hasCutOut[%b] activity[%s]", new Object[] { Boolean.valueOf(a()), paramActivity.getLocalClassName() });
  }
  
  private void c()
  {
    synchronized (this.b)
    {
      this.e.clear();
      return;
    }
  }
  
  WindowInsets a(int paramInt)
  {
    synchronized (this.b)
    {
      WindowInsets localWindowInsets = (WindowInsets)this.e.get(paramInt);
      return localWindowInsets;
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (m.a(this.c, paramConfiguration)) {
      c();
    }
    this.c = new Configuration(paramConfiguration);
  }
  
  public boolean a()
  {
    View localView = this.a.getWindow().getDecorView();
    int i = this.a.getWindowManager().getDefaultDisplay().getRotation();
    synchronized (this.b)
    {
      WindowInsets localWindowInsets = (WindowInsets)this.e.get(i);
      Object localObject1 = localWindowInsets;
      if (localWindowInsets == null) {
        if ((t.a()) && (localView.isAttachedToWindow()))
        {
          localObject1 = localView.getRootWindowInsets();
          this.e.put(i, localView.getRootWindowInsets());
        }
        else if ((!t.a()) && (localView.isAttachedToWindow()))
        {
          localObject1 = (WindowInsets)new k.1(this, 500L, null, localView).a(new s(Looper.getMainLooper()));
          this.e.put(i, localObject1);
        }
        else
        {
          localObject1 = c.a(this.a);
          ((c)localObject1).a(new k.2(this, i, localView, (c)localObject1));
          boolean bool = this.d;
          return bool;
        }
      }
      if (localObject1 != null)
      {
        localObject1 = ((WindowInsets)localObject1).getDisplayCutout();
        if (localObject1 != null)
        {
          localObject1 = ((DisplayCutout)localObject1).getBoundingRects();
          if ((localObject1 != null) && (((List)localObject1).size() > 0)) {
            this.d = true;
          }
        }
      }
      return this.d;
    }
  }
  
  public int b()
  {
    return com.tencent.luggage.util.k.a.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.k
 * JD-Core Version:    0.7.0.1
 */