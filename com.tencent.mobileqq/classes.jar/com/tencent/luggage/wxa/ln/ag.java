package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oi.f;
import org.json.JSONObject;

public class ag
  extends j<h, f>
{
  public static final int CTRL_INDEX = 12;
  public static final String NAME = "stopPullDownRefresh";
  
  public ag()
  {
    super(f.class);
  }
  
  protected void a(@NonNull h paramh, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull f paramf)
  {
    paramf.b();
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.ag
 * JD-Core Version:    0.7.0.1
 */