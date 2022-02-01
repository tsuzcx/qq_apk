package com.tencent.luggage.util;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import com.tencent.luggage.wxa.re.a;
import com.tencent.luggage.wxa.re.e;
import com.tencent.luggage.wxa.re.f;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "invoke"}, k=3, mv={1, 1, 16})
final class k$b
  extends Lambda
  implements Function0<Boolean>
{
  k$b(Context paramContext)
  {
    super(0);
  }
  
  public final boolean a()
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool2 = true;
    if (i >= 28)
    {
      Context localContext = this.a;
      Object localObject = localContext;
      if (!(localContext instanceof Activity)) {
        localObject = null;
      }
      localObject = (Activity)localObject;
      if (localObject != null)
      {
        localObject = ((Activity)localObject).getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null)
          {
            localObject = ((View)localObject).getRootWindowInsets();
            if (localObject != null)
            {
              localObject = ((WindowInsets)localObject).getDisplayCutout();
              if (localObject != null)
              {
                localObject = ((DisplayCutout)localObject).getBoundingRects();
                if (localObject != null)
                {
                  i = ((List)localObject).size();
                  break label118;
                }
              }
            }
          }
        }
      }
      i = 0;
      label118:
      if (i > 0) {
        return true;
      }
    }
    else
    {
      bool1 = bool2;
      if (f.a(this.a)) {
        return bool1;
      }
      bool1 = bool2;
      if (e.a(this.a)) {
        return bool1;
      }
      if (a.a(this.a)) {
        return true;
      }
    }
    boolean bool1 = false;
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.util.k.b
 * JD-Core Version:    0.7.0.1
 */