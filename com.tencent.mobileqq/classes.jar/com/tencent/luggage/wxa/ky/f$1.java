package com.tencent.luggage.wxa.ky;

import com.tencent.luggage.wxa.pd.b.a;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class f$1
  implements b.a
{
  f$1(f paramf, b paramb, String paramString) {}
  
  public void a(String paramString)
  {
    if (!af.c(paramString))
    {
      o.d("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, local file path:%s", new Object[] { paramString });
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BGMFilePath", paramString);
      }
      catch (JSONException paramString)
      {
        o.b("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, set param fail", new Object[] { paramString });
      }
      if (!this.a.a("playBGM", localJSONObject))
      {
        o.b("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, play bgm fail, url:%s", new Object[] { this.b });
        paramString = new HashMap();
        paramString.put("url", this.b);
        this.a.a(10003, "download file fail", paramString);
      }
    }
    else
    {
      o.b("MicroMsg.JsApiOperateLivePusher", "operatePlayBgm, download file fail, url:%s", new Object[] { this.b });
      paramString = new HashMap();
      paramString.put("url", this.b);
      this.a.a(10003, "download file fail", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ky.f.1
 * JD-Core Version:    0.7.0.1
 */