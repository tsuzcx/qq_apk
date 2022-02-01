package com.tencent.ilivesdk.avpreloadservice;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.falco.base.libapi.generalinfo.AppGeneralInfoService;
import com.tencent.falco.base.libapi.http.HttpInterface;
import com.tencent.falco.base.libapi.log.LogInterface;
import com.tencent.falco.utils.NetworkUtil;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.falco.utils.ThreadCenter.HandlerKeyable;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceAdapter;
import com.tencent.ilivesdk.avpreloadservice_interface.AVPreloadServiceInterface.AVPreloadScenes;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AVPreloadSwitch
  implements ThreadCenter.HandlerKeyable
{
  private static final List<AVPreloadSwitch.SwitchConfig> g = new ArrayList();
  private HttpInterface a;
  private AppGeneralInfoService b;
  private LogInterface c;
  private AVPreloadServiceAdapter d;
  private String e = "";
  private List<AVPreloadSwitch.SwitchConfig> f = new ArrayList();
  private AVPreloadSwitch.AVPreloadSwitchListener h;
  
  static
  {
    AVPreloadSwitch.SwitchConfig localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.a = "switch_room";
    localSwitchConfig.b = true;
    localSwitchConfig.c = true;
    localSwitchConfig.d = true;
    localSwitchConfig.e = false;
    localSwitchConfig.f = 3;
    localSwitchConfig.g = 2;
    localSwitchConfig.h = 5;
    g.add(localSwitchConfig);
    localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.a = "clicked_enter_room";
    localSwitchConfig.b = true;
    localSwitchConfig.c = false;
    localSwitchConfig.d = true;
    localSwitchConfig.e = false;
    localSwitchConfig.f = 3;
    localSwitchConfig.g = 2;
    localSwitchConfig.h = 5;
    g.add(localSwitchConfig);
  }
  
  private AVPreloadSwitch.SwitchConfig a(JSONObject paramJSONObject)
  {
    AVPreloadSwitch.SwitchConfig localSwitchConfig = new AVPreloadSwitch.SwitchConfig();
    localSwitchConfig.a = paramJSONObject.optString("scene");
    int i = paramJSONObject.optInt("preload_enable");
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.b = bool1;
    if (paramJSONObject.optInt("mobile_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.c = bool1;
    if (paramJSONObject.optInt("screen_shot_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.d = bool1;
    if (paramJSONObject.optInt("frame_seek_enable") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localSwitchConfig.e = bool1;
    localSwitchConfig.f = paramJSONObject.optInt("max_cache_size");
    localSwitchConfig.g = paramJSONObject.optInt("max_download_count");
    localSwitchConfig.h = paramJSONObject.optInt("max_refresh_count");
    localSwitchConfig.i = paramJSONObject.optString("frame_seek_domain");
    boolean bool1 = bool2;
    if (paramJSONObject.optInt("dispatch_enable") == 1) {
      bool1 = true;
    }
    localSwitchConfig.j = bool1;
    localSwitchConfig.k = paramJSONObject.optString("dispatch_domain");
    return localSwitchConfig;
  }
  
  private void a(AVPreloadSwitch.OnCgiResponse paramOnCgiResponse)
  {
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      localJSONObject1.put("client_type", this.b.getClientType());
      JSONArray localJSONArray = new JSONArray();
      localJSONArray.put("preload_switch_android");
      localJSONObject1.put("config_key", localJSONArray);
      localJSONObject1.put("flag", 0);
      localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "version_code");
      localJSONObject2.put("client_identified_value", String.valueOf(this.b.getVersionCode()));
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      String[] arrayOfString = this.b.getVersionName().split("\\.");
      Object localObject = new StringBuffer();
      try
      {
        ((StringBuffer)localObject).append(arrayOfString[0]);
        int i = arrayOfString[1].length();
        StringBuilder localStringBuilder;
        if (i == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append(arrayOfString[1]);
          ((StringBuffer)localObject).append(localStringBuilder.toString());
        }
        else
        {
          ((StringBuffer)localObject).append(arrayOfString[1]);
        }
        if (arrayOfString[2].length() == 1)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("0");
          localStringBuilder.append(arrayOfString[2]);
          ((StringBuffer)localObject).append(localStringBuilder.toString());
        }
        else
        {
          ((StringBuffer)localObject).append(arrayOfString[2]);
        }
      }
      catch (Exception localException)
      {
        this.c.printException(localException);
      }
      localObject = ((StringBuffer)localObject).toString();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localJSONObject2.put("client_identified_name", "build_version");
        localJSONObject2.put("client_identified_value", localObject);
        localJSONArray.put(localJSONObject2);
      }
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "guid");
      localJSONObject2.put("client_identified_value", this.b.getGuid());
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "os_level");
      localJSONObject2.put("client_identified_value", String.valueOf(Build.VERSION.SDK_INT));
      localJSONArray.put(localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("client_identified_name", "model");
      localJSONObject2.put("client_identified_value", String.valueOf(Build.MODEL));
      localJSONArray.put(localJSONObject2);
      localJSONObject1.put("client_infos", localJSONArray);
    }
    catch (JSONException localJSONException)
    {
      this.c.printException(localJSONException);
    }
    String str;
    if (this.b.isSvrTestEnv()) {
      str = "https://test.ilive.qq.com/cgi-bin/general/platform_config/pull_config";
    } else {
      str = "https://ilive.qq.com/cgi-bin/general/platform_config/pull_config";
    }
    ThreadCenter.postLogicTask(new AVPreloadSwitch.2(this, str, localJSONObject1, paramOnCgiResponse), "fetch_preload_switch");
  }
  
  private boolean a(JSONArray paramJSONArray)
  {
    if ((paramJSONArray != null) && (paramJSONArray.length() != 0))
    {
      this.f.clear();
      int i = 0;
      try
      {
        while (i < paramJSONArray.length())
        {
          JSONObject localJSONObject = paramJSONArray.getJSONObject(i);
          if (localJSONObject != null) {
            this.f.add(a(localJSONObject));
          }
          i += 1;
        }
        return true;
      }
      catch (Exception paramJSONArray)
      {
        this.c.printException(paramJSONArray);
        return false;
      }
    }
    this.c.e("AVPreloadSwitch", "switchConfig is empty return", new Object[0]);
    return false;
  }
  
  private String d(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    int i = AVPreloadSwitch.3.a[paramAVPreloadScenes.ordinal()];
    if (i != 1)
    {
      if (i != 2) {
        return "unknown";
      }
      return "clicked_enter_room";
    }
    return "switch_room";
  }
  
  public AVPreloadSwitch.SwitchConfig a(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    Iterator localIterator = this.f.iterator();
    while (localIterator.hasNext())
    {
      AVPreloadSwitch.SwitchConfig localSwitchConfig = (AVPreloadSwitch.SwitchConfig)localIterator.next();
      if ((localSwitchConfig != null) && (d(paramAVPreloadScenes).equalsIgnoreCase(localSwitchConfig.a))) {
        return localSwitchConfig;
      }
    }
    return b(paramAVPreloadScenes);
  }
  
  public List<AVPreloadSwitch.SwitchConfig> a()
  {
    return this.f;
  }
  
  public void a(AVPreloadSwitch.AVPreloadSwitchListener paramAVPreloadSwitchListener)
  {
    this.h = paramAVPreloadSwitchListener;
  }
  
  public void a(AVPreloadServiceAdapter paramAVPreloadServiceAdapter)
  {
    if (paramAVPreloadServiceAdapter == null) {
      return;
    }
    this.d = paramAVPreloadServiceAdapter;
    this.a = paramAVPreloadServiceAdapter.c();
    this.b = paramAVPreloadServiceAdapter.b();
    this.c = paramAVPreloadServiceAdapter.a();
  }
  
  public AVPreloadSwitch.SwitchConfig b(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    Iterator localIterator = g.iterator();
    while (localIterator.hasNext())
    {
      AVPreloadSwitch.SwitchConfig localSwitchConfig = (AVPreloadSwitch.SwitchConfig)localIterator.next();
      if ((localSwitchConfig != null) && (d(paramAVPreloadScenes).equalsIgnoreCase(localSwitchConfig.a))) {
        return localSwitchConfig;
      }
    }
    return null;
  }
  
  public void b()
  {
    a(new AVPreloadSwitch.1(this));
  }
  
  public boolean c(AVPreloadServiceInterface.AVPreloadScenes paramAVPreloadScenes)
  {
    paramAVPreloadScenes = a(paramAVPreloadScenes);
    if (paramAVPreloadScenes == null) {
      return false;
    }
    if (!paramAVPreloadScenes.b) {
      return false;
    }
    if (paramAVPreloadScenes.c) {
      return true;
    }
    return NetworkUtil.isWiFi(this.b.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ilivesdk.avpreloadservice.AVPreloadSwitch
 * JD-Core Version:    0.7.0.1
 */