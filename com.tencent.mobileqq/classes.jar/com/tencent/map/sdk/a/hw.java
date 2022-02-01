package com.tencent.map.sdk.a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.map.sdk.service.MapServiceManager;
import com.tencent.map.sdk.service.protocol.request.AuthorizeRequest;
import com.tencent.map.tools.net.NetResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public final class hw
  extends AsyncTask<Object, Void, Void>
{
  private Handler a;
  private String b;
  private String c;
  private WeakReference<hv> d;
  
  public hw(Handler paramHandler, hv paramhv, String paramString1, String paramString2)
  {
    this.a = paramHandler;
    this.d = new WeakReference(paramhv);
    boolean bool = TextUtils.isEmpty(paramString1);
    paramHandler = "";
    if (bool) {
      paramString1 = "";
    }
    this.b = paramString1;
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = paramHandler;
    }
    this.c = paramString2;
  }
  
  private Void a()
  {
    Object localObject3 = ((AuthorizeRequest)((my)MapServiceManager.getService(my.class)).c()).checkAuth(pz.a, this.b, fz.g(), this.c, fz.c(), fz.a(), fz.d(), fz.e(), "4.2.8.2", fz.f(), "androidsdk", fz.b());
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((NetResponse)localObject3).charset;
      localObject3 = ((NetResponse)localObject3).data;
      if (localObject3 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(new String((byte[])localObject3, (String)localObject1));
        localObject3 = ((JSONObject)localObject1).optJSONObject("detail");
        if (localObject3 != null) {
          a(((JSONObject)localObject3).optJSONObject("cfg"));
        } else {
          a(null);
        }
        localObject1 = ((JSONObject)localObject1).optJSONObject("info");
        if (localObject1 != null)
        {
          i = ((JSONObject)localObject1).optInt("error");
          localObject1 = ((JSONObject)localObject1).optString("msg");
          if (i == 0)
          {
            fz.g = 0;
          }
          else
          {
            a(i, (String)localObject1);
            if (i < -400) {
              fz.g = -1;
            } else {
              fz.g = 1;
            }
          }
          fz.h = Calendar.getInstance().get(1);
          fz.i = Calendar.getInstance().get(2);
          fz.j = Calendar.getInstance().get(5);
          if (this.a != null)
          {
            localObject1 = new hj();
            ((hj)localObject1).a = 3;
            localObject1 = this.a.obtainMessage(((hj)localObject1).a, localObject1);
            this.a.sendMessage((Message)localObject1);
          }
          return null;
        }
      }
      catch (Exception localException)
      {
        return null;
      }
      Object localObject2 = null;
      int i = 0;
    }
  }
  
  private static void a(int paramInt, String paramString)
  {
    Object localObject = new ArrayList(4);
    ((List)localObject).add("腾讯地图鉴权失败，请访问 lbs.qq.com 检查 key 配置");
    ((List)localObject).add("错误码：".concat(String.valueOf(paramInt)));
    ((List)localObject).add("错误信息：".concat(String.valueOf(paramString)));
    paramString = new StringBuilder(1024);
    paramString.append("Auth Fail:\n");
    char[] arrayOfChar = new char[81];
    Arrays.fill(arrayOfChar, '*');
    arrayOfChar[80] = '\n';
    paramString.append(arrayOfChar);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      paramString.append((String)((Iterator)localObject).next());
      paramString.append("\n");
    }
    paramString.append(arrayOfChar);
    Log.e("tencentmap", paramString.toString());
  }
  
  private void a(JSONObject paramJSONObject)
  {
    WeakReference localWeakReference = null;
    if (paramJSONObject == null)
    {
      paramJSONObject = this.d;
      if ((paramJSONObject != null) && (paramJSONObject.get() != null)) {
        ((hv)this.d.get()).a(null, null);
      }
      return;
    }
    JSONArray localJSONArray = paramJSONObject.optJSONObject("custom_map_style").optJSONArray("style_list");
    JSONObject localJSONObject = paramJSONObject.optJSONObject("indoor_map");
    if (localJSONObject == null)
    {
      paramJSONObject = localWeakReference;
    }
    else
    {
      int i = localJSONObject.optInt("enable", -1);
      int j = localJSONObject.optInt("type", -1);
      paramJSONObject = localWeakReference;
      if (i != -1) {
        if (j == -1) {
          paramJSONObject = localWeakReference;
        } else {
          paramJSONObject = new hh(i, j, localJSONObject.optJSONArray("building_list"));
        }
      }
    }
    localWeakReference = this.d;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      ((hv)this.d.get()).a(localJSONArray, paramJSONObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.map.sdk.a.hw
 * JD-Core Version:    0.7.0.1
 */