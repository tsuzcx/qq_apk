package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import com.tencent.luggage.wxa.fz.a;
import com.tencent.luggage.wxa.gc.a.a;
import com.tencent.luggage.wxa.gc.b;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class j$13
  implements a.a
{
  j$13(j paramj) {}
  
  public void a(String paramString1, String paramString2)
  {
    if (!af.c(paramString2))
    {
      o.d(j.g(this.a), "operatePlayBgm, local file path:%s", new Object[] { paramString2 });
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("BGMFilePath", paramString2);
      }
      catch (JSONException paramString2)
      {
        o.b("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, set param fail", new Object[] { paramString2 });
      }
      if ((j.l(this.a) != null) && (j.l(this.a).a("playBGM", localJSONObject).a != 0))
      {
        o.b("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, play bgm fail, url:%s", new Object[] { paramString1 });
        if (j.b(this.a) != null)
        {
          paramString2 = new HashMap();
          paramString2.put("url", paramString1);
          j.b(this.a).a(this.a.B(), 10003, "play bgm fail", paramString2);
        }
      }
    }
    else
    {
      o.b("MicroMsg.SameLayer.LivePusherPluginHandler", "operatePlayBgm, download file fail, url:%s", new Object[] { paramString1 });
      if (j.b(this.a) != null)
      {
        paramString2 = new HashMap();
        paramString2.put("url", paramString1);
        j.b(this.a).a(this.a.B(), 10003, "download file fail", paramString2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.j.13
 * JD-Core Version:    0.7.0.1
 */