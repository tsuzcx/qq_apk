package com.tencent.luggage.wxa.gd;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jx.s;
import com.tencent.luggage.wxa.jx.v;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

class d$27
  extends com.tencent.luggage.wxa.fy.a
{
  d$27(d paramd, com.tencent.luggage.wxa.gf.a parama, s params)
  {
    super(parama, params);
  }
  
  public void a(@NonNull String paramString, @NonNull com.tencent.luggage.wxa.fx.a parama)
  {
    a(parama);
    parama = parama.d();
    if ((!paramString.contains("insert")) && (!paramString.contains("update")))
    {
      if (paramString.contains("operate"))
      {
        paramString = parama.optString("type");
        if ((!af.c(paramString)) && (paramString.equalsIgnoreCase("play"))) {
          this.a = true;
        }
      }
      else if (paramString.contains("remove"))
      {
        this.a = false;
      }
    }
    else
    {
      if (parama.has("autoplay")) {
        this.a = parama.optBoolean("autoplay");
      }
      paramString = v.a(parama);
      if (paramString != null) {
        this.b = paramString.booleanValue();
      }
    }
    paramString = d.b(this.c);
    parama = new StringBuilder();
    parama.append("mAutoRotationPluginHandlerCommons.handleJsApi, mIsNeedNotify: ");
    parama.append(this.a);
    parama.append(", mIsAutoRotationEnabled: ");
    parama.append(this.b);
    o.e(paramString, parama.toString());
  }
  
  protected boolean a()
  {
    return d.E(this.c) ^ true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gd.d.27
 * JD-Core Version:    0.7.0.1
 */