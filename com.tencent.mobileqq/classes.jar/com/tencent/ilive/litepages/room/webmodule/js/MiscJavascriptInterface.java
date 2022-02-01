package com.tencent.ilive.litepages.room.webmodule.js;

import android.content.Context;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.ilive.litepages.room.webmodule.js.interfaces.BaseLiteMiscJavascriptInterface;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.JsBizAdapter;
import com.tencent.ilive.litepages.room.webmodule.jsmodule.NewJavascriptInterface;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MiscJavascriptInterface
  extends BaseLiteMiscJavascriptInterface
{
  private static final String METHOD_NAME_GET = "GET";
  private static final String METHOD_NAME_POST = "POST";
  private static final String TAG = "MiscJavascriptInterface";
  
  public MiscJavascriptInterface(Context paramContext, JsBizAdapter paramJsBizAdapter)
  {
    super(paramContext, paramJsBizAdapter);
  }
  
  @NewJavascriptInterface
  public void callCgi(Map<String, String> paramMap)
  {
    if ((getJsBizAdapter() == null) || (getJsBizAdapter().getHttp() == null)) {}
    String str1;
    String str2;
    HttpInterface localHttpInterface;
    LinkedHashMap localLinkedHashMap;
    for (;;)
    {
      return;
      str1 = (String)paramMap.get("url");
      str2 = (String)paramMap.get("method");
      localHttpInterface = getJsBizAdapter().getHttp();
      localLinkedHashMap = new LinkedHashMap();
      try
      {
        paramMap = new JSONObject((String)paramMap.get("params"));
        Iterator localIterator = paramMap.keys();
        while (localIterator.hasNext())
        {
          String str3 = (String)localIterator.next();
          localLinkedHashMap.put(str3, paramMap.getString(str3));
        }
        if (!"POST".equals(str2)) {}
      }
      catch (JSONException paramMap)
      {
        paramMap.printStackTrace();
        if ("GET".equals(str2))
        {
          localHttpInterface.get(str1, localLinkedHashMap, new MiscJavascriptInterface.1(this));
          return;
        }
      }
    }
    localHttpInterface.post(str1, localLinkedHashMap, new MiscJavascriptInterface.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilive.litepages.room.webmodule.js.MiscJavascriptInterface
 * JD-Core Version:    0.7.0.1
 */