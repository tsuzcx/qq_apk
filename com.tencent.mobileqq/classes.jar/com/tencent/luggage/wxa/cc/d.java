package com.tencent.luggage.wxa.cc;

import com.tencent.luggage.wxa.ka.j;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import org.apache.commons.lang.ArrayUtils;
import org.json.JSONObject;

public class d
  extends a<j>
{
  public static final int CTRL_INDEX = 79;
  public static final String NAME = "operateWXData";
  private static final String[] b = { "webapi_getuserallappauth", "webapi_getuserinfo", "webapi_getuserprofile" };
  private final boolean a;
  
  public d(boolean paramBoolean)
  {
    super(new j());
    this.a = paramBoolean;
  }
  
  protected boolean a(JSONObject paramJSONObject)
  {
    boolean bool = true;
    if (paramJSONObject == null) {
      str = null;
    } else {
      str = paramJSONObject.toString();
    }
    o.d("JsApiOperateWXDataStandalone", "invoke with args %s", new Object[] { str });
    if ((this.a) && (paramJSONObject != null)) {}
    try
    {
      str = af.b(paramJSONObject.getJSONObject("data").getString("api_name"));
    }
    catch (Throwable localThrowable)
    {
      label64:
      int i;
      break label64;
    }
    String str = "";
    if (ArrayUtils.contains(b, str)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      if (super.a(paramJSONObject)) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.cc.d
 * JD-Core Version:    0.7.0.1
 */