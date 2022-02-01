package com.tencent.luggage.wxa.pp;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.re.d;
import java.lang.reflect.Method;

public final class a
{
  private static final boolean a;
  private final Activity b;
  private boolean c = false;
  private int d = 0;
  
  static
  {
    boolean bool;
    if (Build.VERSION.SDK_INT < 20) {
      bool = true;
    } else {
      bool = false;
    }
    a = bool;
  }
  
  public a(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public static boolean a(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1;
    if (i > 0) {
      bool1 = paramContext.getBoolean(i);
    } else {
      bool1 = false;
    }
    try
    {
      paramContext = Class.forName("android.os.SystemProperties");
      paramContext = (String)paramContext.getMethod("get", new Class[] { String.class }).invoke(paramContext, new Object[] { "qemu.hw.mainkeys" });
      if ("1".equals(paramContext)) {
        return false;
      }
      boolean bool2 = "0".equals(paramContext);
      if (bool2) {
        bool1 = true;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
  
  private void b()
  {
    if (this.c)
    {
      if (this.b.isFinishing()) {
        return;
      }
      if (a)
      {
        if (n.a(this.b) == null)
        {
          o.c("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightIfNeed get null rootLayout");
          return;
        }
        c();
      }
    }
  }
  
  private void c()
  {
    n localn = n.a(this.b);
    Point localPoint = new Point();
    this.b.getWindowManager().getDefaultDisplay().getSize(localPoint);
    int i = com.tencent.mm.ui.a.c(this.b);
    int j = localPoint.y;
    if (d()) {
      i = 0;
    }
    i = j - i;
    o.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "fixLayoutHeightBelow20 forceHeight %d", new Object[] { Integer.valueOf(i) });
    localn.setForceHeight(i);
  }
  
  private boolean d()
  {
    return (this.b.getWindow() != null) && ((this.b.getWindow().getAttributes().flags & 0x400) > 0);
  }
  
  public void a()
  {
    Activity localActivity = this.b;
    if (localActivity != null)
    {
      if (localActivity.getWindow() == null) {
        return;
      }
      this.b.getWindow().setSoftInputMode(16);
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration == null) {
      return;
    }
    o.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityConfigurationChanged, orientation %d", new Object[] { Integer.valueOf(paramConfiguration.orientation) });
    b();
  }
  
  public void a(View paramView)
  {
    Activity localActivity = this.b;
    if ((localActivity != null) && (localActivity.getWindow() != null))
    {
      if (paramView == null) {
        return;
      }
      if (paramView.getParent() != null)
      {
        if (!(paramView.getParent() instanceof ViewGroup)) {
          return;
        }
        this.c = true;
        paramView = (ViewGroup)paramView.getParent();
        if (Build.VERSION.SDK_INT < 20)
        {
          d.a(this.b, paramView);
          c();
        }
        if ((a) && (a(this.b))) {
          am.a(paramView, new a.1(this));
        }
      }
    }
  }
  
  public void a(WindowManager.LayoutParams paramLayoutParams)
  {
    if (paramLayoutParams == null) {
      return;
    }
    o.d("MicroMsg.AppBrandFixInputIssuesActivityHelper", "onActivityWindowAttributesChanged, oldFlags %d, newFlags %d", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramLayoutParams.flags) });
    if (paramLayoutParams.flags != this.d)
    {
      this.d = paramLayoutParams.flags;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.a
 * JD-Core Version:    0.7.0.1
 */