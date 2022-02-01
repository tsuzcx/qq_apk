package com.tencent.ad.tangram.views.form.framework;

import android.text.TextUtils;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.ad.tangram.views.form.AdFormData;
import com.tencent.ad.tangram.views.form.textbox.a;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class i
{
  private static final String TAG = "AdFormUpdateRegexUtil";
  
  private static i.a getRequestParams()
  {
    i.a locala = new i.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    locala.method = "GET";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    return locala;
  }
  
  private static Map<Integer, String> parseRegex(i.a parama, JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    if ((parama != null) && (paramJSONObject != null)) {
      try
      {
        if (!JSONObject.NULL.equals(paramJSONObject))
        {
          parama.returnCode = paramJSONObject.getInt("code");
          Object localObject1 = paramJSONObject.optString("message");
          Object localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("onResponse code:");
          ((StringBuilder)localObject2).append(parama.returnCode);
          ((StringBuilder)localObject2).append(" message:");
          ((StringBuilder)localObject2).append((String)localObject1);
          AdLog.i("AdFormUpdateRegexUtil", ((StringBuilder)localObject2).toString());
          if (parama.returnCode == 0)
          {
            parama = paramJSONObject.getJSONObject("data");
            if ((parama != null) && (!JSONObject.NULL.equals(parama)))
            {
              parama = parama.getJSONObject("regexMap");
              if ((parama != null) && (!JSONObject.NULL.equals(parama)))
              {
                paramJSONObject = parama.keys();
                while (paramJSONObject.hasNext())
                {
                  localObject2 = (String)paramJSONObject.next();
                  if (!TextUtils.isEmpty((CharSequence)localObject2))
                  {
                    localObject1 = Integer.valueOf((String)localObject2);
                    localObject2 = parama.getString((String)localObject2);
                    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
                      localHashMap.put(localObject1, localObject2);
                    }
                  }
                }
                return localHashMap;
              }
            }
          }
        }
      }
      catch (Throwable parama)
      {
        AdLog.e("AdFormUpdateRegexUtil", "parseRegex", parama);
      }
      catch (JSONException parama)
      {
        AdLog.e("AdFormUpdateRegexUtil", "parseRegex", parama);
      }
    }
    AdLog.e("AdFormUpdateRegexUtil", "parseRegex error");
    return null;
  }
  
  private static void parseResponse(WeakReference<AdFormData> paramWeakReference, i.a parama)
  {
    if ((parama != null) && (parama.isSuccess()) && (parama.responseData != null) && (paramWeakReference != null) && (paramWeakReference.get() != null) && (((AdFormData)paramWeakReference.get()).isValid())) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = Charset.forName("UTF-8");
        if (localObject == null) {
          break label278;
        }
        localObject = new String(parama.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break label278;
        }
        parama = parseRegex(parama, new JSONObject((String)localObject));
        if (parama != null) {
          break label286;
        }
      }
      catch (Throwable paramWeakReference)
      {
        Object localObject;
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      catch (JSONException paramWeakReference)
      {
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      if (i < ((AdFormData)paramWeakReference.get()).table.getSize())
      {
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject != null) && (((d)localObject).isValid()))
        {
          if ((localObject instanceof a))
          {
            localObject = (a)a.class.cast(localObject);
            if (localObject == null) {
              AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
            } else if (((a)localObject).regexType != -2147483648) {
              if (!parama.containsKey(Integer.valueOf(((a)localObject).regexType))) {
                AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
              } else {
                ((a)localObject).regex = ((String)parama.get(Integer.valueOf(((a)localObject).regexType)));
              }
            }
          }
        }
        else {
          AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
        }
        i += 1;
      }
      else
      {
        return;
        label278:
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
        return;
        label286:
        i = 0;
      }
    }
  }
  
  private static void update(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    while (i < 3)
    {
      i.a locala = getRequestParams();
      if (locala == null) {
        break;
      }
      AdHttp.send(locala);
      parseResponse(paramWeakReference, locala);
      if ((locala.isSuccess()) && (locala.returnCode == 0)) {
        return;
      }
      i += 1;
    }
    AdLog.e("AdFormUpdateRegexUtil", "update error");
  }
  
  public static void updateAsync(WeakReference<AdFormData> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new i.1(paramWeakReference), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.views.form.framework.i
 * JD-Core Version:    0.7.0.1
 */