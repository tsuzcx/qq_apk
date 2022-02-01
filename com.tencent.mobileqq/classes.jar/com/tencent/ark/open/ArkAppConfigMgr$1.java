package com.tencent.ark.open;

import android.content.SharedPreferences;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.open.security.ArkAppUrlChecker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

class ArkAppConfigMgr$1
  implements Runnable
{
  ArkAppConfigMgr$1(ArkAppConfigMgr paramArkAppConfigMgr) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject1;
      Map.Entry localEntry;
      synchronized (ArkAppConfigMgr.lock)
      {
        ArkAppConfigMgr.access$000(this.this$0).clear();
        localObject1 = ArkEnvironmentManager.getAppConfigSharedPreferences();
        if (localObject1 == null) {
          break label286;
        }
        localObject1 = ((SharedPreferences)localObject1).getAll();
        if (localObject1 == null) {
          break label286;
        }
        Iterator localIterator = ((Map)localObject1).entrySet().iterator();
        if (!localIterator.hasNext()) {
          break label286;
        }
        localEntry = (Map.Entry)localIterator.next();
        if ((localEntry == null) || (localEntry.getValue() == null)) {
          continue;
        }
        boolean bool = localEntry.getValue() instanceof String;
        if (!bool) {
          continue;
        }
      }
      try
      {
        localObject1 = ArkAppConfigMgr.convertJsonToConfig(new JSONObject((String)localEntry.getValue()));
        if ((localObject1 != null) && (localEntry.getKey() != null))
        {
          ArkAppConfigMgr.access$000(this.this$0).put(localEntry.getKey(), localObject1);
          if (((ArkAppInfo.AppConfig)localObject1).urlWhitelist != null)
          {
            localObject1 = new ArkAppUrlChecker(((ArkAppInfo.AppConfig)localObject1).urlWhitelist, ArkAppConfigMgr.access$200(this.this$0), ArkAppConfigMgr.access$300(this.this$0));
            ArkAppConfigMgr.access$400(this.this$0).put(localEntry.getKey(), localObject1);
          }
          ArkAppConfigMgr.access$100().logE("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.initConfig, appname:", localEntry.getKey(), ",config:", localEntry.getValue() });
          continue;
          localObject2 = finally;
          throw localObject2;
        }
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          ArkAppConfigMgr.access$100().logE("ArkApp.ArkAppConfigMgr", new Object[] { "ArkSafe.getAppConfig exception:", localJSONException.toString() });
          Object localObject3 = null;
        }
      }
    }
    label286:
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppConfigMgr.1
 * JD-Core Version:    0.7.0.1
 */