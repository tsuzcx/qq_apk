package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.b;
import com.tencent.luggage.wxa.oi.f;
import com.tencent.luggage.wxa.oi.f.a;
import org.json.JSONObject;

public class s
  extends j<b, f>
{
  public static final int CTRL_INDEX = 454;
  public static final String NAME = "setBackgroundTextStyle";
  
  public s()
  {
    super(f.class);
  }
  
  protected void a(@NonNull b paramb, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull f paramf)
  {
    paramf.a(paramJSONObject.optString("textStyle", f.a.c.a()));
    paramb.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.s
 * JD-Core Version:    0.7.0.1
 */