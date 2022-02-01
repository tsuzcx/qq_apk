package com.tencent.mobileqq.ark.config.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DialogConfig
  extends ArkManageConfig
  implements IQStorageSafable<String>
{
  public boolean a = false;
  public boolean b = false;
  public boolean c = false;
  public boolean d = false;
  public String e = "";
  public boolean f = false;
  public String g = "";
  public HashMap<String, ArrayList<String>> h = new HashMap();
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("DialogConfig", 1, "onParse,fileOrRes is null");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        JSONObject localJSONObject = new JSONObject(paramString);
        this.a = ArkManageConfig.a(localJSONObject, "ark_map_transfer_struct");
        this.g = ArkManageConfig.b(localJSONObject, "business_percent");
        if (localJSONObject.optInt("ark_use_android_http", 0) != 0)
        {
          bool = true;
          this.b = bool;
          this.c = ArkManageConfig.a(localJSONObject, "ark_support_android9_emoji");
          this.d = ArkManageConfig.a(localJSONObject, "ark_engine_multi_thread");
          this.e = ArkManageConfig.b(localJSONObject, "ark_engine_hardware_rendering_device_matcher");
          this.f = ArkManageConfig.a(localJSONObject, "ark_engine_disable_hardware_rendering");
          Object localObject1 = new StringBuilder("mArkMapTransferStruct=");
          ((StringBuilder)localObject1).append(this.a);
          ((StringBuilder)localObject1).append(", mBusinessPercent=");
          ((StringBuilder)localObject1).append(this.g);
          ((StringBuilder)localObject1).append(", mArkUseAndroidHttp=");
          ((StringBuilder)localObject1).append(this.b);
          ((StringBuilder)localObject1).append(", mArkAndroid9EmojiFeatureSupport=");
          ((StringBuilder)localObject1).append(this.c);
          ((StringBuilder)localObject1).append(", mArkEngineMultiThread");
          ((StringBuilder)localObject1).append(this.d);
          ((StringBuilder)localObject1).append(", mArkEngineHardwareRenderingDeviceMatcher=");
          ((StringBuilder)localObject1).append(this.e);
          ((StringBuilder)localObject1).append(", mArkEngineDisableHardwareRendering=");
          ((StringBuilder)localObject1).append(this.f);
          QLog.i("DialogConfig", 1, ((StringBuilder)localObject1).toString());
          localJSONObject = localJSONObject.optJSONObject("msgai_intent_app_map");
          if (localJSONObject != null)
          {
            localObject1 = localJSONObject.keys();
            if (((Iterator)localObject1).hasNext())
            {
              String str1 = (String)((Iterator)localObject1).next();
              Object localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("msgai_intent_app_map, intent = ");
              ((StringBuilder)localObject2).append(str1);
              QLog.i("DialogConfig", 1, ((StringBuilder)localObject2).toString());
              localObject2 = localJSONObject.optJSONArray(str1);
              if (localObject2 == null) {
                continue;
              }
              ArrayList localArrayList = new ArrayList();
              i = 0;
              if (i < ((JSONArray)localObject2).length())
              {
                String str2 = ((JSONArray)localObject2).optString(i);
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("msgai_intent_app_map, appID = ");
                localStringBuilder.append(str2);
                QLog.i("DialogConfig", 1, localStringBuilder.toString());
                if (TextUtils.isEmpty(str2)) {
                  break label490;
                }
                localArrayList.add(str2);
                break label490;
              }
              if (localArrayList.isEmpty()) {
                continue;
              }
              this.h.put(str1, localArrayList);
              continue;
            }
          }
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        QLog.e("DialogConfig", 1, String.format("updateDialogConfig, parse json fail, json=%s, err=%s", new Object[] { paramString, localJSONException.getMessage() }));
      }
      boolean bool = false;
      continue;
      label490:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.config.config.DialogConfig
 * JD-Core Version:    0.7.0.1
 */