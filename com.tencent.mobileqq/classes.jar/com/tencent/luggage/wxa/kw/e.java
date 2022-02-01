package com.tencent.luggage.wxa.kw;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.pc.l;
import com.tencent.mm.plugin.appbrand.page.u;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

public final class e
  extends a<u>
{
  private static final int CTRL_INDEX = 119;
  private static final String NAME = "removeTextArea";
  
  public void a(u paramu, JSONObject paramJSONObject, int paramInt)
  {
    try
    {
      int i = paramJSONObject.getInt("inputId");
      l.a(new e.1(this, new WeakReference(paramu), i, paramInt));
      return;
    }
    catch (JSONException paramJSONObject)
    {
      label31:
      break label31;
    }
    paramu.a(paramInt, b("fail:invalid data"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kw.e
 * JD-Core Version:    0.7.0.1
 */