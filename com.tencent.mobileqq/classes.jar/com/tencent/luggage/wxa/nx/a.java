package com.tencent.luggage.wxa.nx;

import android.content.Context;
import android.content.res.Resources;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.dq.c;
import com.tencent.luggage.wxa.jj.n;
import com.tencent.luggage.wxa.qz.t;

public class a
  implements com.tencent.luggage.wxa.nv.b<c>
{
  public static CharSequence a(@NonNull Context paramContext, @NonNull c paramc)
  {
    if (((com.tencent.luggage.wxa.do.d)paramc.b(com.tencent.luggage.wxa.do.d.class)).b) {
      return paramContext.getString(2131886787);
    }
    return paramContext.getString(2131886789);
  }
  
  public static void a(com.tencent.luggage.wxa.iu.b paramb, String paramString, boolean paramBoolean)
  {
    n.a(paramString, paramBoolean);
    if (paramBoolean) {
      paramString = paramb.getContext().getResources().getString(2131886776);
    } else {
      paramString = paramb.getContext().getResources().getString(2131886775);
    }
    t.a(new a.1(paramb, paramString));
  }
  
  public boolean a(@NonNull Context paramContext, @NonNull c paramc, String paramString)
  {
    return (n.a(paramc.f())) || (n.b(paramString));
  }
  
  public String b(@NonNull Context paramContext, @NonNull c paramc, String paramString)
  {
    return a(paramContext, paramc).toString();
  }
  
  public void c(@NonNull Context paramContext, @NonNull c paramc, String paramString)
  {
    a(paramc, paramString, paramc.f().i().b ^ true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.nx.a
 * JD-Core Version:    0.7.0.1
 */