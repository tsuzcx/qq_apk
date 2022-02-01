package com.tencent.luggage.wxa.jz;

import com.tencent.luggage.wxa.iu.c.c;
import com.tencent.luggage.wxa.jx.u;
import com.tencent.luggage.wxa.qd.f;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import java.util.Vector;
import org.json.JSONObject;

public class e
  extends u
{
  public static final int CTRL_INDEX = 291;
  public static final String NAME = "createAudioInstance";
  private static Vector<String> a = new Vector();
  
  static String a(com.tencent.luggage.wxa.jx.c paramc)
  {
    paramc = paramc.getAppId();
    String str = f.a();
    o.d("MicroMsg.Audio.JsApiCreateAudioInstance", "createAudioInstance appId:%s, audioId:%s", new Object[] { paramc, str });
    Object localObject = new e.a();
    ((e.a)localObject).b = str;
    ((e.a)localObject).d = 0;
    ((e.a)localObject).a = paramc;
    ((e.a)localObject).a();
    localObject = new e.1(paramc);
    if (!a.contains(paramc))
    {
      com.tencent.luggage.wxa.iu.c.a(paramc, (c.c)localObject);
      a.add(paramc);
    }
    return str;
  }
  
  public String a(com.tencent.luggage.wxa.jx.c paramc, JSONObject paramJSONObject)
  {
    paramJSONObject = new HashMap();
    paramJSONObject.put("audioId", a(paramc));
    return a("ok", paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.jz.e
 * JD-Core Version:    0.7.0.1
 */