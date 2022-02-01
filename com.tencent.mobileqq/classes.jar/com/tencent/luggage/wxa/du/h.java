package com.tencent.luggage.wxa.du;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.appcache.o;
import com.tencent.mm.plugin.appbrand.appstorage.n;
import com.tencent.mm.plugin.appbrand.jsruntime.s;

public class h<SERVICE extends c>
  extends a<SERVICE>
{
  protected h(@NonNull SERVICE paramSERVICE, @NonNull s params)
  {
    super(paramSERVICE, params);
  }
  
  protected String a(@NonNull SERVICE paramSERVICE)
  {
    paramSERVICE = paramSERVICE.A().a("WASubContext.js");
    if (!TextUtils.isEmpty(paramSERVICE)) {
      return paramSERVICE;
    }
    throw new o("WASubContext.js");
  }
  
  protected int b(@NonNull SERVICE paramSERVICE)
  {
    return paramSERVICE.A().c();
  }
  
  protected String c()
  {
    return "WASubContext.js";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.du.h
 * JD-Core Version:    0.7.0.1
 */