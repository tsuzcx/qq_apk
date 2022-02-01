package com.tencent.luggage.wxa.ku;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.rt.i;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import org.json.JSONObject;

public final class ac
  extends a
{
  private static final int CTRL_INDEX = 117;
  private static final String NAME = "removeSavedFile";
  
  public void a(c paramc, JSONObject paramJSONObject, int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (af.c(paramJSONObject)) {
      paramJSONObject = "fail:invalid data";
    } else if (!paramc.getFileSystem().j(paramJSONObject)) {
      paramJSONObject = "fail not a store filePath";
    } else if (paramc.getFileSystem().g(paramJSONObject).w()) {
      paramJSONObject = "ok";
    } else {
      paramJSONObject = "fail";
    }
    paramc.a(paramInt, b(paramJSONObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ku.ac
 * JD-Core Version:    0.7.0.1
 */