package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.pp.i;
import com.tencent.luggage.wxa.pw.e;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public final class d
  extends h
{
  private static final int CTRL_INDEX = 110;
  private static final String NAME = "insertTextArea";
  
  protected i a(WeakReference<u> paramWeakReference, String paramString, int paramInt)
  {
    return new d.2(this, paramWeakReference, paramInt, paramString);
  }
  
  protected void a(i parami)
  {
    super.a(parami);
    parami.a(new d.1(this, parami));
  }
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramu, paramJSONObject, paramInt);
  }
  
  protected boolean a(e parame, JSONObject paramJSONObject, u paramu, int paramInt)
  {
    if (!super.a(parame, paramJSONObject, paramu, paramInt)) {
      return false;
    }
    parame.C = Boolean.valueOf(true);
    parame.c = "emoji";
    parame.d = false;
    parame.e = false;
    parame.I = Boolean.valueOf(false);
    parame.D = Boolean.valueOf(paramJSONObject.optBoolean("confirm", true));
    parame.N = Boolean.valueOf(paramJSONObject.optBoolean("showCoverView", false));
    return true;
  }
  
  protected boolean f()
  {
    return false;
  }
  
  protected boolean g()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.d
 * JD-Core Version:    0.7.0.1
 */