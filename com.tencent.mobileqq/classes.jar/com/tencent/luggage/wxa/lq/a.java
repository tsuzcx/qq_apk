package com.tencent.luggage.wxa.lq;

import androidx.annotation.MainThread;
import com.tencent.luggage.wxa.iu.d;
import com.tencent.luggage.wxa.iu.h;
import org.json.JSONObject;

public final class a
  extends com.tencent.luggage.wxa.jx.a<h>
{
  private static final int CTRL_INDEX = 106;
  private static final String NAME = "hideToast";
  
  @MainThread
  private void a(h paramh, int paramInt)
  {
    try
    {
      localo = paramh.q().C();
    }
    catch (Throwable localThrowable1)
    {
      com.tencent.mm.plugin.appbrand.page.o localo;
      label11:
      label70:
      break label11;
    }
    localo = null;
    if (localo == null)
    {
      com.tencent.luggage.wxa.qz.o.b("MicroMsg.JsApiHideToast", "hideToast uiThread NULL page");
      paramh.a(paramInt, b("fail:page don't exist"));
      return;
    }
    try
    {
      if (com.tencent.luggage.wxa.py.a.a(paramh.q()))
      {
        paramh.a(paramInt, b("ok"));
        return;
      }
      paramh.a(paramInt, b("fail:toast can't be found"));
      return;
    }
    catch (Throwable localThrowable2)
    {
      break label70;
    }
    paramh.a(paramInt, b("fail:internal error"));
  }
  
  public void a(h paramh, JSONObject paramJSONObject, int paramInt)
  {
    paramh.a(new a.1(this, paramh, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lq.a
 * JD-Core Version:    0.7.0.1
 */