package com.tencent.gdtad.jsbridge;

import com.tencent.gdtad.aditem.GdtAdLoader;
import com.tencent.gdtad.aditem.GdtAdLoader.Listener;
import com.tencent.gdtad.aditem.GdtAdLoader.Session;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class GdtLoadAdJsCallHandler$1
  implements GdtAdLoader.Listener
{
  GdtLoadAdJsCallHandler$1(GdtLoadAdJsCallHandler paramGdtLoadAdJsCallHandler) {}
  
  public void onResponse(GdtAdLoader paramGdtAdLoader)
  {
    if ((paramGdtAdLoader != null) && (paramGdtAdLoader.a() != null) && (GdtLoadAdJsCallHandler.a(this.a) != null))
    {
      if (GdtLoadAdJsCallHandler.a(this.a).get() == null) {
        return;
      }
      String str = (String)GdtLoadAdJsCallHandler.b(this.a).get(paramGdtAdLoader);
      GdtLoadAdJsCallHandler.b(this.a).remove(paramGdtAdLoader);
      Object localObject1 = GdtJsonPbUtil.a(paramGdtAdLoader.a().a);
      Object localObject2 = GdtJsonPbUtil.a(paramGdtAdLoader.a().b);
      paramGdtAdLoader = new JSONObject();
      try
      {
        paramGdtAdLoader.put("request", localObject1);
        paramGdtAdLoader.put("response", localObject2);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
      ((GdtAdWebPlugin)GdtLoadAdJsCallHandler.a(this.a).get()).callJs(str, new String[] { paramGdtAdLoader.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.jsbridge.GdtLoadAdJsCallHandler.1
 * JD-Core Version:    0.7.0.1
 */