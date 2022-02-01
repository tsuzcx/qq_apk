package com.tencent.luggage.wxa.fy;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.gf.a;
import com.tencent.luggage.wxa.hv.i;
import com.tencent.luggage.wxa.lp.b;
import com.tencent.luggage.wxa.lp.h;
import com.tencent.luggage.wxa.qz.o;

public abstract class c<OriginVideoContainer extends h, PipVideoContainer extends View>
  implements p<OriginVideoContainer, PipVideoContainer>
{
  @NonNull
  private final a a;
  
  protected c(@NonNull a parama)
  {
    this.a = parama;
  }
  
  private String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.AppBrand.AbsXWebPipInfoProvider#");
    localStringBuilder.append(this.a.B());
    return localStringBuilder.toString();
  }
  
  @Nullable
  public b a(@Nullable String paramString)
  {
    try
    {
      paramString = new i(paramString);
      paramString = new c.1(this, com.tencent.luggage.wxa.lp.c.a(paramString), com.tencent.luggage.wxa.lp.c.b(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      o.a(d(), paramString, "getPipExtra fail", new Object[0]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.fy.c
 * JD-Core Version:    0.7.0.1
 */