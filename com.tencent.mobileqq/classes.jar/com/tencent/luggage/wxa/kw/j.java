package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.util.g;
import com.tencent.luggage.wxa.pw.h;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public final class j
  extends i
{
  private static final int CTRL_INDEX = 111;
  private static final String NAME = "updateTextArea";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    super.a(paramu, paramJSONObject, paramInt);
  }
  
  protected boolean a(h paramh, JSONObject paramJSONObject, u paramu, int paramInt)
  {
    boolean bool = super.a(paramh, paramJSONObject, paramu, paramInt);
    paramh.C = Boolean.valueOf(true);
    paramh.I = Boolean.valueOf(false);
    paramJSONObject = paramJSONObject.opt("confirm");
    if (paramJSONObject == null) {
      paramJSONObject = null;
    } else {
      paramJSONObject = g.a(paramJSONObject);
    }
    paramh.D = paramJSONObject;
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.j
 * JD-Core Version:    0.7.0.1
 */