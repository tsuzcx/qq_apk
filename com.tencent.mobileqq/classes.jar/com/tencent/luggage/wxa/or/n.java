package com.tencent.luggage.wxa.or;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import com.tencent.luggage.wxa.oq.c.a;
import com.tencent.luggage.wxa.oq.c.c;
import com.tencent.luggage.wxa.oq.d.b;
import com.tencent.luggage.wxa.qz.r;
import com.tencent.mm.plugin.appbrand.widget.f;

public class n
  implements com.tencent.luggage.wxa.oq.c
{
  protected b a;
  private Context b = new MutableContextWrapper(r.a());
  private j c;
  private WindowInsets d;
  private final SparseArray<Rect> e = new SparseArray(4);
  
  private Rect a(@NonNull Activity paramActivity, int paramInt)
  {
    int i;
    int j;
    if (ViewCompat.isLaidOut(paramActivity.getWindow().getDecorView()))
    {
      paramActivity = paramActivity.getWindow().getDecorView();
      i = paramActivity.getWidth();
      j = paramActivity.getHeight();
    }
    else
    {
      i = getVDisplayMetrics().widthPixels;
      j = getVDisplayMetrics().heightPixels;
    }
    if (!this.c.a()) {
      return new Rect(0, 0, i, j);
    }
    if (this.c.a())
    {
      if (Build.VERSION.SDK_INT >= 28)
      {
        paramActivity = ((k)this.c).a(paramInt);
        if (paramActivity != null)
        {
          paramActivity = paramActivity.getDisplayCutout();
          if (paramActivity != null) {
            return new Rect(paramActivity.getSafeInsetLeft(), paramActivity.getSafeInsetTop(), i - paramActivity.getSafeInsetRight(), j - paramActivity.getSafeInsetBottom());
          }
          com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaGuarded api28 NULL getDisplayCutout, fallback impl");
        }
      }
      int k = this.c.b();
      if (paramInt != 0)
      {
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt != 3) {
              return new Rect(0, 0, i, j);
            }
            return new Rect(0, 0, i - k, j);
          }
          return new Rect(0, 0, i, j - k);
        }
        return new Rect(k, 0, i, j);
      }
      return new Rect(0, k, i, j);
    }
    return new Rect(0, 0, i, j);
  }
  
  private WindowInsets a()
  {
    Object localObject = u();
    if (localObject != null)
    {
      localObject = com.tencent.mm.ui.c.b((Activity)localObject);
      this.d = ((WindowInsets)localObject);
      return localObject;
    }
    localObject = this.d;
    if (localObject != null) {
      return localObject;
    }
    return null;
  }
  
  private void b()
  {
    synchronized (this.e)
    {
      this.e.clear();
      return;
    }
  }
  
  public final int a(com.tencent.luggage.wxa.oq.c paramc)
  {
    if (paramc == null) {
      return -1;
    }
    if (this == paramc) {
      return 0;
    }
    if (getClass() != paramc.getClass()) {
      return getClass().hashCode() - paramc.getClass().hashCode();
    }
    if (((paramc instanceof n)) && (u() == ((n)paramc).u())) {
      return 0;
    }
    return -1;
  }
  
  public com.tencent.luggage.wxa.oq.d a(@Nullable d.b paramb)
  {
    return new a(this, paramb);
  }
  
  public void a(@ColorInt int paramInt, @NonNull com.tencent.luggage.wxa.iu.d paramd)
  {
    int i;
    if ((paramInt != 0) && (paramInt >> 24 == 0)) {
      i = 0;
    } else {
      i = 1;
    }
    paramd = u();
    if (paramd == null) {
      return;
    }
    Window localWindow = paramd.getWindow();
    if (i != 0) {
      paramd = new ColorDrawable(0);
    } else {
      paramd = new ColorDrawable(paramInt);
    }
    localWindow.setBackgroundDrawable(paramd);
  }
  
  public final void a(@NonNull Context paramContext)
  {
    if (this.b == paramContext) {
      return;
    }
    if (k()) {
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.WindowAndroidActivityImpl", "resetContext, this:%s, new:%s, old:%s, stack:%s", new Object[] { getClass().getName(), paramContext, this.b, Log.getStackTraceString(new Throwable()) });
    }
    this.b = paramContext;
    this.c = j.a.a(u());
    v();
    a();
  }
  
  protected void a(Configuration paramConfiguration) {}
  
  public void a(com.tencent.luggage.wxa.oq.j paramj, com.tencent.luggage.wxa.iu.d paramd)
  {
    f localf = paramd.ai();
    if ((localf instanceof com.tencent.mm.plugin.appbrand.widget.c))
    {
      ((com.tencent.mm.plugin.appbrand.widget.c)localf).setWxaLayoutParams(paramj);
      return;
    }
    paramd.ai().setLayoutParams(paramj);
    paramd.ai().setScaleX(paramj.a());
    paramd.ai().setScaleY(paramj.a());
  }
  
  public final void b(Configuration paramConfiguration)
  {
    if (m.a(getContext().getResources().getConfiguration(), paramConfiguration)) {
      b();
    }
    getContext().getResources().getConfiguration().updateFrom(paramConfiguration);
    v().a(paramConfiguration);
    this.c.a(paramConfiguration);
    a(paramConfiguration);
  }
  
  public final boolean f()
  {
    return com.tencent.luggage.wxa.pd.o.a(getContext());
  }
  
  public boolean g_()
  {
    return false;
  }
  
  public final Context getContext()
  {
    return this.b;
  }
  
  @Nullable
  public Rect getSafeAreaInsets()
  {
    Activity localActivity = u();
    if (localActivity == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets with NULL activity");
      return null;
    }
    if (localActivity.getWindow() == null)
    {
      com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.WindowAndroidActivityImpl", "getSafeAreaInsets will NULL window");
      return null;
    }
    int i = localActivity.getWindowManager().getDefaultDisplay().getRotation();
    synchronized (this.e)
    {
      Rect localRect2 = (Rect)this.e.get(i);
      Rect localRect1 = localRect2;
      if (localRect2 == null)
      {
        localRect1 = a(localActivity, i);
        this.e.put(i, localRect1);
      }
      return localRect1;
    }
  }
  
  public float getScale()
  {
    return 1.0F;
  }
  
  @Nullable
  public c.c getStatusBar()
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = a();
      int i;
      if (localObject != null) {
        i = ((WindowInsets)localObject).getStableInsetTop();
      } else {
        i = com.tencent.luggage.util.k.a.c(getContext());
      }
      localObject = new c.c();
      ((c.c)localObject).a = i;
      if (u() != null)
      {
        if (com.tencent.mm.plugin.appbrand.ui.c.a(u())) {
          i = 8;
        } else {
          i = 0;
        }
        ((c.c)localObject).b = i;
      }
      return localObject;
    }
    return null;
  }
  
  public DisplayMetrics getVDisplayMetrics()
  {
    Display localDisplay = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay();
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    localDisplay.getMetrics(localDisplayMetrics);
    return localDisplayMetrics;
  }
  
  public boolean h_()
  {
    return false;
  }
  
  public boolean i()
  {
    if (Build.VERSION.SDK_INT >= 24) {
      return u().isInMultiWindowMode();
    }
    return false;
  }
  
  @Nullable
  public boolean i_()
  {
    return false;
  }
  
  protected boolean k()
  {
    return false;
  }
  
  public void setSoftOrientation(String paramString) {}
  
  @RequiresApi(21)
  public void setWindowDescription(c.a parama)
  {
    if (Build.VERSION.SDK_INT < 21) {
      return;
    }
    if (u() != null)
    {
      if (parama == null) {
        return;
      }
      try
      {
        u().setTaskDescription(m.a(parama));
        return;
      }
      catch (Exception localException)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try1 e=%s", new Object[] { localException });
        try
        {
          u().setTaskDescription(m.a(new c.a(parama.a(), parama.b(), -16777216)));
          return;
        }
        catch (Exception parama)
        {
          com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.WindowAndroidActivityImpl", "setWindowDescription try2 e=%s", new Object[] { parama });
        }
      }
    }
  }
  
  public final WindowManager t()
  {
    return (WindowManager)ContextCompat.getSystemService(this.b, WindowManager.class);
  }
  
  @Nullable
  public final Activity u()
  {
    return com.tencent.luggage.wxa.rc.a.a(this.b);
  }
  
  public b v()
  {
    b localb = this.a;
    if ((localb == null) || (((localb instanceof c)) && (((c)localb).e() != u())))
    {
      localb = this.a;
      if (localb != null) {
        localb.d();
      }
      this.a = new c(this);
    }
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.or.n
 * JD-Core Version:    0.7.0.1
 */