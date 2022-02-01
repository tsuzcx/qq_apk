package com.tencent.luggage.wxa.pd;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.jx.bd;
import com.tencent.luggage.wxa.jx.h;
import com.tencent.luggage.wxa.oq.c;
import com.tencent.luggage.wxa.rc.a;
import com.tencent.mm.plugin.appbrand.page.u;
import kotlin.Deprecated;

public class w
{
  public static int a(int paramInt)
  {
    return Color.rgb(Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }
  
  @Deprecated(message="use com.tencent.mm.plugin.appbrand.utils.LuggageLargeScreenUtil.isLargeScreenWindow")
  public static boolean a(Context paramContext)
  {
    return o.a(paramContext);
  }
  
  public static boolean a(View paramView)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = false;
    if (i < 24) {
      return false;
    }
    if (paramView == null) {
      return false;
    }
    paramView = a.a(paramView.getContext());
    boolean bool1 = bool2;
    if (paramView != null)
    {
      bool1 = bool2;
      if (paramView.isInMultiWindowMode()) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int[] a(@NonNull b paramb)
  {
    paramb = c(paramb);
    com.tencent.luggage.wxa.qz.o.f("Luggage.WXA.UIUtil", "getWindowWidthHeight: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramb[0]), Integer.valueOf(paramb[1]) });
    return paramb;
  }
  
  public static int[] a(h paramh)
  {
    paramh = c(paramh);
    com.tencent.luggage.wxa.qz.o.f("Luggage.WXA.UIUtil", "getScreenSize: [x,y] = [%d,%d]", new Object[] { Integer.valueOf(paramh[0]), Integer.valueOf(paramh[1]) });
    return paramh;
  }
  
  public static int b(h paramh)
  {
    int[] arrayOfInt = new int[2];
    if ((paramh instanceof b))
    {
      paramh = b((b)paramh);
      if (paramh != null)
      {
        paramh.getLocationOnScreen(arrayOfInt);
        i = arrayOfInt[1];
        break label37;
      }
    }
    int i = 0;
    label37:
    com.tencent.luggage.wxa.qz.o.f("Luggage.WXA.UIUtil", "getScreenTop: [%d]", new Object[] { Integer.valueOf(i) });
    return i;
  }
  
  private static View b(b paramb)
  {
    paramb = bd.a(paramb);
    if (paramb == null) {
      return null;
    }
    return paramb.ag();
  }
  
  private static int[] c(@NonNull b paramb)
  {
    Object localObject = b(paramb);
    if ((localObject != null) && (((View)localObject).isLaidOut()))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: normal");
      return new int[] { ((View)localObject).getWidth(), ((View)localObject).getHeight() };
    }
    if ((paramb.getContext() instanceof Activity))
    {
      com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: windowAndroid");
      localObject = paramb.y().getVDisplayMetrics();
      if (((DisplayMetrics)localObject).widthPixels <= 0)
      {
        com.tencent.luggage.wxa.qz.o.b("Luggage.WXA.UIUtil", "getWindowWidthHeight try Method(windowAndroid) but width<=0, use Method(Screen) instead");
        return a(paramb);
      }
      return new int[] { ((DisplayMetrics)localObject).widthPixels, ((DisplayMetrics)localObject).heightPixels };
    }
    com.tencent.luggage.wxa.qz.o.d("Luggage.WXA.UIUtil", "getWindowWidthHeight Method: Screen");
    return a(paramb);
  }
  
  private static int[] c(h paramh)
  {
    c localc;
    if (paramh.q() != null) {
      localc = paramh.q().W();
    } else {
      localc = null;
    }
    if (localc != null)
    {
      com.tencent.luggage.wxa.qz.o.f("Luggage.WXA.UIUtil", "getScreenSizeInner: V_DM");
      paramh = localc.getVDisplayMetrics();
    }
    else
    {
      com.tencent.luggage.wxa.qz.o.f("Luggage.WXA.UIUtil", "getScreenSizeInner: normal DM");
      paramh = paramh.getContext().getResources().getDisplayMetrics();
    }
    return new int[] { paramh.widthPixels, paramh.heightPixels };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pd.w
 * JD-Core Version:    0.7.0.1
 */