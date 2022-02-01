package com.tencent.ad.tangram.canvas.views.form.framework;

import android.text.TextUtils;
import com.tencent.ad.tangram.canvas.views.form.AdFormData;
import com.tencent.ad.tangram.canvas.views.form.textbox.a;
import com.tencent.ad.tangram.log.AdLog;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.thread.AdThreadManager;
import java.lang.ref.WeakReference;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class d
{
  private static final String TAG = "AdFormUpdateRegexUtil";
  
  private static d.a getRequestParams()
  {
    d.a locala = new d.a(null);
    locala.setUrl("https://h5.gdt.qq.com/player/api/form/getRegexp");
    locala.method = "GET";
    locala.contentType = "application/json";
    locala.connectTimeoutMillis = 5000;
    locala.readTimeoutMillis = 5000;
    return locala;
  }
  
  private static Map<Integer, String> parseRegex(d.a parama, JSONObject paramJSONObject)
  {
    localHashMap = new HashMap();
    if ((parama != null) && (paramJSONObject != null)) {}
    label37:
    do
    {
      do
      {
        do
        {
          try
          {
            boolean bool = JSONObject.NULL.equals(paramJSONObject);
            if (!bool) {
              break label37;
            }
          }
          catch (JSONException parama)
          {
            for (;;)
            {
              Object localObject;
              AdLog.e("AdFormUpdateRegexUtil", "parseRegex", parama);
            }
            return localHashMap;
          }
          catch (Throwable parama)
          {
            for (;;)
            {
              AdLog.e("AdFormUpdateRegexUtil", "parseRegex", parama);
            }
          }
          AdLog.e("AdFormUpdateRegexUtil", "parseRegex error");
          return null;
          parama.returnCode = paramJSONObject.getInt("code");
          localObject = paramJSONObject.optString("message");
          AdLog.i("AdFormUpdateRegexUtil", "onResponse code:" + parama.returnCode + " message:" + (String)localObject);
        } while (parama.returnCode != 0);
        parama = paramJSONObject.getJSONObject("data");
      } while ((parama == null) || (JSONObject.NULL.equals(parama)));
      parama = parama.getJSONObject("regexMap");
    } while ((parama == null) || (JSONObject.NULL.equals(parama)));
    paramJSONObject = parama.keys();
    while (paramJSONObject.hasNext())
    {
      String str = (String)paramJSONObject.next();
      if (!TextUtils.isEmpty(str))
      {
        localObject = Integer.valueOf(str);
        str = parama.getString(str);
        if (!TextUtils.isEmpty(str)) {
          localHashMap.put(localObject, str);
        }
      }
    }
  }
  
  private static void parseResponse(WeakReference<AdFormData> paramWeakReference, d.a parama)
  {
    if ((parama == null) || (!parama.isSuccess()) || (parama.responseData == null) || (paramWeakReference == null) || (paramWeakReference.get() == null) || (!((AdFormData)paramWeakReference.get()).isValid()))
    {
      AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
      label49:
      return;
    }
    for (;;)
    {
      Object localObject;
      int i;
      try
      {
        localObject = Charset.forName("UTF-8");
        if (localObject == null) {
          break;
        }
        localObject = new String(parama.responseData, (Charset)localObject);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        parama = parseRegex(parama, new JSONObject((String)localObject));
        if (parama == null) {
          break;
        }
        i = 0;
        if (i >= ((AdFormData)paramWeakReference.get()).table.getSize()) {
          break label49;
        }
        localObject = ((AdFormData)paramWeakReference.get()).table.getItem(i);
        if ((localObject == null) || (!((AdFormItemData)localObject).isValid()))
        {
          AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
        }
        else if ((localObject instanceof a))
        {
          localObject = (a)a.class.cast(localObject);
          if (localObject == null) {
            AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
          }
        }
      }
      catch (JSONException paramWeakReference)
      {
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse", paramWeakReference);
        break;
        if (((a)localObject).regexType == -2147483648) {
          break label262;
        }
        if (parama.containsKey(Integer.valueOf(((a)localObject).regexType))) {
          break label242;
        }
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse error");
      }
      catch (Throwable paramWeakReference)
      {
        AdLog.e("AdFormUpdateRegexUtil", "parseResponse", paramWeakReference);
      }
      break;
      label242:
      ((a)localObject).regex = ((String)parama.get(Integer.valueOf(((a)localObject).regexType)));
      label262:
      i += 1;
    }
  }
  
  private static void update(WeakReference<AdFormData> paramWeakReference)
  {
    int i = 0;
    for (;;)
    {
      d.a locala;
      if (i < 3)
      {
        locala = getRequestParams();
        if (locala != null) {}
      }
      else
      {
        AdLog.e("AdFormUpdateRegexUtil", "update error");
      }
      do
      {
        return;
        AdHttp.send(locala);
        parseResponse(paramWeakReference, locala);
      } while ((locala.isSuccess()) && (locala.returnCode == 0));
      i += 1;
    }
  }
  
  public static void updateAsync(WeakReference<AdFormData> paramWeakReference)
  {
    AdThreadManager.INSTANCE.post(new d.1(paramWeakReference), 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.form.framework.d
 * JD-Core Version:    0.7.0.1
 */