package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.jj.a.d;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.mm.plugin.appbrand.page.u;
import org.json.JSONObject;

public class a
  extends j<u, f>
{
  public static final int CTRL_INDEX = 139;
  public static final String NAME = "disableScrollBounce";
  
  public a()
  {
    super(f.class);
  }
  
  protected void a(@NonNull u paramu, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull f paramf)
  {
    if (!paramJSONObject.has("disable"))
    {
      paramu.a(paramInt, b("ok"));
      return;
    }
    if (paramJSONObject.optBoolean("disable", false))
    {
      paramf.a(false);
    }
    else
    {
      paramJSONObject = paramu.am();
      if (paramJSONObject == null) {
        paramf.a(false);
      } else {
        paramf.a(paramJSONObject.j);
      }
    }
    paramu.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.a
 * JD-Core Version:    0.7.0.1
 */