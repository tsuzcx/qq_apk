package com.tencent.luggage.wxa.fy;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.ba.e;
import com.tencent.luggage.wxa.pc.c;
import com.tencent.luggage.wxa.po.a;
import com.tencent.luggage.wxa.po.b;
import com.tencent.luggage.wxa.qz.o;
import java.lang.ref.WeakReference;

class u$2
  extends u.a
{
  u$2(u paramu, Context paramContext)
  {
    super(paramu, paramContext);
  }
  
  protected Space a(@NonNull Context paramContext)
  {
    paramContext = new Space(paramContext);
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 19.0F));
    return paramContext;
  }
  
  protected View b(@NonNull Context paramContext)
  {
    Object localObject = (b)e.a(b.class);
    if (localObject == null)
    {
      o.c(this.a.a, "createAudioPlayView, gifCoverViewFactory is null");
      return null;
    }
    localObject = ((b)localObject).a(paramContext);
    if ((u.b() != null) && (u.b().get() != null))
    {
      paramContext = (byte[])u.b().get();
    }
    else
    {
      paramContext = c.b(paramContext.getResources().openRawResource(2131230877));
      u.a(new WeakReference(paramContext));
    }
    ((a)localObject).setImageByteArray(paramContext);
    paramContext = ((a)localObject).getView();
    paramContext.setLayoutParams(new LinearLayout.LayoutParams(0, -1, 6.0F));
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.u.2
 * JD-Core Version:    0.7.0.1
 */