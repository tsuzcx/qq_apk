package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.jx.a;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.qz.o;
import org.json.JSONObject;

public class l<CONTEXT extends c>
  extends a<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected o.a a;
  
  protected o.a a(a parama, CONTEXT paramCONTEXT, int paramInt)
  {
    return new o.a(this, paramCONTEXT, paramInt);
  }
  
  protected void a(CONTEXT paramCONTEXT) {}
  
  public void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    if (paramJSONObject == null)
    {
      paramCONTEXT.a(paramInt, b("fail:data is null"));
      o.b("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      return;
    }
    String str = paramCONTEXT.getAppId();
    o.d("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.a == null) {
      this.a = a(this, paramCONTEXT, paramInt);
    }
    o.a locala = this.a;
    locala.c = paramInt;
    locala.g = str;
    a(paramCONTEXT);
    paramCONTEXT = new l.d(this, paramCONTEXT, paramInt);
    paramCONTEXT.b = paramInt;
    paramCONTEXT.c = str;
    paramCONTEXT.d = paramJSONObject.toString();
    paramCONTEXT.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.l
 * JD-Core Version:    0.7.0.1
 */