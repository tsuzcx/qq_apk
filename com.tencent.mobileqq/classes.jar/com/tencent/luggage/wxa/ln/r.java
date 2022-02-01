package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.luggage.wxa.oi.f.a;
import com.tencent.luggage.wxa.pc.g;
import org.json.JSONObject;

public class r
  extends j<b, f>
{
  public static final int CTRL_INDEX = 453;
  public static final String NAME = "setBackgroundColor";
  
  public r()
  {
    super(f.class);
  }
  
  protected void a(@NonNull b paramb, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull f paramf)
  {
    paramJSONObject = paramJSONObject.optString("backgroundColor", "");
    try
    {
      int i = g.b(paramJSONObject);
      paramf.a(f.a.c, i);
      paramb.a(paramInt, b("ok"));
      return;
    }
    catch (Exception paramJSONObject)
    {
      label39:
      break label39;
    }
    paramb.a(paramInt, b("fail:invalid color"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.r
 * JD-Core Version:    0.7.0.1
 */