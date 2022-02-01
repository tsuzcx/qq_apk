package com.tencent.luggage.wxa.ln;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.iu.h;
import com.tencent.luggage.wxa.oi.f;
import org.json.JSONObject;

public class af
  extends j<h, f>
{
  public static final int CTRL_INDEX = 284;
  public static final String NAME = "startPullDownRefresh";
  
  public af()
  {
    super(f.class);
  }
  
  protected void a(@NonNull h paramh, @NonNull JSONObject paramJSONObject, int paramInt, @NonNull f paramf)
  {
    paramf.a();
    paramh.a(paramInt, b("ok"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ln.af
 * JD-Core Version:    0.7.0.1
 */