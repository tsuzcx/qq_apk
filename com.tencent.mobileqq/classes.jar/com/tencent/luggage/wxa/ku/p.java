package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class p
  extends a
{
  private static final int CTRL_INDEX = 116;
  private static final String NAME = "getSavedFileInfo";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (af.c(paramJSONObject))
    {
      paramc.a(paramInt, b("fail:invalid data"));
      return;
    }
    b.a.execute(new p.1(this, paramc, paramJSONObject, paramInt));
  }
  
  protected boolean b()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.p
 * JD-Core Version:    0.7.0.1
 */